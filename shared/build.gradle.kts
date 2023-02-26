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
                isStatic = false
            }
        }
    }

    iosSimulatorArm64 {
        binaries {
            framework {
                baseName = "shared"
                isStatic = false
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
    swiftToolsVersion("5.3")
    targetPlatforms {
        iOS { v("13") }
    }
    packageName("shared")
    outputDirectory(File(rootDir, "/"))
}

android {
    namespace = "com.example.myapplication"
    compileSdk = 33
    defaultConfig {
        minSdk = 24
        targetSdk = 33
    }
}