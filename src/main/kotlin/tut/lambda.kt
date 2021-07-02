fun main() {


    speak("woof woof!!")
    println()

    val greeting = greeter("Hassan", "Abdulwahab")
    println(greeting)
    println()

    println(_greeter("Ella", "Andrews"))
    println()


}

//Lambda functions
//val lambdaName: (inputType) -> returnType = {arguments:inputType -> body}
val speak: (String) -> Unit = {sound:String -> println("speaking $sound")}

val greeter: (String, String) -> String = {firstName:String, lastName:String ->
    val modifiedFN = firstName.toUpperCase()
    val modifiedLN = lastName.toUpperCase()
    //The last line of code in a lambda body is always what is returned
    "Good morning $modifiedFN $modifiedLN"
}

//The above lambdas can be written in a simpler expression like so, without specifying the input and return type parameters
val _speak = {sound:String -> "speaking $sound"}

val _greeter = {firstName:String, lastName:String ->
    val modifiedFN = firstName.toUpperCase()
    val modifiedLN = lastName.toUpperCase()
    repeat(2, ){speak("meow meow")}
    //The last line of code in a lambda body is always what is returned
    "Good morning $modifiedFN $modifiedLN"
}


