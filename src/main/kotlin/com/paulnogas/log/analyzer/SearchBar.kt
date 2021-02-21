package com.paulnogas.log.analyzer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.AmbientDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.awt.Shape

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
) {
    var searchText by remember { mutableStateOf("") }
    Row(
        modifier = modifier
            .background(
                color = MaterialTheme.colors.onSurface.copy(alpha = ContainerAlpha), // copied from TextField source code
                shape = RoundedCornerShape(4.dp)
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(Icons.Filled.Search, modifier = Modifier.padding(horizontal = 4.dp))
        BasicTextField(
            modifier = Modifier.fillMaxWidth(),
            textStyle = MaterialTheme.typography.caption.copy(color = MaterialTheme.colors.onSurface),
            value = searchText,
            onValueChange = { searchText = it },
            cursorColor = MaterialTheme.colors.onSurface,
            singleLine = true
        )
    }
}