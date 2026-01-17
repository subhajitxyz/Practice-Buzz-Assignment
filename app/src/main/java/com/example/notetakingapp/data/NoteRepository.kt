package com.example.notetakingapp.data

import com.example.notetakingapp.data.room.NoteDao
import com.example.notetakingapp.models.NoteEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NoteRepository @Inject constructor(
    private val noteDao: NoteDao
) {

    val notes: Flow<List<NoteEntity>> = noteDao.getAllNotes()

    suspend fun addNote(note: NoteEntity) =
        noteDao.insertNote(note)

    suspend fun deleteNote(note: NoteEntity) =
        noteDao.deleteNote(note)

    suspend fun updateNote(note: NoteEntity) =
        noteDao.updateNote(note)
}
