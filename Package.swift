// swift-tools-version: 5.9
import PackageDescription

let package = Package(
    name: "NativeHelper",
    platforms: [.iOS(.v13)],
    products: [
        .library(
            name: "NativeHelper",
            targets: ["NativeHelperPlugin"])
    ],
    dependencies: [
        .package(url: "https://github.com/ionic-team/capacitor-swift-pm.git", branch: "main")
    ],
    targets: [
        .target(
            name: "NativeHelperPlugin",
            dependencies: [
                .product(name: "Capacitor", package: "capacitor-swift-pm"),
                .product(name: "Cordova", package: "capacitor-swift-pm")
            ],
            path: "ios/Sources/NativeHelperPlugin"),
        .testTarget(
            name: "NativeHelperPluginTests",
            dependencies: ["NativeHelperPlugin"],
            path: "ios/Tests/NativeHelperPluginTests")
    ]
)