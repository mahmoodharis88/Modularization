plugins {
    alias(libs.plugins.mutimodulesample.android.library)
    alias(libs.plugins.mutimodulesample.android.lib.compose)
}

android {
    namespace = "com.sample.mutimodulesample.core.designsystem"

}
dependencies {
    implementation(libs.androidx.ui.text.google.fonts)
}
