package com.example.formula_keyboard.ui.setting;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import com.example.formula_keyboard.R;
import com.example.formula_keyboard.ui.setting.help.HelpFragment;
import com.example.formula_keyboard.ui.setting.info.InfoFragment;
import com.example.formula_keyboard.ui.setting.qa.QAFragment;

public class SettingFragment extends Fragment implements View.OnClickListener{
    private SlideshowViewModel slideshowViewModel;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel = ViewModelProviders.of(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_setting, container, false);
        root.findViewById(R.id.button_help).setOnClickListener(this);
        root.findViewById(R.id.button_QA).setOnClickListener(this);
        root.findViewById(R.id.button_info).setOnClickListener(this);


        return root;
    }
    @Override
    public void onClick(View view){
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        if(view!=null){
            switch (view.getId()){
                case R.id.button_help:
                    transaction.replace(R.id.nav_host_fragment, HelpFragment.newInstance());
                    transaction.commit();
                    break;
                case R.id.button_QA:
                    transaction.replace(R.id.nav_host_fragment, QAFragment.newInstance());
                    transaction.commit();
                    break;
                case R.id.button_info:
                    transaction.replace(R.id.nav_host_fragment, InfoFragment.newInstance());
                    transaction.commit();
                    break;
                default:
                    break;
            }
        }
    }

}
