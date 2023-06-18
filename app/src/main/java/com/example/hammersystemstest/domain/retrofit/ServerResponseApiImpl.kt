package com.example.hammersystemstest.domain.retrofit

import com.example.hammersystemstest.model.ServerResponseDto
import com.example.hammersystemstest.model.toDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ServerResponseApiImpl(private val retrofitServerResponseAPI: RetrofitServerResponseApi) :
    ServerResponseApi {
    override fun fetchServerResponse(): Flow<List<ServerResponseDto>> = flow {
        emit(retrofitServerResponseAPI.fetchServerResponse().map { it.toDto() })
    }

}