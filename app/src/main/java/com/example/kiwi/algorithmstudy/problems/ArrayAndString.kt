package com.example.kiwi.algorithmstudy.problems

fun validateIsUnique(str: String): Boolean {
    if (str.length > 128) return false
    val charArr = BooleanArray(128)
    str.forEach {
        if (charArr[it.toInt()]) {
            return false
        }
        charArr[it.toInt()] = true
    }
    return true
}

/**
 * 1. sorting
 * 2. comparing two strings
 */
fun permutation(str1: String, str2: String): Boolean {
    if (str1.length != str2.length) return false

    val sortedStr1 = str1.toSortedSet()
    val sortedStr2 = str2.toSortedSet()
    return sortedStr1 == sortedStr2
}

/**
 * check number of char
 */
fun permutation2(str1: String, str2: String): Boolean {
    if (str1.length != str2.length) return false
    val letters = IntArray(128)
    str1.forEach {
        letters[it.toInt()]++
    }
    str2.forEach {
        letters[it.toInt()]--
        if (letters[it.toInt()] < 0) return false
    }
    return true
}

/**
 * Replace all spaces to "%20"
 */
fun replaceSpaces(str: CharArray, trueLength: Int): String {
    // 1. how many spaces in str => Calculate result string capacity
    // 2. Reverse, Edit String
    var spaceCount = 0
    str.forEach {
        if (it == ' ') {
            spaceCount++
        }
    }
    var index = trueLength + spaceCount * 2 // [ ] 1col => [%][2][0] 1col + 2col
    val resultStr = CharArray(index)
    if (trueLength < str.size) resultStr[trueLength] = '\n'
    for (i in str.lastIndex downTo 0) {
        if (str[i] == ' ') {
            resultStr[index - 1] = '0'
            resultStr[index - 2] = '2'
            resultStr[index - 3] = '%'
            index -= 3
        } else {
            resultStr[index - 1] = str[i]
            index--
        }
    }
    return resultStr.contentToString()
}

/**
 * palindrome
 */
fun isPalindrome(str: String): Boolean {
    // Get number of each char
    val table = buildCharFrequencyTable(str)
    return checkMaxOneOdd(table)
}

fun checkMaxOneOdd(table: IntArray): Boolean {
    var foundOdd = false
    table.forEach {
        if (it % 2 == 1) {
            if (foundOdd) {
                return false
            }
            foundOdd = true
        }
    }
    return true
}

fun getCharNumber(c: Char): Int {
    val a = 'a'.toInt()
//    println("a: $a")
    val z = 'z'.toInt()
//    println("z: $z")
    val integerChar = c.toInt()
    if (integerChar in a..z) {
        return integerChar - a
    }
    return -1
}

fun buildCharFrequencyTable(str: String): IntArray {
    val table = IntArray('z' - 'a' + 1)
    str.forEach {
        val x = getCharNumber(it)
        println("it: $it, x: $x")
        if (x != -1) {
            table[x]++
        }
    }
    return table
}

fun isPalindrome2(str: String): Boolean {
    var countOdd = 0
    val table = IntArray('z' - 'a' + 1)
    str.forEach {
        val x = getCharNumber(it)
        if (x != -1) {
            table[x]++
            if (table[x] % 2 == 1) {
                countOdd++
            } else {
                countOdd--
            }
        }
    }
    return countOdd <= 1
}

/**
 * Did you take one time to edit string
 * ADD|DEL, REPLACE
 */
fun oneEditWay(first: String, second: String): Boolean {
    return when {
        first.length == second.length -> oneEditReplace(first, second)
        first.length + 1 == second.length -> oneEditInsert(first, second)
        first.length - 1 == second.length -> oneEditInsert(second, first)
        else -> false
    }
//    // check length
//    if (Math.abs(first.length - second.length) > 1) {
//        return false
//    }
//
//    // find shorter string: 's1' is shorter than 's2'
//    val s1 = if (first.length < second.length) first else second
//    val s2 = if (first.length < second.length) second else first
//
//    var index1 = 0
//    var index2 = 0
//    var foundDiff = false
//    while (index2 < s2.length && index1 < s1.length) {
//        if (s1[index1] != s2[index2]) {
//            if (foundDiff) return false
//            foundDiff = true
//
//            // replace
//            if (s1.length == s2.length) {
//                index1++
//            }
//        } else {
//            index1++
//        }
//        index2++
//    }
//    return true
}

