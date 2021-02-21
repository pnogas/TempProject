import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import com.paulnogas.log.analyzer.ui.theme.DefaultTypography

// Themes based-on / copied from visual studio default dark and light
// https://github.com/microsoft/vscode/blob/main/extensions/theme-defaults/themes/dark_vs.json
// https://github.com/microsoft/vscode/blob/main/extensions/theme-defaults/themes/light_vs.json
// and https://material.io/resources/color

private val LightColors = Colors(
    primary = Color(0xFF007ACC),
    primaryVariant = Color(0xFF004F9B),
    secondary = Color(0xFF2C2C2C),
    secondaryVariant = Color(0xFF555555),
    background = Color(0xFFFFFFFF),
    surface = Color(0xFFE5E5E5),
    error = Color(0xFFC72E0F),
    onPrimary = Color(0xFFFFFFFF),
    onSecondary = Color(0xFFFFFFFF),
    onBackground = Color(0xFF000000),
    onSurface = Color(0xFF000000),
    onError = Color(0xFFFFFFFF),
    isLight = true
)

private val DarkColors = Colors(
    primary = Color(0xFF323233),
    primaryVariant = Color(0xFF5b5b5c),
    secondary = Color(0xFF007ACC),
    secondaryVariant = Color(0xFF62EFFF),
    background = Color(0xFF1E1E1E),
    surface = Color(0xFF1E1E1E),
    error = Color(0xFF16825D),
    onPrimary = Color(0xFFFFFFFF),
    onSecondary = Color(0xFF000000),
    onBackground = Color(0xFFFFFFFF),
    onSurface = Color(0xFFFFFFFF),
    onError = Color(0xFFFFFFFF),
    isLight = false
)

@Composable
fun DefaultTheme(
    darkModeState: MutableState<Boolean>,
    content: @Composable () -> Unit
) {
    var isDarkMode by darkModeState
    MaterialTheme(
        colors = if (isDarkMode) DarkColors else LightColors,
        typography = DefaultTypography,
        content = content
    )
}