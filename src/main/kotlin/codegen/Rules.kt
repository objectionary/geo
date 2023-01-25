package codegen

/**
 * Types of elements in a basic tree
 */
enum class Elem {
    OBJECT, STATE_OBJECT, DECORATION, DOT
}

/**
 * Declares which elements can be inserted into the body of the key element
 */
val rules = hashMapOf(
    Elem.OBJECT to listOf(Elem.OBJECT, Elem.STATE_OBJECT, Elem.DECORATION, Elem.DOT),
)
