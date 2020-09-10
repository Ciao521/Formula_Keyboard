package com.example.formula_keyboard.ui.gallery;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.formula_keyboard.R;
import com.example.formula_keyboard.ui.setting.help.HelpFragment;
import com.example.formula_keyboard.ui.setting.info.InfoFragment;
import com.example.formula_keyboard.ui.setting.qa.QAFragment;

public class GalleryFragment extends Fragment /*implements View.OnClickListener */{

    private GalleryViewModel galleryViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);

        RecyclerView recyclerView =root.findViewById(R.id.ImageRecyclerView);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager rLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(rLayoutManager);

        //イベントリスナーの設置
        //root.findViewById(R.id.calculator_image_view).setOnClickListener(this);
        //root.findViewById(R.id.unit_image_view).setOnClickListener(this);
        return root;
    }
    /*
    @Override
    public void onClick(View view){
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        if(view!=null){
            switch (view.getId()){
                case R.id.calculator_image_view:
                    new AlertDialog.Builder(getActivity())
                            .setTitle("何をしますか？")
                            .setMessage("キーボードの表示/非表示の変更\n" +
                                    "または、editorで試す")
                            .setPositiveButton("確定" , new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    // YES button pressed
                                }
                            })
                            .setNeutralButton("editor", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    // Later button pressed
                                }
                            })
                            .setNegativeButton("中止", null)
                            .show();
                    break;
                case R.id.unit_image_view:
                    transaction.replace(R.id.nav_host_fragment, QAFragment.newInstance());

                    break;

                default:
                    break;
            }
        }
    } */
}
