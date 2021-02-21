import androidx.compose.desktop.AppManager
import androidx.compose.desktop.Window
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.window.KeyStroke
import androidx.compose.ui.window.Menu
import androidx.compose.ui.window.MenuBar
import androidx.compose.ui.window.MenuItem
import com.paulnogas.log.analyzer.Body
import com.paulnogas.log.analyzer.Footer
import com.paulnogas.log.analyzer.Header
import java.awt.image.BufferedImage
import javax.imageio.ImageIO

fun main() {
    // To use Apple global menu.
    System.setProperty("apple.laf.useScreenMenuBar", "true")

    var isDarkMode = mutableStateOf(true)
    val lastAction = mutableStateOf("")

    AppManager.setMenu(
        MenuBar(
            Menu(
                name = "File",
                MenuItem(
                    name = "Open",
                    onClick = { lastAction.value = "Open" },
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
                    onClick = { lastAction.value = "DarkMode" },
                    shortcut = KeyStroke(Key.D)
                ),
                MenuItem(
                    name = "Load Analysis Template",
                    onClick = { lastAction.value = "LoadTemplate" },
                    shortcut = KeyStroke(Key.L)
                )
            ),
        )
    )

    Window(title = "Log Analyzer", icon = loadImageResource("app_icon.png")) {
        DefaultTheme(isDarkMode) {
            Surface(Modifier.fillMaxSize()) {
                Column {
                    Header(isDarkMode)
                    Box(
                        Modifier.weight(1f)
                    ) {
                        Body()
                    }
                    Footer()
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