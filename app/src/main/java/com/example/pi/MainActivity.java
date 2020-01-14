package com.example.pi;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {
    EditText userCount;
    Button btnResult;
    Button btnCancel;
    TextView text;
    TextView result;
    String p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnResult = findViewById(R.id.btnRes);
        btnResult.setEnabled(false);
        btnCancel = findViewById(R.id.btnCancel);
        userCount = findViewById(R.id.dotCount);
        userCount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void afterTextChanged(Editable editable) {
                if (userCount.length() > 1)
                    {btnResult.setEnabled(true);}
                else
                    {btnResult.setEnabled(false);}
            }});
        text = findViewById(R.id.rusultTxt);
        result = findViewById(R.id.resultNum);
        btnResult.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        int dotCnt;
        int circCnt = 0;
        int radius = 1;
        double x, y;
        double pi;
        switch (view.getId()) {
             case R.id.btnRes:
                dotCnt = Integer.parseInt(userCount.getText().toString());
                for (int i = 0; i < dotCnt; i++) {
                    x =  (Math.random() * radius);
                    y =  (Math.random() * radius);
                    if (Math.pow(x, 2) + Math.pow(y, 2) <= Math.pow(radius,2))
                        circCnt++;
                }
                pi = (float) (4 * circCnt )/ dotCnt;
                text.setText("Сгенерированное число Пи: ");
                p = String.format("%.5f",pi);
                result.setText(p);
                break;
            case R.id.btnCancel:
                userCount.setText(null);
                text.setText("Операция отменена");
                result.setText(null);
                break;
        }
    }
}