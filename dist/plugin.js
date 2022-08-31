var capacitorCapacitorSafeArea = (function (exports, core) {
    'use strict';

    const CapacitorSafeArea = core.registerPlugin('CapacitorSafeArea', {
        web: () => Promise.resolve().then(function () { return web; }).then(m => new m.CapacitorSafeAreaWeb()),
    });

    class CapacitorSafeAreaWeb extends core.WebPlugin {
        async getSafeAreaInsets() {
            return {
                insets: {
                    top: 0,
                    left: 0,
                    right: 0,
                    bottom: 0,
                }
            };
        }
        async getStatusBarHeight() {
            return {
                statusBarHeight: 0
            };
        }
    }

    var web = /*#__PURE__*/Object.freeze({
        __proto__: null,
        CapacitorSafeAreaWeb: CapacitorSafeAreaWeb
    });

    exports.CapacitorSafeArea = CapacitorSafeArea;

    Object.defineProperty(exports, '__esModule', { value: true });

    return exports;

})({}, capacitorExports);
//# sourceMappingURL=plugin.js.map
