package com.tuncay.superherobook

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.tuncay.superherobook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var superHeroList: ArrayList<SuperHero>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val spiderman = SuperHero("Spiderman","Student",R.drawable.spiderman)
        val batman =  SuperHero("Batman","Patron",R.drawable.batman)
        val ironman =  SuperHero("Ironman","Rich",R.drawable.ironman)
        val aquamen =  SuperHero("Aquaman","Fish",R.drawable.aquaman)

        superHeroList = arrayListOf(spiderman,batman,ironman,aquamen)

        val adapter = SuperHeroAdapter(superHeroList)
        binding.superHeroRecyclerview.layoutManager = LinearLayoutManager(this@MainActivity)
        binding.superHeroRecyclerview.adapter = adapter

    }
}