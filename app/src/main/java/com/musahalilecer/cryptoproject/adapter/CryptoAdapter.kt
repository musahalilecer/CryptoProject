package com.musahalilecer.cryptoproject.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.musahalilecer.cryptoproject.R
import com.musahalilecer.cryptoproject.databinding.RecyclerViewBinding
import com.musahalilecer.cryptoproject.model.CryptoModel
//import kotlinx.android.synthetic.main.recycler_view.view.text_name
//import kotlinx.android.synthetic.main.recycler_view.view.text_price

/*
class CryptoAdapter(private val cryptoList: ArrayList<CryptoModel>, private val listener: Listener): RecyclerView.Adapter<CryptoAdapter.CryptoHolder>() {
    interface Listener{
        fun onItemClick(cryptoModel: CryptoModel)
    }
    private val colors: Array<String> = arrayOf("#FFFF00","#00FFEF","#8470FF","#00FF00","#FF0000","#8470FF","#88DAD4","#C48B9B")
    class CryptoHolder(val binding: RecyclerViewBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoHolder {
        val binding = RecyclerViewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CryptoHolder(binding)
    }

    override fun getItemCount(): Int {
        return cryptoList.count()
    }

    override fun onBindViewHolder(holder: CryptoHolder, position: Int) {
    //    holder.bind(cryptoList[position],colors,position,listener)
        holder.itemView.setOnClickListener {
            listener.onItemClick(cryptoList.get(position))
        }
        holder.itemView.setBackgroundColor(Color.parseColor(colors[position % 8]))

        holder.binding.textName.text = cryptoList.get(position).currency
        holder.binding.textPrice.text = cryptoList.get(position).price

    }
}
 */
