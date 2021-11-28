package space.abdilazov.shoplist.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import space.abdilazov.shoplist.R

class ItemShopActivity : AppCompatActivity() {

    private lateinit var btn: Button
    private lateinit var editText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_shop)

        btn = findViewById(R.id.saveBtn)
        editText = findViewById(R.id.dataEt)

        btn.setOnClickListener {
            setResult(RESULT_OK, Intent().putExtra("key",editText.text.toString()))
            finish()
        }
    }
}