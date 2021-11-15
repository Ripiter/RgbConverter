package com.peter.rgbconverter;

import android.widget.SeekBar;
import java.util.ArrayList;

/**
 * Handles the seekbar values
 *
 * This handler is used to handle seekbar value changes, start and stop
 *
 * @author Peter
 * @version 2021.11.15
 * @since 1.0
 */
public class SliderHandler implements  SeekBar.OnSeekBarChangeListener {

    ArrayList<BarChaneable> listeners = new ArrayList<>();
    CustomColor customColor;

    public SliderHandler(){
        customColor = new CustomColor(0,0,0,0);
    }

    public void addListener(BarChaneable barListener){
        listeners.add(barListener);
    }
    public void removeListener(BarChaneable barListener){
        listeners.remove(barListener);
    }

    /**
     * Method that sets color and informs all listeners that the value changed
     *
     * @param seekBar The seekbar that was changed
     * @param progress The value that was changed too
     * @param fromUser From what activity?
     */
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        //Log.e("Changed", "Progress " + progress + " Bar: " + seekBar.getId());

        switch (seekBar.getId()){
            case  R.id.red_bar:
                customColor.setRed(progress);
                break;
            case  R.id.green_bar:
                customColor.setGreen(progress);
                break;
            case  R.id.blue_bar:
                customColor.setBlue(progress);
                break;
        }


        for (BarChaneable bar : listeners){
            bar.ColorChanged(seekBar.getId(), customColor);
        }

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        //Log.e("Start", "Progress " + seekBar.getId());
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        //Log.e("Stop", "Progress " + seekBar.getId());
    }
}
