class User (var name:String, var age:Int) {

    //This allows us to override the string representation of objects
    //Instead of a string displaying an object's memory address, we'll see name and age
    override fun toString(): String {
        return "$name $age"
    }
}