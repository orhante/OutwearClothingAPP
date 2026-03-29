package com.example.outwearclothingapp.ui.screens.details

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.outwearclothingapp.model.Jacket
import com.example.outwearclothingapp.ui.viewmodel.HomeViewModel

@Composable
fun DetailsScreen(jacket: Jacket, viewModel: HomeViewModel) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(jacket.name, style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(8.dp))
        Text("$${jacket.price}", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { viewModel.addToCart(jacket) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Add to Cart")
        }
    }
}