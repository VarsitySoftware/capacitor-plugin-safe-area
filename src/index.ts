import { registerPlugin } from '@capacitor/core';

import type { CapacitorSafeAreaPlugin } from './definitions';

const CapacitorSafeArea = registerPlugin<CapacitorSafeAreaPlugin>('CapacitorSafeArea', {
  web: () => import('./web').then(m => new m.CapacitorSafeAreaWeb()),
});

export * from './definitions';
export { CapacitorSafeArea };
