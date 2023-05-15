import com.dimafeng.testcontainers.ContainerDef
import com.dimafeng.testcontainers.LocalStackV2Container
import com.dimafeng.testcontainers.scalatest.TestContainerForAll
import org.scalatest.funsuite.AnyFunSuite
import org.testcontainers.containers.localstack.LocalStackContainer.Service

trait LocalstackContainer extends AnyFunSuite with TestContainerForAll {
  override val containerDef: LocalStackV2Container.Def =
    LocalStackV2Container.Def(
      tag = "2.0.2",
      services = Seq(
        Service.S3,
        Service.SQS,
        Service.KINESIS
      )
    )
}
