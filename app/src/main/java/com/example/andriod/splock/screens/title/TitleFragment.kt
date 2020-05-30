package com.example.andriod.splock.screens.title

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import androidx.core.view.get
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.andriod.splock.MainActivity

import com.example.andriod.splock.R
import com.example.andriod.splock.databinding.FragmentTitleBinding


/**
 * A simple [Fragment] subclass.
 */

class TitleFragment : Fragment() {

    // this variable will be passed to game fragment
    private  var rounds : Int = 1

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding : FragmentTitleBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_title, container, false)

        /** Spinner Related Code **/
        val numbers = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val arrayAdapter = ArrayAdapter(requireContext(),android.R.layout.simple_spinner_item, numbers)
        binding.spinner.adapter = arrayAdapter
        binding.spinner.onItemSelectedListener = object :

        AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                rounds = numbers[position]
            }

        }

        //click listener for the play button
        binding.playButton.setOnClickListener {
            findNavController().navigate(TitleFragmentDirections.actionTitleFragmentToGameFragment())
        }
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!,
            view!!.findNavController())
                || super.onOptionsItemSelected(item)
    }

}
