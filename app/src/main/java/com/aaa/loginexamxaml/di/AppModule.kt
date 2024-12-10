package com.aaa.loginexamxaml.di

import com.aaa.loginexamxaml.data.remote.LoginApi
import com.aaa.loginexamxaml.data.remote.LoginApiImpl
import com.aaa.loginexamxaml.data.repository.LoginRepositoryImpl
import com.aaa.loginexamxaml.domain.repository.LoginRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLoginApi(): LoginApi{
        return LoginApiImpl()
    }

    @Provides
    @Singleton
    fun provideLoginRepository(loginApi: LoginApi): LoginRepository {
        return LoginRepositoryImpl(loginApi)
    }
}