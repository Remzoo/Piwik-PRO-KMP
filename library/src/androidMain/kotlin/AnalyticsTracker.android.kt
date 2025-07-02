package io.github.kotlin.fibonacci

import pro.piwik.sdk.Piwik

actual class AnalyticsTracker {

    init {
        println("[AnalyticsTracker] init called.")
    }

    actual fun initialize(apiUrl: String, applicationId: String) {
        println(
            "[AnalyticsTracker] Initialize with apiUrl: $apiUrl and " +
                "applicationId: $applicationId"
        )
        println("[AnalyticsTracker] Piwik logger prefix: ${Piwik.LOGGER_PREFIX}")
    }

    actual fun reportScreenView(screen: AnalyticsScreen) {
        println("[AnalyticsTracker] Repost screenView: $screen")
        println("[AnalyticsTracker] Piwik logger prefix: ${Piwik.LOGGER_PREFIX}")
    }
}