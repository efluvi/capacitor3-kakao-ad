import { registerPlugin } from '@capacitor/core';

import type { Capacitor3KakaoAdPlugin } from './definitions';

const Capacitor3KakaoAd = registerPlugin<Capacitor3KakaoAdPlugin>('Capacitor3KakaoAd', {
  web: () => import('./web').then(m => new m.Capacitor3KakaoAdWeb()),
});

export * from './definitions';
export { Capacitor3KakaoAd };
