package tut
fun main() {

 //Simple creation and connection of nodes
    val node1 = Node(9, Node(2))
    val node2 = Node(3, node1)
    val node3 = Node(4, node2)
    val node4 = Node(7, node3)

    //OR

    val nodeA = Node("A")
    val nodeB = Node("B")
    val nodeC = Node("C")

    nodeA.next = nodeC
    nodeC.next = nodeB

    println(node4) //Prints a list of connected nodes
    println(nodeA) //prints a list of connected nodes

 //As far as practicality goes, this method of building lists is far from ideal.
 //You can easily see that building long lists in this way is impractical.
 //A common way to alleviate this problem is to build a LinkedList that manages the Node objects

    //Push Example
    val list = LinkedList<Int>()
    list.push(1).push(2).push(3)
    println("list after push op. $list")
    list.append(1).append(2).append(3)
    println("list after append op. $list")
    val middleNode = list.nodeAt(2)
    println("middle node after (nodeAt op.) $middleNode")
    println(list.insert(0, middleNode!!))
    println("list after insert op. $list")
    val popValue = list.pop()
    println("popped value $popValue")
    println("list after pop $list")
    val removedLastValue = list.removeLast()
    println("removed last value $removedLastValue")
    println("list after removing last value $list")
    list.size
}


 //Generic data class for creating nodes of any data type
data class Node<T>(var value:T, var next: Node<T>? = null) {
    override fun toString(): String {
        return if (next != null) {
            "$value -> ${next.toString()}"
        } else {
            "$value"
        }
    }
}


 //Generic class for creating LinkedLists of any data type
class LinkedList<T> {
     private var head: Node<T>? = null
     private var tail: Node<T>? = null
     var size = 0
        private set


     private fun isEmpty(): Boolean {
         return size == 0
     }

 //Adding a value at the front of a linked list (head-first insertion)
 //Linked list has the advantage of a constant time insertion at the front

     //Push adds a value at the front of the linked list
     fun push(value: T): LinkedList<T> {
         head = Node(value, head)
         if (tail == null) {
             tail = head
         }
         size++
         return this
     }

 //Adding a value at the end of a list (tail-end-insertion)
     //Append adds a value at the end of a linked list
     fun append(value: T): LinkedList<T> {
         if (isEmpty()) {
             push(value)
             return this
         }
         tail?.next = Node(value)
         tail = tail?.next
         size++
         return this
     }

 //Inserting a value at a particular place in a linkedList
 //It involves two steps: (1) Finding a particular node in the list,
     //(2) Inserting the new node after that node

     fun nodeAt(index: Int): Node<T>? {
         var currentNode = head
         var currentIndex = 0

         while (currentNode != null && currentIndex < index) {

             currentNode = currentNode.next
             currentIndex++
         }
         return currentNode
     }

     fun insert(value: T, afterNode: Node<T>): Node<T> {

         if (tail == afterNode) {
             append(value)
             return tail!!
         }

         val newNode = Node(value, afterNode.next)
         afterNode.next = newNode
         size++
         return newNode
     }

   //Removing a value at the front of a linked list (pop)
     fun pop(): T? {

       if (!isEmpty()) size--
           val value = head?.value
           head = head?.next

       if (isEmpty()) {
           tail = null
       }
           return value
     }
  //Removing a value at the end of a linked list
     fun removeLast(): T? {

      val head = head ?: return null //if head is null, there is nothing to remove so return null
      if (head.next == null) return pop() //if list has only one node, simply pop it

      size-- //At this point, you know that you’ll be removing a node, so you update the size of the list accordingly.

      //Keep searching for the next node until current.next is null signifying the last node in the list
      var prev = head
      var current = head
      var next = current.next

      while(next != null) {
          prev = current
          current = next
          next = current.next
      }

      //Then disconnect the last node using prev.next reference
      prev.next = null
      tail = prev //Also update the tail reference
      return current.value
     }

   //Removing a node at a particular position in a linked list
     //First find the node immediately before the node you wish to remove and then unlink it

     fun removeAfter(node: Node<T>): T? {
         val result = node.next?.value

         if (node.next == tail) {
             tail = node
         }

         if (node.next != null) {
             size--
         }

         node.next = node.next?.next
         return result
     }

  //Returns a string representation of the object
     override fun toString(): String {
         return if (isEmpty()) {
             "Empty List"
         } else {
             head.toString()
         }
     }

 }

