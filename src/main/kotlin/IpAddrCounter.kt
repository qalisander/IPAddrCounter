import java.io.BufferedReader
import java.io.Reader
import java.util.BitSet

class IpAddrCounter(reader: Reader) {
    // Ip address is 4 bytes long, but we can index bitSet with just ~2 billion index
    // (Negative Int is not valid for indexing)
    // So, we need two bitsets for positive and negative values
    // It takes just 500mb memory for two arrays
    private val posAddrSet = BitSet(Int.MAX_VALUE)
    private val negAddrSet = BitSet(Int.MAX_VALUE)
    private val reader = BufferedReader(reader)

    fun count(): UInt {
        var counter = 0u
        reader.forEachLine {
            val intIp = it.strIpToInt()
            if (intIp >= 0) {
                if (!posAddrSet[intIp]) {
                    counter++
                    posAddrSet.set(intIp)
                }
            } else {
                if (!negAddrSet[-intIp]) {
                    counter++
                    negAddrSet.set(-intIp)
                }
            }
        }
        return counter
    }

    companion object {
        fun String.strIpToInt(): Int {
            return this
                .split('.')
                .map { it.toInt() }
                .zip((0 until Int.SIZE_BITS step 8).reversed())
                .fold(0) { intIp, (num, shift) ->
                    intIp or (num shl shift)
                }
        }
    }
}
