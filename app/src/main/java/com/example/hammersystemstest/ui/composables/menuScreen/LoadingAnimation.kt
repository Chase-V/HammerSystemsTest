package com.example.hammersystemstest.ui.composables.menuScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.hammersystemstest.utils.ShimmerSpacer

@Composable
fun MenuScreenLoadingAnimation() {
    Column(
        Modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        ShimmerSpacer(
            Modifier
                .height(112.dp)
                .fillMaxWidth(0.9f)
                .clip(RoundedCornerShape(10.dp))
        )

        Spacer(
            Modifier
                .fillMaxWidth()
                .height(16.dp)
        )

        Row(
            Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth(1f),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            repeat(4) {
                ShimmerSpacer(
                    Modifier
                        .width(72.dp)
                        .height(32.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        repeat(3) {
            Row(
                Modifier
                    .fillMaxWidth(1f)
                    .align(Alignment.CenterHorizontally)
                    .height(150.dp)
                    .padding(horizontal = 16.dp)
            ) {
                ShimmerSpacer(Modifier.size(150.dp))

                Spacer(Modifier.width(16.dp))

                Column {
                    ShimmerSpacer(
                        Modifier
                            .height(16.dp)
                            .fillMaxWidth(1f)
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    ShimmerSpacer(
                        Modifier
                            .height(40.dp)
                            .fillMaxWidth(1f)
                    )


                    Spacer(modifier = Modifier.weight(1f))

                    Row(modifier = Modifier.fillMaxWidth()) {
                        Spacer(modifier = Modifier.weight(1f))
                        ShimmerSpacer(
                            Modifier
                                .height(32.dp)
                                .width(87.dp)
                                .align(Alignment.Bottom)
                        )
                    }

                }
            }
            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}