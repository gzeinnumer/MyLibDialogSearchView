<p align="center">
  <img src="https://github.com/gzeinnumer/MyLibDialogSearchView/blob/master/preview/MyLibDialogSearchView_2.jpg" width="500"/><img src="https://github.com/gzeinnumer/MyLibDialogSearchView/blob/master/preview/MyLibDialogSearchView_5.jpg" width="500"/>
</p>

<h1 align="center">
  MyLibDialogSearchView - Easy Drop Down
</h1>

<div align="center">
    <a><img src="https://img.shields.io/badge/Version-1.0.0-brightgreen.svg?style=flat"></a>
    <a><img src="https://img.shields.io/badge/ID-gzeinnumer-blue.svg?style=flat"></a>
    <a><img src="https://img.shields.io/badge/Java-Suport-green?logo=java&style=flat"></a>
    <a><img src="https://img.shields.io/badge/Koltin-Suport-green?logo=kotlin&style=flat"></a>
    <a href="https://github.com/gzeinnumer"><img src="https://img.shields.io/github/followers/gzeinnumer?label=follow&style=social"></a>
    <br>
    <p>Simple way to select Item Single or Multi</p>
</div>

---

### Feature List
- [x] [Single Select](#)
- [x] [Multi Select](#)
- [x] [Filter](#)

---

### Tech stack and 3rd library
- Material.io ([docs](https://material.io/develop/android/docs/getting-started))
- Multi and Single Selection in Recyclerview ([docs](https://medium.com/@maydin/multi-and-single-selection-in-recyclerview-d29587a7dee2)) ([example](https://github.com/gzeinnumer/MultiandSingleSelectioninRecyclerView))
- DialogFragment ([docs](https://developer.android.com/reference/android/app/DialogFragment))

---

## Download
Minimum Android SDK Version 21

#### Gradle
**Step 1.** add maven `jitpack.io` to your `build.gradle` (Project) :
```gradle
allprojects {
  repositories {
    google()
    jcenter()
    maven { url 'https://jitpack.io' }
  }
}
```

**Step 2.** add dependensi to your `build.gradle` (Module) :
```gradle
dependencies {
  implementation 'com.github.gzeinnumer:MyLibDialog:versi'
  implementation 'com.google.android.material:material:1.2.0'
}
```

---

**First Step Awal**. Use `MaterialComponents` in your style :

```xml
<style name="AppTheme" parent="Theme.MaterialComponents.Light.NoActionBar">
    <!-- Customize your theme here. -->
</style>
```

---

### ConfirmDialog
Dialog with **1 Title, 1 Content, 1 Negative Button, 1 Positive Button**.

**Code** :

```java
new ConfirmDialog(getSupportFragmentManager())
    .setTitle("ini title")
    .setContent("ini content")
    .onCancelPressedCallBack(new ConfirmDialog.OnCancelPressed() {
        @Override
        public void onCancelPressed() {
            Toast.makeText(MainActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
        }
    })
    .onOkPressedCallBack(new ConfirmDialog.OnOkPressed() {
        @Override
        public void onOkPressed() {
            Toast.makeText(MainActivity.this, "Ok", Toast.LENGTH_SHORT).show();
        }
    })
    .show();
```

or you can write code like this :

```java
ConfirmDialog dialog = new ConfirmDialog(getSupportFragmentManager())
    .setTitle("ini title")
    .setContent("ini content");

dialog.onCancelPressedCallBack(new ConfirmDialog.OnCancelPressed() {
    @Override
    public void onCancelPressed() {
        Toast.makeText(MainActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
    }
});

dialog.onOkPressedCallBack(new ConfirmDialog.OnOkPressed() {
    @Override
    public void onOkPressed() {
        Toast.makeText(MainActivity.this, "Ok", Toast.LENGTH_SHORT).show();
    }
});

dialog.show();
```

**Preview** :

<p align="center">
  <img src="https://github.com/gzeinnumer/MyLibDialog/blob/main/preview/MyLibDialog_3.png" width="500"/>
</p>

#### ConfirmDialog -> Customize

<p align="center">
  <img src="https://github.com/gzeinnumer/MyLibDialog/blob/main/preview/MyLibDialog_1.png" width="500"/>
</p>

You can Customize your dialog UI. [**ReadMore**](https://github.com/gzeinnumer/MyLibDialog/blob/main/README_1.md).

---

### InfoDialog
Dialog with **1 Title, 1 Content, 1 Positif Button**.

**Code** :

```java
new InfoDialog(getSupportFragmentManager())
    .setDialogType(DialogType.DialogSuccess)
    .setTitle("ini title")
    .setContent("ini content")
    .onOkPressedCallBack(new InfoDialog.OnOkPressed() {
        @Override
        public void onOkPressed() {
            Toast.makeText(MainActivity.this, "Ok", Toast.LENGTH_SHORT).show();
        }
    })
    .show();
```

**Preview** :

<p align="center">
  <img src="https://github.com/gzeinnumer/MyLibDialog/blob/main/preview/MyLibDialog_6.png" width="500"/>
</p>

#### InfoDialog -> Customize

<p align="center">
  <img src="https://github.com/gzeinnumer/MyLibDialog/blob/main/preview/MyLibDialog_8.png" width="500"/>
</p>

You can Customize your dialog UI. [**ReadMore**](https://github.com/gzeinnumer/MyLibDialog/blob/main/README_2.md).

---

### NumberPickerDialog

Dialog with **1 Title, 1 Content, 1 Positif Button, 1 Negatif Button, 1 EditText, 1 Add Button, 1 Substract Button**.

**Code** :

```java
new NumberPickerDialog(getSupportFragmentManager())
    .setLastValue(12)
    .setTitle("ini title")
    .setContent("ini content")
    .onOkPressedCallBack(new NumberPickerDialog.OnOkPressed() {
        @Override
        public void onOkPressed(int value) {
            Toast.makeText(MainActivity.this, "Nilai nya " + value, Toast.LENGTH_SHORT).show();
        }
    })
    .onCancelPressedCallBack(new NumberPickerDialog.OnCancelPressed() {
        @Override
        public void onCancelPressed() {
            Toast.makeText(MainActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
        }
    })
    .show();
```

**Preview** :

<p align="center">
  <img src="https://github.com/gzeinnumer/MyLibDialog/blob/main/preview/MyLibDialog_10.png" width="500"/>
</p>

#### NumberPickerDialog -> Customize

<p align="center">
  <img src="https://github.com/gzeinnumer/MyLibDialog/blob/main/preview/MyLibDialog_13.png" width="500"/>
</p>

You can Customize your dialog UI. [**ReadMore**](https://github.com/gzeinnumer/MyLibDialog/blob/main/README_3.md).

---

### LoadingDialog

Dialog yang berisi **1 Title, 1 Animasi** yang bisa kamu pakai untuk menampilkan Loading.

**Code** :

```java
LoadingDialog loadingDialog = new LoadingDialog(getSupportFragmentManager())
    .setContent("ini content");

loadingDialog.show();

loadingDialog.dismis();
```

**Preview** :

<p align="center">
  <img src="https://github.com/gzeinnumer/MyLibDialog/blob/main/preview/MyLibDialog_15.png" width="500"/>
</p>

#### LoadingDialog -> Customize

<p align="center">
  <img src="https://github.com/gzeinnumer/MyLibDialog/blob/main/preview/MyLibDialog_14.png" width="500"/>
</p>

You can Customize your dialog UI. [**ReadMore**](https://github.com/gzeinnumer/MyLibDialog/blob/main/README_4.md).

---

### SingleDatePickerDialog

Dialog yang berisi **Calender yang sama dengan material.io** yang bisa kamu pakai untuk megambil tanggal.

**Code** :

```java
new SingleDatePickerDialog(getSupportFragmentManager())
    .setTimeZone("GMT")
    .setTitle("Pilih tanggal")
    .setSelectedToday(true)
    .setTimeFormat("dd/MM/yyyy") //pastikan polanya sama
    .setStartDate("1/08/2020") //pastikan polanya sama
    .setEndDate("31/12/2020") //pastikan polanya sama
    .onOkPressedCallBack(new SingleDatePickerDialog.OnOkPressed() {
        @Override
        public void onOkPressed(String value) {
            Toast.makeText(MainActivity.this, value, Toast.LENGTH_SHORT).show();
        }
    })
    .build()
    .show();
```

- `setTimeZone()` optional . default value `GMT`.
- `setTimeFormat()` optional. default value `dd-MM-yyyy`.
- `setStartDate()` optional.
- `setEndDate()` optional.

Bisa lansung dipanggil seperti diatas, atau kamu bisa memisahkan bagian `show()` dan action callbacknya seperti contoh `ConfirmDialog`.

**Preview** :

|<img src="https://github.com/gzeinnumer/MyLibDialog/blob/main/preview/MyLibDialog_18.png"/>|<img src="https://github.com/gzeinnumer/MyLibDialog/blob/main/preview/MyLibDialog_19.png"/>|
|--|--|

|<img src="https://github.com/gzeinnumer/MyLibDialog/blob/main/preview/MyLibDialog_20.png" width="400"/>|
|--|

#### SingleDatePickerDialog -> Customize

<p align="center">
  <img src="https://github.com/gzeinnumer/MyLibDialog/blob/main/preview/MyLibDialog_21.png" width="300"/>
</p>

You can Customize your dialog UI. [**ReadMore**](https://github.com/gzeinnumer/MyLibDialog/blob/main/README_5.md).

---

### MultiDatePickerDialog

Dialog yang berisi **Calender yang sama dengan material.io** yang bisa kamu pakai untuk megambil tanggal dengan range yang kamu pilih.

**Code** :

```java
new MultiDatePickerDialog(getSupportFragmentManager())
    .setTimeZone("GMT")
    .setTitle("Pilih tanggal")
    .setTimeFormat("dd/MM/yyyy") //pastikan 3 pola ini sama
    .setStartDate("1/08/2020") //pastikan 3 pola ini sama
    .setEndDate("31/12/2020") //pastikan 3 pola ini sama
    .onOkPressedCallBack(new MultiDatePickerDialog.OnOkPressed() {
        @Override
        public void onOkPressed(String firstDate, String secondDate) {
            Toast.makeText(MainActivity.this, firstDate + " - " + secondDate, Toast.LENGTH_SHORT).show();
        }
    })
    .build()
    .show();
```

- `setTimeZone()` optional . default value `GMT`.
- `setTimeFormat()` optional. default value `dd-MM-yyyy`.
- `setStartDate()` optional.
- `setEndDate()` optional.

**Preview** :

|<img src="https://github.com/gzeinnumer/MyLibDialog/blob/main/preview/MyLibDialog_22.png"/>|<img src="https://github.com/gzeinnumer/MyLibDialog/blob/main/preview/MyLibDialog_23.png"/>|
|--|--|

|<img src="https://github.com/gzeinnumer/MyLibDialog/blob/main/preview/MyLibDialog_24.png" width="400"/>|
|--|

#### MultiDataPickerDialog -> Customize

<p align="center">
  <img src="https://github.com/gzeinnumer/MyLibDialog/blob/main/preview/MyLibDialog_25.png" width="300"/>
</p>

You can Customize your dialog UI. [**ReadMore**](https://github.com/gzeinnumer/MyLibDialog/blob/main/README_6.md).

---

```
Copyright 2020 M. Fadli Zein
```