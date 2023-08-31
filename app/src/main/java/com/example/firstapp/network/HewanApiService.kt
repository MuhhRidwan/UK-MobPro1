package com.example.firstapp.network

private const val BASE_URL = "https://raw.githubusercontent.com/" +
        "indraazimi/galeri-hewan/static-api/"
private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()
interface HewanApiService {
    @GET("static-api.json")
    suspend fun getHewan(): String
}
object HewanApi {
    val service: HewanApiService by lazy {
        retrofit.create(HewanApiService::class.java)
    }
}