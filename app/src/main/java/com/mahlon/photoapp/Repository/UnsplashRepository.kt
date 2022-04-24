package com.mahlon.photoapp.Repository

import com.mahlon.photoapp.api.RetroFitInstance
import com.mahlon.photoapp.modal.UnsplashResponse
import retrofit2.Response

class UnsplashRepository {
    suspend fun getImage(pageNumber: Int): Response<UnsplashResponse> {
        return RetroFitInstance.api.getUnsplashPhoto(pageNumber)
    }
}