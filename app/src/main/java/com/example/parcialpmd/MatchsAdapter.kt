package com.example.parcialpmd

import android.content.Context
import android.service.autofill.FieldClassification
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial_pdm.database.entities.Match
import com.example.parcialpmd.fragments.login
import kotlinx.android.synthetic.main.list_element_match.view.*


class MatchsAdapter(var items:List<Match>): RecyclerView.Adapter<MatchsAdapter.ViewHolder>(){



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
         itemView.textView2.text = item.team1+" vs "+item.team2

            itemView.findViewById<Button>(R.id.button2list)?.setOnClickListener(
                Navigation.createNavigateOnClickListener(R.id.game_action, null))

        }


    }
}

