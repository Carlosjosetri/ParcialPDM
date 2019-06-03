package com.example.parcialpmd

import android.content.Context
import android.service.autofill.FieldClassification
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial_pdm.database.entities.Match



class MatchsAdapter(var items:List<Match>): RecyclerView.Adapter<MatchsAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_element_match, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }
    fun updateList(newMatchs:List<Match>){
        newMatchs.forEach{
            println("QUe pex")
        }
        this.items=newMatchs
        notifyDataSetChanged()
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        fun bind(item: Match) = with(itemView) {



        }


    }
}

