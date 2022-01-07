package com.wasnikaditya.timevalidationinjava;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    TextView tvTimer1, tvTimer2;
    int t1Hour, t1Minute, t2Hour, t2Minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tvTimer1 = findViewById(R.id.tv_timer1);
        tvTimer2 = findViewById(R.id.tv_timer2);

        tvTimer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                        t1Hour = hourOfDay;
                        t1Minute = minute;

                        Calendar calendar = Calendar.getInstance();
                        calendar.set(0,0,0,t1Hour,t1Minute);

                        tvTimer1.setText(DateFormat.format("hh:mm aa",calendar));

                    }
                }, 12,0,false);

                timePickerDialog.updateTime(t1Hour, t1Minute);
                timePickerDialog.show();

            }
        });

        tvTimer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        MainActivity.this, android.R.style.Theme_Holo_Dialog_MinWidth, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                        t2Hour = hourOfDay;
                        t2Minute = minute;

                        String time = t2Hour + ":" + t2Minute;

                        SimpleDateFormat f24Hours = new SimpleDateFormat("HH:mm");
                        try
                        {
                            Date date  = f24Hours.parse(time);
                            SimpleDateFormat f12Hours = new SimpleDateFormat("hh:mm aa");

                            tvTimer2.setText(f12Hours.format(date));

                        }
                        catch (ParseException e)
                        {
                            e.printStackTrace();
                        }

                    }
                }, 12,0,false);

                timePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                timePickerDialog.updateTime(t2Hour, t2Minute);
                timePickerDialog.show();

            }
        });

    }
}


       /* //Get the widgets reference from XML layout
        final TextView tv = (TextView) findViewById(R.id.tv);
        final TimePicker tp = (TimePicker) findViewById(R.id.tp);
        Button btn = (Button) findViewById(R.id.btn);

        //Set the TextView text color
        tv.setTextColor(Color.parseColor("#ff2b9030"));

        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                int hourOfDay = tp.getCurrentHour(); //Get TimePicker current hour
                int minute = tp.getCurrentMinute(); //Get TimePicker current minute

                //Display the TimePicker current time to app interface
                String AMPM = "AM";
                if(hourOfDay>11)
                {
                    //Get the current hour as AM PM 12 hour format
                    hourOfDay = hourOfDay-12;
                    AMPM = "PM";
                }
                tv.setText("" + hourOfDay + ":" + minute + ":" + AMPM);
            }
        });
    }
}


*/

       /* //Get a new instance of Calendar
        final Calendar c= Calendar.getInstance();
        int hourOfDay = c.get(c.HOUR_OF_DAY); //Current Hour
        int minute = c.get(c.MINUTE); //Current Minute
        int second = c.get(c.SECOND); //Current Second

        //Get the widgets reference from XML layout
        final TextView tv = (TextView) findViewById(R.id.tv);
        TimePicker tp = (TimePicker) findViewById(R.id.tp);

        //Display the TimePicker initial time
        tv.setText("Initial Time\nH:M:S | " + hourOfDay + ":" + minute + ":" + second);

        //Set a TimeChangedListener for TimePicker widget
        tp.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                //Display the new time to app interface
                tv.setText("Time changed\nH:M | "+hourOfDay + ":" + minute);
            }
        });
    }
}*/