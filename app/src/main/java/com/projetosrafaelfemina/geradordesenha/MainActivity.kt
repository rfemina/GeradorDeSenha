package com.projetosrafaelfemina.geradordesenha

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.projetosrafaelfemina.geradordesenha.databinding.ActivityMainBinding
import kotlin.random.Random


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val alphabet = arrayListOf(
        "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
        "S", "T", "U", "V", "X", "W", "Y", "Z"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btGeneratePassword.setOnClickListener {
            generateRandomPassword()
        }

    }

    private fun generateRandomPassword() {
        val firstLetter = (alphabet.indices).random()
        val secondLetter = (alphabet.indices).random()
        val randomLetter1 = alphabet[firstLetter]
        val randomLetter2 = alphabet[secondLetter]

        val randomNumbers = Random
        val numbers = randomNumbers.nextInt(9999)

        binding.txtPassword.text = "$randomLetter1$randomLetter2-$numbers"
    }

}