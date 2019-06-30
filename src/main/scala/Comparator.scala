trait Comparator[T] {
  def compare(a: T, b: T): Int
}

object IntComparator extends Comparator[Int] {
  def compare(a: Int, b: Int): Int = a - b
}

