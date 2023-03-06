import PackageDescription

let remoteKotlinUrl = "https://maven.pkg.github.com/buxapp/shared-stocks-mobile/Stocks/shared-kmmbridge/0.1.5/shared-kmmbridge-0.1.5.zip"
let remoteKotlinChecksum = "7787bf5a7ed0cf318dd115fcc9d87d8764c1f416cb4d10377b9aa166abe676b8"
let packageName = "shared"

let package = Package(
    name: packageName,
    platforms: [
        .iOS(.v13)
    ],
    products: [
        .library(
            name: packageName,
            targets: [packageName]
        ),
    ],
    targets: [
        .binaryTarget(
            name: packageName,
            url: remoteKotlinUrl,
            checksum: remoteKotlinChecksum
        )
        ,
    ]
)