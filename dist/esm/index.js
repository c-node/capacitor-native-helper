import { registerPlugin } from '@capacitor/core';
const NativeHelper = registerPlugin('NativeHelper', {
    web: () => import('./web').then(m => new m.NativeHelperWeb()),
});
export * from './definitions';
export { NativeHelper };
//# sourceMappingURL=index.js.map