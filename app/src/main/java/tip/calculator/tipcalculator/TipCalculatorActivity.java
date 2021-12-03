package tip.calculator.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TipCalculatorActivity extends AppCompatActivity {

    private EditText checkAmountValue;
    private EditText partySizeValue;
    private Button buttonCompute;
    private EditText fifteenPercentTipValue;
    private EditText twentyPercentTipValue;
    private EditText twentyfivePercentTipValue;
    private EditText fifteenPercentTotalValue;
    private EditText twentyPercentTotalValue;
    private EditText twentyfivePercentTotalValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkAmountValue = findViewById(R.id.checkAmountValue);
        partySizeValue = findViewById(R.id.partySizeValue);
        buttonCompute = findViewById(R.id.buttonCompute);
        fifteenPercentTipValue = findViewById(R.id.fifteenPercentTipValue);
        twentyPercentTipValue = findViewById(R.id.twentyPercentTipValue);
        twentyfivePercentTipValue = findViewById(R.id.twentyfivePercentTipValue);
        fifteenPercentTotalValue = findViewById(R.id.fifteenPercentTotalValue);
        twentyPercentTotalValue = findViewById(R.id.twentyPercentTotalValue);
        twentyfivePercentTotalValue = findViewById(R.id.twentyfivePercentTotalValue);

        buttonCompute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }
        });
    }

    private void calculate(){

        Double copyCheckAmountValue;
        Double copyPartySizeValue;
        long percentTipValue15;
        long percentTipValue20;
        long percentTipValue25;
        long percentTotalValue15;
        long percentTotalValue20;
        long percentTotalValue25;

        if(checkAmountValue.getText().toString().equals("") || partySizeValue.getText().toString().equals("") || Double.parseDouble(checkAmountValue.getText().toString()) <= 0 || Double.parseDouble( partySizeValue.getText().toString()) <= 0 ){

            Toast.makeText(this, "Empty or incorrect value(s)!", Toast.LENGTH_SHORT).show();
        }

        if(!checkAmountValue.getText().toString().equals("")){

            copyCheckAmountValue = Double.parseDouble(checkAmountValue.getText().toString());
            copyPartySizeValue = Double.parseDouble(partySizeValue.getText().toString());

            percentTotalValue15 =  Math.round(copyCheckAmountValue * 15 / 100);
            percentTotalValue20 = Math.round(copyCheckAmountValue * 20 / 100);
            percentTotalValue25 = Math.round(copyCheckAmountValue * 25 / 100);

            percentTipValue15 = Math.round(percentTotalValue15 / copyPartySizeValue);
            percentTipValue20 = Math.round(percentTotalValue20 / copyPartySizeValue);
            percentTipValue25 = Math.round(percentTotalValue25 / copyPartySizeValue);

            fifteenPercentTotalValue.setText(String.valueOf(percentTotalValue15));
            twentyPercentTotalValue.setText(String.valueOf(percentTotalValue20));
            twentyfivePercentTotalValue.setText(String.valueOf(percentTotalValue25));

            fifteenPercentTipValue.setText(String.valueOf(percentTipValue15));
            twentyPercentTipValue.setText(String.valueOf(percentTipValue20));
            twentyfivePercentTipValue.setText(String.valueOf(percentTipValue25));

        }
    }
}