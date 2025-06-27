import { WebPlugin } from '@capacitor/core';

import type { NativeHelperPlugin } from './definitions';

export class NativeHelperWeb extends WebPlugin implements NativeHelperPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }

  async toastMe(options: { text: string }): Promise<void> {
    console.log('toastMe:', options);
    alert(options.text);
  }

  async moveToBackground(): Promise<void> {
    console.log('moveToBackground: Not available on web');
  }

  async startClipService(): Promise<void> {
    console.log('startClipService: Not available on web');
  }

  async stopClipService(): Promise<void> {
    console.log('stopClipService: Not available on web');
  }

  async storeInSharedPrefs(options: { key: string; value: string }): Promise<void> {
    console.log('storeInSharedPrefs:', options);
    localStorage.setItem(options.key, options.value);
  }

  async getOverlayPermissionStatus(): Promise<{ result: boolean }> {
    console.log('getOverlayPermissionStatus: Not available on web');
    return { result: false };
  }

  async getNotificationPermissionStatus(): Promise<{ result: boolean }> {
    console.log('getNotificationPermissionStatus: Not available on web');
    return { result: false };
  }

  async getSystemLanguage(): Promise<{ value: string }> {
    console.log('getSystemLanguage');
    const language = navigator.language || 'en';
    return { value: language };
  }

  async getVersionName(): Promise<{ versionName: string }> {
    console.log('getVersionName: Not available on web');
    return { versionName: 'web' };
  }

  async requestOverlayPermission(): Promise<void> {
    console.log('requestOverlayPermission: Not available on web');
  }

  async goToNotificationSettings(): Promise<void> {
    console.log('goToNotificationSettings: Not available on web');
  }

  async checkTheme(): Promise<{ theme: string }> {
    const isDarkMode = window.matchMedia && window.matchMedia('(prefers-color-scheme: dark)').matches;
    const theme = isDarkMode ? 'dark' : 'light';

    return { theme };
  }
}
