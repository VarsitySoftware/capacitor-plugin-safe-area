export interface CapacitorSafeAreaPlugin {
    getSafeAreaInsets(): Promise<SafeAreaInsets>;
    getStatusBarHeight(): Promise<StatusBarInfo>;
}

interface SafeArea {
    top: number;
    right: number;
    bottom: number;
    left: number;
}
export interface SafeAreaInsets {
    insets: SafeArea
}

export interface StatusBarInfo {
    statusBarHeight: number;
}
