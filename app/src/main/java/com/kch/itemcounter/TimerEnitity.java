package com.kch.itemcounter;

import android.os.CountDownTimer;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by kch on 2016/9/21.
 */

public class TimerEnitity {
    private int timeLength;
    private MyTimer timer;
    private Bean bean;

    public TimerEnitity(int timeLength,Bean bean) {
        this.timeLength = timeLength;
        this.bean=bean;
        timer =  new MyTimer(timeLength,999);
        timer.start();

    }
        public int  getsurplusTime(){
            return this.bean.getTime();
        }
    public void setTimeLength(int timeLength) {
        this.timeLength = timeLength;
    }
    public class MyTimer extends CountDownTimer{


        public MyTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long l) {
            Log.e("time",l+"");
                bean.setTime((int) l);

        }

        @Override
        public void onFinish() {
            bean.setTime(0);
        }
    }

}

