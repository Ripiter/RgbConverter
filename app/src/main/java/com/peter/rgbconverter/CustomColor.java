package com.peter.rgbconverter;
/**
 * Contains rgb values
 *
 * This class holds rgb values and usefull methods
 *
 * @author Peter
 * @version 2021.11.15
 * @since 1.0
 */
public class CustomColor {
    private int red;
    private int green;
    private int blue;
    private int alpha;
    
    public CustomColor(int _a, int _r, int _g, int _b){
        alpha = _a;
        red = _r;
        green = _g;
        blue = _b;
    }

    public int getAlpha(){ return alpha; }
    public void setAlpha(int value) { alpha = value; }
    
    public int getRed(){
        return  red;
    }

    public void setRed(int value){
        red = value;
    }

    public int getGreen(){
        return green;
    }
    public void setGreen(int value){
        green = value;
    }


    public int getBlue(){
        return  blue;
    }

    public void setBlue(int value){
        blue = value;
    }

    public int getColor(){
        return (255 & 0xff) << 24 | (red & 0xff) << 16 | (green & 0xff) << 8 | (blue & 0xff);
    }

    public String getHex(){
        return String.format("#%02x%02x%02x", red, green, blue);
    }
}
