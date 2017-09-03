package com.example.android.footeamsv1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class RandomTeamSorter extends AppCompatActivity {

    ListView show_team_a, show_team_b;
    Button sortAgain;
    ArrayList<String> player_list=new ArrayList<>();
    ArrayList<String> display_name_list=new ArrayList<>();
    Sorter sorter = new Sorter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_team_sorter);

        Intent intent = getIntent();
        Bundle args = intent.getBundleExtra("BUNDLE");
        player_list=(ArrayList<String>) args.getSerializable("ARRAYLIST");

        sorter.sorterFunction(player_list.size());

        sortAgain=(Button)findViewById(R.id.reSort);
        show_team_a=(ListView)findViewById(R.id.teama);
        show_team_b=(ListView)findViewById(R.id.teamb);

        makeTeams();

        sortAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sorter.sorterFunction(player_list.size());
                makeTeams();
            }
        });


    }

    public void makeTeams(){
        fillTeamList(sorter.random_order_a);
        populateTeam(show_team_a);
        fillTeamList(sorter.random_order_b);
        populateTeam(show_team_b);
    }

    public void fillTeamList(int random_list[]){
        int i;
        for(i=0;i<(player_list.size()/2);i++) {
            display_name_list.add(player_list.get(random_list[i]));
        }
    }

    public void populateTeam(ListView show_team){
        ArrayList<String> clonelist= new ArrayList<>();
        clonelist.addAll(display_name_list);
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, clonelist);
        show_team.setAdapter(arrayAdapter);
        display_name_list.clear();
    }

}
