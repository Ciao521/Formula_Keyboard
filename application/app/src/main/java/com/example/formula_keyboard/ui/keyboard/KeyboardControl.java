package com.example.formula_keyboard.ui.keyboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

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
import com.example.formula_keyboard.ui.setting.help.HelpFragment;
import com.example.formula_keyboard.ui.setting.info.InfoFragment;
import com.example.formula_keyboard.ui.setting.qa.QAFragment;

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


public class KeyboardControl extends InputMethodService implements KeyboardView.OnKeyboardActionListener, View.OnClickListener {

    private static KeyboardView keyboardViewAtControl;
    private static Keyboard keyboardAtControl;
    private static KeyboardControl contextAtControl;
    private static int keyboardNumber = 1;
    private LinearLayout viewAtControl;

    //初回だけ呼ばれる
    @Override
    public void onCreate() {
        super.onCreate();

    }

    //初回だけ呼ばれる
    @Override
    public View onCreateInputView() {
        //super.onCreateInputView();
        contextAtControl = this;

        @SuppressLint("ResourceType")
        LinearLayout view = (LinearLayout) View.inflate(this, R.xml.navigator_bar, null);
        viewAtControl = view;
        //KeyboardView kv = (KeyboardView) getLayoutInflater().inflate(keyboard.xml, null);
        switch (this.keyboardNumber) {
            case 1:
                //KeyboardCalculator.setKeyboardCalculator(contextAtControl,view);
                keyboardViewAtControl = (KeyboardView) getLayoutInflater().inflate(R.layout.keyboard_view, null);
                setKeyboardCalculator();
                viewAtControl.addView(keyboardViewAtControl, 1);
                break;
            case 2:

                keyboardViewAtControl = (KeyboardView) getLayoutInflater().inflate(R.layout.keyboard_view, null);
                setKeyboardUnit();
                viewAtControl.addView(keyboardViewAtControl, 1);
                break;
            case 3:
                keyboardViewAtControl = (KeyboardView) getLayoutInflater().inflate(R.layout.keyboard_view, null);
                setKeyboardHighSchool();
                viewAtControl.addView(keyboardViewAtControl, 1);
                break;
            default:
                //setKeyboardCalculator();
                break;
        }
        viewAtControl.findViewById(R.id.choose_calculator_button).setOnClickListener(this);
        viewAtControl.findViewById(R.id.choose_unit_button).setOnClickListener(this);
        viewAtControl.findViewById(R.id.choose_high_school_button).setOnClickListener(this);

        return viewAtControl;

    }

    public final static void setKeyboardCalculator() {

        keyboardAtControl = new Keyboard(contextAtControl, R.xml.keyboard_calculator);
        keyboardViewAtControl.setKeyboard(keyboardAtControl);
        keyboardViewAtControl.setOnKeyboardActionListener(contextAtControl);
        keyboardViewAtControl.setPreviewEnabled(false);
    }

    public final static void setKeyboardUnit() {
        keyboardAtControl = new Keyboard(contextAtControl, R.xml.keyboard_unit);
        keyboardViewAtControl.setKeyboard(keyboardAtControl);
        keyboardViewAtControl.setOnKeyboardActionListener(contextAtControl);
        keyboardViewAtControl.setPreviewEnabled(false);
    }

    public final static void setKeyboardHighSchool() {
        keyboardAtControl = new Keyboard(contextAtControl, R.xml.keyboard_high_school);
        keyboardViewAtControl.setKeyboard(keyboardAtControl);
        keyboardViewAtControl.setOnKeyboardActionListener(contextAtControl);
        keyboardViewAtControl.setPreviewEnabled(false);
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
        switch (keyboardNumber) {
            case 1:
                KeyboardCalculator keyboardCalculator = new KeyboardCalculator();
                keyboardCalculator.keyDown(primaryCode, keyCodes, ic);
                break;
            case 2:
                KeyboardUnit keyboardUnit = new KeyboardUnit();
                keyboardUnit.keyDown(primaryCode, keyCodes, ic);
                break;
            case 3:
                KeyboardHighSchool keyboardHighSchool = new KeyboardHighSchool();
                keyboardHighSchool.keyDown(primaryCode, keyCodes, ic);
                break;
        }
    }

    @Override
    public void onClick(View view) {
        Log.i("CHANGE", "Current status " + keyboardNumber);

        if (view != null) {
            switch (view.getId()) {
                case R.id.choose_calculator_button:
                    keyboardNumber = 1;
                    keyboardAtControl = new Keyboard(this, R.xml.keyboard_calculator);
                    keyboardViewAtControl.setKeyboard(keyboardAtControl);
                    Log.i("CHANGE", "Current status " + keyboardNumber);
                    keyboardViewAtControl.invalidateAllKeys();
                    break;
                case R.id.choose_unit_button:
                    keyboardNumber = 2;
                    keyboardAtControl = new Keyboard(this, R.xml.keyboard_unit);
                    keyboardViewAtControl.setKeyboard(keyboardAtControl);
                    Log.i("CHANGE", "Current status " + keyboardNumber);
                    keyboardViewAtControl.invalidateAllKeys();

                    break;
                case R.id.choose_high_school_button:
                    keyboardNumber = 3;
                    keyboardAtControl = new Keyboard(this, R.xml.keyboard_high_school);
                    keyboardViewAtControl.setKeyboard(keyboardAtControl);
                    Log.i("CHANGE", "Current status " + keyboardNumber);
                    keyboardViewAtControl.invalidateAllKeys();
                    break;
                default:
                    break;
            }
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
