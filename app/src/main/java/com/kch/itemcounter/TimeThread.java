package com.kch.itemcounter;


import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kch on 2016/9/21.
 */

public class TimeThread extends Thread {
    private List<TextView> textViews;
    private List<Bean> beans = new ArrayList<>();
    private boolean isRun=true;
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            int cache = -1;
            for(int i=0;i<textViews.size();i++){
                if (beans.get(i).isPressed()) {
                    textViews.get(i).setText(MyUtils.timeToString(beans.get(i).getTimerEnitity().getsurplusTime()));
                }else textViews.get(i).setText("00:00");

            }
        }
    };
    public TimeThread(){
        textViews = new ArrayList<TextView>();
        boolean isMain = (Looper.myLooper() == Looper.getMainLooper());
        boolean isMainThread=(currentThread()==Looper.getMainLooper().getThread());
        Log.e("Looper", isMain+"");
        Log.e("Thread",isMainThread+"");
    }

    @Override
    public void run() {
        while (isRun){
            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mHandler.sendEmptyMessage(0);
        }
    }

    public void setTextViewToList(TextView textView,Bean bean){
        textViews.add(textView);
        beans.add(bean);
    }
    public void setChangedBean(int postion,Bean bean){
        beans.get(postion).setPressed(bean.isPressed());
        beans.get(postion).setTimerEnitity(bean.getTimerEnitity());
    }

}
