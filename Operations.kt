import kotlin.math.max

class Operations(val st1:String, val st2: String) {


    fun sumStrings(): CharArray{
        val n = st1.length; val m = st2.length
        var N = max(n,m)
        var i = 0; var j = 0
        var z: Array<IntArray> = Array( 3, {IntArray(N+1,{0}) } )
        for (i in 0..n-1)
                z[1][i] = charToInt(st1[n-1-i])
        for (i in 0..m-1)
            z[2][i] = charToInt(st2[m-1-i])
        var t = 0
        for (i in 0 until N) if (z[1][i] + z[2][i] + t >= 10) {
            z[0][i] = (z[1][i] + z[2][i] + t) % 10
            t = 1
            if (i == N-1)
            {
                N = N+1
                z[0][N-1] = 1;
            }
        } else {
            z[0][i] = z[1][i] + z[2][i] + t
            t = 0
        }
        var s:CharArray = CharArray(N, {'0'})
        for (i in 0 until N)
            s[i] = intToChar(z[0][N-1-i])

    return s}








    fun charToInt(c: Char):Int {
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

    fun intToChar(i: Int):Char{
        when (i){
            0 -> return '0'
            1 -> return '1'
            2 -> return '2'
            3 -> return '3'
            4 -> return '4'
            5 -> return '5'
            6 -> return '6'
            7 -> return '7'
            8 -> return '8'
            9 -> return '9'
            else -> return 'z'
        }

    }
}