// swift-tools-version:5.3
import PackageDescription

let package = Package(
    name: "piwikprokmp",
    platforms: [
        .iOS(.v14),
    ],
    products: [
        .library(name: "piwikprokmp", targets: ["piwikprokmp"])
    ],
    targets: [
        .binaryTarget(
            name: "piwikprokmp",
            url: "https://github.com/Remzoo/Piwik-PRO-KMP/releases/download/v1.0.1/piwikprokmp.xcframework.zip",
            checksum: "69f29ea9da1749989bebf550b79d02ce30fbb69f0fdaa4844f7d405a8ce0ce5b"
        )
    ]
)





