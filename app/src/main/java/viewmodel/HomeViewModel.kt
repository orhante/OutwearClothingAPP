import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.example.outwearclothingapp.viewmodel

class HomeViewModel : ViewModel() {
    val jackets = mutableStateListOf<Jacket>()
    val cart = mutableStateListOf<Jacket>()

    fun addJacket(name: String, price: Double) {
        jackets.add(Jacket(name, price))
    }

    fun addToCart(jacket: Jacket) {
        cart.add(jacket)
    }

    var jackets by mutableStateOf(listOf<Jacket>())
        private set

    init {
        loadJackets()
    }

    private fun loadJackets() {
        jackets = listOf(
            Jacket(1, "Winter Jacket", 120.0),
            Jacket(2, "Rain Coat", 90.0)
        )
    }
}