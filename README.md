| <img src="https://github.com/gzeinnumer/MyLibDialogSearchView/blob/master/preview/MyLibDialogSearchView_2.jpg" width="300"/> | <img src="https://github.com/gzeinnumer/MyLibDialogSearchView/blob/master/preview/MyLibDialogSearchView_5.jpg" width="300"/> | <img src="https://github.com/gzeinnumer/MyLibDialogSearchView/blob/master/preview/MyLibDialogSearchView_6.jpg" width="300"/> |
|:-----------------------------------------------------------------------------------------------------------------------------|:-----------------------------------------------------------------------------------------------------------------------------|:-----------------------------------------------------------------------------------------------------------------------------|

<h1 align="center">
  MyLibDialogSearchView - Easy Drop Down
</h1>

<div align="center">
    <a><img src="https://img.shields.io/badge/Version-1.0.3-brightgreen.svg?style=flat"></a>
    <a><img src="https://img.shields.io/badge/ID-gzeinnumer-blue.svg?style=flat"></a>
    <a><img src="https://img.shields.io/badge/Java-Suport-green?logo=java&style=flat"></a>
    <a><img src="https://img.shields.io/badge/Koltin-Suport-green?logo=kotlin&style=flat"></a>
    <a href="https://github.com/gzeinnumer"><img src="https://img.shields.io/github/followers/gzeinnumer?label=follow&style=social"></a>
    <br>
    <p>Simple way to select Item Single or Multi</p>
</div>

---

