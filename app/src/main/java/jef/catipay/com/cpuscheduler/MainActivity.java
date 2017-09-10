package jef.catipay.com.cpuscheduler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView mCounter;
    EditText mP1value, mP2value, mP3value, mP4value, mP5value,mQuantum;
    Button mRR,mFCFS, mSJF;
    int p1,p2,p3,p4,p5,Q;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        p1 = Integer.parseInt(mP1value.getText().toString());
        p2 = Integer.parseInt(mP2value.getText().toString());
        p3 = Integer.parseInt(mP3value.getText().toString());
        p4 = Integer.parseInt(mP4value.getText().toString());
        p5 = Integer.parseInt(mP5value.getText().toString());
        Q = Integer.parseInt(mQuantum.getText().toString());

        mRR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RoundRobin(p1,p2,p3,p4,p5,Q);
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
    }

    public void RoundRobin (int p1, int p2, int p3, int p4, int p5, int Q){
    int counter,counterIN, counted = p1+p2+p3+p4+p5, wp1,wp2,wp3,wp4,wp5;


            for (counterIN =0; counterIN<Q; counterIN++){
             System.out.println("count");

            }


           for ( counter = 0; counter <=counted; counter++){




           }


        mCounter.setText(String.valueOf(counted)+" Cycle/s");
    }


}
