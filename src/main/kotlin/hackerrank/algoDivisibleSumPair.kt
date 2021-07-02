fun main() {

    val arr = arrayOf(1, 2, 3, 4, 5)
    println(divisibleSumPairs1(6, 5, arr))
    println("------------------------------------------")
    val ar = arrayOf(1, 2, 3, 4, 5)
    println(divisibleSumPairs2(6, 5, ar))

    for (i in 5 until 4) {
        println(" I am $i")
    }
}

//Method 1
fun divisibleSumPairs1(n:Int, k:Int, arr:Array<Int>): Int {
    var count = 0 //Initialize a counter starting at 0
    arr.forEachIndexed { index, number -> //Create a ForEachIndexed loop that allows you to move
        //through the array and perform operation(s) on each element of the array along the
        //way. The advantage of the ForEachIndexed loop is that it gives you access to each elements
        //corresponding index
        if (index != arr.size - 1) { //Set a condition to do no further operation once
            //the loop has reached the last index of the array, since there are no values in front of it
            //to loop through and add to itself.
            for (i in index+1 until arr.size) { //Until we are at the last index of the array,
                //loop through the array starting from the next element of the current element our
                // ForEachIndexed loop is on
                val sum = number + arr[i]

                if (sum % k == 0) {
                    println("Pairs: $number ${arr[i]}")
                count++
                }
            }
        }
    }
    println("count ${count}")
    return count
}

//Method2
fun divisibleSumPairs2(n:Int, k:Int, ar:Array<Int>): Int {

    var counter = 0

    for(i in ar.indices){
        for (j in ar.indices){
            if(i < j && (ar[i] + ar[j]) % k == 0){
                counter++
            }
        }
    }
    return counter
}