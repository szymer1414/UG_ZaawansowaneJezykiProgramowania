/*import org.apache.pekko
import pekko.actor.{ActorSystem, Actor, ActorLogging, ActorRef, Props}

case class Pilka(okrazenia: Int)
case class GrajZ(a: ActorRef)

class Player extends Actor with ActorLogging {
  def receive: Receive = {
    case GrajZ(a) =>
      // log.info(s"${self.path.name} - odebral aktora")
      context.become(WithPlayer(a))
      // a ! Pilka
      log.info(s" got a partner: ${a.path.name}")
    case Pilka(_) =>
      log.info(s"received the ball but has no partner!")
  }
  def WithPlayer(a: ActorRef): Receive = { case Pilka(okrazenia) =>
    if (okrazenia > 0) {
      log.info(
        s"passes to ${a.path.name}. Remaining passes: ${okrazenia - 1}"
      )
      Thread.sleep(500)
      a ! Pilka(okrazenia - 1)
    } else {
      log.info(
        s" received the ball"
      )
      context.system.terminate()
    }

  }
}
@main
def mainProg: Unit = {
  val system = ActorSystem("Hollywood")

  val players =
    (1 to 10).map(i => system.actorOf(Props[Player](), s"player$i")).toList

  for (i <- players.indices) {
    val next = players((i + 1) % players.length)
    players(i) ! GrajZ(next)

  }
  val o = 2

  val okrazenia = o * players.length
  players.head ! Pilka(okrazenia)
}
*/