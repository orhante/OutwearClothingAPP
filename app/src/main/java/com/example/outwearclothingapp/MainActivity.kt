package com.example.outwearclothingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.outwearclothingapp.ui.theme.OutwearClothingAPPTheme
import com.example.outwearclothingapp.viewmodel.HomeViewModel
import com.example.outwearclothingapp.ui.screens.home.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        NavHost(navController, startDestination = "home") {
            composable("home") { HomeScreen(navController, viewModel) }
            composable("list") { ListScreen(viewModel) { navController.navigate("details/${it.id}") } }
            composable("add") { AddScreen(viewModel) }
            composable("cart") { CartScreen(viewModel) }
            composable("details/{jacketId}") { backStackEntry ->
                val jacket = viewModel.jackets.find { it.id == backStackEntry.arguments?.getString("jacketId") }
                jacket?.let { DetailsScreen(it, viewModel) }
            }
        }
            setContent {
                val viewModel = HomeViewModel()
                HomeScreen(viewModel)
            }
            OutwearClothingAPPTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    OutwearClothingAPPTheme {
        Greeting("Android")
    }
}

