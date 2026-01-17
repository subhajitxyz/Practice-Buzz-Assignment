package com.example.notetakingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.notetakingapp.screens.notescreen.AddNoteScreen
import com.example.notetakingapp.screens.notescreen.EditNoteScreen
import com.example.notetakingapp.screens.notescreen.NotesScreen
import com.example.notetakingapp.screens.notescreen.Screen
import com.example.notetakingapp.ui.theme.NoteTakingAppTheme
import dagger.hilt.android.AndroidEntryPoint

//Display a list of notes (title or short text).
//·       Allow the user to add a new note.
//·       Allow editing of existing notes.
//·       Allow deletion of a note.


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NoteTakingAppTheme {

                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = Screen.Notes.route
                ) {

                    composable(Screen.Notes.route) {
                        NotesScreen(navController)
                    }

                    composable(Screen.AddNote.route) {
                        AddNoteScreen(navController)
                    }

                    composable(
                        Screen.EditNote.route,
                        arguments = listOf(navArgument("noteId") {
                            type = NavType.IntType
                        })
                    ) { backStackEntry ->
                        val noteId = backStackEntry.arguments?.getInt("noteId")!!
                        EditNoteScreen(
                            noteId = noteId,
                            navController = navController
                        )
                    }
                }
            }
        }
    }
}
