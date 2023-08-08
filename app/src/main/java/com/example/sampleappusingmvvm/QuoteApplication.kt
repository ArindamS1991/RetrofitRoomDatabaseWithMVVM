package com.example.sampleappusingmvvm

import android.app.Application
import com.example.sampleappusingmvvm.api.QuoteService
import com.example.sampleappusingmvvm.api.RetrofitHelper
import com.example.sampleappusingmvvm.db.QuoteDatabase
import com.example.sampleappusingmvvm.repository.QuoteRepository

class   QuoteApplication : Application() {

    lateinit var quoteRepository: QuoteRepository

    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {
        val quoteService = RetrofitHelper.getInstance().create(QuoteService::class.java)
        val database = QuoteDatabase.getDatabase(applicationContext)
        quoteRepository = QuoteRepository(quoteService, database, applicationContext)
    }
}