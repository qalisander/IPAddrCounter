import IpAddrCounter.Companion.mapToUint
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import java.io.StringReader
import java.util.*

internal class IpAddrCounterTest {

    @Test
    fun count() {
        val strReader = StringReader("1.2.3.4\n1.2.3.4\n1.2.3.5")
        val ipAddrCounter = IpAddrCounter(strReader)
        val count = ipAddrCounter.count()
        assertEquals(2u, count)
    }

    @Test
    fun mapToUint() {
        val uintIp = "8.4.2.1".mapToUint()
        assertEquals(
            "00001000" + "00000100"+ "00000010"+ "00000001", 
            Integer.toBinaryString(uintIp.toInt()).padStart(32, '0'))
    }
}