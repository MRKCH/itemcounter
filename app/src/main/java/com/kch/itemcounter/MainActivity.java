package com.kch.itemcounter;

import android.content.Context;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static android.R.id.list;
import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private TimeAdapter adapter;
    private TimeThread timeThread;
    private List<Bean> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listview);
        initData();
         timeThread = new TimeThread();
        timeThread.start();
        adapter = new TimeAdapter(listView);
        listView.setAdapter(adapter);

    }

    private void initData() {
        for (int i = 0; i < 30; i++) {
            Bean bean = new Bean();
            bean.setText("item" + i);
            bean.setTime(0);
            bean.setPressed(false);
            data.add(bean);
        }
    }

    class TimeAdapter extends BaseAdapter {
        private ListView listView;
        public TimeAdapter(ListView listView){
            this.listView = listView;
        }
        private LayoutInflater inflater = LayoutInflater.from(MainActivity.this);

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Object getItem(int i) {
            return (Bean)data.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(final int i, View view, ViewGroup viewGroup) {
            ViewHolder holder = null;
            final Bean bean = (Bean) getItem(i);
            if (view == null) {
                view = inflater.inflate(R.layout.item, null);
                holder = new ViewHolder();
                holder.textView = (TextView) view.findViewById(R.id.text);
                holder.button = (Button) view.findViewById(R.id.btn);
                view.setTag(holder);
            } else {
                holder = (ViewHolder) view.getTag();
            }
            timeThread.setTextViewToList(holder.textView,bean);
            holder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    bean.setPressed(true);
                    TimerEnitity enitity = new TimerEnitity(60000,bean);
                    bean.setTimerEnitity(enitity);
                    timeThread.setChangedBean(i,bean);
                }
            });
            holder.textView.setText(MyUtils.timeToString(bean.getTime()));
            holder.button.setText(data.get(i).getText());

            return view;
        }

        public   class ViewHolder {
            public TextView textView;
            public Button button;
        }
    }
}

