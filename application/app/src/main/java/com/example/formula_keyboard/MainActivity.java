package com.example.formula_keyboard;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;

import com.example.formula_keyboard.ui.keyboard.KeyboardData;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private boolean isAddKeyboard = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        //インストールされているIMEアプリケーション一覧取得
        InputMethodManager imm = (InputMethodManager)
                getSystemService(INPUT_METHOD_SERVICE);
        List<InputMethodInfo> inputMethodInfoList =
                imm.getEnabledInputMethodList();
        int inputMethodInfoListSize = inputMethodInfoList.size();
        for (int i = 0; i < inputMethodInfoListSize; ++i) {
            InputMethodInfo inputMethodInfo = inputMethodInfoList.get(i);
            CharSequence label = inputMethodInfo.loadLabel(getPackageManager());
            Log.v("label", String.valueOf(label));
            //Formula_Keyboardがインストールされている場合
            if (String.valueOf(label).equals("Formula_Keyboard")) {
                Log.v("label", String.valueOf(label) + " is active!");
                isAddKeyboard = true;
            }
        }
        //キーボードが追加されていない場合はアラートを発生
        if (!isAddKeyboard) {
            showMyDialog();
        }


  /*    データの読み出し

        SharedPreferences preferences=getSharedPreferences("KEYBOARDS",MODE_PRIVATE);
        String stringItem = preferences.getString("ARRAY","");
        String[] numString;
        int[] num;
        if(stringItem != null && stringItem.length() != 0){
            numString=stringItem.split(",",0);
            if(numString[0]!=""){
                int i;
                num=new int[numString.length];
                for(i=0;i<numString.length;i++){
                    num[i]=Integer.parseInt(numString[i]);
                }
            }
        }
*/
        /*    データの書き込み

         */
/*
        データが存在しないとき

        SharedPreferences a=getSharedPreferences("KEY",MODE_PRIVATE);
        String stringItemTest = a.getString("ARRAY","");
        Log.i("test",stringItemTest+" is test string");
        if (stringItemTest ==  "") {
            Log.i("test","not defined");
        }
        */

        //環境変数初期化フェーズ
        SharedPreferences preferences = getSharedPreferences("KEYBOARDS", MODE_PRIVATE);
        String keyboardOrderArray = preferences.getString("KEYBOARD_ORDER_ARRAY", "");
        String keyboardButtonDisplayArray = preferences.getString("KEYBOARD_BUTTON_DISPLAY_ARRAY", "");
        //キーボード一覧の順番の初期化
        if (keyboardOrderArray == "") {
            String arrayData = Arrays.toString(KeyboardData.KEYBOARD_INT);
            String data = arrayData.substring(1, arrayData.length() - 1);
            Log.i("init", "keyboard's order is " + data);
            preferences.edit().putString("KEYBOARD_ORDER_ARRAY", data).commit();
        }
        //キーボード変更のボタンの初期化
        if (keyboardButtonDisplayArray == "") {
            String arrayData = Arrays.toString(KeyboardData.KEYBOARD_INT);
            String data = arrayData.substring(1, arrayData.length() - 1);
            Log.i("init", "display button is " + data);
            preferences.edit().putString("KEYBOARD_ORDER_ARRAY", data).commit();
        }

        //確認のためのコード 他の箇所で使うが、最終的には削除予定
        String[] numString;
        int[] num;
        if (keyboardOrderArray != null && keyboardOrderArray.length() != 0) {
            //stringに空白も入っているので注意
            numString = keyboardOrderArray.split(", ", -1);
            if (numString[0] != "") {
                int i;
                num = new int[numString.length];
                for (i = 0; i < numString.length; i++) {
                    num[i] = Integer.parseInt(numString[i]);
                    Log.i("data", "num is " + num[i]);
                }
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void showMyDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = LayoutInflater.from(this);
        final View dialog_view = inflater.inflate(R.layout.add_formula_keyboard, null);

        builder.setView(dialog_view)
                .setIcon(R.drawable.images)
                .setTitle("Formula Keyboard")
                .setPositiveButton("OK!",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent();
                                intent.setAction(Settings.ACTION_INPUT_METHOD_SETTINGS);
                                startActivity(intent);
                            }
                        })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //  cancel????
                        dialog.cancel();
                    }
                });

        AlertDialog myDialog = builder.create();
        myDialog.setCanceledOnTouchOutside(false);

        myDialog.show();

    }
}
