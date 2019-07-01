import Comparators._

object Main extends App{

  val sortedList = sort(List(6, 1, 4, 7, 5, 2, 9, 3, 8))
  println(sortedList)


  val sortedSetsList1 = sort(List(Set(1,2,3), Set.empty[Int], Set(2,4,6,8), Set(2,3,5,8,9)))
  // インスタンス宣言のため、Set.empty のInt は必要
  println(sortedSetsList1)

  val sortedSetsList2 = sort(List(Set("one", "two"), Set("1", "2", "3")))
  println(sortedSetsList2)


  val sortedTupleList = sort(List((1,2), (4,3), (6,2)))
  println(sortedTupleList)

  val intCompareResult = IntComparator.compare(3,4)
  println(intCompareResult)

  val intComparatorResult2 = implicitly[Comparator[Int]].compare(3,4)
  println(intComparatorResult2)

  def sort[T](list: List[T])(implicit comparator: Comparator[T]): List[T] = {
    list match {
      case x :: xs =>
        val (ys, zs) = xs.partition(a => comparator.compare(x, a) > 0)
        sort(ys) ++ List(x) ++ sort(zs)
      case Nil => Nil }
  }
}

