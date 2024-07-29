plugins {
    alias(libs.plugins.mutimodulesample.android.application)
    alias(libs.plugins.mutimodulesample.android.app.compose)
}

dependencies {
    implementation(projects.feature.onboarding)
    implementation(projects.core.designSystem)
    implementation(projects.core.ui)
    implementation(libs.androidx.core.splashscreen)
}