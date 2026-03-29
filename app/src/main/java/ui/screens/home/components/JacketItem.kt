package com.example.outwearclothingapp.ui.screens.home.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.outwearclothingapp.model.Jacket

@Composable
fun JacketItem(jacket: Jacket) {
    Text(text = "${jacket.name} - $${jacket.price}")
}