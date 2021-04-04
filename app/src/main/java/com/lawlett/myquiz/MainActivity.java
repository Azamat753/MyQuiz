package com.lawlett.myquiz;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.lawlett.myquiz.fragments.StartFragment;

public class MainActivity extends AppCompatActivity {
    FrameLayout frameLayout;
    FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        openFragment();
    }

    private void openFragment() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container_fragment,new StartFragment());
        fragmentTransaction.commit();
    }

    private void initViews() {
        frameLayout = findViewById(R.id.container_fragment);
    }
}