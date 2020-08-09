package com.example.formula_keyboard.ui.keyboard;

import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;

public class KeyboardUnit extends InputMethodService {
    public static final int MG=10000;
    public static final int G=10001;
    public static final int KG=10002;
    public static final int MM=10003;
    public static final int CM=10004;
    public static final int M=10005;
    public static final int KM=10006;
    public static final int ML=10007;
    public static final int DL=10008;
    public static final int L=10009;
    public static final int KL=10010;
    public static final int M2=10011;
    public static final int M3=10012;
    public static final int HA=10013;
    public static final int MS=10014;
    public static final int MOL=10015;
    public static final int MOLL=10016;
    public static final int C=10017;
    public static final int F=10018;
    public static final int PH=10019;
    public static final int HZ=10020;
    public static final int OMEGA=10021;
    public static final int A=10022;
    public static final int V=10023;
    public static final int W=10024;
    public static final int PA=10025;
    public static final int CC=10026;
    public static final int KK=10027;
    public static final int N=10028;
    public static final int RAD=10029;
    public static final int J=10030;
    public static final int NANAME=10031;
    public static final int K=10032;
    public static final int S=10033;
    public static final int H=10034;
    public static final int WAT=10035;
    public final void keyDown(int primaryCode, int[] keyCodes,InputConnection ic) {
        switch (primaryCode) {

            case Keyboard.KEYCODE_DELETE:
                ic.deleteSurroundingText(1, 0);
                break;
            case KeyEvent.KEYCODE_ENTER:
                ic.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER));
                break;
            case KeyEvent.KEYCODE_SPACE:
                ic.commitText(" ", 1);
                break;
            case MG:
                ic.commitText("mg", 1);
                break;
            case G:
                ic.commitText("g", 1);
                break;
            case KG:
                ic.commitText("kg", 1);
                break;
            case MM:
                ic.commitText("mm", 1);
                break;
            case CM:
                ic.commitText("cm", 1);
                break;
            case M:
                ic.commitText("m", 1);
                break;
            case KM:
                ic.commitText("km", 1);
                break;
            case ML:
                ic.commitText("mL", 1);
                break;
            case DL:
                ic.commitText("dL", 1);
                break;
            case L:
                ic.commitText("L", 1);
                break;
            case KL:
                ic.commitText("kL", 1);
                break;
            case M2:
                ic.commitText("㎡", 1);
                break;
            case M3:
                ic.commitText("㎥", 1);
                break;
            case HA:
                ic.commitText("ha", 1);
                break;
            case MS:
                ic.commitText("m/s", 1);
                break;
            case MOL:
                ic.commitText("mol", 1);
                break;
            case MOLL:
                ic.commitText("mol/L", 1);
                break;
            case C:
                ic.commitText("℃", 1);
                break;
            case F:
                ic.commitText("℉", 1);
                break;
            case PH:
                ic.commitText("pH", 1);
                break;
            case HZ:
                ic.commitText("Hz", 1);
                break;
            case OMEGA:
                ic.commitText("Ω", 1);
                break;
            case A:
                ic.commitText("A", 1);
                break;
            case V:
                ic.commitText("V", 1);
                break;
            case W:
                ic.commitText("W", 1);
                break;
            case PA:
                ic.commitText("Pa", 1);
                break;
            case CC:
                ic.commitText("c", 1);
                break;
            case KK:
                ic.commitText("k", 1);
                break;
            case N:
                ic.commitText("N", 1);
                break;
            case RAD:
                ic.commitText("rad", 1);
                break;
            case J:
                ic.commitText("J", 1);
                break;
            case NANAME:
                ic.commitText("/", 1);
                break;
            case K:
                ic.commitText("K", 1);
                break;
            case S:
                ic.commitText("s", 1);
                break;
            case H:
                ic.commitText("h", 1);
                break;
            case WAT:
                ic.commitText("W", 1);
                break;

            default:
                break;
        }
    }


}