### Feature List
- [x] [Single Select](#searchviewdialog)
- [x] [Multi Select](#searchviewdialog)
- [x] [Filter](#searchviewdialog)

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
  implementation 'com.github.gzeinnumer:MyLibDialogSearchView:versi'
  implementation 'com.google.android.material:material:1.2.0'
}
```

---

**First Step**. Use `MaterialComponents` in your style :

```xml
<style name="AppTheme" parent="Theme.MaterialComponents.Light.NoActionBar">
    <!-- Customize your theme here. -->
</style>
```

---

**Deprecated**

| OLD                                                       | New                                                                 |
|:----------------------------------------------------------|:--------------------------------------------------------------------|
| `new SearchViewDialog(getSupportFragmentManager(), list)` | `new SearchViewDialog(getSupportFragmentManager()) .setItems(list)` |

---

### SearchViewDialog
Dialog with **1 Title, 1 Content, 1 EditText, 1 RecyclerView, 1 Negative Button, 1 Positive Button**. You can choise `Single Item Select` or `Multi Item Select`. The difference is only in `callback` function.
- **Content Item** there is 3 type of is that you can sent to this dialog.
**Type 1**
```java
String[] arrayString = {"M", "Fadli", "Zein"};
new SearchViewDialog(getSupportFragmentManager())
        .setItems(arrayString);
```
**Type 2**
```java
ArrayList<String> listString = new ArrayList<>();
listString.add("Lorem ipsum dolor");
new SearchViewDialog(getSupportFragmentManager())
        .setItems(listString);
```
**Type 3** for this type you should override function `toString()` to your `model pojo`
```java

public class ExampleModel {

    private int id;
    private String name;
    private String address;
    
    //constructor
    
    //getter
    //setter

    @Override
    public String toString() {
        return "ExampleModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
```
```java
ArrayList<ExampleModel> listObject = new ArrayList<>();
listObject.add(new ExampleModel(1, "Zein", "Balbar"));
new SearchViewDialog(getSupportFragmentManager())
        .setItems(listObject);
```

- **Single Item Select**. Use `onOkPressedCallBackSingle` to enable `Multi Select Item`.
**Code** :
```java
ArrayList<String> list = new ArrayList<>();
list.add("Lorem ipsum dolor");
list.add("sit amet, consectetur");
list.add("adipiscing elit sed do");

new SearchViewDialog(getSupportFragmentManager())
    .setItems(list)
    .setTitle("ini title")
    .setContent("ini content")
    .onOkPressedCallBackSingle(new SearchViewDialog.OnOkPressedSingle() {
        @Override
        public void onOkSingle(int position, String value) {
            String temp = "Single Select :\n\n";
            temp = temp+"position on list => "+position+"\n";
            temp = temp+"value on list => "+value+"\n";

            tv.setText(temp);
            Toast.makeText(MainActivity.this, temp, Toast.LENGTH_SHORT).show();
        }
    })
    .onCancelPressedCallBack(new SearchViewDialog.OnCancelPressed() {
        @Override
        public void onCancelPressed() {
            Toast.makeText(MainActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
        }
    })
    .show();
```

- **Multi Item Select**. Use `onOkPressedCallBackMulti` to enable `Multi Select Item`.
**Code** :
```java
ArrayList<String> list = new ArrayList<>();
list.add("Lorem ipsum dolor");
list.add("sit amet, consectetur");
list.add("adipiscing elit sed do");

new SearchViewDialog(getSupportFragmentManager())
    .setItems(list)
    .setTitle("ini title")
    .setContent("ini content")
    .onOkPressedCallBackMulti(new SearchViewDialog.OnOkPressedMulti(){
        @Override
        public void onOkMulti(List<SearchViewModel> data) {
            String temp = "Multi Select :\n";
            temp = temp + "Total Data => "+data.size()+"\n\n";
            for (SearchViewModel d: data){
                temp = temp + "position on list => "+d.getPosition()+"\n";
                temp = temp + "value on list => "+d.getName()+"\n\n";
            }
            tv.setText(temp);
        }
    })
    .onCancelPressedCallBack(new SearchViewDialog.OnCancelPressed() {
        @Override
        public void onCancelPressed() {
            Toast.makeText(MainActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
        }
    })
    .show();
```

or you can write code like this :

```java
SearchViewDialog dialog = new SearchViewDialog(getSupportFragmentManager())
    .setItems(list)
    .setTitle("ini title")
    .setContent("ini content");

dialog.onOkPressedCallBackMulti(new SearchViewDialog.OnOkPressedMulti(){
    @Override
    public void onOkMulti(List<SearchViewModel> data) {
        
    }
}).

dialog.onCancelPressedCallBack(new SearchViewDialog.OnCancelPressed() {
    @Override
    public void onCancelPressed() {
        Toast.makeText(MainActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
    }
});

dialog.show();
```

[FullCode](https://github.com/gzeinnumer/MyLibDialogSearchView/blob/master/app/src/main/java/com/gzeinnumer/mylibsearchviewdialog/MainActivity.java) **Preview** :

| <img src="https://github.com/gzeinnumer/MyLibDialogSearchView/blob/master/preview/MyLibDialogSearchView_2.jpg"/> | <img src="https://github.com/gzeinnumer/MyLibDialogSearchView/blob/master/preview/MyLibDialogSearchView_4.jpg"/> | <img src="https://github.com/gzeinnumer/MyLibDialogSearchView/blob/master/preview/MyLibDialogSearchView_6.jpg"/> |
|:-----------------------------------------------------------------------------------------------------------------|:-----------------------------------------------------------------------------------------------------------------|:-----------------------------------------------------------------------------------------------------------------|
| `Single Select Item` Preview, you only can select **1** Item                                                     | Click `OK` and call function `onOkPressedCallBackSingle`                                                         | Fiture `Filter` will enable on `Single Select` or `Multi Select`                                                 |


| <img src="https://github.com/gzeinnumer/MyLibDialogSearchView/blob/master/preview/MyLibDialogSearchView_5.jpg" /> | <img src="https://github.com/gzeinnumer/MyLibDialogSearchView/blob/master/preview/MyLibDialogSearchView_7.jpg"/> |
|:------------------------------------------------------------------------------------------------------------------|:-----------------------------------------------------------------------------------------------------------------|
| `Multi Select Item` Preview, you can select more than **1** Item                                                  | Click `OK` and call function `onOkPressedCallBackMulti`                                                          |

#### SearchViewDialog -> Customize

<p align="center">
  <img src="https://github.com/gzeinnumer/MyLibDialogSearchView/blob/master/preview/MyLibDialogSearchView_15.jpg" width="500"/>
</p>

You can Customize your dialog UI. [**ReadMore**](https://github.com/gzeinnumer/MyLibDialogSearchView/blob/master/README_1.md).

---

```
Copyright 2020 M. Fadli Zein
```