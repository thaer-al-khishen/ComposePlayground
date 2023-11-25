package com.example.composeplayground

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

data class Contact(val name: String, val phoneNumber: String)

@Composable
fun ContactItem(contact: Contact) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)) {
        Text(text = contact.name, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = contact.phoneNumber)
    }
}

@Composable
fun ContactList(contacts: List<Contact>) {
    LazyColumn {
        items(contacts) { contact ->
            ContactItem(contact)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewContactList() {
    val sampleContacts = listOf(
        Contact("Alice", "123-456-7890"),
        Contact("Bob", "234-567-8901"),
        // Add more sample contacts
    )
    ContactList(sampleContacts)
}
