object Comparators {
  implicit object IntComparator extends Comparator[Int] {
    def compare(a: Int, b: Int): Int = a - b }

  implicit def setSizeComparator[T]: Comparator[Set[T]] ={
    new Comparator[Set[T]] {
      def compare(a: Set[T], b: Set[T]): Int = a.size - b.size
    }
  }

  implicit def tupleComparator[T1, T2](
    implicit cmp1: Comparator[T1], cmp2: Comparator[T2]
  ): Comparator[(T1, T2)] = {
    new Comparator[(T1, T2)] {
      def compare(a: (T1, T2), b: (T1, T2)): Int = {
        val res2 = cmp2.compare(a._2, b._2)
        if (res2 == 0) cmp1.compare(a._1, b._1) else res2
      } }
  }
}
