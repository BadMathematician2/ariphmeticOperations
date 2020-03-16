import kotlin.math.max

class Operations(val st1:String, val st2: String) {


    private val n = st1.length; private val m = st2.length
    private var N = max(n,m)

    private fun sumStringsInt(): String{

        var z= Array( 3) {IntArray(N+1) {0} }
        for (i in 0 until n)
            z[1][i] = charToInt(st1[n-1-i])
        for (i in 0 until m)
            z[2][i] = charToInt(st2[m-1-i])
        var t = 0
        for (i in 0 until N) if (z[1][i] + z[2][i] + t >= 10) {
            z[0][i] = (z[1][i] + z[2][i] + t) % 10
            t = 1
            if (i == N-1)
            {
                N += 1
                z[0][N-1] = 1;
            }
        } else {
            z[0][i] = z[1][i] + z[2][i] + t
            t = 0
        }
        var s = ""
        for (i in 0 until N)
            s += intToString(z[0][N - 1 - i])

        return s
    }


    private fun sumStringsDouble(): String
    {


        var z= Array( 6) {IntArray(N+1) {0} }  // 0, 1 ціла і дробова частина результату;
                                                                                                // 2,3 - ціла і дробова частина першого числа
        for (i in st1.substringBefore('.').indices)                               // 4,5 - ціла і дробова частина другого числа
          z[2][i] = charToInt(st1[st1.substringBefore('.').length - 1 - i])
        if (!intOrDouble(st1))
        for (i in st1.substringAfter('.').indices)                        // 4,5 - ціла і дробова частина другого числа
            z[3][i] = charToInt(st1.substringAfter('.')[i])


        for (i in st2.substringBefore('.').indices)                               // 4,5 - ціла і дробова частина другого числа
            z[4][i] = charToInt(st2[st2.substringBefore('.').length-1-i])
        if (!intOrDouble(st2))
        for (i in st2.substringAfter('.').indices)                               // 4,5 - ціла і дробова частина другого числа
            z[5][i] = charToInt(st2.substringAfter('.')[i])
         var whole = max(st1.substringBefore('.').length,st2.substringBefore('.').length)
        val frac = max(st1.substringAfter('.').length,st2.substringAfter('.').length)


        var t = 0
        for (i in frac-1 downTo 0) if (z[3][i] + z[5][i] + t >= 10) {
            z[1][i] = (z[3][i] + z[5][i] + t) % 10
            t = 1
        }
        else {
            z[1][i] = z[3][i] + z[5][i] + t
            t = 0
        }
        for (i in 0 until whole) if (z[2][i] + z[4][i] + t >= 10) {
            z[0][i] = (z[2][i] + z[4][i] + t) % 10
            t = 1
            if (i == whole-1)
            {
                whole += 1
                z[0][whole-1] = 1;
            }
        } else {
            z[0][i] = z[2][i] + z[4][i] + t
            t = 0
        }

        var s1 = ""; var s2 = ""
        for (i in 0 until whole)
            s1 += intToString(z[0][whole - 1 - i])

        for (i in 0 until frac)
            s2 += intToString(z[1][i])


        return "$s1.$s2"
    }

    fun sum():String{
        if (intOrDouble(st1)&&intOrDouble(st2))
            return sumStringsInt()
        else return sumStringsDouble()
    }

    private fun intOrDouble(s:String):Boolean{
        return s.all{
            it.isDigit()}
    }

    private fun charToInt(c: Char):Int {
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

    private fun intToString(i: Int):String{
        return when (i){
            0 -> "0"
            1 -> "1"
            2 -> "2"
            3 -> "3"
            4 -> "4"
            5 -> "5"
            6 -> "6"
            7 -> "7"
            8 -> "8"
            9 -> "9"
            else -> "Not number"
        }

    }


}