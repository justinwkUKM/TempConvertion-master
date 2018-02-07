package com.waqas.myxlab.tempconvert;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class NextActivity extends AppCompatActivity {

    TextView tvCelcius;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        tvCelcius = (TextView) findViewById(R.id.textViewCelciusValue);
        img = (ImageView) findViewById(R.id.imageViewNextActivity);

        Bundle bundle = getIntent().getExtras();
        String receivedString = bundle.getString("key1");
        double receivedTemp = bundle.getDouble("key2");

        tvCelcius.setText("The condition is "+ receivedString +
                "\nThe Temp is "+ receivedTemp);


        if (receivedTemp>99){

            img.setImageResource(R.drawable.icons_hot);

        }else if (receivedTemp<0){

            img.setImageResource(R.drawable.icons_cold);

        }else{

            img.setImageResource(R.drawable.icons_normal);

        }

    }









}
