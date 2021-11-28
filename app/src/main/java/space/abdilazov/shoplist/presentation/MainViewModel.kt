package space.abdilazov.shoplist.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import space.abdilazov.shoplist.data.ShopListRepositoryImpl
import space.abdilazov.shoplist.domain.*

class MainViewModel: ViewModel() {

    private val repository = ShopListRepositoryImpl()

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteSHopItemUseCase(repository)
    private val getShopItemUseCase = GetShopItemUseCase(repository)
    private val addShopItemUseCase = AddShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()

    private val scope = CoroutineScope(Dispatchers.Default)

    fun addShopItem(shopItem: ShopItem){
        scope.launch {
            addShopItemUseCase.addShopItem(shopItem)
        }
    }

    fun deleteShopItem(shopItem: ShopItem){
        scope.launch {
            deleteShopItemUseCase.deleteShopItem(shopItem)
        }
    }

    override fun onCleared() {
        super.onCleared()
        scope.cancel()
    }
}