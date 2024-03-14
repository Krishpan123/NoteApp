    package com.krishpan.noteapp.database

    import android.provider.ContactsContract
    import androidx.lifecycle.LiveData
    import androidx.room.Dao
    import androidx.room.Delete
    import androidx.room.Insert
    import androidx.room.OnConflictStrategy
    import androidx.room.Query
    import androidx.room.Update
    import com.krishpan.noteapp.model.Notes


    @Dao
    interface NoteDao {

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        suspend fun insertNote(notes: Notes)

        @Update
        suspend fun updateNote(notes: Notes)

        @Delete
        suspend fun deleteNotes(notes: Notes)

        @Query("SELECT * FROM note ORDER BY id DESC")
        fun getAllNotes(): LiveData<List<Notes>>

        @Query("SELECT * FROM note WHERE noteTitle LIKE :query OR noteDesc LIKE :query")
        fun searchNote(query: String?): LiveData<List<Notes>>

    }