fun oneEditReplace(s1: String, s2: String): Boolean {
    var foundDiff = false
    for (i in 0..s1.length) {
        if (s1[i] != s2[i]) {
            if (foundDiff) {
                return false
            }
            foundDiff = true
        }
    }
    return true
}

// insert a char to s1, and check that makes s2
fun oneEditInsert(s1: String, s2: String): Boolean {
    var index1 = 0
    var index2 = 0
    while (index2 < s2.length && index1 < s1.length) {
        if (s1[index1] != s2[index2]) {
            if (index1 != index2) {
                return false
            }
            index2++
        } else {
            index1++
            index2++
        }
    }
    return true
}

// sorting
// for문 돌면서 다른문자 만나기전까지 counting
fun compressString(str: String): String {
    var compressedStr = ""
    var countConsecutive = 0
    str.forEachIndexed { index, c ->
        countConsecutive++

        if (index + 1 >= str.length || str[index] != str[index + 1]) {
            compressedStr += "" + str[index] + countConsecutive
            countConsecutive = 0
        }
    }
    return if (compressedStr.length < str.length) compressedStr else str
}

fun compressString2(str: String): String {
    val compressed = StringBuilder()
    var count = 0
    for (i in 0..str.lastIndex) {
        count++
        if (i + 1 >= str.length || str[i] != str[i + 1]) {
            compressed.append(str[i])
            compressed.append(count)
            count = 0
        }
    }
    return if (compressed.length < str.length) compressed.toString() else str
}

fun rotate(matrix: Array<Array<Int>>): Boolean {
    println("matrix.size: $matrix.size, matrix[0].size: $matrix[0].size")
    if (matrix.isEmpty() || matrix.size != matrix[0].size) return false
    for (layer in 0 until matrix.size / 2) {
        val first = layer
        val last = matrix.size - 1 - layer
        for (i in first until last) {
            val offset = i - first
            val top = matrix[first][i]
            // left -> top
            matrix[first][i] = matrix[last - offset][first]
            // bottom -> left
            matrix[last - offset][first] = matrix[last][last - offset]
            // right -> bottom
            matrix[last][last - offset] = matrix[i][last]
            // top -> right
            matrix[i][last] = top
        }
    }
    return true
}

fun setZeros(matrix: Array<Array<Int>>) {
    val row = BooleanArray(matrix.size)
    val col = BooleanArray(matrix[0].size)

    for (i in 0 until matrix.size) {
        for (j in 0 until matrix[0].size) {
            if (matrix[i][j] == 0) {
                row[i] = true
                col[j] = true
            }
        }
    }

    row.forEachIndexed { index, value ->
        if (value) nullifyRow(matrix, index)
    }
    col.forEachIndexed { index, b ->
        if (b) nullifyCol(matrix, index)
    }
}

fun nullifyRow(matrix: Array<Array<Int>>, row: Int) {
    for (i in 0 until matrix[0].size) {
        matrix[row][i] = 0
    }
}

fun nullifyCol(matrix: Array<Array<Int>>, col: Int) {
    for (i in 0 until matrix.size) {
        matrix[i][col] = 0
    }
}

fun isRotation(xy: String, yx: String): Boolean {
    // is it same length?
    if (xy.length == yx.length && xy.isNotEmpty()) {
        val xyxy = xy + xy
        return xyxy.contains(yx)
    }
    return false
}

fun isSubString(xyxy: String, yx: String): Boolean {
    var indexOfYxStarting = 0
    xyxy.forEachIndexed { index, fullstring ->
        if (fullstring == yx.first()) {
            indexOfYxStarting = index
        }
    }

    for (i in indexOfYxStarting until yx.length) {
        yx.forEach { substr ->
            if (substr != xyxy[i]) {
                return false
            }
        }
    }

    return true
}

fun main(args: Array<String>) {
//    println("result: " + isRotation("waterbottle", "erbottlewat"))
    println("result: " + isSubString("aabbaabb", "bbaa"))
//    val input = Scanner(System.`in`)
//
//    val a = input.nextInt()
//    val b = input.nextInt()
//
//    println(a + b)
}