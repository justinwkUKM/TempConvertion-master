package com.waqas.myxlab.tempconvert;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;


public class ConversionActivity extends AppCompatActivity {

    EditText etF;
    Button btConvert;
    Button btNext;
    TextView tvC;
    String s;
    double fehrenheit;
    double celcius;
    ImageView ivIcon;
    String condition = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion);
        etF = (EditText) findViewById(R.id.editTextFehrenheit);
        btConvert = (Button) findViewById(R.id.buttonConvert);
        tvC = (TextView) findViewById(R.id.textViewCelsius);
        btNext = (Button) findViewById(R.id.buttonNext);
        ivIcon = (ImageView) findViewById(R.id.imageViewTemp);

        btConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s= etF.getText().toString();
                fehrenheit = Double.parseDouble(s);
                celcius = (fehrenheit-32)*(0.5556);
                Log.e("Clicked","I CLicked" + s );
                DecimalFormat df = new DecimalFormat("###.##");
                //String finalCelcius = String.valueOf(celcius);
                double rounded  = Double.parseDouble(df.format(celcius));
                tvC.setText(rounded + " " +(char)186 + "C");

                if (celcius>99){
                    //do something here, you are boiling
                    condition = "Hot";
                    ivIcon.setImageResource(R.drawable.icons_hot);
                    Toast.makeText(ConversionActivity.this, "Boiling here", Toast.LENGTH_SHORT).show();

                }else if (celcius<0){
                    condition = "freezing";
                    //do something here, you are freezing
                    ivIcon.setImageResource(R.drawable.icons_cold);
                    Toast.makeText(ConversionActivity.this, "Freezing here", Toast.LENGTH_SHORT).show();

                }else{
                    condition = "normal";
                    // its all fine here
                    ivIcon.setImageResource(R.drawable.icons_normal);
                    Toast.makeText(ConversionActivity.this, "Nice Temprature", Toast.LENGTH_SHORT).show();

                }

            }
        });


            btNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i  = new Intent(ConversionActivity.this, NextActivity.class);
                    //step 1 create a bundle object
                    Bundle bundle = new Bundle();
                    //step 2 add your data to bundle
                    bundle.putString("key1", condition);
                    bundle.putDouble("key2", celcius);
                    //step 3 add the bundle to intent
                    i.putExtras(bundle);
                    startActivity(i);
                }
            });
















    }
}







