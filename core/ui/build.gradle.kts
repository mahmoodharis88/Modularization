plugins {
    alias(libs.plugins.blooddonation.android.library)
    alias(libs.plugins.blooddonation.android.lib.compose)
}

android {
    namespace = "com.blood.donation.core.ui"

}

dependencies {
    implementation(projects.core.designSystem)
}
