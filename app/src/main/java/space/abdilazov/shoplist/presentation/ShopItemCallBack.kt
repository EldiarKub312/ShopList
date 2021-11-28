package space.abdilazov.shoplist.presentation

import androidx.recyclerview.widget.DiffUtil
import space.abdilazov.shoplist.domain.ShopItem

class ShopItemCallBack: DiffUtil.ItemCallback<ShopItem>() {
    override fun areItemsTheSame(oldItem: ShopItem, newItem: ShopItem): Boolean = (oldItem.id == newItem.id)

    override fun areContentsTheSame(oldItem: ShopItem, newItem: ShopItem): Boolean = (oldItem.id == newItem.id)

}