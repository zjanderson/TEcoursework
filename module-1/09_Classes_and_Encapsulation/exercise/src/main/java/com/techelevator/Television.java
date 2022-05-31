package com.techelevator;

public class Television {


    /*
        Fields, Properties, Member Variables, Instance Variables
     */
    private boolean isOn; //need getter, Whether or not the TV is turned on.
    private int currentChannel; //need getter, The value for the current channel. Channel levels go between 3 and 18.
    private int currentVolume; //need getter, The current volume level.



    /*
        Constructors      The Television class doesn't need a constructor.
                          However, the instance variables need default values:
                          a new TV is off by default. The channel is set to three
                          and the volume level to two.
     */
                 ////NOT SURE if the below is corrext, I'm stuck
    public static final boolean DEFAULT_ON_OFF = false;  //default state is off
    public static final int DEFAULT_CHANNEL = 3;  //default channel
    public static final int DEFAULT_VOLUME = 2; //default volume






    /*
        Getters and Setters
     */

    public boolean getisOn() {
        return isOn;
    }

    public int getCurrentChannel() {
        return currentChannel;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }


    /*
        Methods
     */




}
