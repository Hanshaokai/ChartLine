package com.example.lxr_yfb.tendchart2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    BrokenLineGraphView brokenLineGraphView;
    Boolean aBoolean = false;
    private int i;
    private int[] y;
    private String[] x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        brokenLineGraphView = (BrokenLineGraphView) findViewById(R.id.scoreTrend);
        Button bt = (Button) findViewById(R.id.bt);
        y = new int[32];
        x = new String[32];
        i = 0;
        for (int j = 1; j < 33; j++) {
            y[j - 1] = j;
            x[j - 1] = j + "";
        }

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == 0) {
                    i++;
                    brokenLineGraphView.setScore(new int[]{45, 20, 5, 0}, new String[]{"2017-3-7", "2017-3-8", "2017-3-9", "2017-3-10"});
                    return;
                }
                if (i == 1) {
                    i++;
                    brokenLineGraphView.setScore(new int[]{600, 500, 800, 1000}, new String[]{"2017-3-7", "2017-3-8", "2017-3-9", "2017-3-10"});
                    return;
                }
                if (i == 2) {
                    i++;
                    brokenLineGraphView.setScore(new int[]{22, 28, 12, 38}, new String[]{"2017-3-7", "2017-3-8", "2017-3-9","2017-3-9"});
                    return;
                }
                if (i == 3) {
                    i++;
                    brokenLineGraphView.setScore(new int[]{99, 55, 66, 22, 20, 56, 88}, new String[]{"2017-3-7", "2017-3-8", "2017-3-9", "2017-3-10", "2017-3-10", "2017-3-10", "2017-3-10"});
                    return;
                }
                if (i == 4) {
                    brokenLineGraphView.setScore(y, x);
                    i = 0;
                }

            }
        });


















       /* HistoryLine myView = new HistoryLine(this, 8);
        LinearLayout viewById = (LinearLayout) findViewById(R.id.ll);
        myView.SetInfo(
                new String[]{"0", "50", "100", "150", "200"},   //Y轴刻度
                new String[]{"43", "140", "50", "26", "89", "68",}  //数据

        );
        viewById.addView(myView);
*/

    }

    public void countNum() {


    }


}
