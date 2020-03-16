
fun main(){


    var s1= readLine()!!
    var s2 = readLine()!!


    var s: String = ""
    for (j in 1..100) {
        var x = Operations(s1,s1)

        for (i in 1 until s2.toInt()) {
            s = x.sum()
            x = Operations(s, s1)
        }
        println("$s    ;   ${s1.toDouble()*s2.toDouble()}")
        s2 = (j).toString()
    }
    var st:String
    for (i in 0..10)
    {

        println("${0.1*i}")
    }

}


