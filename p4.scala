abstract class Notification

case class Email(sender: String, title: String, body: String) extends Notification
case class SMS(caller: String, message: String) extends Notification

object NotificationApp {
  def showNotification(notification: Notification): String = {
    notification match {
      case Email(sender, title, _) => s"You got an email from $sender with title: $title"
      case SMS(caller, message) => s"You got an SMS from $caller! Message: $message"
    }
  }

  def main(args: Array[String]): Unit = {
    val email = Email("alice@example.com", "Hi", "How are you?")
    val sms = SMS("12345", "Are you there?")

    println(showNotification(email))
    println(showNotification(sms))
  }
}

