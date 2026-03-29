package com.example.outwearclothingapp.ui.screens.cart

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.outwearclothingapp.ui.viewmodel.HomeViewModel

@Composable
fun CartScreen(viewModel: HomeViewModel) {
    val cartItems = viewModel.cart

    if (cartItems.isEmpty()) {
        Text("Cart is empty", modifier = Modifier.padding(16.dp))
    } else {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(cartItems) { jacket ->
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                ) {
                    Text(jacket.name)
                    Spacer(modifier = Modifier.weight(1f))
                    Text("$${jacket.price}")
                }
            }
        }
    }
}