package com.example.listadofutbol

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class Adapter(val context: Context) : ListAdapter<Equipo, Adapter.ViewHolder>(DiffCallBack) {

    lateinit var onItemClickListener: (Equipo) -> Unit
    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val nombreElem: TextView = view.findViewById(R.id.item_nombre)
        val escudoElem: ImageView = view.findViewById(R.id.item_escudo)
        val apodoElem: TextView = view.findViewById(R.id.item_apodo)
        val estadioElem: TextView = view.findViewById(R.id.item_estadio)
        val paisElem: ImageView = view.findViewById(R.id.item_pais)

        fun bind (eq: Equipo) {
            nombreElem.text=eq.nombre
            apodoElem.text=eq.apodo.toString()
            estadioElem.text=eq.estadio.toString()

            Glide.with(context).load(eq.escudo).into(escudoElem)

            val imagePais = when(eq.pais){
                Paises.ARGENTINA -> R.drawable.arg
                Paises.URUGUAY-> R.drawable.uru
                Paises.BRAZIL -> R.drawable.bra
                Paises.CHILE -> R.drawable.chi
                else -> R.drawable.col
            }
            paisElem.setImageResource(imagePais)

            view.setOnClickListener() {
                onItemClickListener(eq)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        val pokemon = getItem(position)
        holder.bind(pokemon)
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<Equipo>() {
        override fun areItemsTheSame(oldItem: Equipo, newItem: Equipo): Boolean {
            return  oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Equipo, newItem: Equipo): Boolean {
            return oldItem == newItem
        }
    }
}