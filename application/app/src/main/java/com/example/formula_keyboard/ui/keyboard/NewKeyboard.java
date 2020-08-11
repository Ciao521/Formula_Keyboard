/*
package com.sample.keyboard;

import android.os.Bundle;
import android.util.Log;
import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;

import com.sample.keyboard.R;

public class NewKeyboard extends InputMethodService implements KeyboardView.OnKeyboardActionListener {

    private KeyboardView keyboardView;
    private Keyboard keyboard;
    boolean isupper;

    //初回だけ呼ばれる
    @Override
    public void onCreate() {
        super.onCreate();
    }

    //初回だけ呼ばれる
    @Override
    public View onCreateInputView() {
        super.onCreateInputView();

        keyboardView = (KeyboardView) getLayoutInflater().inflate(R.layout.keyboard_view, null);
        keyboard = new Keyboard(this, R.xml.lowercase);
        keyboardView.setKeyboard(keyboard);
        keyboardView.setOnKeyboardActionListener(this);
        keyboardView.setPreviewEnabled(false);
        return keyboardView;
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
                ic.commitText("q", 1);
                break;
            case KeyEvent.KEYCODE_2:
                ic.commitText("w", 1);
                break;
            case KeyEvent.KEYCODE_3:
                ic.commitText("e", 1);
                break;
            case KeyEvent.KEYCODE_4:
                ic.commitText("r", 1);
                break;
            case KeyEvent.KEYCODE_5:
                ic.commitText("t", 1);
                break;
            case KeyEvent.KEYCODE_6:
                ic.commitText("y", 1);
                break;
            case KeyEvent.KEYCODE_7:
                ic.commitText("u", 1);
                break;
            case KeyEvent.KEYCODE_8:
                ic.commitText("i", 1);
                break;
            case KeyEvent.KEYCODE_9:
                ic.commitText("o", 1);
                break;
            case KeyEvent.KEYCODE_11:
                ic.commitText("p", 1);
                break;
            case KeyEvent.KEYCODE_12:
                ic.commitText("a", 1);
                break;
            case KeyEvent.KEYCODE_F1:
                ic.commitText("s", 1);
                break;
            case KeyEvent.KEYCODE_F2:
                ic.commitText("d", 1);
                break;
            case KeyEvent.KEYCODE_F3:
                ic.commitText("f", 1);
                break;
            case KeyEvent.KEYCODE_F4:
                ic.commitText("g", 1);
                break;
            case KeyEvent.KEYCODE_F5:
                ic.commitText("h", 1);
                break;
            case KeyEvent.KEYCODE_F6:
                ic.commitText("j", 1);
                break;
            case KeyEvent.KEYCODE_F7:
                ic.commitText("k", 1);
                break;
            case KeyEvent.KEYCODE_F8:
                ic.commitText("l", 1);
                break;
            case KeyEvent.KEYCODE_F9:
                ic.commitText("z", 1);
                break;
            case KeyEvent.KEYCODE_F10:
                ic.commitText("x", 1);
                break;
            case KeyEvent.KEYCODE_F11:
                ic.commitText("c", 1);
                break;

            case KeyEvent.KEYCODE_F12:
                ic.commitText("v", 1);
                break;
            case KeyEvent.KEYCODE_A:
                ic.commitText("b", 1);
                break;
            case KeyEvent.KEYCODE_B:
                ic.commitText("n", 1);
                break;
            case KeyEvent.KEYCODE_C:
                ic.commitText("m", 1);
                break;
            case KeyEvent.KEYCODE_D:
                ic.commitText(",", 1);
                break;
            case KeyEvent.KEYCODE_E:
                ic.commitText(".", 1);
                break;
            case KeyEvent.KEYCODE_F:
                ic.commitText("Q", 1);
                break;
            case KeyEvent.KEYCODE_G:
                ic.commitText("W", 1);
                break;
            case KeyEvent.KEYCODE_H:
                ic.commitText("E", 1);
                break;
            case KeyEvent.KEYCODE_I:
                ic.commitText("R", 1);
                break;
            case KeyEvent.KEYCODE_J:
                ic.commitText("T", 1);
                break;
            case KeyEvent.KEYCODE_K:
                ic.commitText("Y", 1);
                break;
            case KeyEvent.KEYCODE_L:
                ic.commitText("U", 1);
                break;
            case KeyEvent.KEYCODE_M:
                ic.commitText("I", 1);
                break;
            case KeyEvent.KEYCODE_N:
                ic.commitText("O", 1);
                break;
            case KeyEvent.KEYCODE_O:
                ic.commitText("P", 1);
                break;
            case KeyEvent.KEYCODE_P:
                ic.commitText("A", 1);
                break;
            case KeyEvent.KEYCODE_Q:
                ic.commitText("S", 1);
                break;
            case KeyEvent.KEYCODE_R:
                ic.commitText("D", 1);
                break;
            case KeyEvent.KEYCODE_S:
                ic.commitText("F", 1);
                break;
            case KeyEvent.KEYCODE_T:
                ic.commitText("G", 1);
                break;
            case KeyEvent.KEYCODE_U:
                ic.commitText("H", 1);
                break;
            case KeyEvent.KEYCODE_V:
                ic.commitText("J", 1);
                break;
            case KeyEvent.KEYCODE_W:
                ic.commitText("K", 1);
                break;
            case KeyEvent.KEYCODE_X:
                ic.commitText("L", 1);
                break;
            case KeyEvent.KEYCODE_Y:
                ic.commitText("Z", 1);
                break;
            case KeyEvent.KEYCODE_Z:
                ic.commitText("X", 1);
                break;
            case KeyEvent.KEYCODE_AT:
                ic.commitText("C", 1);
                break;
            case KeyEvent.KEYCODE_EISU:
                ic.commitText("V", 1);
                break;
            case KeyEvent.KEYCODE_ASSIST:
                ic.commitText("B", 1);
                break;
            case KeyEvent.KEYCODE_NAVIGATE_OUT:
                ic.commitText("N", 1);
                break;
            case KeyEvent.KEYCODE_GRAVE:
                ic.commitText("M", 1);
                break;

            case Keyboard.KEYCODE_DELETE:
                ic.deleteSurroundingText(1, 0);
                break;
            case KeyEvent.KEYCODE_ENTER:
                ic.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER));
                break;
            case KeyEvent.KEYCODE_SPACE:
                ic.commitText(" ", 1);
                break;
            case Keyboard.KEYCODE_SHIFT:
                //toggle the flag for determine lowercase and uppercase.
                if(isupper == true) isupper = false;
                else isupper = true;
                if (isupper == true) {
                    //inflate uppercase.xml file
                    keyboard=new Keyboard(this, R.xml.uppercase);
                    //set the uppercase keyboard
                    keyboardView.setKeyboard(keyboard);
                    keyboardView.setShifted(true);
                    Log.i("KEYCODE_SHIFT", "Current status " + isupper);
                    keyboardView.invalidateAllKeys();
                }else{
                    keyboard=new Keyboard(this, R.xml.lowercase);
                    //set the uppercase keyboard
                    keyboardView.setKeyboard(keyboard);
                    keyboardView.setShifted(false);
                    Log.i("KEYCODE_SHIFT", "Current status " + isupper);
                    keyboardView.invalidateAllKeys();
                }
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

 */