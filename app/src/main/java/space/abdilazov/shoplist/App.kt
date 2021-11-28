package space.abdilazov.shoplist

import android.app.Application
import androidx.room.Room
import space.abdilazov.shoplist.data.AppDataBase

class App: Application() {

    companion object {
        lateinit var shopDataBase: AppDataBase
    }

    override fun onCreate() {
        super.onCreate()
        shopDataBase = Room.databaseBuilder(this,AppDataBase::class.java, "dataBase")
            .allowMainThreadQueries()
            .build()
    }

}