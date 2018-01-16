package com.example.frisbeegolfsb;

/**
 * This activity purpose is just ask how many players we have and how many holes are in course
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;;

public class GetPlayerInformationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_player_information);

        final Intent intent = getIntent();

        final EditText editText = (EditText) findViewById(R.id.editText);
        final EditText editText2 = (EditText) findViewById(R.id.editText2);

        Button btn = (Button) findViewById(R.id.button);

        /**
         * Saves and returns information to MainActivity class
         */
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String players = editText.getText().toString();
                String holes = editText2.getText().toString();

                intent.putExtra("holes", holes);
                intent.putExtra("players", players);

                setResult(RESULT_OK, intent);
                finish();
            }
        });


    }

}
