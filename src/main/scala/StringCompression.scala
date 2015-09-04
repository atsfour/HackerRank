object StringCompression{

  def makeScanner(fileName: String = null) = fileName match {
    case null => new java.util.Scanner(System.in)
    case s => new java.util.Scanner(new java.io.File(getClass.getResource(fileName).getPath))
  }

  //val sc = makeScanner("StringCompressionInput.txt")
  //val input: Seq[Char] = sc.next.toSeq
  val input = scala.io.StdIn.readLine().toSeq
  println(compress(input))

  def compress(chars: Seq[Char]): String = {
    val sb = new StringBuilder
    def appendCompressed(sb: StringBuilder, c: Char, num: Int):Unit ={
      sb.append(c)
      if (num > 1) sb.append(num)
    }
    def go(cs: Seq[Char], prev: Char, ctr: Int): Unit = {
      cs match {
        case Nil => appendCompressed(sb, prev, ctr)
        case sq if sq.head == prev => go(cs.tail, cs.head, ctr + 1)
        case sq => {
          appendCompressed(sb, prev, ctr)
          go(cs.tail, cs.head, 1)
        }
      }
    }
    go(chars.tail, chars.head, 1)
    sb.result()
  }
}