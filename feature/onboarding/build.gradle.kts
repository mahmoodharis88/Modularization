plugins {
    alias(libs.plugins.mutimodulesample.android.library)
    alias(libs.plugins.mutimodulesample.android.lib.compose)
    alias(libs.plugins.mutimodulesample.android.feature)
}

android {
    namespace = "com.sample.mutimodulesample.feature.onboarding"

}