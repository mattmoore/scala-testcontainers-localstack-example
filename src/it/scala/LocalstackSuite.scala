import cats.effect.IO
import com.dimafeng.testcontainers.LocalStackV2Container
import com.dimafeng.testcontainers.scalatest.TestContainerForAll
import kinesis4cats.client.KinesisClient
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.*
import org.testcontainers.containers.localstack.LocalStackContainer.Service
import software.amazon.awssdk.services.kinesis.model.CreateStreamRequest
import software.amazon.awssdk.services.kinesis.model.PutRecordRequest
import software.amazon.awssdk.core.SdkBytes
import software.amazon.awssdk.services.kinesis.model.GetRecordsRequest

class LocalstackSuite extends LocalstackContainer {
  test("fires up localstack") {
    KinesisClient.Builder
      .default[IO]
      .build
      .use(client =>
        for {
          _ <- client.createStream(
            CreateStreamRequest
              .builder()
              .streamName("my-stream")
              .shardCount(1)
              .build()
          )
          _ <- client.putRecord(
            PutRecordRequest
              .builder()
              .partitionKey("some-partition-key")
              .streamName("my-stream")
              .data(SdkBytes.fromUtf8String("my-data"))
              .build()
          )
          r <- client.getRecords(
            GetRecordsRequest
              .builder()
              .shardIterator("1")
              .streamARN("my-stream")
              .build()
          )
          // _ <- log.info(r.toString())
        } yield r
      )
  }
}
