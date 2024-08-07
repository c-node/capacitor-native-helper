# native-helper

A Native Helper for Delkeda

## Install

```bash
npm install native-helper
npx cap sync
```

## API

<docgen-index>

* [`echo(...)`](#echo)
* [`toastMe(...)`](#toastme)
* [`moveToBackground()`](#movetobackground)
* [`startClipService()`](#startclipservice)
* [`stopClipService()`](#stopclipservice)
* [`storeInSharedPrefs(...)`](#storeinsharedprefs)
* [`getOverlayPermissionStatus()`](#getoverlaypermissionstatus)
* [`getNotificationPermissionStatus()`](#getnotificationpermissionstatus)
* [`getSystemLanguage()`](#getsystemlanguage)
* [`getVersionName()`](#getversionname)
* [`requestOverlayPermission()`](#requestoverlaypermission)
* [`goToNotificationSettings()`](#gotonotificationsettings)

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


### toastMe(...)

```typescript
toastMe(options: { text: string; }) => Promise<void>
```

| Param         | Type                           |
| ------------- | ------------------------------ |
| **`options`** | <code>{ text: string; }</code> |

--------------------


### moveToBackground()

```typescript
moveToBackground() => Promise<void>
```

--------------------


### startClipService()

```typescript
startClipService() => Promise<void>
```

--------------------


### stopClipService()

```typescript
stopClipService() => Promise<void>
```

--------------------


### storeInSharedPrefs(...)

```typescript
storeInSharedPrefs(options: { key: string; value: string; }) => Promise<void>
```

| Param         | Type                                         |
| ------------- | -------------------------------------------- |
| **`options`** | <code>{ key: string; value: string; }</code> |

--------------------


### getOverlayPermissionStatus()

```typescript
getOverlayPermissionStatus() => Promise<{ result: boolean; }>
```

**Returns:** <code>Promise&lt;{ result: boolean; }&gt;</code>

--------------------


### getNotificationPermissionStatus()

```typescript
getNotificationPermissionStatus() => Promise<{ result: boolean; }>
```

**Returns:** <code>Promise&lt;{ result: boolean; }&gt;</code>

--------------------


### getSystemLanguage()

```typescript
getSystemLanguage() => Promise<{ value: string; }>
```

**Returns:** <code>Promise&lt;{ value: string; }&gt;</code>

--------------------


### getVersionName()

```typescript
getVersionName() => Promise<{ versionName: string; }>
```

**Returns:** <code>Promise&lt;{ versionName: string; }&gt;</code>

--------------------


### requestOverlayPermission()

```typescript
requestOverlayPermission() => Promise<void>
```

--------------------


### goToNotificationSettings()

```typescript
goToNotificationSettings() => Promise<void>
```

--------------------

</docgen-api>
