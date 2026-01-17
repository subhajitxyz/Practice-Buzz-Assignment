package com.example.notetakingapp.uicomponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.notetakingapp.models.NoteEntity

@Composable
fun NoteItem(
    note: NoteEntity,
    onDelete: () -> Unit,
    onEdit: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
    ) {
        Column(Modifier.padding(16.dp)) {

            Text(note.title, fontWeight = FontWeight.Bold)
            Text(note.description)

            Row {
                TextButton(
                    onClick = onEdit
                ) {
                    Text("Edit")
                }
                TextButton(
                    onClick = onDelete
                ) {
                    Text("Delete")
                }
            }
        }
    }
}

