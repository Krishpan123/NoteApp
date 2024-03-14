package com.krishpan.noteapp.repository


import com.krishpan.noteapp.database.NoteDatabase
import com.krishpan.noteapp.model.Notes

class NoteRepository(private val db:NoteDatabase) {


    suspend fun insertNote(notes: Notes) = db.getNoteDao().insertNote(notes)
    suspend fun updateNote(notes: Notes) = db.getNoteDao().updateNote(notes)
    suspend fun deleteNote(notes: Notes) = db.getNoteDao().deleteNotes(notes)


    fun getAllNotes() = db.getNoteDao().getAllNotes()
    fun searchNote(query: String?) = db.getNoteDao().searchNote(query)
}