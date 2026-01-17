package com.example.notetakingapp.screens.notescreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notetakingapp.data.room.NoteDao
import com.example.notetakingapp.models.NoteEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditNoteViewModel @Inject constructor(
    private val dao: NoteDao
) : ViewModel() {

    var title by mutableStateOf("")
    var content by mutableStateOf("")
    private var noteId: Int = -1

    fun loadNote(id: Int) {
        viewModelScope.launch {
            val note = dao.getNoteById(id)
            noteId = note.id
            title = note.title
            content = note.description
        }
    }

    fun updateNote() {
        viewModelScope.launch {
            dao.updateNote(
                NoteEntity(
                    id = noteId,
                    title = title,
                    description = content
                )
            )
        }
    }
}
