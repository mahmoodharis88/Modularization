plugins {
    alias(libs.plugins.blooddonation.android.application)
    alias(libs.plugins.blooddonation.android.app.compose)
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

dependencies {
    implementation(projects.feature.onboarding)
    implementation(projects.core.designSystem)
    implementation(projects.core.navigation)
    implementation(projects.core.ui)


    implementation(libs.androidx.core.splashscreen)
    implementation(libs.androidx.core.splashscreen)

    //    Hilt
    implementation(libs.hilt.android)
    implementation(libs.androidx.hilt.navigation.compose)
    kapt(libs.hilt.compiler)

}