package sg.edu.rp.c346.id20014518.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    DatePicker dp;
    TimePicker tp;
    Button btnReserve;
    Button btnReset;
    CheckBox cb;
    EditText etSize;
    EditText etPhone;
    EditText etName;
    TextView tv;
    TextView tvDes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        btnReserve = findViewById(R.id.buttonReserve);
        btnReset = findViewById(R.id.buttonReset);
        cb = findViewById(R.id.checkBox);
        etSize = findViewById(R.id.editTextNumber);
        etPhone = findViewById(R.id.editTextPhone);
        etName = findViewById(R.id.editTextTextPersonName);
        tv = findViewById(R.id.textViewSmoke);
        tvDes = findViewById(R.id.textViewName);

        btnReserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String size = etSize.getText().toString();
                int iSize = Integer.parseInt(size);
                if (iSize > 5){
                    Toast.makeText(MainActivity.this,"Max 5 allowed",Toast.LENGTH_LONG).show();
                    etSize.setText("");
                }
                if (cb.isChecked()){
                    tv.setText("You have selected a table in the smoking area");
                }
                else{
                    tv.setText("You have selected a table in the non-smoking area");
                }
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tp.setCurrentHour(19);
                tp.setCurrentMinute(30);
                dp.updateDate(2020,5,1);
                etSize.setText("");
                etName.setText("");
                etPhone.setText("");
                tv.setText("");
                tvDes.setText("");
                cb.setChecked(false);
            }
        });
        tvDes.setText("Name: " + etName);
        tvDes.setText("Tel: " + etPhone);
        tvDes.setText("Size: " + etSize);
        tvDes.setText("Smoking: " + cb);
        tvDes.setText("Date: " + dp);
        tvDes.setText("Time: " + tp);

    }
}