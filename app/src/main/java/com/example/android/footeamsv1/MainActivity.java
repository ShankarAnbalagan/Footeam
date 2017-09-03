package com.example.android.footeamsv1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText enter_player_name;
    Button accept_player, sort_into_teams, remove_name;
    ListView display_player_name;

    ArrayList <String> player_name_list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enter_player_name=(EditText)findViewById(R.id.enterName);
        display_player_name= (ListView) findViewById(R.id.displayName);
        accept_player=(Button)findViewById(R.id.acceptName);
        remove_name=(Button)findViewById(R.id.delete);
        sort_into_teams=(Button)findViewById(R.id.sortButton);


        accept_player.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItemToList();
                enter_player_name.setText("");
            }
        });

        remove_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteItemInList();
                enter_player_name.setText("");
            }
        });

        sort_into_teams.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RandomTeamSorter.class);
                Bundle args = new Bundle();
                args.putSerializable("ARRAYLIST",player_name_list);
                intent.putExtra("BUNDLE",args);
                startActivity(intent);
            }
        });

    }

    public void populateArrayList(){
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, player_name_list);
        display_player_name.setAdapter(arrayAdapter);
    }

    public void addItemToList(){
        String text;
        text=enter_player_name.getText().toString();
        if(text.equals(""))
            return;
        for(String word : player_name_list)
        {
            if(word.equals(text)) {
                Toast.makeText(getApplicationContext(), "Name already entered", Toast.LENGTH_SHORT).show();
                return;
            }
        }
        player_name_list.add(text);
        populateArrayList();
    }

    public void deleteItemInList(){
        String word_to_delete;
        word_to_delete=enter_player_name.getText().toString();
        if (word_to_delete.equals(""))
            return;
        for(String word: player_name_list){
            if (word.equals(word_to_delete)){
                player_name_list.remove(word_to_delete);
                break;
            }
        }
        populateArrayList();
    }
}
