package com.example.formula_keyboard.ui.keyboard;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;


import com.example.formula_keyboard.R;

/*
public class Test_Keyboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_keyboard_view);
    }
}

 */
//package com.sample.customkeyboard;



public class KeyboardControl extends InputMethodService implements KeyboardView.OnKeyboardActionListener {

    private KeyboardView keyboardView;
    private Keyboard keyboard;
    //初回だけ呼ばれる
    @Override
    public void onCreate() {
        super.onCreate();

    }

    //初回だけ呼ばれる
    @Override
    public View onCreateInputView() {
        //super.onCreateInputView();


        @SuppressLint("ResourceType")
        LinearLayout view = (LinearLayout) View.inflate(this, R.xml.navigator_bar, null);
        //View keyboardContent=(View) view.findViewById(R.id.keyboard_content);
        HorizontalScrollView scrollView = (HorizontalScrollView) view.findViewById(R.id.keyboard_bar);



        keyboardView = (KeyboardView) getLayoutInflater().inflate(R.layout.keyboard_view, null);
        //KeyboardView kv = (KeyboardView) getLayoutInflater().inflate(keyboard.xml, null);
        keyboard = new Keyboard(this, R.xml.keyboard_calculator);
        keyboardView.setKeyboard(keyboard);
        keyboardView.setOnKeyboardActionListener(this);
        keyboardView.setPreviewEnabled(false);
        view.addView(keyboardView,1);
        return view;

    }

    //キーボードが表示されるたびに呼ばれるメソッド
    @Override
    public void onStartInputView(EditorInfo editorInfo, boolean restarting) {
        //なんらかの処理
    }

    //キーボードが閉じる時に呼ばれるメソッド
    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    //キーを押した時
    @Override
    public void onKey(int primaryCode, int[] keyCodes) {
        InputConnection ic = getCurrentInputConnection();
        switch (primaryCode) {
            case KeyEvent.KEYCODE_1:
                ic.commitText("1", 1);
                break;
            case KeyEvent.KEYCODE_2:
                ic.commitText("2", 1);
                break;
            case KeyEvent.KEYCODE_3:
                ic.commitText("3", 1);
                break;
            case KeyEvent.KEYCODE_4:
                ic.commitText("4", 1);
                break;
            case KeyEvent.KEYCODE_5:
                ic.commitText("5", 1);
                break;
            case KeyEvent.KEYCODE_6:
                ic.commitText("6", 1);
                break;
            case KeyEvent.KEYCODE_7:
                ic.commitText("7", 1);
                break;
            case KeyEvent.KEYCODE_8:
                ic.commitText("8", 1);
                break;
            case KeyEvent.KEYCODE_9:
                ic.commitText("9", 1);
                break;
            case KeyEvent.KEYCODE_0:
                ic.commitText("0", 1);
                break;
            case Keyboard.KEYCODE_DELETE:
                ic.deleteSurroundingText(1, 0);
                break;
            case KeyEvent.KEYCODE_ENTER:
                ic.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER));
                break;
            case KeyEvent.KEYCODE_SPACE:
                ic.commitText(" ",1);
                break;
            case 10000:
                ic.commitText(":",1);
                break;
            case 10001:
                ic.commitText("×",1);
                break;
            case 10002:
                ic.commitText("+",1);
                break;
            case 10003:
                ic.commitText("/",1);
                break;
            case 10004:
                ic.commitText("~",1);
                break;
            case 10005:
                ic.commitText("÷",1);
                break;
            case 10006:
                ic.commitText("-",1);
                break;
            case 10007:
                ic.commitText("%",1);
                break;
            case 10008:
                ic.commitText("(",1);
                break;
            case 10009:
                ic.commitText(")",1);
                break;
            case 10010:
                ic.commitText("=",1);
                break;
            case 10011:
                ic.commitText(".",1);
                break;
            case 10012:
                ic.commitText(",",1);
                break;

            default:
                break;
        }
    }

    @Override
    public void onPress(int primaryCode) {
    }

    @Override
    public void onRelease(int primaryCode) {
    }

    @Override
    public void onText(CharSequence text) {
    }

    @Override
    public void swipeLeft() {
    }

    @Override
    public void swipeRight() {
    }

    @Override
    public void swipeDown() {
    }

    @Override
    public void swipeUp() {
    }

}
