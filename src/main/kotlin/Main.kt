import java.io.FileReader


fun main(args: Array<String>) {
//    val fos = FileOutputStream("compressed.zip")
//    val zos = ZipOutputStream(fos)
//    val zipFile = ZipFile("ip_addresses.zip")
//    for (entry in zipFile.entries()) {
//        val inputStream = zipFile.getInputStream(entry)
//        inputStream.readNBytes(1000)
//    }
    
//    writing to file in Kotlin
//    https://www.studytonight.com/kotlin/kotlin-file-handling
    
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