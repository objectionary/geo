package codegen

import codegen.traverse.GenNodeObject
import kotlin.random.Random

/**
 * File with representation of [Elem]s and util functions for code generation
 */

private var objectNamesCount = 0
private var attrNamesCount = 0
private var freeAttrNamesCount = 0

fun generateObjectName() = "object_${objectNamesCount++}"

fun generateAttrName() = "attr_${attrNamesCount++}"

fun generateFreeAttrName() = "fa_${freeAttrNamesCount++}"

fun generateObject(obj: GenNodeObject): String {
    var body = "${offset(obj.depth)}["
    obj.freeAttributesList.forEach { body += "$it " }
    if (obj.freeAttributesList.size > 0) body = body.substring(0, body.length - 1)
    body += "] > ${obj.name}\n"
    return body
}

fun generateStateAttr(attrName: String, attrValue: String, depth: Int) = "${offset(depth)}$attrValue > $attrName\n"

fun generateDecoration(attrName: String) = "$attrName > @"

var objectCountMap = mutableMapOf<Int, Int>() // file -> number of objects

fun rand(from: Int, to: Int) = Random.nextInt(from, to)

fun offset(depth: Int): String {
    var ret = ""
    for (i in 0 until depth) {
        ret += "  "
    }
    return ret
}
