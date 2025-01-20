import org.apache.pekko
import pekko.actor.{ActorSystem, Actor, ActorLogging, ActorRef, Props}

case object Pilka
case class GrajZ(a: ActorRef, odbicia: Int)
case class UpdateNext(newNext: Option[ActorRef])

class Player extends Actor with ActorLogging {
  private var next: Option[ActorRef] = None
  private var remainingBounces: Int = 0

  def receive: Receive = {
    case GrajZ(a, odbicia) =>
      next = Some(a)
      remainingBounces = odbicia
      log.info(
        s"${self.path.name} starts with $remainingBounces bounces. Next player: ${a.path.name}"
      )

    case Pilka =>
      if (sender() == self) {
        log.info(
          s"${self.path.name} is the only player left. Stopping the game."
        )
        context.system.terminate()
      } else if (remainingBounces > 0) {
        remainingBounces -= 1
        log.info(
          s"${self.path.name} bounces the ball. Remaining bounces: $remainingBounces"
        )
        Thread.sleep(500) // Simulate reaction time
        next.foreach(_ ! Pilka)
      } else {
        log.info(
          s"${self.path.name} finished its bounces. Thank you for the game!"
        )
        sender() ! UpdateNext(next)
        // context.stop(self) // Stop the actor after completing its bounces
      }
    case UpdateNext(newNext) =>
      next = newNext
      log.info(
        s"${self.path.name} updates next player to ${newNext.map(_.path.name).getOrElse("None")}"
      )
      newNext.foreach(_ ! Pilka)

  }
}

@main
def mainProg(): Unit = {
  val system = ActorSystem("PingPongSystem")

  // Create players with random bounce counts
  val playersWithBounces: List[(ActorRef, Int)] = (1 to 5).map { i =>
    val player = system.actorOf(Props[Player](), s"player$i")
    val bounces = scala.util.Random.between(1, 4) // Random bounces per player
    (player, bounces)
  }.toList

  // Link players in a circular fashion
  for (i <- playersWithBounces.indices) {
    val nextPlayer = playersWithBounces((i + 1) % playersWithBounces.length)._1
    val (player, bounces) = playersWithBounces(i)
    player ! GrajZ(nextPlayer, bounces)
  }

  // Start the game by sending the ball to the first player
  playersWithBounces.head._1 ! Pilka
}
