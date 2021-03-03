/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
