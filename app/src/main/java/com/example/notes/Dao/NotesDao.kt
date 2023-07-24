package com.example.notes.Dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.notes.Entity.NotesEntity


@Dao
interface NotesDao {

    @Query("SELECT * FROM Notes")
    fun getNotes() : LiveData<List<NotesEntity>>

    // this onconflict will replace the new item with previous item if similar item is put
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNotes(notes:NotesEntity)

    @Query("DELETE FROM Notes WHERE id=:id")
    fun deleteNotes(id:Int):Void

    @Update
    fun updateNotes(notes:NotesEntity)
}