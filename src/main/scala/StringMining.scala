/**
 * Created on 2015/09/04.
 */
object StringMining extends App {
  val p = scala.io.StdIn.readLine()
  val q = scala.io.StdIn.readLine()
  val sb = new StringBuilder
  for (i <- 0 until p.length){
    sb.append(p(i)).append(q(i))
  }
  println(sb.result())
}
