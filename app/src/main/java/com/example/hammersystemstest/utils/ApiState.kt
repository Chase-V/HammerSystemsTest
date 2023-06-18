package com.example.hammersystemstest.utils

import com.example.hammersystemstest.model.ServerResponseDto

sealed class ApiState {

    class Success(val data:List<ServerResponseDto>):ApiState()
    class Failure(val msg:Throwable):ApiState()
    object Loading:ApiState()
    object Empty:ApiState()

}