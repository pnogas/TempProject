import androidx.compose.desktop.AppManager
import androidx.compose.desktop.Window
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.window.KeyStroke
import androidx.compose.ui.window.Menu
import androidx.compose.ui.window.MenuBar
import androidx.compose.ui.window.MenuItem
import com.paulnogas.log.analyzer.*
import java.awt.image.BufferedImage
import javax.imageio.ImageIO

fun main() {
    val filterViewModel = FilterViewModel()
    val searchViewModel = SearchViewModel()
    val darkModeViewModel = DarkModeViewModel()

    filterViewModel.loadFilters(TempVars.defaultLogFilters)
    // To use Apple global menu.
    System.setProperty("apple.laf.useScreenMenuBar", "true")

    val windowActionManager = WindowActionManager(darkModeViewModel, filterViewModel)

    AppManager.setMenu(
        MenuBar(
            Menu(
                name = "File",
                MenuItem(
                    name = "Open",
                    onClick = { windowActionManager.handleAction(MenuBarActions.OpenFile) },
                    shortcut = KeyStroke(Key.O)
                ),
                MenuItem(
                    name = "Exit",
                    onClick = { AppManager.exit() },
                    shortcut = KeyStroke(Key.Q)
                )
            ),
            Menu(
                name = "Options",
                MenuItem(
                    name = "Dark Mode",
                    onClick = { windowActionManager.handleAction(MenuBarActions.ToggleDarkMode) },
                    shortcut = KeyStroke(Key.D)
                ),
                MenuItem(
                    name = "Load Filters",
                    onClick = { windowActionManager.handleAction(MenuBarActions.LoadFilters) },
                    shortcut = KeyStroke(Key.L)
                )
            ),
        )
    )

    Window(title = "Log Analyzer", icon = loadImageResource("app_icon.png")) {
        println("hi")
        DefaultTheme(darkModeViewModel) {
            Surface(Modifier.fillMaxSize()) {
                Column {
                    Header(darkModeViewModel, filterViewModel, searchViewModel)
                    Box(
                        Modifier.weight(1f)
                    ) {
                        Body(searchViewModel)
                    }
                    Footer(searchViewModel)
                }
            }
        }
    }
}

@Suppress("SameParameterValue")
private fun loadImageResource(path: String): BufferedImage {
    val resource = Thread.currentThread().contextClassLoader.getResource(path)
    requireNotNull(resource) { "Resource $path not found" }
    return resource.openStream().use(ImageIO::read)
}