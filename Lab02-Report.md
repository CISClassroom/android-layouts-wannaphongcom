# รายงานผลการทดลอง

นายวรรณพงษ์ ภัททิยไพบูลย์ 603410214-3

## Relative Layout

แสดง Control `title` และ `Detail`

```xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".RelativeActivity">

    <EditText
        android:id="@+id/editText"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:ems="10"
        android:inputType="textPersonName"
        android:text="Name" />

    <EditText
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:inputType="textPersonName"
        android:text="Name"
        android:ems="10"
        android:layout_below="@id/editText"
        android:id="@+id/editText4"/>
    <EditText
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:inputType="textPersonName"
        android:text="Name"
        android:ems="10"
        android:layout_below="@id/editText4"
        android:id="@+id/editText5"/>
</RelativeLayout>
```

แอดทริบิ้วที่แสดงความสัมพันธ์ระหว่าง control ทั้งสอง

```xml
android:layout_above="@id/control ที่อ้างอิงที่อยู่ข้างบน"
```

## Linear Layout

แสดง Control `to`, `subject`, `tag` และ `message`

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".L2">

    <EditText
        android:id="@+id/editText"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:ems="10"
        android:inputType="textPersonName"
        android:text="Name"
        tools:layout_editor_absoluteX="14dp"
        tools:layout_editor_absoluteY="20dp" />

    <LinearLayout
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:orientation="horizontal">

        <EditText
            android:id="@+id/editText2"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:ems="10"
            android:inputType="textPersonName"
            android:text="Name"
            tools:layout_editor_absoluteX="16dp"
            tools:layout_editor_absoluteY="86dp" />

        <EditText
            android:id="@+id/editText3"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:ems="10"
            android:inputType="textPersonName"
            android:text="Name"
            tools:layout_editor_absoluteX="14dp"
            tools:layout_editor_absoluteY="151dp" />
    </LinearLayout>

    <EditText
        android:id="@+id/editText4"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_weight="1"
        android:ems="10"
        android:gravity="start|top"
        android:inputType="textMultiLine" />

    <Button
        android:id="@+id/button"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Button"
        tools:layout_editor_absoluteX="17dp"
        tools:layout_editor_absoluteY="210dp" />
</LinearLayout>

```

อธิบายความแตกต่างระหว่าง vertical และ horizontal orientation

```
vertical จะแสดงวัตถุภายในเป็นแนวตั้ง ส่วน horizontal orientation จะแสดงผลวัตถุภายในเป็นแนวนอนเดียวกัน
```

## Constrant Layout

จงออกแบบและสร้างหน้า Constrant layout สำหรับแสดงข้อมูลนักศึกษา ประกอบไปด้วย รูปโปรไฟล์ รูปพื้นหลัง ชื่อ-นามสกุล รหัสนักศึกษา และเกรดเฉลี่ยรวม

```kotlin
package com.numfa.androidlayouts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.view.Window
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_profile.*


class Profile : AppCompatActivity() {
    private lateinit var webView: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (supportActionBar != null)
            supportActionBar?.hide()
        setContentView(R.layout.activity_profile)
        webView = findViewById(R.id.web1)
        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url)
                return true
            }
        }
        webView.loadUrl("https://blog.wannaphong.com")
    }
}
```

**xml**

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    tools:context=".Profile">

    <ImageView
        android:id="@+id/imageView"
        android:layout_width="420dp"
        android:layout_height="278dp"
        android:layout_marginTop="1dp"
        android:layout_marginBottom="448dp"
        android:background="#005F1919"
        android:scaleType="centerCrop"
        android:visibility="visible"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="1.0"
        app:srcCompat="@drawable/m"
        tools:ignore="MissingConstraints" />

    <ImageView
        android:id="@+id/imageView3"
        android:layout_width="140dp"
        android:layout_height="147dp"
        android:layout_marginTop="208dp"
        android:background="#F44336"
        android:scaleType="fitXY"
        app:layout_constraintTop_toTopOf="@+id/imageView"
        app:srcCompat="@drawable/p"
        tools:ignore="MissingConstraints"
        tools:layout_editor_absoluteX="0dp" />

    <TextView
        android:id="@+id/textView5"
        android:layout_width="237dp"
        android:layout_height="72dp"
        android:layout_marginStart="156dp"
        android:layout_marginTop="280dp"
        android:fontFamily="sans-serif-light"
        android:text="นาย วรรณพงษ์ ภัททิยไพบูลย์\nรหัส 603410214-3\n\nเกรดเฉลี่ยรวม 3.46"
        app:layout_constraintStart_toStartOf="@+id/imageView3"
        app:layout_constraintTop_toTopOf="@+id/imageView" />

    <WebView
        android:id="@+id/web1"
        android:layout_width="409dp"
        android:layout_height="368dp"
        android:background="#FFC107"
        app:layout_constraintTop_toBottomOf="@+id/imageView3"
        tools:layout_editor_absoluteX="0dp" />

</androidx.constraintlayout.widget.ConstraintLayout>
```
