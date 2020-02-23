package com.umld.tasks.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.ActionBar;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.umld.tasks.R;

public class MainActivity extends AppCompatActivity {

    public static FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*
        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);   //show back button
*/
        fragmentManager = getSupportFragmentManager();

        if (findViewById(R.id.mainFrame) != null) {
            if (savedInstanceState !=null){
                return;
            }

            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            LoginFragment loginFragment = new LoginFragment();
            fragmentTransaction.add(R.id.mainFrame, loginFragment);
            fragmentTransaction.commit();
        }
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
