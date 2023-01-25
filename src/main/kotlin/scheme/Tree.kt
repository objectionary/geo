package scheme

import config.OBJECTS
import codegen.Elem

/**
 * Tree is a basic scheme for the future generated code, it consists of [Node]s
 */
class Tree {

    private val builder = TreeBuilder()
    val heads: MutableList<Node> = mutableListOf()

    fun build() {
        for (i in 0 until OBJECTS) {
            val objectNode = Node(Elem.OBJECT, 0)
            heads.add(objectNode)
            builder.buildObject(objectNode)
        }
    }

    /**
     * Node representation, contains a list of children and a type of node represented by the [Elem]
     */
    data class Node(val type: Elem, val depth: Int) {
        val children: MutableList<Node> = mutableListOf()
    }
}
