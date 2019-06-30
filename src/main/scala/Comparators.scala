object Comparators {
  implicit object IntComparator extends Comparator[Int] {
    def compare(a: Int, b: Int): Int = a - b }
}
