package com.lawlett.myquiz.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.lawlett.myquiz.QuestionModel;
import com.lawlett.myquiz.R;

public class GameFragment extends Fragment {
    TextView levelValue, questionTv;
    Button firstAnswerBtn, secondAnswerBtn, thirdAnswerBtn, fourAnswerBtn;
    QuestionModel questionModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game, container, false);
        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        getQuestions();
        setQuestions();
    }

    private void setQuestions() {
        levelValue.setText(questionModel.getCurrentLevel());
        questionTv.setText(questionModel.getQuestion());
        firstAnswerBtn.setText(questionModel.getFirstAnswer());
        secondAnswerBtn.setText(questionModel.getSecondAnswer());
        thirdAnswerBtn.setText(questionModel.getThirdAnswer());
        fourAnswerBtn.setText(questionModel.getFourAnswer());
    }

    private void initViews(View view) {
        levelValue = view.findViewById(R.id.level_value);
        questionTv = view.findViewById(R.id.question_tv);
        firstAnswerBtn = view.findViewById(R.id.first_answer_btn);
        secondAnswerBtn = view.findViewById(R.id.second_answer_btn);
        thirdAnswerBtn = view.findViewById(R.id.third_answer_btn);
        fourAnswerBtn = view.findViewById(R.id.four_answer_btn);
    }

    //    Bundle args = getArguments();
//    String personJsonString = args.getString(PERSON_KEY);
//    Person person= Utils.getGsonParser().fromJson(personJsonString, Person.class)
    private void getQuestions() {
        if (getArguments()!=null)
        questionModel = (QuestionModel) getArguments().getSerializable("question");
    }
}