package k4ustu3h.sehat.di

import android.content.Context
import k4ustu3h.sehat.MedicationNotificationService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NotificationModule {
    @Provides
    @Singleton
    fun provideMedicationNotificationService(
        @ApplicationContext context: Context,
    ): MedicationNotificationService = MedicationNotificationService(context)
}