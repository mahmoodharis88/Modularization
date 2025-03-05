plugins {
    alias(libs.plugins.blooddonation.android.library)
    alias(libs.plugins.blooddonation.android.lib.compose)
    alias(libs.plugins.blooddonation.android.feature)
}

android {
    namespace = "com.blood.donation.feature.onboarding"

}

dependencies {
    implementation(projects.core.navigation)
}