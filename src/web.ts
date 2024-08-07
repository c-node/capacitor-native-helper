import { WebPlugin } from '@capacitor/core';

import type { NativeHelperPlugin } from './definitions';

export class NativeHelperWeb extends WebPlugin implements NativeHelperPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
