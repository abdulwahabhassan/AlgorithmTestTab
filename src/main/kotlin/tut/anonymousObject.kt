fun main() {

    //Using anonymous object to implement an interface
    //An inefficient way to implement an interface would be to extend it to a custom class
    //and call its function from within that class which overrides it, such as is seen
    //in the commented class MyListener.

//    val button = Button()
//    button.clickListener = MyListener()
//    button.click()

    val button = Button()
    button.clickListener = object : OnClickListener {
        override fun onClick() {
            println("BUTTON cLICKED")
        }
    }
    button.click()

    //Another way of implementing an interface using a calling function inside View class
    button.setOnClickListener(object : OnClickListener {
        override fun onClick() {
            println("Clicked Clicked")
        }
    })
    button.click()
}

//class MyListener:OnClickListener {
//    override fun onClick() {
//            println("BUTTON cLICKED")
//    }
//
//}

interface OnClickListener {
    fun onClick()
}

abstract class View {
    lateinit var clickListener: OnClickListener

    fun setOnClickListener(onClickListener: OnClickListener) {
        this.clickListener = onClickListener
    }
    fun click() {
        clickListener.onClick()
    }
}

class Button: View()