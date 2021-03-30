package `fun`.kulikov.aviasalestestapp.di.modules

import `fun`.kulikov.aviasalestestapp.data.api.ApiController
import `fun`.kulikov.aviasalestestapp.data.api.DestinationService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module(includes = [RetrofitModule::class])
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    @Singleton
    fun provideApiController(
        destinationService: DestinationService
    ): ApiController = ApiController(destinationService)

}