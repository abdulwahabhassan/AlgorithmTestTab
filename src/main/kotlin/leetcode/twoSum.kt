package leetcode

fun main() {

    println(twoSum(intArrayOf(2,7,11,15), 9))
}

fun twoSum(nums: IntArray, target: Int): IntArray {

    var intArray = intArrayOf()
    nums.forEachIndexed{indexOne, elemOne ->
        nums.forEachIndexed{indexTwo, elemTwo ->
            if (elemOne + elemTwo == target && indexOne != indexTwo) {
                intArray = intArrayOf(indexOne, indexTwo)
                println("$indexOne $indexTwo")
            }
        }
    }
    return intArray
}