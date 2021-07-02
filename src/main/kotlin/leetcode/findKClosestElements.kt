package leetcode

fun main() {
    findClosestElements(intArrayOf(1,2,3,4,5), 4, 3)
    findClosestElements(intArrayOf(1,2,3,4,5), 4, -1)
    findClosestElements(intArrayOf(1,1,1,10,10,10), 1, 9)
}

fun findClosestElements
            (arr: IntArray, k: Int, x: Int): List<Int> {
    val mutableList = arr.toMutableList()

    if (x !in mutableList) {
        mutableList.add(x)
    }
    mutableList.sort()
    val indexOfX = mutableList.indexOf(x)

    val negativeRange = indexOfX - k
    val positiveRange = indexOfX + k

    val list = mutableListOf<Int>()

    mutableList.forEachIndexed { index, i ->
        if(index in negativeRange..positiveRange) {
            list.add(i)
        }
    }
    if(x !in arr) { list.remove(x)}

    val collectionList = mutableListOf<Int>()
    val mappedList = list.map { Math.abs((it - x)) }
    var min = mappedList.min()

    while(collectionList.size < k) {

        if(min != null) {
            mappedList.forEachIndexed { index, i ->
                if(i == min) {
                    collectionList.add(list[index])
                }
            }
        }
        min.let { if (min != null) {min++} }
    }

    val droppedList = collectionList.dropLast(collectionList.size - k)
        .toMutableList()
    droppedList.sort()

    println(droppedList)
    return droppedList

}