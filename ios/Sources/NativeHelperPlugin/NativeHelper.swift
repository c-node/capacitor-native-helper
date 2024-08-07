import Foundation

@objc public class NativeHelper: NSObject {
    @objc public func echo(_ value: String) -> String {
        print(value)
        return value
    }
}
