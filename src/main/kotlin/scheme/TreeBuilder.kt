package scheme

import codegen.*
import config.MAX_DEPTH
import config.MAX_DOT
import config.MAX_INNER_OBJECTS
import config.MAX_STATE_OBJECTS

/**
 * Builds the tree using [Tree] representation
 */
class TreeBuilder {

    fun buildObject(objectNode: Tree.Node, d: Int = 0) {
        val depth = d + 1
        // todo use [rules] map
        objectNode.children.add(Tree.Node(Elem.DECORATION, depth))
        if (depth < MAX_DEPTH) {
            for (i in 0..rand(0, MAX_INNER_OBJECTS)) {
                val node = Tree.Node(Elem.OBJECT, depth)
                buildObject(node, depth + 1)
                objectNode.children.add(node)
            }
        }
        for (i in 0..rand(0, MAX_STATE_OBJECTS)) {
            objectNode.children.add(Tree.Node(Elem.STATE_OBJECT, depth))
        }
        for (i in 0..rand(0, MAX_DOT)) {
            objectNode.children.add(Tree.Node(Elem.DOT, depth))
        }
    }
}