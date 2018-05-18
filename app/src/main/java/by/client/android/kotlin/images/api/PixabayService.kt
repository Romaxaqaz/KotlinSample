package by.client.android.kotlin.images.api

import by.client.android.kotlin.images.api.search.SearchResponse
import com.google.gson.GsonBuilder
import io.reactivex.Observable
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.QueryMap


/**
 * Created by PanteleevRV on 18.05.2018.
 *
 * @author PRV
 */
interface PixabayService {

    @GET("/api")
    fun search(@QueryMap input: HashMap<String, String>): Observable<SearchResponse>


    companion object Factory {
        fun create(): PixabayService {
            val gson = GsonBuilder().setLenient().create()
            val client = OkHttpClient().newBuilder().addInterceptor(ApiKeyInterceptor()).build()

            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .baseUrl("https://pixabay.com/")
                    .client(client)
                    .build()

            return retrofit.create(PixabayService::class.java)
        }
    }
}
