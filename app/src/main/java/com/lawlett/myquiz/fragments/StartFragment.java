package com.lawlett.myquiz.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.lawlett.myquiz.R;

public class StartFragment extends Fragment {
    Button startBtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_start, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        initClickers();
    }

    private void initClickers() {
        startBtn.setOnClickListener(view -> openLevelFragment());
    }

    public void openLevelFragment() {
        Bundle bundle = new Bundle();
        bundle.putString("key1","1");
        bundle.putString("key2","2");
        bundle.putString("key3","3");
        LevelFragment levelFragment = new LevelFragment();
        levelFragment.setArguments(bundle);
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_fragment, levelFragment)
                .commit();
    }

    private void initViews(View view) {
        startBtn = view.findViewById(R.id.start_btn);
    }
}