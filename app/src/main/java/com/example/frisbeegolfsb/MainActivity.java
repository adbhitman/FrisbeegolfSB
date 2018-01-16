package com.example.frisbeegolfsb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int players = 0;
    private int holes = 0;

    static final int REQUEST_DATA = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Getting needed information to create right size table based on
        //how many players we have and how many holes are in course
        Intent intent = new Intent(this, GetPlayerInformationActivity.class);
        startActivityForResult(intent, REQUEST_DATA);

    }


    /**
     * This part is transferring data between two activities
     * @param requestCode
     * @param resultCode
     * @param data data trasfered
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //5super.onActivityResult(requestCode, resultCode, data);
        // Check which request we're responding to
        if (requestCode == REQUEST_DATA) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                players = Integer.parseInt(data.getStringExtra("players"));
                holes = Integer.parseInt(data.getStringExtra("holes"));

                TextView textView = (TextView) findViewById(R.id.textView);
                //textView.setText(players+" "+holes);
                textView.setText(String.format("Number of players: %d\nNumber of holes: %d", players, holes));
            }
        }
    }


}
