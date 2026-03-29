package com.example.outwearclothingapp.ui.screens.list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.outwearclothingapp.model.Jacket
import com.example.outwearclothingapp.ui.screens.list.components.JacketItem
import com.example.outwearclothingapp.ui.viewmodel.HomeViewModel

@Composable
fun ListScreen(viewModel: HomeViewModel, onItemClick: (Jacket) -> Unit) {
    val jackets = viewModel.jackets

    if (jackets.isEmpty()) {
        Text("No items yet", modifier = Modifier.padding(16.dp))
    } else {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(jackets) { jacket ->
                JacketItem(jacket = jacket, onClick = { onItemClick(jacket) })
            }
        }
    }
}