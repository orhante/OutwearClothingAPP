package com.example.outwearclothingapp.ui.screens.add

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.outwearclothingapp.ui.screens.add.components.InputField
import com.example.outwearclothingapp.ui.viewmodel.HomeViewModel

@Composable
fun AddScreen(viewModel: HomeViewModel) {
    var name by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }

    val isValid = name.isNotBlank() && price.isNotBlank()

    Column(modifier = Modifier.padding(16.dp)) {
        InputField(value = name, onValueChange = { name = it }, label = "Name")
        Spacer(modifier = Modifier.height(8.dp))
        InputField(value = price, onValueChange = { price = it }, label = "Price")
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { viewModel.addJacket(name, price.toDouble()) },
            enabled = isValid,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Add Jacket")
        }
        if (!isValid) {
            Text("Please fill all fields", color = MaterialTheme.colorScheme.error)
        }
    }
}