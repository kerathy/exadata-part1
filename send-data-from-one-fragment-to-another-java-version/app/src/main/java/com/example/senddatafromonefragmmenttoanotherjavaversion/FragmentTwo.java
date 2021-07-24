package com.example.senddatafromonefragmmenttoanotherjavaversion;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentTwo extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fragment_two, container, false);
        String inputText = getArguments().getString("inputText");

        TextView textView = view.findViewById(R.id.outPutTextView);
        textView.setText(inputText);
        return view;
    }
}