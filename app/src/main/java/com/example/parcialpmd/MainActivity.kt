package com.example.parcialpmd

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer

import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial_pdm.database.entities.Match
import com.example.parcial_pdm.database.viewmodel.BasketViewModel
import com.example.parcialpmd.fragments.login
import com.example.parcialpmd.fragments.new_match

import kotlinx.android.synthetic.main.fragment_matchs.*
import java.util.ArrayList

class MainActivity : AppCompatActivity(), login.OnFragmentInteractionListener,new_match.NewMatchListener
  {
    lateinit var viewModel:BasketViewModel

     var count: Int = 0
    override fun insertMatch(team1: String, team2: String) {
        Log.d("holi","holi")
      val match: Match = Match(team1 = team1,team2 = team2,id = count,date = "dd/mm/yy"
      ,commit = "nice")
        Log.d("holi",match.team2)
      viewModel.insert(match)

    }


    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel= ViewModelProviders.of(this).get(BasketViewModel::class.java)

    }



}


