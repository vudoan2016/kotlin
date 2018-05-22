import mu.KLogging

class StringUtil {
    companion object: KLogging()
    var name: String
    
    constructor(name: String) {
	this.name = name
    }
    fun findAnagrams(str: String, subStr: String) : Int {
	var i = 0
	var count = 0
	val m = mutableMapOf<Char, Int>()
	while (i <= (str.length - subStr.length)) {
	    for (j in 0..subStr.length-1) {
		m[subStr[j]] = (m[subStr[j]] ?: 0) + 1
		logger.debug(subStr[j] + " " + m.get(subStr[j]))
	    }
	    var seq = str.subSequence(i, i+subStr.length)
	    var hit = true
	    for (j in 0..seq.length-1) {
		if (!m.containsKey(seq[j]) || m.get(seq[j]) == 0) {
		    hit = false
		    break
		} else {
		    m[seq[j]] = (m[seq[j]] ?: 0) -1;
		    logger.debug("hit " + seq[j] + " " + m.get(seq[j]) + " " + subStr[j])
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
}
