package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tictactoe.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String currPlayer;
    private ActivityMainBinding binding;
    private ArrayList<Button> buttons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        buttons = new ArrayList<>();

        buttons.add(binding.button1);
        buttons.add(binding.button2);
        buttons.add(binding.button3);
        buttons.add(binding.button4);
        buttons.add(binding.button5);
        buttons.add(binding.button6);
        buttons.add(binding.button7);
        buttons.add(binding.button8);
        buttons.add(binding.button9);
        currPlayer = "X";

    }

    public void resetGame(View view) {
        for (Button button : buttons){
            button.setText("");
        }
        updateCurrPlayer("X");
    }

    private void updateCurrPlayer(String name) {
        currPlayer = name;
        if (name.equals("X")){
            binding.textView.setText(R.string.playerX);
        }
        else {
            binding.textView.setText(R.string.playerO);
        }
    }

    public void onButtonClick(View view) {
        Button button = (Button) view;
        if(button.getText().length() == 0) {
            button.setText(currPlayer);
            if (currPlayer.equals("X")) {
                updateCurrPlayer("O");
            } else {
                updateCurrPlayer("X");
            }
        }
    }
}