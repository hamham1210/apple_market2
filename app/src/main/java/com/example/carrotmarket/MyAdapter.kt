package com.example.carrot_market

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.carrot_market.databinding.ActivityRecyclerviewBinding
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.Locale

class MyAdapter(val mItems: MutableList<MyItem>) : RecyclerView.Adapter<MyAdapter.Holder>() {

    interface ItemClick {
        fun onClick(view: View, position: Int)
    }

    var itemClick: ItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding =
            ActivityRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        // Adapter와 연결될 Activity의 모든 정보를 끌고옴(context란 Activity에서 담고 있는 모든 정보를 표현, false는 추가적인 루트없음?)
        return Holder(binding)
    }// ViewHolder의 값들을 모두 가져와서 view에 연결시켜준다. 2번

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.itemView.setOnClickListener {  //클릭이벤트추가부분
            itemClick?.onClick(it, position)
        }

        holder.iconImageView.setImageResource(mItems[position].icon)
        holder.name.text = mItems[position].name
        holder.adress.text = mItems[position].adress
        val price = mItems[position].pirce
        holder.price.text = DecimalFormat("#,###").format(price)+"원"
        holder.like.text = mItems[position].heart.toString()
        holder.chat.text =mItems[position].comment.toString()

    }// 지속적으로 호출되면서 onCreateViewHolder에 view를 넣어준다. 3번

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }//iteml

    override fun getItemCount(): Int {
        return mItems.size
        //itemlist의 크기 만큼 돌려준다
    }

    //리스트들에 대한 총 갯수를 정해줌

    inner class Holder(val binding: ActivityRecyclerviewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val iconImageView = binding.itemImage
        val name = binding.itemName
        val adress = binding.itemAddress
        val price = binding.itemPrice
        val like = binding.detailTxtLike
        val chat = binding.detialTxtCom

        init {
            itemView.setOnClickListener {
                itemClick?.onClick(it, adapterPosition)
            }
        }// RecyclerView에 들어갈 itemView들을 넣어준다. 1번
    }
}



//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_main,parent,false)
//    // Adapter와 연결될 Activity의 모든 정보를 끌고옴(context란 Activity에서 담고 있는 모든 정보를 표현, false는 추가적인 루트없음?)
//        return CustomViewHolder(view)
//        // CustomViewHolder의 값들을 모두 가져와서 view에 연결시켜준다. 2번
//    }
//
//    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
//        holder.icon.setImageResource(itemlist.get(position).icon)
//        holder.name.text = itemlist.get(position).name
//        holder.adress.text = itemlist.get(position).adress //text = settext
//        holder.price.text = itemlist.get(position).pirce.toString() //price의 경우 Int값이여서 toString()을 해줘야 한다.
//    } // 지속적으로 호출되면서 onCreateViewHolder에 view를 넣어준다.
//
//    override fun getItemCount(): Int {
//        return itemlist.size
//        //itemlist의 크기 만큼 돌려준다
//    }//리스트들에 대한 총 갯수를 정해줌
//
//    override fun getCount(): Int {
//        return itemlist.size
//    }
//
//
//    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val icon = itemView.findViewById<ImageView>(R.id.item_image) // 상품 이미지
//        val name = itemView.findViewById<TextView>(R.id.item_name) // 상품 이름
//        val adress = itemView.findViewById<TextView>(R.id.item_address) // 판매자 주소
//        val price = itemView.findViewById<TextView>(R.id.item_price)  // 상품 가격
//    }// RecyclerView에 들어갈 itemView들을 넣어준다. 1번
//}
