package com.example.pizzaapp3388

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterTransaction(private val ListOrder: List<TransactionModel>): RecyclerView.Adapter<AdapterTransaction.ViewHolderOrder>() {
    class ViewHolderOrder(view: View): RecyclerView.ViewHolder(view) {
        val imgFotoMenu: ImageView
        val txtNama: TextView
        val txtHarga: TextView
        val txtJml: TextView
        val context = view.context
        init {
            txtNama= view.findViewById(R.id.textNamaMenu)
            txtHarga = view.findViewById(R.id.textHargaMenu)
            txtJml = view.findViewById(R.id.textQtyMenu)
            imgFotoMenu = view.findViewById(R.id.imageMenu)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterTransaction.ViewHolderOrder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.card_layout_order, parent, false)

        return ViewHolderOrder(cellForRow)
    }

    override fun onBindViewHolder(
        holder: AdapterTransaction.ViewHolderOrder,
        position: Int
    ) {
        val modelTrx = ListOrder[position]
        holder.txtNama.text = modelTrx.nama
        holder.txtHarga.text = modelTrx.harga
        holder.txtJml.text = modelTrx.jumlah
        holder.imgFotoMenu.setImageResource(modelTrx.gambar)
    }

    override fun getItemCount(): Int {
       return ListOrder.size
    }

}