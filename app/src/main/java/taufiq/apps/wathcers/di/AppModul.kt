package taufiq.apps.wathcers.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import taufiq.apps.wathcers.network.MovieClientRequest
import taufiq.apps.wathcers.utils.Constant.Companion.BASE_URL
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created By Taufiq on 4/26/2021.
 *
 */
@Module
@InstallIn(ViewModelComponent::class)
class AppModul {

    @Singleton
    @Provides
    fun providesOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder().apply {
            addInterceptor(interceptor)
            connectTimeout(5, TimeUnit.SECONDS)
            readTimeout(5, TimeUnit.SECONDS)
        }
        return client.build()
    }


    @Singleton
    @Provides
    fun provideGithubApi(okHttpClient: OkHttpClient): MovieClientRequest =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieClientRequest::class.java)

}