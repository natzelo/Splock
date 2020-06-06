package com.example.andriod.splock.screens.game

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.andriod.splock.R
import com.example.andriod.splock.databinding.FragmentGameBinding

/**
 * A simple [Fragment] subclass.
 */
class GameFragment : Fragment() {

    //declare data binding variable
    private lateinit var binding: FragmentGameBinding
    //declare view model factory
    private lateinit var  viewModelFactory : GameViewModelFactory
    //declare game view model
    private lateinit var viewModel: GameViewModel


    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Initialize Binding VariableInflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_game, container,false)

        // Initialize ViewModel
        viewModelFactory = GameViewModelFactory(GameFragmentArgs.fromBundle(arguments!!).rounds)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(GameViewModel::class.java)

        viewModel.eventGameFinish.observe(viewLifecycleOwner, Observer { result ->
            if(result == 1) {
                findNavController().navigate(GameFragmentDirections.actionGameFragmentToGameWonFragment())
            }
            else if(result == 0) {
                findNavController().navigate(GameFragmentDirections.actionGameFragmentToGameLostFragment())
            }
            else {
                findNavController().navigate(GameFragmentDirections.actionGameFragmentToGameTiedFragment())
            }
        })

        viewModel.cround.observe(viewLifecycleOwner, Observer { updateRound ->
            binding.cround.text = updateRound.toString()
        })

        viewModel.yourScore.observe(viewLifecycleOwner, Observer { newYourScore->
            binding.yourScoreValue.text = newYourScore.toString()
        })

        viewModel.androidScore.observe(viewLifecycleOwner, Observer { newAndroidScore ->
            binding.androidScoreValue.text = newAndroidScore.toString()
        })
        viewModel.result.observe(viewLifecycleOwner, Observer { newResult ->
            if (newResult == 1) {
                Toast.makeText(requireContext(), "Android picked ${viewModel.computer}. Round Won!" ,  Toast.LENGTH_SHORT).show()
            }
            else if (newResult == 0) {
                Toast.makeText(requireContext(), "Android picked ${viewModel.computer}. Round Lost :/", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(requireContext(), "Woah! It's a tie!", Toast.LENGTH_SHORT).show()
            }
        })
        binding.gameViewModel = viewModel
        return binding.root
    }

}
