import java.nio.file.Paths

fun main(args: Array<String>) {
    val s = StringUtil("Kotlin String")

    val statement = " aby ... maybe not baby ... whatever ... abab ... blah"
    val word = "aab"
    print("1. '" + word + "'" + " appears " + s.countAnagrams(statement, word))
    println(" times in " + "'" + statement + "'")

    s.readFile("Spelling-Grade5_Unit1.txt")
}
