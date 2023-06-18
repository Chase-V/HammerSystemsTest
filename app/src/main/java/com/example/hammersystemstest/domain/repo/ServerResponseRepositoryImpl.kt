package com.example.hammersystemstest.domain.repo

import com.example.hammersystemstest.domain.retrofit.ServerResponseApi
import com.example.hammersystemstest.model.ServerResponseDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class ServerResponseRepositoryImpl(private val api: ServerResponseApi) : ServerResponseRepository {

    override fun getData(): Flow<List<ServerResponseDto>> =
        api.fetchServerResponse().flowOn(Dispatchers.IO)

}