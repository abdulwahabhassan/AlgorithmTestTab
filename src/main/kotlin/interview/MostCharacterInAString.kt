package interview

fun main() {
    println(returnNumOfMostChar("pauflaoojojaadffa"))
}

fun returnNumOfMostChar (string: String): Int {

    val hashMap = hashMapOf<Char, Int>()

    for (i in string) {
        if (hashMap.containsKey(i)) {
            val v = hashMap[i]!!
            hashMap[i] = v + 1
        } else {
            hashMap[i] = 1
        }
    }

    println(hashMap.entries)
    return hashMap.entries.map { it.value }.maxOrNull() ?: 0
}