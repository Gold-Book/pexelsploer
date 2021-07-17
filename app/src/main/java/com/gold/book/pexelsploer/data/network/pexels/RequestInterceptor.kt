package com.gold.book.pexelsploer.data.network.pexels

import com.gold.book.pexelsploer.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class RequestInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()

        val newRequest = originalRequest.newBuilder()
            .header("Authorization", BuildConfig.PEXELS_API_KEY)
            .method(originalRequest.method, originalRequest.body)
            .build()

        return chain.proceed(newRequest)
    }
}
