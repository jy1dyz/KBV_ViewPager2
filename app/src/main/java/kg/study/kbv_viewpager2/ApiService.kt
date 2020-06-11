package kg.study.kbv_viewpager2

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("products")
    fun fetchImages(): Call<ImageDBResponse?>?
}