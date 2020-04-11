package com.example.lab3_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View v) {
        EditText input = (EditText) findViewById(R.id.Input);
        TextView resultText = (TextView) findViewById(R.id.Result);
        TextView timeText = (TextView) findViewById(R.id.TimeResult);
        TextView countText = (TextView) findViewById(R.id.CountResult);

        if (input.getText().toString().trim().equals("")) {
            resultText.setText("Невірно введені дані!");
            return;
        }

        long num = Long.parseLong(input.getText().toString());
        long a = (long) Math.ceil(Math.sqrt(num));
        double end, start = System.nanoTime();
        int count = 0;

        if (a * a == num) {
            resultText.setText("√" + num + "\n[ " + a + ", " + a + " ]");
            end = System.nanoTime();
            String finalTime = new Double(end - start).toString();
            timeText.setText("Час обрахунку:\n" + finalTime);
            countText.setText("Кількість ітерацій:\n" + count);

            return;
        }

        if ((num & 1) == 0) {
            resultText.setText("Число є парним\n[ " + num / 2 + ", " + 2 + " ]");
            end = System.nanoTime();
            String finalTime = new Double(end - start).toString();
            timeText.setText("Час обрахунку:\n" + finalTime);
            countText.setText("Кількість ітерацій:\n" + count);
            return;
        }

        long b;
        while (true) {
            long c = a * a - num;
            b = (long) (Math.sqrt(c));

            if (b * b == c)
                break;
            count++;
            a += 1;
        }
        end = System.nanoTime();
        resultText.setText("[ " + (a - b) + ", " + (a + b) + " ]");
        String finalTime = new Double(end - start).toString();
        timeText.setText("Час обрахунку:\n" + finalTime);
        countText.setText("Кількість ітерацій:\n" + count);
        return;
    }

    public void Clear(View v) {
        EditText input = (EditText) findViewById(R.id.Input);
        TextView result = (TextView) findViewById(R.id.Result);
        TextView timeResult = (TextView) findViewById(R.id.TimeResult);
        TextView countResult = (TextView) findViewById(R.id.CountResult);

        input.setText(null);
        result.setText(null);
        timeResult.setText(null);
        countResult.setText(null);
    }
}
