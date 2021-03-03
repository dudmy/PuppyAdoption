package com.example.androiddevchallenge.ui.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.Puppy

@Composable
fun DetailPage(puppy: Puppy, navUp: () -> Unit, adopt: (Puppy) -> Unit) {
    Column {
        TopAppBar(
            title = { Text(text = puppy.name) },
            navigationIcon = {
                IconButton(onClick = { navUp() }) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Go Back")
                }
            }
        )
        PuppyDetail(puppy = puppy, adopt = adopt)
    }
}

@Composable
fun PuppyDetail(puppy: Puppy, adopt: (Puppy) -> Unit) {
    var adopted by remember { mutableStateOf(puppy.adoption) }

    Column(modifier = Modifier.padding(8.dp)) {
        Image(
            painter = painterResource(id = puppy.drawable),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .clip(MaterialTheme.shapes.medium)
        )
        Text(
            text = "Name : ${puppy.name}",
            style = MaterialTheme.typography.h3,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = "Age : ${puppy.age}",
            style = MaterialTheme.typography.h5,
        )
        Text(
            text = "Breed : ${puppy.breed}",
            style = MaterialTheme.typography.h5,
            modifier = Modifier.padding(bottom = 30.dp)
        )
        Button(
            onClick = {
                adopt(puppy)
                adopted = true
            },
            enabled = adopted.not(),
            shape = MaterialTheme.shapes.medium,
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
        ) {
            Text(text = if (adopted) "You Adopted Me!" else "Adopt Me!")
        }
    }
}
