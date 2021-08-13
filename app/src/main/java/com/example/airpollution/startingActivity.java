package com.example.airpollution;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

public class startingActivity extends AppCompatActivity {

    private TextView day;
    private TextView month;
    private static final int maxDay = 4;
    private static final int maxMonth = 12;
    private static final int minDay = 1;
    private static final int minMonth = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtMaxDate = findViewById(R.id.txtMaxDate);
        String dateRange = minDay + "." + minMonth + ".2019 - "+ maxDay + "." + maxMonth + ".2019";
        txtMaxDate.setText(dateRange);

        Button btn = findViewById(R.id.btn_0);
        CalendarView calendar = findViewById(R.id.calendarView);
        day = findViewById(R.id.txtDay);
        month = findViewById(R.id.txtMonth);

        btn.setBackgroundResource(R.drawable.custom_button);

        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int i, int i1, int i2) {

                    if(Integer.toString(i).equals("2019"))
                    {
                        String dayStr = Integer.toString(i2);
                        String monthStr = Integer.toString(i1+1);

                        day.setText(dayStr);
                        month.setText(monthStr);
                    }
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String chosenDay = day.getText().toString();
                String chosenMonth = month.getText().toString();

                int chosenD = Integer.parseInt(chosenDay);
                int chosenM = Integer.parseInt(chosenMonth);

                if(chosenD < 1 || chosenD > 31 || chosenM < 1 || chosenM > 12 || (chosenM == 2 && chosenD > 28) ||
                        (chosenM == 4 && chosenD > 30) || (chosenM == 6 && chosenD > 30) ||
                        (chosenM == 9 && chosenD > 30) || (chosenM == 11 && chosenD > 30) ||
                        (chosenM >= maxMonth && chosenD > maxDay))
                {
                    makeToast("Невалидна дата");
                }

                else
                {
                    Intent intent = new Intent(startingActivity.this, map_Activity.class);

                    chosenDay = Integer.toString(chosenD);
                    if(chosenD < 10) chosenDay = "0"+chosenDay;

                    chosenMonth = Integer.toString(chosenM);
                    if(chosenM < 10) chosenMonth = "0"+chosenMonth;

                    String fileName = chosenDay + "." + chosenMonth + ".2019" +
                            " г. - Данни за периода от 00_00 часа до 24_00 часа.csv";

                    intent.putExtra("fileName", fileName);
                    startActivity(intent);
                }
            }
        });
    }

    private void makeToast(String text)
    {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, text, duration);
        toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 80);
        toast.show();
    }

}
