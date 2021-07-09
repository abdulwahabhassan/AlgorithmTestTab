package leetcode

fun main() {
    println(threeSum(intArrayOf(0)))
}

fun threeSum(nums: IntArray): List<List<Int>> {

    var mutableList = mutableListOf<List<Int>>()

    nums.forEachIndexed{indexOne, elemOne ->
        nums.forEachIndexed{indexTwo, elemTwo ->
            nums.forEachIndexed{indexThree, elemThree ->
                if (indexOne != indexTwo && indexOne != indexThree && indexTwo != indexThree && elemOne + elemTwo + elemThree == 0) {
                    mutableList.add(listOf(elemOne, elemTwo, elemThree).sorted())
                }
            }
        }
    }
    return mutableList.distinct()
}