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
package com.example.androiddevchallenge

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.model.Puppy

internal typealias BreedInfo = Pair<String, Int>

class MainViewModel : ViewModel() {

    val puppies by mutableStateOf(
        (0 until 20).map {
            Puppy(it + 1, NAMES[it], it + 1, BREEDS[it].first, BREEDS[it].second)
        }
    )

    fun adoptPuppy(puppy: Puppy) {
        puppy.adoption = true
    }

    companion object {

        private val NAMES: Array<String> = arrayOf(
            "Bella", "Luna", "Lucy", "Daisy", "Lola", "Sadie", "Molly", "Bailey", "Stella", "Lexi",
            "Sophie", "Chloe", "Penny", "Zoey", "Lily", "Coco", "Roxy", "Gracie", "Rosie", "Nala"
        )

        private val BREEDS: Array<BreedInfo> = arrayOf(
            BreedInfo("Labrador Retriever", R.drawable.puppy1),
            BreedInfo("German Shepherd", R.drawable.puppy2),
            BreedInfo("Golden Retriever", R.drawable.puppy3),
            BreedInfo("Bulldog", R.drawable.puppy4),
            BreedInfo("Beagle", R.drawable.puppy5),
            BreedInfo("French Bulldog", R.drawable.puppy6),
            BreedInfo("Yorkshire Terrier", R.drawable.puppy7),
            BreedInfo("Poodle", R.drawable.puppy8),
            BreedInfo("Rottweiler", R.drawable.puppy9),
            BreedInfo("Boxer", R.drawable.puppy10),
            BreedInfo("German Shorthaired Pointer", R.drawable.puppy11),
            BreedInfo("Siberian Husky", R.drawable.puppy12),
            BreedInfo("Dachshund", R.drawable.puppy13),
            BreedInfo("Doberman Pinscher", R.drawable.puppy14),
            BreedInfo("Great Dane", R.drawable.puppy15),
            BreedInfo("Miniature Schnauzer", R.drawable.puppy16),
            BreedInfo("Cavalier King Charles Spaniel", R.drawable.puppy17),
            BreedInfo("Shih-Tzu", R.drawable.puppy18),
            BreedInfo("Pembroke Welsh Corgi", R.drawable.puppy19),
            BreedInfo("Pomeranian", R.drawable.puppy20),
        )
    }
}
