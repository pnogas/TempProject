package com.paulnogas.log.analyzer

import androidx.compose.desktop.AppWindowAmbient
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import java.io.File
import java.io.FilenameFilter
import javax.swing.JFileChooser
import javax.swing.filechooser.FileFilter

@Composable
fun WindowActionManager(lastAction: State<String>) {
    if (lastAction.value == "Open") {
        var result: File?
        JFileChooser("C:\\Users\\pnogas").apply {
            fileFilter = LogFileFilter()
            showOpenDialog(AppWindowAmbient.current!!.window)
            result = selectedFile
        }
        print(result)
        /** AWT file filter doesn't work for windows, otherwise it's okay */
//        var result: Array<File?> = arrayOf(null)
//        FileDialog(AppWindowAmbient.current!!.window).apply {
//            directory = "C:\\Users\\pnogas"
//            isMultipleMode = false
//            filenameFilter = LogFileNameFilter()
//            isVisible = true
//            result = files
//        }
//        println(result[0]?.path)
    }
}

//class LogFileNameFilter : FilenameFilter {
//    override fun accept(dir: File?, name: String?): Boolean {
//        return name?.let {
//            it.endsWith(".txt", true) ||
//                    it.endsWith(".log", true)
//        } ?: false
//    }
//}

class LogFileFilter : FileFilter() {
    override fun accept(f: File?): Boolean {
        return f?.let {
            it.isDirectory ||
                    it.name.endsWith(".txt", true) ||
                    it.name.endsWith(".log", true)
        } ?: false
    }

    override fun getDescription(): String {
        return "Log Files"
    }
}
