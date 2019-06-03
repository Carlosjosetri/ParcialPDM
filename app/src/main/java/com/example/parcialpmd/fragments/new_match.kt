package com.example.parcialpmd.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.parcial_pdm.database.entities.Match
import com.example.parcialpmd.R
import kotlinx.android.synthetic.main.fragment_new_match.view.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class new_match : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null



    var listenerTool :  NewMatchListener? = null


    interface NewMatchListener{
        fun insertMatch(team1: String,team2: String)

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

    }
    fun initSearchButton(container:View) = container.btncreateMatch.setOnClickListener {
        Log.d("holi","quepex")
        listenerTool?.insertMatch(container.team1.text.toString(),container.team2.text.toString())
    }

    //fun initSearchButton(container:View) = container.btncreateMatch.setOnClickListener {
     //   listenerTool?.insertMatch{val match: Match=Match(team1 = container.team1.text.toString(),
    //        team2 = container.team2.text.toString(),date = "dd/mm/yy",commit = "nice",id = 0)}
  //  }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =inflater.inflate(R.layout.fragment_new_match, container, false)

        initSearchButton(view)
        // Inflate the layout for this fragment
        return view
    }
    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is NewMatchListener) {
            listenerTool = context
        } else {
            throw RuntimeException("Se necesita una implementación de  la interfaz")
        }
    }



    override fun onDetach() {
        super.onDetach()
        listenerTool = null
    }
}
