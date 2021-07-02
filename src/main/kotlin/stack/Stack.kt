package stack



fun main() {

    val stack = Stack<Int>().apply {
        push(1)
        push(2)
        push(3)
        push(4)
    }

    println(stack)
    val poppedElement = stack.pop()
    println("popped $poppedElement")
    println(stack)

    val input = "{()[]}[{}]"
    println(input.checkForBalance())

}

interface StackImpl<T> {

    fun push(element: T)

    fun pop(): T?

    fun peek(): T?

    val count: Int
        get

    val isEmpty: Boolean
        get() = count == 0

}

class Stack<T : Any>() : StackImpl<T>  {
    private val storage = arrayListOf<T>()

    override fun toString() = buildString {
        appendLine("----top----")
        storage.asReversed().forEach {
            appendLine("$it")
        }
        appendLine("-----------")
    }

    override fun push(element: T) {
        storage.add(element)
    }

    override fun pop(): T? {
        if (isEmpty) {
            return null
        }
        return storage.removeAt(count - 1)
    }

    override fun peek(): T? {
        return storage.lastOrNull()
    }

    override val count: Int
        get() = storage.size

}

//Function checks for matching parentheses
fun String.checkForBalance(): Boolean {

    val stack = java.util.Stack<Char>()
    for (char in this) {

        when (char) {
            '('  -> stack.push(char)
            '[' -> stack.push(char)
            '{' -> stack.push(char)
            else -> {if (char == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop()
                } else {
                    println("Not balanced")
                    return false
                }
            } else if (char == ']') {
                if (!stack.isEmpty() && stack.peek() == '[') {
                    stack.pop()
                } else {
                    println("Not balanced")
                    return false
                }
            } else if (char == '}') {
                if (!stack.isEmpty() && stack.peek() == '{') {
                    stack.pop()
                } else {
                    println("Not balanced")
                    return false
                }
            }}
        }
    }

    println("Balanced")
    return stack.empty()
}
