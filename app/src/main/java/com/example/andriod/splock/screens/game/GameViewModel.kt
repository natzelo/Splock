package com.example.andriod.splock.screens.game

import android.app.PendingIntent.getActivity
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.andriod.splock.R


class GameViewModel(tRounds : Int) : ViewModel() {
    private val elements = arrayOf("Stone", "Paper", "Scissor", "Lizard", "Spock")
    private var user : String = ""
     var computer : String = ""
    private  val totalRounds : Int = tRounds
    // Event which triggers the end of the game
    private val _eventGameFinish = MutableLiveData<Int>()
    val eventGameFinish: LiveData<Int>
        get() = _eventGameFinish


    private val _cround = MutableLiveData<Int>(1)
    val cround : LiveData<Int>
        get() = _cround

    private val _yourScore = MutableLiveData<Int>(0)
    val yourScore : LiveData<Int>
        get() = _yourScore

    private  val _androidScore = MutableLiveData<Int>(0)
    val androidScore : LiveData<Int>
        get() = _androidScore


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
                _yourScore.value = _yourScore.value?.plus(2)

            }
            else if(computer == "Spock" || computer == "Paper") {
                _androidScore.value = _androidScore.value?.plus(2)

            }
            else {

            }
            _cround.value = _cround.value?.plus(1)
        }
        else if (user == "Paper") {
            if (computer == "Spock" || computer == "Stone") {
                _yourScore.value = _yourScore.value?.plus(2)

            }
            else if(computer == "Scissor" || computer == "Lizard") {
                _androidScore.value = _androidScore.value?.plus(2)

            }
            else {

            }
            _cround.value = _cround.value?.plus(1)
        }
        else if (user == "Scissor") {
            if(computer == "Lizard" || computer == "Paper") {
                _yourScore.value = _yourScore.value?.plus(2)

            }
            else if (computer == "Spock" || computer == "Stone") {
                _androidScore.value = _androidScore.value?.plus(2)

            }
            else {

            }
            _cround.value = _cround.value?.plus(1)
        }
        else if (user == "Lizard") {
            if(computer == "Spock" || computer == "Paper") {
                _yourScore.value = _yourScore.value?.plus(2)

            }
            else if (computer == "Stone" || computer == "Scissor") {
                _androidScore.value = _androidScore.value?.plus(2)

            }
            else {

            }
            _cround.value = _cround.value?.plus(1)
        }
        else if (user == "Spock") {
            if(computer == "Scissor" || computer == "Stone") {
                _yourScore.value = _yourScore.value?.plus(2)
            }
            else if(computer == "Lizard" || computer == "Paper") {
                _androidScore.value = _androidScore.value?.plus(2)

            }
            else {

            }
            _cround.value = _cround.value?.plus(1)

        }
        else {
            Log.e("GameViewModel", "invalid user selection")
        }


        if(_cround.value == totalRounds + 1) {
            if(_yourScore.value!! > _androidScore.value!!) {
                _eventGameFinish.value = 1
            }
            else if(_yourScore.value!! < _androidScore.value!!) {
                _eventGameFinish.value = 0
            }
            else {
                _eventGameFinish.value = 2
            }
        }
    }

}