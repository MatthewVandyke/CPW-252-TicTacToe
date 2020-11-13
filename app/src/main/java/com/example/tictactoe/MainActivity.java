package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tictactoe.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private String currPlayer;
    private ActivityMainBinding binding;
    private Button[][] buttons;
    private boolean gameDone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        buttons = new Button[][]{{binding.button1, binding.button2, binding.button3},
                                 {binding.button4, binding.button5, binding.button6},
                                 {binding.button7, binding.button8, binding.button9}};
        currPlayer = "X";

    }

    public void resetGame(View view) {
        for (Button[] row : buttons){
            for (Button button : row){
                button.setText("");
            }
        }
        updateCurrPlayer("X");
        gameDone = false;
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
        if (gameDone)
            return;
        Button button = (Button) view;
        if(button.getText().length() == 0) {
            button.setText(currPlayer);
            if(checkWin(currPlayer)) {
                gameDone = true;
                binding.textView.setText("Player " + currPlayer + " Wins!");
                return;
            }

            if(checkTie()) {
                gameDone = true;
                binding.textView.setText("It's a tie!");
                return;
            }

            if (currPlayer.equals("X")) {
                updateCurrPlayer("O");
            } else {
                updateCurrPlayer("X");
            }
        }
    }

    private boolean checkWin(String player) {

        //Check rows
        for (Button[] row : buttons){
            if (row[0].getText().equals(player)
            && row[1].getText().equals(player)
            && row[2].getText().equals(player)) {
                return true;
            }
        }

        //Check cols
        for (int i = 0; i < 3; i++) {
            if (buttons[0][i].getText().equals(player)
            && buttons[1][i].getText().equals(player)
            && buttons[2][i].getText().equals(player)) {
                return true;
            }
        }

        //Check X
        if (buttons[0][0].getText().equals(player)
        && buttons[1][1].getText().equals(player)
        && buttons[2][2].getText().equals(player)) {
            return true;
        }

        if (buttons[0][2].getText().equals(player)
        && buttons[1][1].getText().equals(player)
        && buttons[2][0].getText().equals(player)) {
            return true;
        }

        return false;
    }

    private boolean checkTie() {
        for (Button[] row : buttons){
            for (Button button : row){
                if (button.getText().length() == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}