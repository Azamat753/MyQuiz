package com.lawlett.myquiz.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.lawlett.myquiz.LevelAdapter;
import com.lawlett.myquiz.OnItemClick;
import com.lawlett.myquiz.QuestionModel;
import com.lawlett.myquiz.R;

import java.util.ArrayList;

public class LevelFragment extends Fragment implements OnItemClick {
    String firstLevel, secondLevel, thirdLevel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_level, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getLevels();
        initAdapter(view);
    }

    private void sendLevel(int position) {
        Bundle bundle = new Bundle();
        switch (position) {
            case 0:
                bundle.putSerializable("question", new QuestionModel(firstLevel, "How much rooms in GeekTech",
                        "2", "1", "5", "4"));
                break;
            case 1:
                bundle.putSerializable("question", new QuestionModel(secondLevel, "What happened in my mind",
                        "I want sleep", "Eat", "I want play dota 2", "Smoke"));
                break;
        }
        GameFragment gameFragment = new GameFragment();
        gameFragment.setArguments(bundle);
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container_fragment, gameFragment);
        fragmentTransaction.commit();
    }

    private void initAdapter(View view) {
        ArrayList<String> levels = new ArrayList<>();
        levels.add(firstLevel);
        levels.add(secondLevel);
        levels.add(thirdLevel);
        RecyclerView recyclerView = view.findViewById(R.id.level_recycler);
        LevelAdapter adapter = new LevelAdapter(this);
        recyclerView.setAdapter(adapter);
        adapter.getLevel(levels);
    }

    private void getLevels() {
        if (getArguments() != null) {
            firstLevel = getArguments().getString("key1");
            secondLevel = getArguments().getString("key2");
            thirdLevel = getArguments().getString("key3");
        }
    }

    @Override
    public void onClick(int position) {
        sendLevel(position);
    }
}