package com.example.notetakingapp.screens.notescreen

sealed class Screen(val route: String) {
    object Notes : Screen("notes")
    object AddNote : Screen("add_note")

    object EditNote : Screen("edit_note/{noteId}") {
        fun createRoute(noteId: Int) = "edit_note/$noteId"
    }
}
