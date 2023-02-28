plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("io.github.luca992.multiplatform-swiftpackage") version "2.1.1"
}

kotlin {
    android()
    iosX64 {
        binaries {
            framework {
                baseName = "shared"
                isStatic = true
            }
        }
    }

    iosArm64 {
        binaries {
            framework {
                baseName = "shared"
                isStatic = true
            }
        }
    }

    sourceSets {
        val commonMain by getting
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
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
    distributionMode { local() } // Where will we look for the XCFramework.
}

android {
    namespace = "com.example.myapplication"
    compileSdk = 33
    defaultConfig {
        minSdk = 24
        targetSdk = 33
    }
}