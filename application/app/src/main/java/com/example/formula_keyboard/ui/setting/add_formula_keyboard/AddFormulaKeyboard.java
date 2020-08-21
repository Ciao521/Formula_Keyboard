package com.example.formula_keyboard.ui.setting.add_formula_keyboard;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.os.Bundle;
import android.view.View;

import com.example.formula_keyboard.R;
/*

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showMyDialog();
    }
    //???????????
    public void showMyDialog()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = LayoutInflater.from(this);
        final View dialog_view = inflater.inflate(R.layout.my_dialog, null);

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


 */