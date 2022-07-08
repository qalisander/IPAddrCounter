import kotlin.io.path.Path
import kotlin.io.path.forEachLine

class IpAddrCounter(fileName: String) {
    var strAddrSet = HashSet<String>()
    var uintAddrSet = HashSet<UInt>()
    var filePath = Path(fileName)

    fun count(): UInt {
        var counter = 0u
        filePath.forEachLine { 
            if (it !in strAddrSet) {
                counter++
                strAddrSet.add(it)
            }
        }
        return counter
    }

    // https://kotlinlang.org/docs/extensions.html
    companion object fun String.mapToUint(strIp: String): UInt {
        val numAndShifts = strIp
            .split('.')
            .map { it.toUInt() }
            .zip(0 until UInt.SIZE_BITS step 8)

        var uintIp = 0u
        for ((num, shift) in numAndShifts) {
            uintIp = uintIp or (num shl shift)
        }
        return uintIp
    }
}