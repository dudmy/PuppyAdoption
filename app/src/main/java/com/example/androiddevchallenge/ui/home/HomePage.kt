package com.example.androiddevchallenge.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.Puppy

@Composable
fun HomePage(puppies: List<Puppy>, onClick: (Int) -> Unit) {
    Column {
        TopAppBar(title = { Text(text = "Puppy Adoption") })
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(8.dp)
        ) {
            items(puppies) { puppy ->
                PuppyItem(
                    puppy = puppy,
                    modifier = Modifier
                        .clickable { onClick(puppy.id) }
                        .fillMaxWidth()
                )
            }
        }
    }
}

@Composable
fun PuppyItem(puppy: Puppy, modifier: Modifier) {
    Card(modifier = modifier.clip(MaterialTheme.shapes.medium)) {
        Row {
            Image(
                painter = painterResource(id = puppy.drawable),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(MaterialTheme.shapes.medium)
            )
        }
    }
}
