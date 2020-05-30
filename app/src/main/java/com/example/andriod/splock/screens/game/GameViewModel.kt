package com.example.andriod.splock.screens.game

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.andriod.splock.R


class GameViewModel : ViewModel() {
    private val elements = arrayOf("Stone", "Paper", "Scissor", "Lizard", "Spock")
    private var user : String = ""
     var computer : String = ""

    // Event which triggers the end of the game
    private val _eventGameFinish = MutableLiveData<Int>()
    val eventGameFinish: LiveData<Int>
        get() = _eventGameFinish

    fun choicemade(view : View)
    {

        when(view.id) {
            R.id.stone_image -> { user = "Stone"}
            R.id.paper_image -> { user = "Paper"}
            R.id.scissor_image -> { user = "Scissor"}
            R.id.lizard_image -> { user = "Lizard"}
            R.id.spock_image -> { user = "Spock"}
        }

         computer = elements.random()
        makedecision()


    }

    private fun makedecision() {
        if(user == "Stone") {
            if(computer == "Lizard" || computer == "Scissor") {
                _eventGameFinish.value = 1
            }
            else if(computer == "Spock" || computer == "Paper") {
                _eventGameFinish.value = 0
            }
            else {
                _eventGameFinish.value = 2
            }
        }
        else if (user == "Paper") {
            if (computer == "Spock" || computer == "Stone") {
                _eventGameFinish.value = 1
            }
            else if(computer == "Scissor" || computer == "Lizard") {
                _eventGameFinish.value = 0
            }
            else {
                _eventGameFinish.value = 2
            }
        }
        else if (user == "Scissor") {
            if(computer == "Lizard" || computer == "Paper") {
                _eventGameFinish.value = 1
            }
            else if (computer == "Spock" || computer == "Stone") {
                _eventGameFinish.value = 0
            }
            else {
                _eventGameFinish.value = 2
            }
        }
        else if (user == "Lizard") {
            if(computer == "Spock" || computer == "Paper") {
                _eventGameFinish.value = 1
            }
            else if (computer == "Stone" || computer == "Scissor") {
                _eventGameFinish.value = 0
            }
            else {
                _eventGameFinish.value = 2
            }
        }
        else if (user == "Spock") {
            if(computer == "Scissor" || computer == "Stone") {
                _eventGameFinish.value = 1
            }
            else if(computer == "Lizard" || computer == "Paper") {
                _eventGameFinish.value = 0
            }
            else {
                _eventGameFinish.value = 2
            }
        }
    }

}