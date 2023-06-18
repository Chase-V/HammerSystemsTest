package com.example.hammersystemstest.model

import com.example.hammersystemstest.domain.ServerResponse

data class ServerResponseDto(
    val title: String,
    val explanation: String,
    val url: String,
    val mediaType: String
)

fun ServerResponse.toDto() =
    ServerResponseDto(title = title, explanation = explanation, url = url, mediaType = mediaType)