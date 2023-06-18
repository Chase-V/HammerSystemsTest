package com.example.hammersystemstest.viewModel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hammersystemstest.domain.repo.ServerResponseRepository
import com.example.hammersystemstest.utils.ApiState
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class ServerResponseViewModel(
    private val serverResponseRepository: ServerResponseRepository
) : ViewModel() {

    val data: MutableState<ApiState> = mutableStateOf(ApiState.Empty)

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            serverResponseRepository.getData()
                .onStart {
                    data.value = ApiState.Loading
                }
                .catch {
                    data.value = ApiState.Failure(it)
                    Log.d("", "ViewModel:loadData:getData:error: ${it.message}")
                }
                .collect { response ->
                    data.value = ApiState.Success(response)
                }
        }
    }

}