package com.example.formula_keyboard;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;

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

import com.google.android.material.

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private boolean isAddKeyboard=false;

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

        //TODO キーボードが追加されているかの判断

        //キーボードが追加されていない場合はアラートを発生
        if(!isAddKeyboard){
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
        SharedPreferences preferences=getSharedPreferences("KEYBOARDS",MODE_PRIVATE);
        String data="1,2";
        preferences.edit().putString("ARRAY",data).commit();
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
                    Log.i("data","num is "+num[i]);
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
    public void showMyDialog()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = LayoutInflater.from(this);
        final View dialog_view = inflater.inflate(R.layout.add_formula_keyboard, null);

        builder.setView(dialog_view)
                .setIcon(R.drawable.images)
                .setTitle("Formula Keyboard")
                .setPositiveButton("OK!",
                        new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent();
                                intent.setAction(Settings.ACTION_INPUT_METHOD_SETTINGS);
                                startActivity(intent);
                            }
                        })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        //  cancel????
                        dialog.cancel();
                    }
                });

        AlertDialog myDialog = builder.create();
        myDialog.setCanceledOnTouchOutside(false);

        myDialog.show();

    }
}
