package com.example.senddatafromonefragmmenttoanotherjavaversion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Communicator{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirstFragment firstFragment = new FirstFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.relativeLayout, firstFragment).commit();

    }

    @Override
    public void passData(String editTextInput) {
        Bundle bundle = new Bundle();
        bundle.putString("inputText", editTextInput);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        FragmentTwo fragmentTwo = new FragmentTwo();

        fragmentTwo.setArguments(bundle);
        fragmentTransaction.replace(R.id.relativeLayout, fragmentTwo);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fragmentTransaction.commit();
    }
}