package id.ac.ubaya.adv160419026week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_game.*
import kotlinx.android.synthetic.main.fragment_main.*


class GameFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        if(arguments != null){
            val playerName =
                    GameFragmentArgs.fromBundle(requireArguments()).playerName
        txtTurn.text = "$playerName's Turn"
        }

        var randomNumber1 = (0..100).random()
        var randomNumber2 = (0..100).random()
        var player_point = 0
        txtNumber1.text = randomNumber1.toString()
        txtNumber2.text = randomNumber2.toString()

        btnSubmit.setOnClickListener{
            if(player_answer.text.toString() == (randomNumber1 + randomNumber2).toString()){
                player_point += 1

                randomNumber1 = (0..100).random()
                randomNumber2 = (0..100).random()

                txtNumber1.text = randomNumber1.toString()
                txtNumber2.text = randomNumber2.toString()
            }
            else
            {
                val action = GameFragmentDirections.actionResultFragment(player_point.toString())
                Navigation.findNavController(it).navigate(action)
            }
        }
    }
}