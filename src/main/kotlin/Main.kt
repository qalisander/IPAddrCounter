import java.io.FileReader


fun main() {
    println("Enter a file name")
    var fileName = readln()
    if (fileName.isBlank()) {
        fileName = "ip_addresses_light"
    }
    val fileReader = FileReader(fileName)
    val ipAddrCounter = IpAddrCounter(fileReader)
    val count = ipAddrCounter.count()
    println("Unique ip addresses count is: $count")
}