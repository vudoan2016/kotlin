package Util

fun main(args: Array<String>) {
    val s = StringUtil("Kotlin String")
    
    val greeting = "Hello Kotlin. "
    var statement: String = "Here I come!"
    print(greeting + statement)
    statement = " aby ... maybe not baby ... whatever ... abab ... blah"
    println(statement)
    
    val word = "aab"
    print("'" + word + "'" + " appears " + s.findAnagrams(statement, word))
    println(" times in " + "'" + statement + "'")
}

