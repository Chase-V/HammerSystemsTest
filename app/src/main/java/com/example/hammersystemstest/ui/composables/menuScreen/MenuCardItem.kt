package com.example.hammersystemstest.ui.composables.menuScreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.hammersystemstest.model.ServerResponseDto
import com.example.hammersystemstest.utils.shimmerBrush

@Composable
fun MenuCardItem(item: ServerResponseDto) {
    val showShimmer = remember {
        mutableStateOf(true)
    }
    Spacer(modifier = Modifier.height(16.dp))
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp),
        shape = RectangleShape,
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {

        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {

            AsyncImage(
                modifier = Modifier
                    .background(
                        shimmerBrush(
                            showShimmer = showShimmer.value,
                            targetValue = 1000f
                        )
                    )
                    .size(135.dp)
                    .clip(RoundedCornerShape(6.dp))
                    .aspectRatio(1f),
                model = item.url,
                contentDescription = null,
                onSuccess = { showShimmer.value = false },
                contentScale = ContentScale.Crop,
            )

            Spacer(
                modifier = Modifier
                    .width(22.dp)
                    .fillMaxHeight()
            )

            Column {
                Text(
                    text = item.title,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF222831),
                )
                Text(
                    modifier = Modifier.height(68.dp),
                    text = item.explanation,
                    maxLines = 4,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 14.sp,
                    color = Color(0xFFAAAAAD),
                    lineHeight = 15.sp
                )
                Spacer(modifier = Modifier.weight(1f))
                OutlinedButton(
                    onClick = {  },
                    shape = RoundedCornerShape(6.dp),
                    modifier = Modifier
                        .align(Alignment.End)
                        .padding(0.dp)
                        .height(32.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = Color(0xFFFD3A69)
                    ),
                    border = BorderStroke(width = 1.dp, color = Color(0xFFFD3A69))
                ) {
                    Text(
                        text = "от 345 р",
                        fontSize = 13.sp,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
        }


    }
}

