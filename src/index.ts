import { registerPlugin } from '@capacitor/core';

import type { NativeHelperPlugin } from './definitions';

const NativeHelper = registerPlugin<NativeHelperPlugin>('NativeHelper', {
  web: () => import('./web').then(m => new m.NativeHelperWeb()),
});

export * from './definitions';
export { NativeHelper };
