import java.util.concurrent.atomic.AtomicInteger
import scala.annotation.tailrec

object Main extends App {

  private val symbol = 'i'
  private var text = "Hello! My name is Denis!"

  def charInStrTailRec(str: String, c: Char): Int = {
    val count = new AtomicInteger()

    @tailrec
    def charInStrTailRec(i: Int): Int = {
      if (c.equals(str.charAt(i))) count.incrementAndGet()
      if (i == 0) count.get()
      else charInStrTailRec(i - 1)
    }

    charInStrTailRec(str.length - 1)
  }

  def charInStrFor(str: String, c: Char): Int = {
    val count = new AtomicInteger()

    for (i <- 0 until str.length) {
      if (c.equals(str.charAt(i)))
        count.incrementAndGet()
    }
    count.get()
  }

  println(charInStrTailRec(text, symbol))
  println(charInStrFor(text, symbol));

  text = "111222233333334455555566"

  def digitsInStrTailRec(str: String): Int = {
    val it = new AtomicInteger()
    val count = new AtomicInteger()

    @tailrec
    def digitsInStrTailRec(i: Int): Int = {
      val c = str.charAt(i)
      if (c > 47 && c < 58) {
        val symbol = str.charAt(i - 1)
        symbol match {
          case j if j.equals(c) => it.incrementAndGet()
          case _ => it.set(1)
        }
        it.get() match {
          case j if j > count.get() => count.set(it.get())
          case _ =>
        }
      }
      if (i == 1) count.get()
      else digitsInStrTailRec(i - 1)
    }

    digitsInStrTailRec(str.length - 1)
  }

  def digitsInStrFor(str: String): Int = {
    val it = new AtomicInteger()
    val count = new AtomicInteger()

    for (i <- 0 to str.length - 2) {
      val c = str.charAt(i)
      if (c > 47 && c < 58) {
        val symbol = str.charAt(i + 1)
        symbol match {
          case j if j.equals(c) => it.incrementAndGet()
          case _ => it.set(1)
        }
        it.get() match {
          case j if j > count.get() => count.set(it.get())
          case _ =>
        }
      }
    }
    count.get()
  }

  println(digitsInStrFor(text));
  println(digitsInStrTailRec(text))
}
