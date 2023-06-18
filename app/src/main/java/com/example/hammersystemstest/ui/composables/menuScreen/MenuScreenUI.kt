package com.example.hammersystemstest.ui.composables.menuScreen

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hammersystemstest.R
import com.example.hammersystemstest.utils.ApiState
import com.example.hammersystemstest.utils.shimmerBrush
import com.example.hammersystemstest.viewModel.ServerResponseViewModel
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun MenuScreenUI(
    navController: NavController
) {

    val viewModel = koinViewModel<ServerResponseViewModel>()

    Scaffold(
        topBar = {
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp, top = 24.dp)
                        .height(56.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Button(
                        onClick = { },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent,
                            contentColor = Color(0xFF222831)
                        ),
                        contentPadding = (PaddingValues(0.dp))
                    ) {
                        Text(text = "Моcква", fontSize = 16.sp)
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowDown,
                            contentDescription = null,
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }

                    IconButton(
                        onClick = { /*TODO*/ },
                        Modifier
                            .size(24.dp)
                            .aspectRatio(1f)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.qr_code),
                            contentDescription = null
                        )
                    }
                }
            }

        }
    ) { innerPadding ->

        Spacer(modifier = Modifier.height(16.dp))

        Surface(modifier = Modifier.padding(paddingValues = innerPadding)) {
            GetData(viewModel = viewModel)
        }


    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GetData(viewModel: ServerResponseViewModel) {

    when (val result = viewModel.data.value) {

        is ApiState.Success -> {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(vertical = 8.dp),
            ) {

                item {
                    BannerGrid(items = bannerList)
                }

                stickyHeader(key = "chips") {
                    ChipsGridItem(items = chipsList)
                }

                itemsIndexed(result.data) { index, item ->
                    MenuCardItem(item)
                    if (index < result.data.lastIndex)
                        Divider(color = Color(0xFFF3F5F9), thickness = 1.dp)
                }

            }
        }

        is ApiState.Failure -> {
            Box(modifier = Modifier.fillMaxWidth(1f)) {
                Icon(
                    imageVector = Icons.Default.Warning,
                    contentDescription = null,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }

        ApiState.Loading -> {
            MenuScreenLoadingAnimation()
        }

        ApiState.Empty -> {
            Log.d("mylog", "getData: loading")
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .background(shimmerBrush(true, 1000f))
            ) {

            }
        }
    }
}


val bannerList = listOf(R.drawable.rectangle38, R.drawable.rectangle39)
val chipsList = listOf("Пицца", "Комбо", "Десерты", "Напитки")