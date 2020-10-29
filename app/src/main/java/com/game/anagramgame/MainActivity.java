package com.game.anagramgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView wordAnagram;
    EditText wordEnter;
    Button search, restart;
    private String wordToFind;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Anagram.zapAnagram();
        wordAnagram = findViewById(R.id.wordAnagram);
        wordEnter = findViewById(R.id.wordEnter);
        search = findViewById(R.id.search);
        restart = findViewById(R.id.restart);

        search.setOnClickListener(this);
        restart.setOnClickListener(this);

        newGame();
    }

    @Override
    public void onClick(View view) {
        Button button = findViewById(view.getId());
        if(button.equals(search)){
            search();
        }else if (view == restart){
            newGame();
        }
    }

    private void search(){

        String w = wordEnter.getText().toString();//wordAnagram.getText().toString();

        if(wordToFind.equals(w)){
            Toast.makeText(this, "Congratulations!!! You found the word" + wordToFind, Toast.LENGTH_SHORT).show();
            newGame();
        }else{
            Toast.makeText(this, "Retry!" , Toast.LENGTH_SHORT).show();
        }
    }

    private void newGame(){
        wordToFind = Anagram.randomW();
        String wordShuffled = Anagram.schuffleW(wordToFind);
        wordAnagram.setText(wordShuffled);
        wordEnter.setText("");
    }
}