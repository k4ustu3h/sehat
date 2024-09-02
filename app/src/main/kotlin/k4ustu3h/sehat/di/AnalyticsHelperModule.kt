package k4ustu3h.sehat.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import k4ustu3h.sehat.analytics.AnalyticsHelper
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AnalyticsHelperModule {

    @Provides
    @Singleton
    fun provideAnalyticsHelper(
        @ApplicationContext context: Context,
    ): AnalyticsHelper {
        return AnalyticsHelper(context = context)
    }
}
