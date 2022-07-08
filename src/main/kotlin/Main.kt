import java.io.File
import java.io.FileOutputStream
import java.util.zip.ZipFile
import java.util.zip.ZipInputStream
import java.util.zip.ZipOutputStream
import kotlin.io.path.Path
import kotlin.io.path.forEachLine
import kotlin.io.path.useLines


fun main(args: Array<String>) {
//    println("Hello World!")
//----------------------------
//    val fos = FileOutputStream("compressed.zip")
//    val zos = ZipOutputStream(fos)
//    val zipFile = ZipFile("ip_addresses.zip")
//    for (entry in zipFile.entries()) {
//        val inputStream = zipFile.getInputStream(entry)
//        inputStream.readNBytes(1000)
//    }
    
//    writing to file in Kotlin
//    https://www.studytonight.com/kotlin/kotlin-file-handling
    
    var ipAddrCounter = IpAddrCounter("ip_addresses_light")
    val count = ipAddrCounter.count()
    println("Unique ip addresses count is: ${count}")
}