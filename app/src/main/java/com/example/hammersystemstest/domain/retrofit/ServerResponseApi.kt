package com.example.hammersystemstest.domain.retrofit

import com.example.hammersystemstest.model.ServerResponseDto
import kotlinx.coroutines.flow.Flow

interface ServerResponseApi {
    fun fetchServerResponse(): Flow<List<ServerResponseDto>>
}