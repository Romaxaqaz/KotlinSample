package by.client.android.kotlin.images.api

import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by PanteleevRV on 18.05.2018.
 *
 * @author PRV
 */
class ApiKeyInterceptor : Interceptor {
    // TODO KEY_VALUE
    override fun intercept(chain: Interceptor.Chain?): Response {
        var request = chain!!.request()
        val url = request
                .url()
                .newBuilder()
                .addQueryParameter("key", "KEY_VALUE")
                .build()
        request = request.newBuilder().url(url).build()
        return chain.proceed(request)
    }

}