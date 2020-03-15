import kotlin.math.max

fun main(){


    val s1: String = readLine()!!
    val s2 = readLine()!!
    val x: Operations = Operations(s1,s2)
    println(x.sumStrings())



}


fun charToInt(c: Char):Short {
    val x = c.toInt()
    when (x){
        48 -> return 0
        49 -> return 1
        50 -> return 2
        51 -> return 3
        52 -> return 4
        53 -> return 5
        54 -> return 6
        55 -> return 7
        56 -> return 8
        57 -> return 9
        else -> return -1
    }
}