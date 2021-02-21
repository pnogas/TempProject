package com.paulnogas.log.analyzer

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

val tempText = listOf("Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
    "Quisque auctor dapibus justo, eget accumsan elit viverra eget.",
    "Nulla quis ante quis nulla molestie malesuada",
    "Mauris vel sodales nisl, sit amet auctor ante.",
    "Nunc ornare hendrerit orci, sed euismod erat.",
    "Morbi efficitur est arcu, vitae hendrerit ex fringilla vitae.",
    "Sed aliquam pretium aliquam.",
    "Aenean purus turpis, tristique sed volutpat varius, vulputate in neque.",
    "Nam eu placerat massa.",
    "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
    "Quisque auctor dapibus justo, eget accumsan elit viverra eget.",
    "Nulla quis ante quis nulla molestie malesuada",
    "Mauris vel sodales nisl, sit amet auctor ante.",
    "Nunc ornare hendrerit orci, sed euismod erat.",
    "Morbi efficitur est arcu, vitae hendrerit ex fringilla vitae.",
    "Sed aliquam pretium aliquam.",
    "Aenean purus turpis, tristique sed volutpat varius, vulputate in neque.",
    "Nam eu placerat massa.",
    "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
    "Quisque auctor dapibus justo, eget accumsan elit viverra eget.",
    "Nulla quis ante quis nulla molestie malesuada",
    "Mauris vel sodales nisl, sit amet auctor ante.",
    "Nunc ornare hendrerit orci, sed euismod erat.",
    "Morbi efficitur est arcu, vitae hendrerit ex fringilla vitae.",
    "Sed aliquam pretium aliquam.",
    "Aenean purus turpis, tristique sed volutpat varius, vulputate in neque.",
    "Nam eu placerat massa.",
    "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
    "Quisque auctor dapibus justo, eget accumsan elit viverra eget.",
    "Nulla quis ante quis nulla molestie malesuada",
    "Mauris vel sodales nisl, sit amet auctor ante.",
    "Nunc ornare hendrerit orci, sed euismod erat.",
    "Morbi efficitur est arcu, vitae hendrerit ex fringilla vitae.",
    "Sed aliquam pretium aliquam.",
    "Aenean purus turpis, tristique sed volutpat varius, vulputate in neque.",
    "Nam eu placerat massa.",)

@Composable
fun Body(){
    LazyColumnFor(tempText) { item ->
        Text(item)
    }
}