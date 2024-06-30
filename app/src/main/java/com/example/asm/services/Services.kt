package com.example.asm.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

data class RegisterReq(val email: String, val password: String, val fullName: String)
data class RegisterRes(val status: Boolean, val message: String)
data class LoginReq(val email:String, val password: String)
data class LoginRes(val status: Boolean, val message: String)
data class CategoryRes(val cateID: String, val cateName: String, val image: String)
data class ProductRes(val productID: String, val productName: String, val description: String, val image: String, val price: String, val cateID: String)
// Interface định nghĩa API
interface ApiService {
//    @GET("get-category.php")
//    suspend fun getCategory(): List<Category>

    @POST("register.php")
    suspend fun register(@Body registerReq: RegisterReq): RegisterRes?


    @POST("login.php")
    suspend fun login(@Body loginReq: LoginReq): LoginRes?

    @GET("get-category.php")
    suspend fun getCategory(): List<CategoryRes>

    @GET("get-product.php")
    suspend fun getProductByCateID(@Query("cateID") cateID: String?): List<ProductRes>

    @GET("detail-product.php")
    suspend fun getProductByID(@Query("productID") productID: String?): ProductRes?
}

// Object để khởi tạo Retrofit
object RetrofitInstance {
    const val BASE_URL = "https://apis.tridinhne.click/asmkot104/"

    val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}
