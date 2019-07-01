object Comparators {
  implicit object IntComparator extends Comparator[Int] {
    def compare(a: Int, b: Int): Int = a - b }

  implicit def setSizeComparator[T]: Comparator[Set[T]] ={
    new Comparator[Set[T]] {
      def compare(a: Set[T], b: Set[T]): Int = a.size - b.size
    }
  }
}
