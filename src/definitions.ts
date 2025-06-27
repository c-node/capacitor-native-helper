declare module "@capacitor/core" {
  interface PluginRegistry {
    NativeHelper: NativeHelperPlugin
  }
}

export interface NativeHelperPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
  toastMe(options: { text: string }): Promise<void>;
  moveToBackground(): Promise<void>;
  startClipService(): Promise<void>;
  stopClipService(): Promise<void>;
  storeInSharedPrefs(options: { key: string; value: string }): Promise<void>;
  getOverlayPermissionStatus(): Promise<{ result: boolean }>;
  getNotificationPermissionStatus(): Promise<{ result: boolean }>;
  getSystemLanguage(): Promise<{ value: string }>;
  getVersionName(): Promise<{ versionName: string }>;
  requestOverlayPermission(): Promise<void>;
  goToNotificationSettings(): Promise<void>;
  checkTheme(): Promise<{ theme: string }>;
}
