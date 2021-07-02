fun main() {

    var arr = arrayOf(arrayOf(0, 2), arrayOf(1, 1))
    var arr2 = arrayOf(arrayOf(1, 3, 1), arrayOf(2, 1, 2), arrayOf(3, 3, 3))

    println(organizingContainers(arr))
    println(organizingContainers(arr2))
}

fun organizingContainers(container: Array<Array<Int>>): String {
    // Write your code here
    var size = container.size - 1

    val mutableList = MutableList(container.size){0}

    while (size >= 0) {
        container.forEachIndexed { index, array ->
            mutableList[size] = array[size] + mutableList[size]
        }
        size--
    }


    println("arrayList: ${mutableList}")
    var distinct = mutableList.distinct()
    println("distinct arrayList: ${distinct}")

    mutableList.forEachIndexed { index, i ->
         for(int in index+1 until mutableList.size) {
             if (mutableList[int] == i) {
                 mutableList[int] = 0
             }
         }
    }

    val filteredList = mutableList.filter { int -> int != 0 }

    println("Answer: $filteredList")

    return "Not solved"

}