package com.example.formula_keyboard.ui.keyboard;

import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;

public class KeyboardHighSchool extends InputMethodService {
    public final void keyDown(int primaryCode, int[] keyCodes, InputConnection ic) {
        switch (primaryCode){
            case 20000:
                ic.commitText("Σ",1);
                break;
            case 20001:
                ic.commitText("log",1);
                break;
            case 20002:
                ic.commitText("ln",1);
                break;
            case 20003:
                ic.commitText("φ",1);
                break;
            case 20004:
                ic.commitText("Δ",1);
                break;
            case 20005:
                ic.commitText("√",1);
                break;
            case 20006:
                ic.commitText("e",1);
                break;
            case 20007:
                ic.commitText("exp",1);
                break;
            case 20008:
                ic.commitText("C",1);
                break;
            case 20009:
                ic.commitText("P",1);
                break;
            case 20010:
                ic.commitText("∫",1);
                break;
            case 20011:
                ic.commitText("dx",1);
                break;
            case 20012:
                ic.commitText("i",1);
                break;
            case 20013:
                ic.commitText("ρ",1);
                break;
            case 20014:
                ic.commitText("μ",1);
                break;
            case 20015:
                ic.commitText("sin",1);
                break;
            case 20016:
                ic.commitText("cos",1);
                break;
            case 20017:
                ic.commitText("tan",1);
                break;
            case 20018:
                ic.commitText("Θ",1);
                break;
            case 20019:
                ic.commitText("lim",1);
                break;
            case 20020:
                ic.commitText("→",1);
                break;
            case 20021:
                ic.commitText("∞",1);
                break;
            case 20022:
                ic.commitText("inf",1);
                break;
            case 20023:
                ic.commitText("!",1);
                break;
            case 20024:
                ic.commitText("^",1);
                break;
            case 20025:
                ic.commitText("(",1);
                break;
            case 20026:
                ic.commitText(")",1);
                break;
            case 20027:
                ic.commitText("=",1);
                break;
            case KeyEvent.KEYCODE_PERIOD:
                ic.commitText(".",1);
                break;
            case 10012:
                ic.commitText(",",1);
                break;
            case KeyEvent.KEYCODE_SLASH:
                ic.commitText("/",1);
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
            default:
                break;
        }
    }
}

/*
package com.example.formula_keyboard.ui.keyboard;
​
import android.os.Bundle;
import android.util.Log;
import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
​
import com.sample.customkeyboard.R;
​
public class NewKeyboard extends InputMethodService implements KeyboardView.OnKeyboardActionListener {
​
    private KeyboardView keyboardView;
    private Keyboard keyboard;
​
    //初回だけ呼ばれる
    @Override
    public void onCreate() {
        super.onCreate();
    }
​
    //初回だけ呼ばれる
    @Override
    public View onCreateInputView() {
        super.onCreateInputView();
​
        keyboardView = (KeyboardView) getLayoutInflater().inflate(R.layout.keyboard_view, null);
        keyboard = new Keyboard(this, R.xml.keyboard);
        keyboardView.setKeyboard(keyboard);
        keyboardView.setOnKeyboardActionListener(this);
        keyboardView.setPreviewEnabled(false);
        return keyboardView;
    }
​
    //キーボードが表示されるたびに呼ばれるメソッド
    @Override
    public void onStartInputView(EditorInfo editorInfo, boolean restarting) {
        //なんらかの処理
    }
​
    //キーボードが閉じる時に呼ばれるメソッド
    @Override
    public void onDestroy() {
        super.onDestroy();
    }
​
    //キーを押した時
    @Override
    public void onKey(int primaryCode, int[] keyCodes) {
        InputConnection ic = getCurrentInputConnection();
        switch (primaryCode) {
            case 20000:
                ic.commitText("Σ",1);
                break;
            case 20001:
                ic.commitText("log",1);
                break;
            case 20002:
                ic.commitText("ln",1);
                break;
            case 20003:
                ic.commitText("φ",1);
                break;
            case 20004:
                ic.commitText("Δ",1);
                break;
            case 20005:
                ic.commitText("√",1);
                break;
            case 20006:
                ic.commitText("e",1);
                break;
            case 20007:
                ic.commitText("exp",1);
                break;
            case 20008:
                ic.commitText("C",1);
                break;
            case 20009:
                ic.commitText("P",1);
                break;
​
            case 20010:
                ic.commitText("∫",1);
                break;
            case 20011:
                ic.commitText("dx",1);
                break;
            case 20012:
                ic.commitText("i",1);
                break;
            case 20013:
                ic.commitText("ρ",1);
                break;
            case 20014:
                ic.commitText("μ",1);
                break;
            case 20015:
                ic.commitText("sin",1);
                break;
            case 20016:
                ic.commitText("cos",1);
                break;
            case 20017:
                ic.commitText("tan",1);
                break;
            case 20018:
                ic.commitText("Θ",1);
                break;
​
            case 20019:
                ic.commitText("lim",1);
                break;
            case 20020:
                ic.commitText("→",1);
                break;
            case 20021:
                ic.commitText("∞",1);
                break;
            case 20022:
                ic.commitText("inf",1);
                break;
            case 20023:
                ic.commitText("!",1);
                break;
            case 20024:
                ic.commitText("^",1);
                break;
            case 20025:
                ic.commitText("(",1);
                break;
            case 20026:
                ic.commitText(")",1);
                break;
            case 20027:
                ic.commitText("=",1);
                break;
​
            case KeyEvent.KEYCODE_PERIOD:
                ic.commitText(".",1);
                break;
            case KeyEvent.KEYCODE_SLASH:
                ic.commitText("/",1);
                break;
​
            case Keyboard.KEYCODE_DELETE:
                ic.deleteSurroundingText(1, 0);
                break;
            case KeyEvent.KEYCODE_ENTER:
                ic.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER));
                break;
            case KeyEvent.KEYCODE_SPACE:
                ic.commitText(" ",1);
                break;
​
            default:
                break;
        }
    }
​
    @Override
    public void onPress(int primaryCode) {
    }
​
    @Override
    public void onRelease(int primaryCode) {
    }
​
    @Override
    public void onText(CharSequence text) {
    }
​
    @Override
    public void swipeLeft() {
    }
​
    @Override
    public void swipeRight() {
    }
​
    @Override
    public void swipeDown() {
    }
​
    @Override
    public void swipeUp() {
    }
​
}
*/