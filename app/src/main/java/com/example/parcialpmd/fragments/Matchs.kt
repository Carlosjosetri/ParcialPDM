package com.example.parcialpmd.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial_pdm.database.viewmodel.BasketViewModel
import com.example.parcialpmd.MatchsAdapter
import com.example.parcialpmd.R
import kotlinx.android.synthetic.main.fragment_matchs.*
import kotlinx.android.synthetic.main.fragment_matchs.view.*
import java.util.ArrayList


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [Matchs.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [Matchs.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class Matchs : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var viewAdapter: MatchsAdapter

    lateinit var viewModel:BasketViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

    }

    fun bind(view: View){
        viewModel= ViewModelProviders.of(this).get(BasketViewModel::class.java)
        viewAdapter= MatchsAdapter(ArrayList())

       view.rv_matchs.adapter= this.viewAdapter
        view.rv_matchs.layoutManager = LinearLayoutManager(this.context)

        viewModel.getAllMatchs().observe(this, Observer {
            viewAdapter.updateList(it)
        })

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_matchs, container, false)
        bind(view)
        // Inflate the layout for this fragment
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        view.findViewById<TextView>(R.id.butnew)?.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.new_action, null))


    }
    // TODO: Rename method, update argument and hook method into UI event

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */



}
