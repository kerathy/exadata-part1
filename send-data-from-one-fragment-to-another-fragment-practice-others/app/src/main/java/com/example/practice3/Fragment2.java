package com.example.practice3;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Fragment2 extends Fragment {

    View view;
    Button button;
    EditText editText;
    TextView textView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.activity_fragment2, container, false);
        button = view.findViewById(R.id.fragment2btn1);
        editText = view.findViewById(R.id.dataToFragment1);
        textView = view.findViewById(R.id.textView2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle result = new Bundle();
                result.putString("data_from_fragment2", editText.getText().toString());
                getParentFragmentManager().setFragmentResult("requestKeyDataFrom2", result);
                editText.setText("");
            }
        });

        getParentFragmentManager().setFragmentResultListener("requestKeyDataFrom1", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull  String requestKey, @NonNull Bundle result) {
                String data = result.getString("data_from_fragment1");
                textView.setText(data);
            }
        });
        return view;
    }
}