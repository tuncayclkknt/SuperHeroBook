package com.tuncay.superherobook

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.tuncay.superherobook.databinding.ActivityMainBinding
import com.tuncay.superherobook.databinding.ActivityTanitimAktivitesiBinding

class TanitimAktivitesi : AppCompatActivity() {
    private lateinit var binding: ActivityTanitimAktivitesiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTanitimAktivitesiBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        val intentFromAdapter = intent
//        val selectedHero = intentFromAdapter.getSerializableExtra("selectedHero") as SuperHero
//        val selectedHero = intentFromAdapter.getSerializableExtra("selectedHero",SuperHero::class.java)

        val selectedHero = MySingleton.selectedSuperHero
        selectedHero?.let {
            binding.imageView.setImageResource(selectedHero.image)
            binding.nameTextView.text = selectedHero.name
            binding.jobTextView.text = selectedHero.job
        }
    }
}