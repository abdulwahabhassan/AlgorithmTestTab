package hackerrank

import stack.Stack

fun main() {

    sockMerchant(9, arrayOf(10, 20, 20, 10, 10, 30, 50, 10, 20))

}

fun sockMerchant(n: Int, ar: Array<Int>): Int {

    var count = 0
    ar.sort()
    val stack = Stack<Int>()
    for (int in ar) {
        if (stack.isEmpty || stack.peek() != int) {
            stack.push(int)
        } else {
            stack.pop()
            count++
        }
    }
    return count

}