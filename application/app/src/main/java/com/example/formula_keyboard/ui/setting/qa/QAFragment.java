package com.example.formula_keyboard.ui.setting.qa;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.formula_keyboard.R;
import com.example.formula_keyboard.ui.setting.help.HelpFragment;

public class QAFragment extends Fragment {
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.q_and_a, container, false);
        return root;
    }
    public static QAFragment newInstance() {
        QAFragment fragment = new QAFragment();
        return fragment;
    }
}
