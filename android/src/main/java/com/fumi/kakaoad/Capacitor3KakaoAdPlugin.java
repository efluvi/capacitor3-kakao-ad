package com.fumi.kakaoad;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.getcapacitor.JSArray;
import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.kakao.ad.common.json.AddToCart;
import com.kakao.ad.common.json.AddToWishList;
import com.kakao.ad.common.json.CompleteRegistration;
import com.kakao.ad.common.json.Participation;
import com.kakao.ad.common.json.Product;
import com.kakao.ad.common.json.Purchase;
import com.kakao.ad.common.json.Search;
import com.kakao.ad.common.json.SignUp;
import com.kakao.ad.common.json.ViewCart;
import com.kakao.ad.common.json.ViewContent;
import com.kakao.ad.tracker.KakaoAdTracker;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Currency;
import java.util.List;
import java.util.Locale;

@CapacitorPlugin(name = "Capacitor3KakaoAd")
public class Capacitor3KakaoAdPlugin extends Plugin {

    private Capacitor3KakaoAd implementation = new Capacitor3KakaoAd();


    //SDK 초기화
    public static void initKakaoSdkAd(Context context, String key) {
        if (!KakaoAdTracker.isInitialized()) {
            KakaoAdTracker.getInstance().init(context, key);
            Log.d("log", "!!!!!!!initKakaoAdTracker:" + key);
        }
    }



    @PluginMethod
    public void initializePixel(PluginCall call) {
        String value = call.getString("value");
        JSObject ret = new JSObject();
        call.resolve(ret);
    }

    @PluginMethod
    public void echo(PluginCall call) {
        String value = call.getString("value");

        JSObject ret = new JSObject();
        ret.put("value", implementation.echo(value));
        call.resolve(ret);
    }


    @PluginMethod
    public void pageView(PluginCall call) {
        JSObject ret = new JSObject();
        call.resolve(ret);
    }


    @PluginMethod
    public void completeRegistration(PluginCall call) {
        String tag = call.getString("tag");

        CompleteRegistration event = new CompleteRegistration();
        event.tag = tag; // 분류
        KakaoAdTracker.getInstance().sendEvent(event);

        JSObject ret = new JSObject();
        call.resolve(ret);
    }

    @PluginMethod
    public void search(PluginCall call) {
        String tag = call.getString("tag");
        String keyword = call.getString("keyword");

        Search event = new Search();
        event.tag = tag; // 분류
        event.search_string = keyword; // 검색 문자열
        KakaoAdTracker.getInstance().sendEvent(event);

        JSObject ret = new JSObject();
        call.resolve(ret);
    }

    @PluginMethod
    public void viewContent(PluginCall call) {
        String tag = call.getString("tag");
        String id = call.getString("id");

        ViewContent event = new ViewContent();
        event.tag = tag; // 분류
        event.content_id = id; // 상품 코드
        KakaoAdTracker.getInstance().sendEvent(event);


        JSObject ret = new JSObject();
        call.resolve(ret);
    }

    @PluginMethod
    public void addToCart(PluginCall call) {
        String tag = call.getString("tag");
        String id = call.getString("id");

        AddToCart event = new AddToCart();
        event.tag = tag;
        event.content_id = id; // 상품 코드, 상품 코드값이 필수로 포함되어야 합니다.
        KakaoAdTracker.getInstance().sendEvent(event);

        JSObject ret = new JSObject();
        call.resolve(ret);
    }

    @PluginMethod
    public void addToWishList(PluginCall call) {
        String tag = call.getString("tag");
        String id = call.getString("id");

        AddToWishList event = new AddToWishList();
        event.tag = tag; // 분류
        event.content_id = id; // 상품 코드, 상품 코드값이 필수로 포함되어야 합니다.
        KakaoAdTracker.getInstance().sendEvent(event);

        JSObject ret = new JSObject();
        call.resolve(ret);
    }

    @PluginMethod
    public void viewCart(PluginCall call) {
        String tag = call.getString("tag");

        ViewCart event = new ViewCart();
        event.tag = tag; // 분류
        KakaoAdTracker.getInstance().sendEvent(event);

        JSObject ret = new JSObject();
        call.resolve(ret);
    }

    @PluginMethod
    public void purchase(PluginCall call) {

        String tag = call.getString("tag");
        JSArray list = call.getArray("products");
        ArrayList<Product> products = new ArrayList<>();

        for (int i = 0; i < list.length(); i++) {

            try {
                JSONObject aData = list.getJSONObject(i);
                Product product1 = new Product(); // 상품
                product1.name = aData.getString("name"); // 상품명
                product1.quantity = Integer.parseInt(aData.getString("quantity")); // 개수
                product1.price = Float.parseFloat(aData.getString("price")); // 금액
                products.add(product1);

            } catch (Exception e) {

                Log.d("log", "ex!!:" + e.toString());
            }

        }

        int totalQuantity = 0;
        double totalPrice = 0;
        for (Product product : products) {
            totalQuantity += product.quantity; // 총 개수
            totalPrice += product.price; // 총 금액
        }

        Purchase event = new Purchase(); // 구매 이벤트
        event.tag = tag; // 분류
        event.products = products; // 구매 상품 목록
        event.currency = Currency.getInstance(Locale.KOREA); // 통화코드(ISO-4217)
        event.total_quantity = totalQuantity; // 총 개수
        event.total_price = totalPrice; // 총 금액
        KakaoAdTracker.getInstance().sendEvent(event);

        JSObject ret = new JSObject();
        call.resolve(ret);
    }

    @PluginMethod
    public void participation(PluginCall call) {
        String tag = call.getString("tag");

        Participation event = new Participation();
        event.tag = tag; // 분류
        KakaoAdTracker.getInstance().sendEvent(event);


        JSObject ret = new JSObject();
        call.resolve(ret);
    }

    @PluginMethod
    public void signUp(PluginCall call) {
        
        String tag = call.getString("tag");
        SignUp event = new SignUp();
        event.tag = tag; // 분류
        KakaoAdTracker.getInstance().sendEvent(event);
        JSObject ret = new JSObject();
        call.resolve(ret);
    }


}
