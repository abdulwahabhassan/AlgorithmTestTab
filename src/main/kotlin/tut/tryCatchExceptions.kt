import java.lang.IllegalArgumentException

fun main() {

    try { //Try block tries our function and throws an error/exception that we specify in our code  if its conditions are met
        val answer = add(0, 0)
        println(answer)
    } catch(error:Throwable) {
        when (error) { //Control statement to determin what kind of error/exception was thrown
            is OutOfMemoryError -> println("Out of Memory Exception, Calculation could not be completed")
            is IllegalArgumentException -> println("IllegalArgumentException, Calculation could not be completed")
        }
    } finally { //Finally will run after try and catch block. This can be used to clean up memory to avoid memory leak
        println("Now closing application")
    }
}


fun add (x:Int, y:Int):Int {
    if (x == 0 && y == 0) {
        throw IllegalArgumentException("x and y is 0") //Custom type of exception that we can throw and use to set
        //descriptive message for us to easily identify the cause of thrown exception
    } else {
        return x + y
    }
}