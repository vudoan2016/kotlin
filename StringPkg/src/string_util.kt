import java.nio.file.Files
import java.nio.file.Paths
import java.io.IOException

class StringUtil {
    var name: String

    constructor(name: String) {
        this.name = name
    }

    fun countAnagrams(str: String, subStr: String) : Int {
        var i = 0
        var count = 0
        val m = mutableMapOf<Char, Int>()
        while (i <= (str.length - subStr.length)) {
            for (j in 0..subStr.length-1) {
                m[subStr[j]] = (m[subStr[j]] ?: 0) + 1
            }
            var seq = str.subSequence(i, i+subStr.length)
            var hit = true
            for (j in 0..seq.length-1) {
                if (!m.containsKey(seq[j]) || m.get(seq[j]) == 0) {
                    hit = false
                    break
                } else {
                    m[seq[j]] = (m[seq[j]] ?: 0) -1;
                }
            }
            if (hit) {
                count++
            }
            i++
            for (j in 0..subStr.length-1) {
                m.put(subStr[j], 0)
            }

        }
        return count
    }

    fun readFile(file: String): Unit {
        val input = Files.newInputStream(Paths.get(file))
        try {
            var byte = input.read()
            while (byte != -1) {
                println(byte)
                byte = input.read()
            }
        } catch (e: IOException) {
            println("Error reading from file. Error was ${e.message}")
        } finally {
            input.close()
        }
    }
}