import IpAddrCounter.Companion.strIpToInt
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import java.io.StringReader
import java.util.*

internal class IpAddrCounterTest {

    @Test
    fun count() {
        val strReader = StringReader("1.2.3.4\n1.2.3.4\n1.2.3.5\n129.0.0.0")
        val ipAddrCounter = IpAddrCounter(strReader)
        val count = ipAddrCounter.count()
        assertEquals(3u, count)
    }

    @Test
    fun mapToUint() {
        var uintIp = "8.4.2.1".strIpToInt()
        assert(uintIp > 0)
        assertEquals(
            "00001000" + "00000100"+ "00000010"+ "00000001", 
            Integer.toBinaryString(uintIp).padStart(32, '0'))
        uintIp = "128.4.2.1".strIpToInt()
        assert(uintIp < 0)
        assertEquals(
            "10000000" + "00000100"+ "00000010"+ "00000001", 
            Integer.toBinaryString(uintIp).padStart(32, '0'))
    }
}