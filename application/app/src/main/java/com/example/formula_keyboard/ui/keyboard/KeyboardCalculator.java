package com.example.formula_keyboard.ui.keyboard;

import android.annotation.SuppressLint;
import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputConnection;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

import com.example.formula_keyboard.R;

public class KeyboardCalculator extends InputMethodService {
    private static KeyboardView keyboardViewAtControl;
    private static Keyboard keyboardAtControl;
    public final static void setKeyboardCalculator(KeyboardControl context,LinearLayout view){
        //keyboardViewAtControl = (KeyboardView) getLayoutInflater().inflate(R.layout.keyboard_view, null);

        keyboardAtControl = new Keyboard(context, R.xml.keyboard_calculator);
        keyboardViewAtControl.setKeyboard(keyboardAtControl);
        keyboardViewAtControl.setOnKeyboardActionListener(context);
        keyboardViewAtControl.setPreviewEnabled(false);
        view.addView(keyboardViewAtControl,1);

    }
    public final void keyDown(int primaryCode, int[] keyCodes, InputConnection ic) {
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
}
