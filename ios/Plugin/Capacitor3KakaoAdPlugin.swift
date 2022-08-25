import Foundation
import Capacitor
import KakaoAdSDK

/**
 * Please read the Capacitor iOS Plugin Development Guide
 * here: https://capacitorjs.com/docs/plugins/ios
 */
@objc(Capacitor3KakaoAdPlugin)
public class Capacitor3KakaoAdPlugin: CAPPlugin {
    private let implementation = Capacitor3KakaoAd()

    
    @objc func initKakaoSdk() {
        print("initKakaoSdk")
    }
    

    @objc func echo(_ call: CAPPluginCall) {
        let value = call.getString("value") ?? ""
        call.resolve([
            "value": implementation.echo(value)
        ])
    }
    
    @objc func initializePixel(_ call: CAPPluginCall) {
        call.resolve()
    }
    
    @objc func pageView(_ call: CAPPluginCall) {
        call.resolve()
    }
    
    
    @objc func completeRegistration(_ call: CAPPluginCall) {
        let tag = call.getString("tag") ?? ""
        KakaoAdTracker.sendCompleteRegisterEvent(tag: tag)
        call.resolve()
    }
    
    
    @objc func search(_ call: CAPPluginCall) {
        let tag = call.getString("tag") ?? ""
        let searchString = call.getString("keyword") ?? ""
        KakaoAdTracker.sendSearchEvent(tag: tag, searchString: searchString)
        call.resolve()
    }
    
    @objc func viewContent(_ call: CAPPluginCall) {
        let tag = call.getString("tag") ?? ""
        let contentId = call.getString("idÏ") ?? ""
        KakaoAdTracker.sendViewContentEvent(tag: tag, contentId:contentId)
        call.resolve()
    }
    
    
    
    @objc func addToCart(_ call: CAPPluginCall) {

        let tag = call.getString("tag") ?? ""
        let contentId = call.getString("id") ?? ""
        KakaoAdTracker.sendAddToCartEvent(tag: tag, contentId:contentId)
        call.resolve()
    }
    
    @objc func addToWishList(_ call: CAPPluginCall) {
        
        let tag = call.getString("tag") ?? ""
        let contentId = call.getString("id") ?? ""
        
        KakaoAdTracker.sendAddToWishListEvent(tag: tag, contentId:contentId)
        
        call.resolve()
    }
    
    @objc func viewCart(_ call: CAPPluginCall) {
        let tag = call.getString("tag") ?? ""
        KakaoAdTracker.sendViewCartEvent(tag: tag)
        call.resolve()
    }
    
    
    @objc func purchase(_ call: CAPPluginCall) {
        
        let tag = call.getString("tag") ?? ""
        var products : [KakaoAdDetailProduct] = []
        let list  = call.getArray("products")
 
        var totalQuantity:UInt = 0
        var totalPrice:Double = 0
        let currency = "KRW"
        
        list?.forEach({ data in
            
            let dic = data as! Dictionary<String, String>
            let quantity = UInt(dic["quantity"]!) ?? 0
            let price = Double(dic["price"]!) ?? 0
            totalQuantity += quantity
            totalPrice += price
            let product_1 = KakaoAdDetailProduct(name: dic["name"], quantity: Int(quantity) , price:price )
            products.append(product_1)
        })
        KakaoAdTracker.sendPurchaseEvent(tag: tag, totalQuantity: Int(totalQuantity), totalPrice: totalPrice, currency:currency, products:products)
        call.resolve()
            
    }
    
    @objc func participation(_ call: CAPPluginCall) {

        let tag = call.getString("tag") ?? ""
        KakaoAdTracker.sendParticipationEvent(tag: tag)
        call.resolve()
    }
    
    @objc func signUp(_ call: CAPPluginCall) {
        let tag = call.getString("tag") ?? ""
        KakaoAdTracker.sendSignUpEvent(tag: tag)
        call.resolve()
        
    }

}
