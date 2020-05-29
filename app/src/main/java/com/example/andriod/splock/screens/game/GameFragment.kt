package com.example.andriod.splock.screens.game

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.andriod.splock.R
import com.example.andriod.splock.databinding.FragmentGameBinding

/**
 * A simple [Fragment] subclass.
 */
class GameFragment : Fragment() {

    //declare data binding variable
    private lateinit var binding: FragmentGameBinding
    //declare game view model
    private lateinit var viewModel: GameViewModel


    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Initialize Binding VariableInflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_game, container,false)





        return binding.root
    }

}
