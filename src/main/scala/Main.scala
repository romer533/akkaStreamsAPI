import akka.stream._
import akka.stream.scaladsl._
import akka.{Done, NotUsed}
import akka.actor.ActorSystem
import akka.stream.scaladsl.MergeHub.source
import akka.util.ByteString

import scala.concurrent._
import java.nio.file.Paths

object Main extends App {

  implicit val system: ActorSystem = ActorSystem("QuickStart")

  val done: Future[Done] = source.runForeach(println)

  implicit val ec = system.dispatcher
  done.onComplete(_ => system.terminate())

  val factorials = source.scan(BigInt(1))((acc, next) => acc * next)

  val result: Future[IOResult] =
    factorials.map(num => ByteString(s"$num\n")).runWith(FileIO.toPath(Paths.get("factorials.txt")))

}
