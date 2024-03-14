package com.krishpan.noteapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.lifecycle.ViewModelProvider
import com.krishpan.noteapp.database.NoteDatabase
import com.krishpan.noteapp.repository.NoteRepository
import com.krishpan.noteapp.viewmodel.NoteViewModel
import com.krishpan.noteapp.viewmodel.NoteViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViewModel()
    }

    private fun setupViewModel(){
        val noteRepository = NoteRepository(NoteDatabase(this))
        val viewModelProviderFactory = NoteViewModelFactory(application, noteRepository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory)[NoteViewModel::class.java]
    }
}