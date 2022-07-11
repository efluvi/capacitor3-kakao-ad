# capacitor3-kakao-ad

capacitor3 kakao ad

## Install

```bash
npm install capacitor3-kakao-ad
npx cap sync
```

## API

<docgen-index>

* [`echo(...)`](#echo)
* [`initializePixel(...)`](#initializepixel)
* [`pageView(...)`](#pageview)
* [`completeRegistration(...)`](#completeregistration)
* [`search(...)`](#search)
* [`viewContent(...)`](#viewcontent)
* [`addToCart(...)`](#addtocart)
* [`addToWishList(...)`](#addtowishlist)
* [`viewCart(...)`](#viewcart)
* [`purchase(...)`](#purchase)
* [`participation(...)`](#participation)
* [`signUp(...)`](#signup)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### echo(...)

```typescript
echo(options: { value: string; }) => Promise<{ value: string; }>
```

| Param         | Type                            |
| ------------- | ------------------------------- |
| **`options`** | <code>{ value: string; }</code> |

**Returns:** <code>Promise&lt;{ value: string; }&gt;</code>

--------------------


### initializePixel(...)

```typescript
initializePixel(options: { track_id: string; }) => Promise<{ value: string; }>
```

| Param         | Type                               |
| ------------- | ---------------------------------- |
| **`options`** | <code>{ track_id: string; }</code> |

**Returns:** <code>Promise&lt;{ value: string; }&gt;</code>

--------------------


### pageView(...)

```typescript
pageView(options: { tag?: string; }) => Promise<{ value: string; }>
```

| Param         | Type                           |
| ------------- | ------------------------------ |
| **`options`** | <code>{ tag?: string; }</code> |

**Returns:** <code>Promise&lt;{ value: string; }&gt;</code>

--------------------


### completeRegistration(...)

```typescript
completeRegistration(options: { tag?: string; }) => Promise<{ value: string; }>
```

| Param         | Type                           |
| ------------- | ------------------------------ |
| **`options`** | <code>{ tag?: string; }</code> |

**Returns:** <code>Promise&lt;{ value: string; }&gt;</code>

--------------------


### search(...)

```typescript
search(options: { tag?: string; keyword: string; }) => Promise<{ value: string; }>
```

| Param         | Type                                            |
| ------------- | ----------------------------------------------- |
| **`options`** | <code>{ tag?: string; keyword: string; }</code> |

**Returns:** <code>Promise&lt;{ value: string; }&gt;</code>

--------------------


### viewContent(...)

```typescript
viewContent(options: { tag?: string; id: string; }) => Promise<{ value: string; }>
```

| Param         | Type                                       |
| ------------- | ------------------------------------------ |
| **`options`** | <code>{ tag?: string; id: string; }</code> |

**Returns:** <code>Promise&lt;{ value: string; }&gt;</code>

--------------------


### addToCart(...)

```typescript
addToCart(options: { id: string; tag?: string; }) => Promise<{ value: string; }>
```

| Param         | Type                                       |
| ------------- | ------------------------------------------ |
| **`options`** | <code>{ id: string; tag?: string; }</code> |

**Returns:** <code>Promise&lt;{ value: string; }&gt;</code>

--------------------


### addToWishList(...)

```typescript
addToWishList(options: { id: string; tag?: string; }) => Promise<{ value: string; }>
```

| Param         | Type                                       |
| ------------- | ------------------------------------------ |
| **`options`** | <code>{ id: string; tag?: string; }</code> |

**Returns:** <code>Promise&lt;{ value: string; }&gt;</code>

--------------------


### viewCart(...)

```typescript
viewCart(options: { tag?: string; }) => Promise<{ value: string; }>
```

| Param         | Type                           |
| ------------- | ------------------------------ |
| **`options`** | <code>{ tag?: string; }</code> |

**Returns:** <code>Promise&lt;{ value: string; }&gt;</code>

--------------------


### purchase(...)

```typescript
purchase(options: { tag?: string; total_quantity: string; total_price: string; currency: string; products: [ { id: string; name: string; quantity: string; price: string; } ]; }) => Promise<{ value: string; }>
```

| Param         | Type                                                                                                                                                                      |
| ------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **`options`** | <code>{ tag?: string; total_quantity: string; total_price: string; currency: string; products: [{ id: string; name: string; quantity: string; price: string; }]; }</code> |

**Returns:** <code>Promise&lt;{ value: string; }&gt;</code>

--------------------


### participation(...)

```typescript
participation(options: { tag?: string; }) => Promise<{ value: string; }>
```

| Param         | Type                           |
| ------------- | ------------------------------ |
| **`options`** | <code>{ tag?: string; }</code> |

**Returns:** <code>Promise&lt;{ value: string; }&gt;</code>

--------------------


### signUp(...)

```typescript
signUp(options: { tag?: string; }) => Promise<{ value: string; }>
```

| Param         | Type                           |
| ------------- | ------------------------------ |
| **`options`** | <code>{ tag?: string; }</code> |

**Returns:** <code>Promise&lt;{ value: string; }&gt;</code>

--------------------

</docgen-api>
