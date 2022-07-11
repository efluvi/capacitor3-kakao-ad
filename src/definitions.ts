export interface Capacitor3KakaoAdPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;

  initializePixel(options: { track_id: string }): Promise<{ value: string }>;

  pageView(options: { tag?: string }): Promise<{ value: string }>;
  completeRegistration(options: { tag?: string }): Promise<{ value: string }>;

  search(options: {
    tag?: string;
    keyword: string;
  }): Promise<{ value: string }>;

  viewContent(options: {
    tag?: string;
    id: string;
  }): Promise<{ value: string }>;

  addToCart(options: { id: string; tag?: string }): Promise<{ value: string }>;

  addToWishList(options: {
    id: string;
    tag?: string;
  }): Promise<{ value: string }>;

  viewCart(options: { tag?: string }): Promise<{ value: string }>;

  purchase(options: {
    tag?: string;
    total_quantity: string; // 주문 내 상품 개수(optional)
    total_price: string; // 주문 총 가격(optional)
    currency: string; // 주문 가격의 화폐 단위(optional, 기본 값은 KRW)
    products: [
      // 주문 내 상품 정보(optional)
      { id: string; name: string; quantity: string; price: string },
    ];
  }): Promise<{ value: string }>;

  participation(options: { tag?: string }): Promise<{ value: string }>;

  signUp(options: { tag?: string }): Promise<{ value: string }>;
}
