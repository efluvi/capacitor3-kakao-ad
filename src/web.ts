import { WebPlugin } from '@capacitor/core';

declare var kakaoPixel: any;

import type { Capacitor3KakaoAdPlugin } from './definitions';

export class Capacitor3KakaoAdWeb
  extends WebPlugin
  implements Capacitor3KakaoAdPlugin {
  track_id: any;

  initializePixel(options: { track_id: string }) {
    return new Promise<{ value: string }>(resolve => {
      if (!this.track_id) {
        this.track_id = options.track_id;
      }

      console.log('init pixel plugin!!:' + this.track_id);
      resolve({ value: 'done' });
    });
  }

  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }

  async pageView(_options: { tag?: string }): Promise<{ value: string }> {
    await kakaoPixel(this.track_id).pageView(_options.tag);
    return { value: '' };
  }
  
  async completeRegistration(_options: {
    tag?: string;
  }): Promise<{ value: string }> {
    await kakaoPixel(this.track_id).completeRegistration(_options.tag);
    return { value: '' };
  }


  async search(_options: {
    tag?: string;
    keyword: string;
  }): Promise<{ value: string }> {

    await kakaoPixel(this.track_id).search({
      tag: _options.tag,
      keyword:_options.keyword
    });


    return { value: '' };
  }

  async viewContent(_options: {
    tag?: string;
    id: string;
  }): Promise<{ value: string }> {

    await kakaoPixel(this.track_id).viewContent({
      tag:_options.tag,
      id: `${_options.id}`
    });


    return { value: '' };
  }

  async addToCart(_options: {
    id: string;
    tag?: string;
  }): Promise<{ value: string }> {

    await kakaoPixel(this.track_id).addToCart({
      id: _options.id,
      tag:_options.tag
    });

    return { value: '' };
  }

  async addToWishList(_options: {
    id: string;
    tag?: string;
  }): Promise<{ value: string }> {

    await kakaoPixel(this.track_id).addToWishList({
      id: _options.id,
      tag:_options.tag
    });


    return { value: '' };
  }

  async viewCart(_options: { tag?: string }): Promise<{ value: string }> {

    await kakaoPixel(this.track_id).viewCart(_options.tag);

    return { value: '' };
  }

  async purchase(_options: {
    tag?: string;
    total_quantity: string; // 주문 내 상품 개수(optional)
    total_price: string; // 주문 총 가격(optional)
    currency: string; // 주문 가격의 화폐 단위(optional, 기본 값은 KRW)
    products: [
      // 주문 내 상품 정보(optional)
      { id: string; name: string; quantity: string; price: string },
    ];
  }): Promise<{ value: string }> {

    await kakaoPixel(this.track_id).purchase(_options);
    return { value: '' };
  }

  async participation(_options: { tag?: string }): Promise<{ value: string }> {
    await kakaoPixel(this.track_id).participation(_options.tag);
    return { value: '' };
  }

  async signUp(_options: { tag?: string }): Promise<{ value: string }> {
    await kakaoPixel(this.track_id).signUp(_options.tag);
    return { value: '' };
  }
}
