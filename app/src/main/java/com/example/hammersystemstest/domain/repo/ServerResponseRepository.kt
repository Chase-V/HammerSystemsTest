package com.example.hammersystemstest.domain.repo

import com.example.hammersystemstest.model.ServerResponseDto
import kotlinx.coroutines.flow.Flow

interface ServerResponseRepository {

    fun getData(): Flow<List<ServerResponseDto>>

}