package com.fibonacci;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText qtdElementos;
    private RadioGroup radioFibo;
    private TextView resultFibo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        qtdElementos = (EditText)findViewById(R.id.qtdElementos);
        radioFibo = (RadioGroup)findViewById(R.id.radioGroupFibonacci);
        resultFibo = (TextView)findViewById(R.id.resultadoFibo);
    }

    public void calcFibo(View view) {
        int elements = Integer.parseInt(qtdElementos.getText().toString());
        int checked = radioFibo.getCheckedRadioButtonId();

        int n1 = 0, n2 = 1, n3;
        int[] arrayFibo = new int [elements];
        arrayFibo[0] = n1;
        arrayFibo[1] = n2;

        if(elements > 2) {
            for (int i = 2; i < elements; i++) {
                n3 = n1 + n2;
                arrayFibo[i] = n3;
                n1 = n2;
                n2 = n3;
            }
        }

        if(checked == R.id.sequence) {
            String seqFibo ="";
            for (int i = 0; i <= arrayFibo.length; i++) {
                seqFibo += arrayFibo[i] + " ";
            }
            resultFibo.setText(seqFibo);
        }
        else if (checked == R.id.element) {
            String elemento = String.valueOf(arrayFibo[(elements - 1)]);
            resultFibo.setText(elemento);
        }
    }
}