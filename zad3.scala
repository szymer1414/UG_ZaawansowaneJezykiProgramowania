/*import org.apache.pekko
import pekko.actor.{ActorSystem, Actor, ActorLogging, ActorRef, Props}

case object Pilka
case class GrajZ(a: ActorRef)

class Player extends Actor with ActorLogging {
  def receive: Receive = {
    case GrajZ(a) =>
      // log.info(s"${self.path.name} - odebral aktora")
      context.become(WithPlayer(a))
      //a ! Pilka
      log.info(s"${self.path.name} got a partner: ${a.path.name}")
    case Pilka =>
      log.info(s"${self.path.name} received the ball but has no partner!")
  }
  def WithPlayer(a: ActorRef): Receive = { case Pilka =>
    log.info(s"${self.path.name} received the ball and passes it to ${a.path.name}")
    Thread.sleep(500)
    a ! Pilka
  }

}

@main
def mainProg: Unit = {
  val system = ActorSystem("Hollywood")
  
  val players = (1 to 10).map(i => system.actorOf(Props[Player](), s"player$i")).toList

  for (i <- players.indices) {
    val next = players((i+1)% players.length)
    players(i) ! GrajZ(next)

  }
  players.head ! Pilka
}
*/