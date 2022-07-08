import java.io.BufferedReader
import java.io.Reader
import java.util.BitSet

class IpAddrCounter(reader: Reader) {
    private val addrSet = HashSet<UInt>()
    private val reader = BufferedReader(reader)

    fun count(): UInt {
        var counter = 0u
        reader.forEachLine { 
            val uintIp = it.mapToUint()
            if (uintIp !in addrSet) {
                counter++
                addrSet.add(uintIp)
                if (counter % 1_000_000u == 0u) {
                    println(counter)
                }
            }
        }
        return counter
    }

    // https://kotlinlang.org/docs/extensions.html
    companion object {
        fun String.mapToUint(): UInt {
            val numAndShifts = this
                .split('.')
                .map { it.toUInt() }
                .zip((0 until UInt.SIZE_BITS step 8).reversed())

            var uintIp = 0u
            for ((num, shift) in numAndShifts) {
                uintIp = uintIp or (num shl shift)
            }
            return uintIp
        }
    }
}