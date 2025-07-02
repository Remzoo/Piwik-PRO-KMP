package io.github.kotlin.fibonacci

expect class AnalyticsTracker {
    fun initialize(apiUrl: String, applicationId: String)
    fun reportScreenView(screen: AnalyticsScreen)
}