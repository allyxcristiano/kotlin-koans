package i_introduction._3_Default_Arguments

import util.TODO
import util.doc2

fun todoTask3(): Nothing = TODO(
        """
        Task 3.
        Several overloaded 'foo' functions in the class 'JavaCode3' can be replaced with one function in Kotlin.
        Change the declaration of the function 'foo' in a way that makes the code using 'foo' compile.
        You have to add 'foo' parameters and implement its body.
        Uncomment the commented code and make it compile.
    """,
        documentation = doc2(),
        references = { name: String -> JavaCode3().foo(name); foo(name) })

val defaultNumber : Int = 42

fun foo(name: String): String {
    return foo(name, defaultNumber)
}

fun foo(name: String, number: Int): String {
    return foo(name, number, false)
}

fun foo(name: String, toUpperCase: Boolean): String {
    return foo(name, defaultNumber, toUpperCase)
}

fun foo(name: String, number: Int, toUpperCase: Boolean): String {
    return (if (toUpperCase) name.toUpperCase() else name) + number.toString()
}

fun task3(): String {
    return (foo("a") +
            foo("b", number = 1) +
            foo("c", true) +
            foo("d", 2, true))
}