plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("io.github.luca992.multiplatform-swiftpackage") version "2.1.1"
}

kotlin {
    android()
    ios {
        binaries {
            framework {
                baseName = "shared"
                isStatic = true
            }
        }
    }

    iosSimulatorArm64 {
        binaries {
            framework {
                baseName = "shared"
                isStatic = true
            }
        }
    }

    sourceSets {
        val iosMain by getting
        val iosTest by getting
        val iosSimulatorArm64Main by getting {
            dependsOn(iosMain)
        }
        val iosSimulatorArm64Test by getting {
            dependsOn(iosTest)
        }
    }
}

multiplatformSwiftPackage {
    swiftToolsVersion("5.7.0")
    targetPlatforms {
        iOS { v("15") }
    }
    packageName("shared")
    outputDirectory(File(rootDir, "/"))
    distributionMode { local() }
}

android {
    namespace = "com.example.myapplication"
    compileSdk = 33
    defaultConfig {
        minSdk = 24
        targetSdk = 33
    }
}