package codegen

import codegen.traverse.GenNode
import java.io.OutputStream

fun printTree(node: GenNode, outputStream: OutputStream) {
    printRec(node, outputStream)
}

fun printRec(node: GenNode, outputStream: OutputStream) {
    outputStream.write(node.body.toByteArray())
    node.children.forEach { printRec(it, outputStream) }
}