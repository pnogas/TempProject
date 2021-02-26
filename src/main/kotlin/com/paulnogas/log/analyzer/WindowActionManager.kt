package com.paulnogas.log.analyzer

import androidx.compose.desktop.AppWindowAmbient
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import java.io.File
import javax.swing.JFileChooser
import javax.swing.filechooser.FileFilter

@Composable
fun WindowActionManager(
    menuBarAction: MenuBarActions,
    darkModeViewModel: DarkModeViewModel,
    filterViewModel: FilterViewModel
) {
    println(menuBarAction)
    when (menuBarAction) {
        MenuBarActions.OpenFile -> openLogFile()
        MenuBarActions.ToggleDarkMode -> toggleDarkMode(darkModeViewModel)
        MenuBarActions.LoadFilters -> loadFilters(filterViewModel)
        else -> {
        } // no-op
    }
}

@Composable
fun openLogFile() {
    var result: File?
    JFileChooser(System.getProperty("user.home")).apply {
        fileFilter = LogFileFilter()
        showOpenDialog(AppWindowAmbient.current!!.window)
        result = selectedFile
    }
    print(result)
}

@Composable
fun toggleDarkMode(darkModeViewModel: DarkModeViewModel) {
    println("d")
    darkModeViewModel.toggleDarkMode()
}

@Composable
fun loadFilters(filterViewModel: FilterViewModel) {
    remember { filterViewModel }
    filterViewModel.loadFilters(TempVars.newLogFilters)
}


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
