package com.example.hammersystemstest.ui.composables.menuScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.ElevatedSuggestionChip
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SuggestionChipDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChipsGridItem(items: List<String>) {
    var currentItem by remember {
        mutableStateOf(0)
    }
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White),
    ) {
        LazyHorizontalGrid(
            rows = GridCells.Fixed(1),
            modifier = Modifier
                .height(64.dp)
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            itemsIndexed(chipsList) { index, item ->
                ElevatedSuggestionChip(
                    onClick = { currentItem = index },
                    elevation = SuggestionChipDefaults.suggestionChipElevation(
                        defaultElevation = 5.dp
                    ),
                    label = { Text(text = item) },
                    border = null,
                    colors = if (currentItem == index) {
                        SuggestionChipDefaults.elevatedSuggestionChipColors(
                            containerColor = Color(0xFFFD3A69),
                            labelColor = Color(0xFFFFFFFF),
                        )
                    } else {
                        SuggestionChipDefaults.elevatedSuggestionChipColors(
                            containerColor = Color(0xFFFFFFFF),
                            labelColor = Color(0xFFC7C8CD)
                        )
                    },
                )
            }
        }
    }


}