package com.mahlon.photoapp.api

import com.mahlon.photoapp.modal.UnsplashResponse
import com.mahlon.photoapp.util.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface UnsplashAPI {
    @GET("photos")
    suspend fun getUnsplashPhoto(
        @Query("page")
        pageNumber: Int,
        @Query("client_id")
        clientId: String = Constants.API_KEY
    ): Response<UnsplashResponse>
}