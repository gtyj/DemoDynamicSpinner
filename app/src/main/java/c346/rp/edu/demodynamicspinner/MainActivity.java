package c346.rp.edu.demodynamicspinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Spinner spn1;
    Spinner spn2;
    Button btnUpdate;
    ArrayList<String> alNumbers;
    ArrayAdapter<String> aaNumbers;
    String[] strNumbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spn1 = findViewById(R.id.spinner1);
        spn2 = findViewById(R.id.spinner2);
        btnUpdate = findViewById(R.id.button);
        alNumbers = new ArrayList<>();
        aaNumbers = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item, alNumbers);

        /*
        alNumbers.add("2");
        alNumbers.add("4");
        alNumbers.add("6");
        */

        /*
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = spn1.getSelectedItemPosition();
                alNumbers.clear();

                if (pos == 0) {
                    strNumbers = getResources().getStringArray(R.array.even_numbers);
                }
                else {
                    strNumbers = getResources().getStringArray(R.array.odd_numbers);
                }
                alNumbers.addAll(Arrays.asList(strNumbers));

                spn2.setAdapter(aaNumbers);
            }
        });
        */

        spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int pos = 0;
                alNumbers.clear();
                switch (position) {
                    case 0:
                        strNumbers = getResources().getStringArray(R.array.even_numbers);
                        pos = 2;
                        break;
                    case 1:
                        strNumbers = getResources().getStringArray(R.array.odd_numbers);
                        pos = 1;
                        break;
                }
                alNumbers.addAll(Arrays.asList(strNumbers));
                spn2.setAdapter(aaNumbers);
                spn2.setSelection(pos);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
