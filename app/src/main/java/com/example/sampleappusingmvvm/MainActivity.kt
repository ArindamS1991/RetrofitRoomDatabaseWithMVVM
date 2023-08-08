package com.example.sampleappusingmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.sampleappusingmvvm.api.QuoteService
import com.example.sampleappusingmvvm.api.RetrofitHelper
import com.example.sampleappusingmvvm.repository.QuoteRepository
import com.example.sampleappusingmvvm.viewmodels.MainViewModel
import com.example.sampleappusingmvvm.viewmodels.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = (application as QuoteApplication).quoteRepository

        mainViewModel = ViewModelProvider(this, MainViewModelFactory(repository)).get(MainViewModel::class.java)

        mainViewModel.quotes.observe(this, Observer {
            Toast.makeText(this@MainActivity, it.results.size.toString(), Toast.LENGTH_SHORT).show()
        })
    }
}