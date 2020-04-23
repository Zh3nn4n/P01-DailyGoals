package sg.edu.rp.c347.p01_dailygoals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SummaryActivity extends AppCompatActivity {
Button btnClose;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        TextView tv1 = (TextView)findViewById(R.id.tvsummaryqn1);
        TextView tv2 = (TextView)findViewById(R.id.tvsummaryqn2);
        TextView tv3 = (TextView)findViewById(R.id.tvsummaryqn3);
        TextView tv4 = (TextView)findViewById(R.id.tvsummaryqn4);
        Button btn = (Button) findViewById(R.id.button2);

        Intent i = getIntent();

        String[] info = i.getStringArrayExtra("info");


        tv1.setText("Read up on materials before class: " + info[1]);
        tv2.setText("Arrive on time so as not to miss important part of \n the lesson: " + info[2]);
        tv3.setText("Attempt the problem myself: " + info[3]);
        tv4.setText("Reflection: " + info[0]);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
