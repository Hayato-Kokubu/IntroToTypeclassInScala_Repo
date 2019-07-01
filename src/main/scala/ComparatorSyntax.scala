object ComparatorSyntax {
  implicit class ComparatorOps[T](a: T)
  (implicit cmp: Comparator[T]) {
    def >-> (b: T): Boolean = cmp.compare(a, b) > 0
  }
}