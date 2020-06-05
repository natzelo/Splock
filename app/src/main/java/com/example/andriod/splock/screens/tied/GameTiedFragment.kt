package com.example.andriod.splock.screens.tied

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController

import com.example.andriod.splock.R
import com.example.andriod.splock.databinding.FragmentGameTiedBinding

/**
 * A simple [Fragment] subclass.
 */
class GameTiedFragment : Fragment() {

    private lateinit var binding : FragmentGameTiedBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_game_tied, container, false)

        binding.playAgainButton.setOnClickListener {
            findNavController().navigate(GameTiedFragmentDirections.actionGameTiedFragmentToGameFragment())
        }

        return binding.root
    }

}
