plugins {
    alias(libs.plugins.blooddonation.android.library)
    alias(libs.plugins.blooddonation.android.lib.compose)
}

android {
    namespace = "com.blood.donation.core.designsystem"

}
dependencies {
    implementation(libs.androidx.ui.text.google.fonts)
}
