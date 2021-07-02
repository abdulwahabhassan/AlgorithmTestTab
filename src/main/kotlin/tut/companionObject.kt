package tut
fun main() {

    //Using companion objects as a factory for creating instances of a class
    println()
    Decadev.createDecadevs("Mona", "Daniel", "Alan", "Binta")
    println()
    println(Decadev.listOfDecadevs)
    println()
    println(Decadev.numberOfDecadevs)
    println("INSTANCE: ${Decadev.INSTANCE}")
    println()


    val decadevInstance = Decadev("Bayo")
    println(decadevInstance.name)
    println(decadevInstance.title)
    println()


    val decadev1 = Decadev.listOfDecadevs[0]
    println(decadev1.name)
    println(decadev1.title)
    println()

    val decadev2 = Decadev.listOfDecadevs[1]
    println(decadev2.name)
    println(decadev1.title)
    println()

    println(Decadev.createDecadev("Hassan", "GoogleDev"))
    println("INSTANCE: ${Decadev.INSTANCE}")

}

class Decadev(var name:String, var title: String = "Decadev") {


    companion object{

        var INSTANCE: Decadev? = null
        var listOfDecadevs = mutableListOf<Decadev>()
        var numberOfDecadevs = 0

        fun createDecadev(name: String, title:String): Decadev{
            INSTANCE = Decadev(name, title)
            return INSTANCE!!
        }

        fun createDecadevs(vararg names:String) : Decadev {

            for (i in names) {
                INSTANCE = Decadev(name = i.toUpperCase())
                println("${INSTANCE?.name} ${INSTANCE?.title}")
                numberOfDecadevs++
                listOfDecadevs.add(INSTANCE!!)
            }
            return INSTANCE!!
        }
    }

    fun nameTitle():String = "$name $title"

    override fun toString(): String {
        return Decadev(name).nameTitle()
    }
}