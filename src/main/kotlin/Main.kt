import codegen.*
import codegen.traverse.Traverser
import scheme.Tree
import config.OBJECTS
import config.DEST_FOLDER
import java.io.ByteArrayOutputStream
import java.io.File
import java.nio.file.Files
import java.nio.file.Path
import java.util.logging.Level
import java.util.logging.Logger
import kotlin.io.path.outputStream

fun main(args: Array<String>) {
    init()
    val tree = Tree()
    tree.build()
    val traverser = Traverser(tree)
    traverser.traverse()
    val path = Path.of("$DEST_FOLDER${File.separatorChar}sample.eo")
    if (Files.exists(path)) Files.delete(path)
    val file = Files.createFile(path)
    val baos = ByteArrayOutputStream()
    traverser.heads.forEach { node ->
        run {
            baos.write(node.body.toByteArray())
        }
    }
    file.outputStream().write(baos.toByteArray())
    Logger.getLogger("Main").log(Level.INFO, "Successfully generated sample.eo")
}

fun init() {
    for (i in 0 until OBJECTS) {
        objectCountMap[i] = 0
    }
}