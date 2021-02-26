package com.paulnogas.log.analyzer

import androidx.compose.desktop.AppWindowAmbient
import java.io.File
import javax.swing.JFileChooser
import javax.swing.filechooser.FileFilter

class WindowActionManager(
    private val darkModeViewModel: DarkModeViewModel,
    private val filterViewModel: FilterViewModel
) {

    fun handleAction(menuBarAction: MenuBarActions) {
        when (menuBarAction) {
            MenuBarActions.OpenFile -> openLogFile()
            MenuBarActions.ToggleDarkMode -> toggleDarkMode()
            MenuBarActions.LoadFilters -> loadFilters()
            else -> {
            } // no-op
        }
    }

    fun openLogFile() {
        var result: File?
        JFileChooser(System.getProperty("user.home")).apply {
            fileFilter = LogFileFilter()
            showOpenDialog(null)
            result = selectedFile
        }
        print(result)
    }

    fun toggleDarkMode() {
        darkModeViewModel.toggleDarkMode()
    }

    fun loadFilters() {
        filterViewModel.loadFilters(TempVars.newLogFilters)
    }
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