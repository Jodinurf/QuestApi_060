package com.jodifrkh.serverdatabase.dependenciesinjection

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.jodifrkh.serverdatabase.data.repository.MahasiswaRepository
import com.jodifrkh.serverdatabase.data.repository.NetworkMahasiswaRepository
import com.jodifrkh.serverdatabase.service.MahasiswaService
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer{
    val mahasiswaRepository: MahasiswaRepository
}

class MahasiswaContainer : AppContainer{
    private val baseUrl = "http://10.0.2.2/umyTI/"
    private val json = Json { ignoreUnknownKeys = true }
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl).build()

    private val mahasiswaService: MahasiswaService by lazy { retrofit.create(MahasiswaService::class.java) }
    override val mahasiswaRepository: MahasiswaRepository by lazy { NetworkMahasiswaRepository(mahasiswaService) }
}