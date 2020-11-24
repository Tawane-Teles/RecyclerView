package com.tawane.listadepaises.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.tawane.listadepaises.R

class ListaAdapter(nameList: List<String>, private var ctx: Context) :
    RecyclerView.Adapter<ListaAdapter.ViewHolder>() {

    private var nameList: List<String> = ArrayList<String>()

    init {
        this.nameList = nameList
    }

    // Aqui é onde o viewholder é criado a partir do layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(ctx).inflate(R.layout.content_lista, parent, false)
        return ViewHolder(view)
    }

    // Nessa parte é onde se modifica o item do viewholder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val name = nameList[position]

        holder.name.text = name

        // Verifica se o nome for igual a Emy seta a cor e a imagem em si
        if (name == ctx.resources.getString(R.string.pais_um)) {
            holder.name.setTextColor(ContextCompat.getColor(ctx, R.color.green))
            holder.imagem.setBackgroundResource(R.drawable.img_brazil)
        }

        if (name == ctx.resources.getString(R.string.pais_dois)) {
            holder.name.setTextColor(ContextCompat.getColor(ctx, R.color.red))
            holder.imagem.setBackgroundResource(R.drawable.img_estadosunidos)
        }
        if (name == ctx.resources.getString(R.string.pais_tres)) {
            holder.name.setTextColor(ContextCompat.getColor(ctx, R.color.dark_red))
            holder.imagem.setBackgroundResource(R.drawable.img_canada)
        }
        if (name == ctx.resources.getString(R.string.pais_quatro)) {
            holder.name.setTextColor(ContextCompat.getColor(ctx, R.color.blue))
            holder.imagem.setBackgroundResource(R.drawable.img_franca)
        }


    }

    // Devolve quantidade de itens do nameList
    override fun getItemCount(): Int {
        return nameList.size
    }

    // Aqui é a criação dos itens do viewholder
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var name = view.findViewById<TextView>(R.id.img_primeirafrase)!!
        var imagem = view.findViewById<ImageView>(R.id.img_mapamundi)!!
    }
}