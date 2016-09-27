package com.kch.itemcounter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kch on 2016/9/20.
 */

public class Bean {
    private String text;
    private int  time;
    private boolean isPressed;
    private TimerEnitity timerEnitity;

    public TimerEnitity getTimerEnitity() {
        return timerEnitity;
    }

    public void setTimerEnitity(TimerEnitity timerEnitity) {
        this.timerEnitity = timerEnitity;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getTime() {
        return time;
    }

    public boolean isPressed() {
        return isPressed;
    }

    public void setPressed(boolean isPressed) {
        this.isPressed = isPressed;
    }

    public void setTime(int time) {
        this.time = time;
    }

}
