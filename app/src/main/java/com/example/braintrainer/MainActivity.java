package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView timer;
    TextView prob;
    TextView score;
    TextView done;
    TextView status;
    Button go;
    Button play;
    GridLayout grid;
    Button op1;
    Button op2;
    Button op3;
    Button op4;
    int totalScore=0;
    int correctScore=0;
    int correctTag;
    public void setAll(){
        int i,j,sol;
        i=(int)(Math.random()*20);
        j=(int)(Math.random()*20);
        sol=i+j;
        prob.setText(Integer.toString(i)+"+"+Integer.toString(j));
        correctTag=(int)(Math.random()*4);
        setOptions(sol);

    }
    public void setOptions(int sol)
    {
        int no1,no2,no3;
        no1=(int)(Math.random()*40);
        while (no1==sol)
        {
            no1=(int)(Math.random()*40);
        }
        no2=(int)(Math.random()*40);
        while(no2==sol || no2==no1)
        {
            no2=(int)(Math.random()*40);
        }
        no3=(int)(Math.random()*40);
        while(no3==sol || no3==no1 || no3==no2)
        {
            no3=(int)(Math.random()*40);
        }

        switch (correctTag)
        {
            case 0: op1.setText(Integer.toString(sol));
                    op2.setText(Integer.toString(no1));
                    op3.setText(Integer.toString(no2));
                    op4.setText(Integer.toString(no3));
                    break;
            case 1: op1.setText(Integer.toString(no1));
                    op2.setText(Integer.toString(sol));
                    op3.setText(Integer.toString(no2));
                    op4.setText(Integer.toString(no3));
                    break;
            case 2: op1.setText(Integer.toString(no1));
                    op2.setText(Integer.toString(no2));
                    op3.setText(Integer.toString(sol));
                    op4.setText(Integer.toString(no3));
                    break;
            case 3: op1.setText(Integer.toString(no1));
                    op2.setText(Integer.toString(no2));
                    op3.setText(Integer.toString(no3));
                    op4.setText(Integer.toString(sol));
                    break;
        }
    }
    public void goF(View view)
    {
        go.setVisibility(View.INVISIBLE);
        timer.setVisibility(View.VISIBLE);
        prob.setVisibility(View.VISIBLE);
        score.setVisibility(View.VISIBLE);
        grid.setVisibility(View.VISIBLE);
        done.setVisibility(View.INVISIBLE);
        play.setVisibility(View.INVISIBLE);
        status.setText(null);
        status.setVisibility(View.VISIBLE);
        op1.setClickable(true);
        op2.setClickable(true);
        op3.setClickable(true);
        op4.setClickable(true);
        totalScore=0;
        correctScore=0;
        score.setText("");
        new CountDownTimer(30100,1000){
            @Override
            public void onTick(long millisUntilFinished) {
                timer.setText(Integer.toString((int)millisUntilFinished/1000)+"s");
            }

            @Override
            public void onFinish() {
                status.setVisibility(View.INVISIBLE);
                done.setVisibility(View.VISIBLE);
                play.setVisibility(View.VISIBLE);
                op1.setClickable(false);
                op2.setClickable(false);
                op3.setClickable(false);
                op4.setClickable(false);

            }
        }.start();
        setAll();

    }
    public void ansF(View view)
    {
        Button ans=(Button)view;
        if(String.valueOf(ans.getTag()).equals(Integer.toString(correctTag)))
        {
            correctScore++;
            totalScore++;
            status.setText("CORRECT!");
        }
        else
        {
            totalScore++;
            status.setText("WRONG!");
        }
        score.setText(Integer.toString(correctScore)+"/"+Integer.toString(totalScore));
        setAll();

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timer=(TextView)findViewById(R.id.timer);
        prob=(TextView)findViewById(R.id.prob);
        score=(TextView)findViewById(R.id.score);
        done=(TextView)findViewById(R.id.done);
        go=(Button)findViewById(R.id.go);
        play=(Button)findViewById(R.id.play);
        grid=findViewById(R.id.grid);
        op1=(Button)findViewById(R.id.op1);
        op2=(Button)findViewById(R.id.op2);
        op3=(Button)findViewById(R.id.op3);
        op4=(Button)findViewById(R.id.op4);
        status=(TextView)findViewById(R.id.status);
    }
}
