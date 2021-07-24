package com.example.senddatafromonefragmmenttoanotherjavaversion;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FirstFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_first_fragment, container, false);

        Button btn = view.findViewById(R.id.btnSend);
        Communicator communicator = (Communicator) getActivity();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = view.findViewById(R.id.editText);
                String data = editText.getText().toString();
                assert communicator != null;
                communicator.passData(data);
            }
        });
        return view;
    }
}