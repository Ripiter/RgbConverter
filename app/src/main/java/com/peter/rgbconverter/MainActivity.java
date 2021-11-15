package com.peter.rgbconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements  BarChaneable {
    ImageView imageView;
    TextView rgbText;
    TextView hexText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SliderHandler sliderHandler = new SliderHandler();

        SeekBar redBar = findViewById(R.id.red_bar);
        SeekBar greenBar = findViewById(R.id.green_bar);
        SeekBar blueBar = findViewById(R.id.blue_bar);

        redBar.setOnSeekBarChangeListener(sliderHandler);
        greenBar.setOnSeekBarChangeListener(sliderHandler);
        blueBar.setOnSeekBarChangeListener(sliderHandler);

        sliderHandler.addListener(this);

        imageView = findViewById(R.id.imageView);

        rgbText = findViewById(R.id.rgb_text);
        hexText = findViewById(R.id.hex_text);
    }

    @Override
    public void ColorChanged(int sliderID, CustomColor color) {
        rgbText.setText("Red: " + color.getRed() + " Green: " + color.getGreen() + " Blue: " + color.getBlue());
        hexText.setText(color.getHex());
        imageView.setBackgroundColor(color.getColor());
    }
}