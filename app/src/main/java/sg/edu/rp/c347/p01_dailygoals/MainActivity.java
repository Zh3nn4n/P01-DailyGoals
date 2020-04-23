package sg.edu.rp.c347.p01_dailygoals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etqn4;
    RadioGroup rg1, rg2, rg3;
    RadioButton rb, rb2, rb3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etqn4 = (EditText)findViewById(R.id.editTextReflection);



        SharedPreferences sh   = getSharedPreferences("MySharedPref",MODE_PRIVATE);
        String qn1 = sh.getString("qn1", "");
        String qn2 = sh.getString("qn2", "");
        String qn3 = sh.getString("qn3", "");
        String qn4 = sh.getString("qn4", "");

        if (qn1.equals("Yes")){
            rg1.check(-1);
        }else{
            rg1.check(0);
        }
        if (qn2.equals("Yes")){
            rg2.check(-1);
        }else{
            rg2.check(0);
        }
        if (qn3.equals("Yes")){
            rg3.check(-1);
        }else{
            rg3.check(0);
        }

        etqn4.setText(qn4);

        Button btnOk = (Button) findViewById(R.id.buttonOK);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rg1 = (RadioGroup) findViewById(R.id.radioGroup1);
                rg2 = (RadioGroup) findViewById(R.id.radioGroup2);
                rg3 = (RadioGroup) findViewById(R.id.radioGroup3);

                int selectedButtonId1 = rg1.getCheckedRadioButtonId();
                int selectedButtonId2 = rg2.getCheckedRadioButtonId();
                int selectedButtonId3 = rg3.getCheckedRadioButtonId();

                rb = (RadioButton) findViewById(selectedButtonId1);
                rb2 = (RadioButton) findViewById(selectedButtonId2);
                rb3 = (RadioButton) findViewById(selectedButtonId3);

                EditText etReflection = (EditText) findViewById(R.id.editTextReflection);

                String[] info = {etReflection.getText().toString(), rb.getText().toString(), rb2.getText().toString(), rb3.getText().toString()};

                SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
                SharedPreferences.Editor myEdit = sharedPreferences.edit();

                myEdit.putString("qn1", rb.getText().toString());
                myEdit.putString("qn2", rb2.getText().toString());
                myEdit.putString("qn3", rb3.getText().toString());
                myEdit.putString("qn4", etqn4.getText().toString());

                myEdit.apply();


                Intent i = new Intent(MainActivity.this, SummaryActivity.class);

                i.putExtra("info", info);
                startActivity(i);


            }
        });
    }


}

