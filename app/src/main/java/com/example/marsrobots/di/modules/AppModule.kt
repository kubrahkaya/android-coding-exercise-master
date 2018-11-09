package com.example.marsrobots.di.modules

import android.content.Context
import android.util.Log
import androidx.room.Room
import com.example.marsrobots.App
import com.example.marsrobots.data.source.local.ImageDao
import com.example.marsrobots.data.source.local.ImageDatabase
import com.example.marsrobots.data.source.remote.ApiService
import com.example.marsrobots.di.qualifiers.ApplicationContext
import com.example.marsrobots.di.scopes.PerApplication
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class AppModule(private var application: App) {

    @Provides
    @PerApplication
    internal fun provideApplication(): App = application

    @Provides
    @PerApplication
    @ApplicationContext
    internal fun provideContext(): Context = application

    @Provides
    @PerApplication
    internal fun provideImageDao(imageDatabase: ImageDatabase): ImageDao = imageDatabase.imageDao()

    @Provides
    @PerApplication
    internal fun provideRoomDatabase(): ImageDatabase = Room.databaseBuilder(application, ImageDatabase::class.java, "image-db").build()

    @Provides
    @PerApplication
    internal fun provideRetrofitService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

    @Provides
    @PerApplication
    internal fun retrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://images-api.nasa.gov")
        .build()

    @Provides
    @PerApplication
    fun okHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    @Provides
    @PerApplication
    fun loggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor { message -> Log.i("", message) }
        .setLevel(HttpLoggingInterceptor.Level.BODY)
}