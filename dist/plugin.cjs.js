'use strict';

Object.defineProperty(exports, '__esModule', { value: true });

var core = require('@capacitor/core');

const NativeHelper = core.registerPlugin('NativeHelper', {
    web: () => Promise.resolve().then(function () { return web; }).then(m => new m.NativeHelperWeb()),
});

class NativeHelperWeb extends core.WebPlugin {
    async echo(options) {
        console.log('ECHO', options);
        return options;
    }
    async toastMe(options) {
        console.log('toastMe:', options);
        alert(options.text);
    }
    async moveToBackground() {
        console.log('moveToBackground: Not available on web');
    }
    async startClipService() {
        console.log('startClipService: Not available on web');
    }
    async stopClipService() {
        console.log('stopClipService: Not available on web');
    }
    async storeInSharedPrefs(options) {
        console.log('storeInSharedPrefs:', options);
        localStorage.setItem(options.key, options.value);
    }
    async getOverlayPermissionStatus() {
        console.log('getOverlayPermissionStatus: Not available on web');
        return { result: false };
    }
    async getNotificationPermissionStatus() {
        console.log('getNotificationPermissionStatus: Not available on web');
        return { result: false };
    }
    async getSystemLanguage() {
        console.log('getSystemLanguage');
        const language = navigator.language || 'en';
        return { value: language };
    }
    async getVersionName() {
        console.log('getVersionName: Not available on web');
        return { versionName: 'web' };
    }
    async requestOverlayPermission() {
        console.log('requestOverlayPermission: Not available on web');
    }
    async goToNotificationSettings() {
        console.log('goToNotificationSettings: Not available on web');
    }
    async checkTheme() {
        const isDarkMode = window.matchMedia && window.matchMedia('(prefers-color-scheme: dark)').matches;
        const theme = isDarkMode ? 'dark' : 'light';
        return { theme };
    }
}

var web = /*#__PURE__*/Object.freeze({
    __proto__: null,
    NativeHelperWeb: NativeHelperWeb
});

exports.NativeHelper = NativeHelper;
//# sourceMappingURL=plugin.cjs.js.map
