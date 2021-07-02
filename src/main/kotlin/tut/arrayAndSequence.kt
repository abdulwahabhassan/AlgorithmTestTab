
fun main() {
    val items = arrayOf(2,3,4,5,9,10)
    var answer = 5
    items.forEachIndexed { index, i ->
        if (i > answer) {
            answer = i
            println(index)
        }
    }
    println("answer = $answer")
    println()

    val firstUsersList = arrayOf(User("Ani", 10), User("Sophia", 18))
    firstUsersList.forEach { println(it) }
    println()
    val secondUsersList = firstUsersList.plus(User("Monica", 12))

    //Map applies a transformation to each item a give collection and returns a list of their result
    //As it is convenient to chain operations on a map
    secondUsersList.map{it.age.plus(2)}
        .forEachIndexed{index, elem ->
            println (secondUsersList[index].name+" is now $elem years old and at index position $index")}

    println()
    val list = generateSequence(1) {it + 1 }
        .take(10)
        .toList()
    println(list)

    val result = list
        .filter { it % 3 == 0 }
        .average()

    println(result)
    println("DONE!")
}