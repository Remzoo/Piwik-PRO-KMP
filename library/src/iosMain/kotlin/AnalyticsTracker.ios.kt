@file:OptIn(ExperimentalForeignApi::class)

package io.github.kotlin.fibonacci

import cocoapods.PiwikPROSDK.PiwikTracker
import kotlinx.cinterop.ExperimentalForeignApi

actual class AnalyticsTracker {

    private var tracker: PiwikTracker? = null

    init {
        println("[AnalyticsTracker] init called.")
    }

    actual fun initialize(apiUrl: String, applicationId: String) {
        println(
            "[AnalyticsTracker] Initialize with apiUrl: $apiUrl and " +
                    "applicationId: $applicationId"
        )
        tracker = PiwikTracker.sharedInstanceWithSiteID(apiUrl, applicationId)
    }

    actual fun reportScreenView(screen: AnalyticsScreen) {
        println("[AnalyticsTracker] Repost screenView: $screen")
        tracker?.sendView(screen.name)
    }
}