package jef.catipay.com.cpuscheduler;

import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView mCounter,mSchedStyle,mAvgTxt,wait1,wait2,wait3,wait4,wait5;
    EditText mP1value, mP2value, mP3value, mP4value, mP5value,mQuantum;
    Button mRR,mFCFS, mSJF;
    int p1,p2,p3,p4,p5,Q,
            wp1 = 1,
            wp2 = 1,
            wp3 = 1,
            wp4 = 1,
            wp5 = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();


        mRR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RoundRobin();
            }
        });

        mFCFS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirstComeFirstServe();
            }
        });

        mSJF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShortestJobFirst();
            }
        });

    }

    private void findViews() {
         mCounter = (TextView) findViewById(R.id.mCounter);
         mP1value = (EditText) findViewById(R.id.mP1counter);
         mP2value = (EditText) findViewById(R.id.mP2counter);
         mP3value = (EditText) findViewById(R.id.mP3counter);
         mP4value = (EditText) findViewById(R.id.mP4counter);
         mP5value = (EditText) findViewById(R.id.mP5counter);
         mQuantum = (EditText) findViewById(R.id.mQuantum);
         mRR = (Button) findViewById(R.id.mRoundBtn);
         mFCFS = (Button) findViewById(R.id.mFCFSBtn);
         mSJF = (Button) findViewById(R.id.mSJFBtn);
         mAvgTxt = (TextView) findViewById(R.id.mAvgTxt);
         mSchedStyle =(TextView) findViewById(R.id.mSchedStyle);
         wait1 =(TextView) findViewById(R.id.wait1);
         wait2 =(TextView) findViewById(R.id.wait2);
         wait3 =(TextView) findViewById(R.id.wait3);
         wait4 =(TextView) findViewById(R.id.wait4);
         wait5 =(TextView) findViewById(R.id.wait5);

    }

    public void ShortestJobFirst(){
        reset();
        p1 = Integer.parseInt(mP1value.getText().toString());
        p2 = Integer.parseInt(mP2value.getText().toString());
        p3 = Integer.parseInt(mP3value.getText().toString());
        p4 = Integer.parseInt(mP4value.getText().toString());
        p5 = Integer.parseInt(mP5value.getText().toString());
        Q = Integer.parseInt(mQuantum.getText().toString());


        int

                m1 = p1,
                m2 = p2,
                m3 = p3,
                m4 = p4,
                m5 = p5;
        List<Integer> array = new ArrayList<Integer>();
        List<Integer> schedulerList = new ArrayList<Integer>();

        array.add(p1);
        array.add(p2);
        array.add(p3);
        array.add(p4);
        array.add(p5);

        Collections.sort(array);
        for(int counter: array){
            System.out.println(counter);
        }


        for(int counter: array){
            if (counter == p1){
                schedulerList.add(1);
            }
             else if (counter == p2){
                schedulerList.add(2);
            }
            else if (counter == p3){
                schedulerList.add(3);
            }
            else if (counter == p4){
                schedulerList.add(4);
            }
            else if (counter == p5){
                schedulerList.add(5);
            }
        }

        for(int counter: schedulerList){
            System.out.println(counter);
        }

        for(int scheduler: schedulerList){
            System.out.println(scheduler);
            switch (scheduler) {
                case 1: {
                    while (m1 != 0) {
                        m1--;
                        waitCounter(m1,m2,m3,m4,m5);
                    }
                    break;
                }
                case 2: {
                    while (m2 != 0) {
                        m2--;
                        waitCounter(m1,m2,m3,m4,m5);
                    }
                    break;
                }
                case 3: {
                    while (m3 != 0) {
                        m3--;
                        waitCounter(m1,m2,m3,m4,m5);
                    }
                    break;
                }
                case 4: {
                    while (m4 != 0) {
                        m4--;
                        waitCounter(m1,m2,m3,m4,m5);
                    }
                    break;
                }
                case 5: {
                    while (m5 != 0) {
                        m5--;
                        waitCounter(m1,m2,m3,m4,m5);
                    }
                    break;
                }


            }
        }

        mSchedStyle.setText("Shortest Job First");
   finished();
    }

    public void FirstComeFirstServe(){
        reset();
        p1 = Integer.parseInt(mP1value.getText().toString());
        p2 = Integer.parseInt(mP2value.getText().toString());
        p3 = Integer.parseInt(mP3value.getText().toString());
        p4 = Integer.parseInt(mP4value.getText().toString());
        p5 = Integer.parseInt(mP5value.getText().toString());
        Q = Integer.parseInt(mQuantum.getText().toString());

        int     m1 = p1,
                m2 = p2,
                m3 = p3,
                m4 = p4,
                m5 = p5;

        for (int scheduler = 1; scheduler<6; scheduler++){

            switch (scheduler % 6) {
                case 1: {
                    while (m1 != 0) {
                        m1--;
                        waitCounter(m1,m2,m3,m4,m5);
                    }
                    break;
                }
                case 2: {
                    while (m2 != 0) {
                        m2--;
                        waitCounter(m1,m2,m3,m4,m5);
                    }
                    break;
                }
                case 3: {
                    while (m3 != 0) {
                        m3--;
                        waitCounter(m1,m2,m3,m4,m5);
                    }
                    break;
                }
                case 4: {
                    while (m4 != 0) {
                        m4--;
                        waitCounter(m1,m2,m3,m4,m5);
                    }
                    break;
                }
                case 5: {
                    while (m5 != 0) {
                        m5--;
                        waitCounter(m1,m2,m3,m4,m5);
                    }
                    break;
                }


            }

        }
    mSchedStyle.setText("First Come First Serve");
    finished();
    }

    public void RoundRobin (){
    reset();
        p1 = Integer.parseInt(mP1value.getText().toString());
        p2 = Integer.parseInt(mP2value.getText().toString());
        p3 = Integer.parseInt(mP3value.getText().toString());
        p4 = Integer.parseInt(mP4value.getText().toString());
        p5 = Integer.parseInt(mP5value.getText().toString());
        Q = Integer.parseInt(mQuantum.getText().toString());

        int
                scheduler= 1,
                m1 = p1,
                m2 = p2,
                m3 = p3,
                m4 = p4,
                m5 = p5;


        while(true){

            for (int qCounter = 1; qCounter<=Q; qCounter++) {

                switch (scheduler % 6) {
                    case 1: {
                        if (m1 != 0) {
                            m1--;
                            waitCounter(m1,m2,m3,m4,m5);
                        }
                        break;
                    }
                    case 2: {
                        if (m2 != 0) {
                            m2--;
                            waitCounter(m1,m2,m3,m4,m5);
                        }
                        break;
                    }
                    case 3: {
                        if (m3 != 0) {
                            m3--;
                            waitCounter(m1,m2,m3,m4,m5);
                        }
                        break;
                    }
                    case 4: {
                        if (m4 != 0) {
                            m4--;
                            waitCounter(m1,m2,m3,m4,m5);
                        }
                        break;
                    }
                    case 5: {
                        if (m5 != 0) {
                            m5--;
                            waitCounter(m1,m2,m3,m4,m5);
                        }
                        break;
                    }


                }

            }



            scheduler++;

            if (scheduler ==6)
            {
                scheduler = 1;

            }
            if(     m1 ==0&&
                    m2 ==0&&
                    m3 ==0&&
                    m4 ==0&&
                    m5 ==0
                    ){
            break;}

        }



       mSchedStyle.setText("Round Robbin");
       finished();
    }

    private void reset() {
                wp1 = 1;
                wp2 = 1;
                wp3 = 1;
                wp4 = 1;
                wp5 = 1;
    }

    private void waitCounter(int m1,int m2,int m3,int m4,int m5) {
        if (m1!=0){
            wp1++;
        }
        if (m2!=0){
            wp2++;
        }
        if (m3!=0){
            wp3++;
        }
        if (m4!=0){
            wp4++;
        }
        if (m5!=0){
            wp5++;
        }

    }

    private void finished() {
        int wait,
        cycle = p1+p2+p3+p4+p5;
        wp1 = wp1 -p1;
        wp2 = wp2 -p2;
        wp3 = wp3 -p3;
        wp4 = wp4 -p4;
        wp5 = wp5 -p5;

        wait = (wp1+wp2+wp3+wp4+wp5)/5;

        wait1.setText(String.valueOf(wp1));
        wait2.setText(String.valueOf(wp2));
        wait3.setText(String.valueOf(wp3));
        wait4.setText(String.valueOf(wp4));
        wait5.setText(String.valueOf(wp5));
        mAvgTxt.setText("Average waiting time: "+String.valueOf(wait));
        mCounter.setText(String.valueOf(cycle)+"Cycles");
    }


}
