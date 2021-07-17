package com.gold.book.pexelsploer.data.network.pexels

import com.gold.book.pexelsploer.BuildConfig
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

class HttpClient {
    companion object {
        private const val readTimeoutSeconds = 30L
        private const val connectTimeoutSeconds = 30L

        val apiV1: Retrofit = Retrofit.Builder().apply {
            client(okhttpBuilder().build())
            baseUrl(BuildConfig.PEXELS_V1_URL)

            val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
            addConverterFactory(MoshiConverterFactory.create(moshi))
        }.build()

        private fun okhttpBuilder() = OkHttpClient.Builder().apply {
            if (BuildConfig.DEBUG) addInterceptor(HttpLoggingInterceptor().setLevel(Level.BODY))
            addInterceptor(RequestInterceptor())
            connectTimeout(connectTimeoutSeconds, TimeUnit.SECONDS)
            readTimeout(readTimeoutSeconds, TimeUnit.SECONDS)
        }
    }
}