//これはメインのコード
/*package com.example.keytry;

import android.os.Bundle;
import android.util.Log;
import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;

import com.sample.keytry.R;

public class NewKeyboard extends InputMethodService implements KeyboardView.OnKeyboardActionListener {

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
        super.onCreateInputView();

        keyboardView = (KeyboardView) getLayoutInflater().inflate(R.layout.keyboard_view, null);
        keyboard = new Keyboard(this, R.xml.keyboard);
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

            case Keyboard.KEYCODE_DELETE:
                ic.deleteSurroundingText(1, 0);
                break;
            case KeyEvent.KEYCODE_ENTER:
                ic.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER));
                break;
            case KeyEvent.KEYCODE_SPACE:
                ic.commitText(" ", 1);
                break;
            case SpecialKey.MG:
                ic.commitText("mg", 1);
                break;
            case SpecialKey.G:
                ic.commitText("g", 1);
                break;
            case SpecialKey.KG:
                ic.commitText("kg", 1);
                break;
            case SpecialKey.MM:
                ic.commitText("mm", 1);
                break;
            case SpecialKey.CM:
                ic.commitText("cm", 1);
                break;
            case SpecialKey.M:
                ic.commitText("m", 1);
                break;
            case SpecialKey.KM:
                ic.commitText("km", 1);
                break;
            case SpecialKey.ML:
                ic.commitText("mL", 1);
                break;
            case SpecialKey.DL:
                ic.commitText("dL", 1);
                break;
            case SpecialKey.L:
                ic.commitText("L", 1);
                break;
            case SpecialKey.KL:
                ic.commitText("kL", 1);
                break;
            case SpecialKey.M2:
                ic.commitText("㎡", 1);
                break;
            case SpecialKey.M3:
                ic.commitText("㎥", 1);
                break;
            case SpecialKey.HA:
                ic.commitText("ha", 1);
                break;
            case SpecialKey.MS:
                ic.commitText("m/s", 1);
                break;
            case SpecialKey.MOL:
                ic.commitText("mol", 1);
                break;
            case SpecialKey.MOLL:
                ic.commitText("mol/L", 1);
                break;
            case SpecialKey.C:
                ic.commitText("℃", 1);
                break;
            case SpecialKey.F:
                ic.commitText("℉", 1);
                break;
            case SpecialKey.PH:
                ic.commitText("pH", 1);
                break;
            case SpecialKey.HZ:
                ic.commitText("Hz", 1);
                break;
            case SpecialKey.OMEGA:
                ic.commitText("Ω", 1);
                break;
            case SpecialKey.A:
                ic.commitText("A", 1);
                break;
            case SpecialKey.V:
                ic.commitText("V", 1);
                break;
            case SpecialKey.W:
                ic.commitText("W", 1);
                break;
            case SpecialKey.PA:
                ic.commitText("Pa", 1);
                break;
            case SpecialKey.CC:
                ic.commitText("c", 1);
                break;
            case SpecialKey.KK:
                ic.commitText("k", 1);
                break;
            case SpecialKey.N:
                ic.commitText("N", 1);
                break;
            case SpecialKey.RAD:
                ic.commitText("rad", 1);
                break;
            case SpecialKey.J:
                ic.commitText("J", 1);
                break;
            case SpecialKey.NANAME:
                ic.commitText("/", 1);
                break;
            case SpecialKey.K:
                ic.commitText("K", 1);
                break;
            case SpecialKey.S:
                ic.commitText("s", 1);
                break;
            case SpecialKey.H:
                ic.commitText("h", 1);
                break;
            case SpecialKey.WAT:
                ic.commitText("W", 1);
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
*/


//こっちはキーボードのための番号を作成
/*
*
* package com.example.keytry;

public class SpecialKey {
    public static final int MG=10000;
    public static final int G=10001;
    public static final int KG=10002;
    public static final int MM=10003;
    public static final int CM=10004;
    public static final int M=10005;
    public static final int KM=10006;
    public static final int ML=10007;
    public static final int DL=10008;
    public static final int L=10009;
    public static final int KL=10010;
    public static final int M2=10011;
    public static final int M3=10012;
    public static final int HA=10013;
    public static final int MS=10014;
    public static final int MOL=10015;
    public static final int MOLL=10016;
    public static final int C=10017;
    public static final int F=10018;
    public static final int PH=10019;
    public static final int HZ=10020;
    public static final int OMEGA=10021;
    public static final int A=10022;
    public static final int V=10023;
    public static final int W=10024;
    public static final int PA=10025;
    public static final int CC=10026;
    public static final int KK=10027;
    public static final int N=10028;
    public static final int RAD=10029;
    public static final int J=10030;
    public static final int NANAME=10031;
    public static final int K=10032;
    public static final int S=10033;
    public static final int H=10034;
    public static final int WAT=10035;


}
*/
