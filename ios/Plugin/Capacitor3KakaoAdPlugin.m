#import <Foundation/Foundation.h>
#import <Capacitor/Capacitor.h>

// Define the plugin using the CAP_PLUGIN Macro, and
// each method the plugin supports using the CAP_PLUGIN_METHOD macro.
CAP_PLUGIN(Capacitor3KakaoAdPlugin, "Capacitor3KakaoAd",
           CAP_PLUGIN_METHOD(echo, CAPPluginReturnPromise);
           CAP_PLUGIN_METHOD(initializePixel, CAPPluginReturnPromise);
           CAP_PLUGIN_METHOD(pageView, CAPPluginReturnPromise);
           CAP_PLUGIN_METHOD(completeRegistration, CAPPluginReturnPromise);
           CAP_PLUGIN_METHOD(search, CAPPluginReturnPromise);
           CAP_PLUGIN_METHOD(viewContent, CAPPluginReturnPromise);
           CAP_PLUGIN_METHOD(addToCart, CAPPluginReturnPromise);
           CAP_PLUGIN_METHOD(addToWishList, CAPPluginReturnPromise);
           CAP_PLUGIN_METHOD(viewCart, CAPPluginReturnPromise);
           CAP_PLUGIN_METHOD(purchase, CAPPluginReturnPromise);
           CAP_PLUGIN_METHOD(participation, CAPPluginReturnPromise);
           CAP_PLUGIN_METHOD(signUp, CAPPluginReturnPromise);
           
)
