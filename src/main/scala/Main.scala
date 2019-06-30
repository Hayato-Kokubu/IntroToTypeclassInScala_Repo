object Main extends App{

  val sortedList = sort(List(6, 1, 4, 7, 5, 2, 9, 3, 8), IntComparator)

  println(sortedList)

  def sort[T](list: List[T], comparator: Comparator[T]): List[T] = {
    list match {
      case x :: xs =>
        val (ys, zs) = xs.partition(a => comparator.compare(x, a) > 0)
        sort(ys, comparator) ++ List(x) ++ sort(zs, comparator)
      case Nil => Nil }
  }


}

