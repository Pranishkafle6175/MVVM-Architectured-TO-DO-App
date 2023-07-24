package com.example.notes.Repository

import androidx.lifecycle.LiveData
import com.example.notes.Dao.NotesDao
import com.example.notes.Entity.NotesEntity


class NotesRepository(private  val dao:NotesDao) {

    fun getAllNotes():LiveData<List<NotesEntity>>{
        return dao.getNotes()
    }

    fun insertNotes(note :NotesEntity){
        dao.insertNotes(note)
    }

    fun deleteNotes(id :Int){
        dao.deleteNotes(id)
    }

    fun updateNotes(note:NotesEntity){
        dao.updateNotes(note)
    }

}