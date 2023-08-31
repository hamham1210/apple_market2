package com.example.carrotmarket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.carrot_market.MyItem
import com.example.carrot_market.R
import com.example.carrot_market.databinding.ActivityDetailBinding
import java.text.NumberFormat
import java.util.Locale

class Detail : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val item = intent.getParcelableExtra<MyItem>("myItem")
        if (item != null) {
            val img = item.icon
            val name = item.name
            val itemInfo = item.ItemInfo
            val nickname = item.nickname
            val address = item.adress
            val price = item.pirce

            binding.detailImg.setImageResource(img)
            binding.dtailName.text = name
            binding.detailDetail.text = itemInfo
            binding.detailNickname.text = nickname
            binding.detailAdress.text = address
            binding.detailPrice.text = price.toString()

            val formattedPrice = Commas(price)
            binding.detailPrice.text = formattedPrice
        }
        binding.detailBack.setOnClickListener {
            finish()
        }
    }

    private fun Commas(price: Int): String {
        val nf = NumberFormat.getNumberInstance(Locale.getDefault())
        return nf.format(price)
    }
}
