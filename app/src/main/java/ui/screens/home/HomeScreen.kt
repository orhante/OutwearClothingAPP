package com.example.outwearclothingapp.ui.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.outwearclothingapp.viewmodel.HomeViewModel
import com.example.outwearclothingapp.ui.screens.home.components.JacketItem

@Composable
fun HomeScreen(viewModel: HomeViewModel) {

    val jackets = viewModel.jackets

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text("Outerwear Store")

        Spacer(modifier = Modifier.height(16.dp))

        if (jackets.isEmpty()) {
            Text("No items yet") // ✅ EDGE CASE
        } else {
            jackets.forEach {
                JacketItem(it) // ✅ COMPONENT USED
            }
        }
    }
}