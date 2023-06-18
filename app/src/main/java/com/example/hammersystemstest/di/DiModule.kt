package com.example.hammersystemstest.di

import com.example.hammersystemstest.domain.repo.ServerResponseRepository
import com.example.hammersystemstest.domain.repo.ServerResponseRepositoryImpl
import com.example.hammersystemstest.domain.retrofit.RetrofitServerResponseApi
import com.example.hammersystemstest.domain.retrofit.ServerResponseApi
import com.example.hammersystemstest.domain.retrofit.ServerResponseApiImpl
import com.example.hammersystemstest.viewModel.ServerResponseViewModel
import com.google.gson.GsonBuilder
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {

    single<String>(qualifier = named("baseUrl")) {
        "https://api.nasa.gov/"
    }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(get<String>(qualifier = named("baseUrl")))
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder()
                        .setLenient().create()
                )
            )
            .build()
    }

    single<RetrofitServerResponseApi> { get<Retrofit>().create(RetrofitServerResponseApi::class.java) }

    single<ServerResponseApi> { ServerResponseApiImpl(get<RetrofitServerResponseApi>()) }

    single<ServerResponseRepository> { ServerResponseRepositoryImpl(get<ServerResponseApi>()) }

    viewModel { ServerResponseViewModel(get<ServerResponseRepository>()) }
}