package com.krishpan.noteapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Query
import com.krishpan.noteapp.model.Notes
import com.krishpan.noteapp.repository.NoteRepository
import kotlinx.coroutines.launch

class NoteViewModel(app: Application, private val noteRepository: NoteRepository): AndroidViewModel(app){

    fun addNote(notes: Notes){
        viewModelScope.launch {
            noteRepository.insertNote(notes)
        }
    }

    fun deleteNote(notes: Notes){
        viewModelScope.launch {
            noteRepository.deleteNote(notes)
        }
    }

    fun updateNote(notes: Notes){
        viewModelScope.launch {
            noteRepository.updateNote(notes)
        }
    }

    fun getAllNotes() = noteRepository.getAllNotes()
    fun searchNotes(query: String?) = noteRepository.searchNote(query)
}



