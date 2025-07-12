package com.example.juansuarez_p2_ap2.di

import com.example.juansuarez_p2_ap2.data.remote.ContributorsApi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@dagger.hilt.InstallIn(dagger.hilt.components.SingletonComponent::class)
@dagger.Module
object ApiModule {

    const val BASE_URL = "https://api.github.com/"

    @dagger.Provides
    @javax.inject.Singleton
    fun provideMoshi(): Moshi =
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

    @Provides
    @Singleton
    fun provideContributorsApi(moshi: Moshi): ContributorsApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(ContributorsApi::class.java)
    }

}
