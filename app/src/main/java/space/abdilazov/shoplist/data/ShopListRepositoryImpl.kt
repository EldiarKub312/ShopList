package space.abdilazov.shoplist.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import space.abdilazov.shoplist.App
import space.abdilazov.shoplist.domain.ShopItem
import space.abdilazov.shoplist.domain.ShopListRepository

class ShopListRepositoryImpl: ShopListRepository {

    private val shopListDao = App.shopDataBase.shopListDao()
    private val mapper = ShopListMap()

    override suspend fun addShopItem(shopItem: ShopItem) {
        shopListDao.addShopItem(mapper.mapEntityToDbModel(shopItem))
    }

    override suspend fun deleteShopItem(shopItem: ShopItem) {
        shopListDao.deleteShopItem(shopItem.id)
    }

    override suspend fun editShopItem(shopItem: ShopItem) {
        TODO()
    }

    override suspend fun getShopItem(shopId: Int): ShopItem {
        TODO()
    }


    override fun getShopList(): LiveData<List<ShopItem>> = Transformations.map(
        shopListDao.getShopList()
    ){ mapper.mapListDbModelToListEntity(it)
    }

}