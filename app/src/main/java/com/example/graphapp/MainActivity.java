package com.example.graphapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create onClickListener when confirm plot -> check for null,plot graph
        Button plot = (Button) findViewById(R.id.plot);
        plot.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Variables to plot to graph
                int x1Graph = 0, x2Graph = 0, x3Graph, x4Graph, x5Graph, x6Graph;
                int y1Graph = 0, y2Graph = 0, y3Graph, y4Graph, y5Graph, y6Graph;

                //getting from xml file
                EditText x1 = (EditText) findViewById(R.id.x1);
                EditText x2 = (EditText) findViewById(R.id.x2);
                EditText x3 = (EditText) findViewById(R.id.x3);
                EditText x4 = (EditText) findViewById(R.id.x4);
                EditText x5 = (EditText) findViewById(R.id.x5);
                EditText x6 = (EditText) findViewById(R.id.x6);

                EditText y1 = (EditText) findViewById(R.id.y1);
                EditText y2 = (EditText) findViewById(R.id.y2);
                EditText y3 = (EditText) findViewById(R.id.y3);
                EditText y4 = (EditText) findViewById(R.id.y4);
                EditText y5 = (EditText) findViewById(R.id.y5);
                EditText y6 = (EditText) findViewById(R.id.y6);

                //direct parsing experiment without method
                x1Graph = Integer.parseInt(x1.getText().toString());
                x2Graph = Integer.parseInt(x2.getText().toString());
                x3Graph = Integer.parseInt(x3.getText().toString());
                x4Graph = Integer.parseInt(x4.getText().toString());
                x5Graph = Integer.parseInt(x5.getText().toString());
                x6Graph = Integer.parseInt(x6.getText().toString());

                y1Graph = Integer.parseInt(y1.getText().toString());
                y2Graph = Integer.parseInt(y2.getText().toString());
                y3Graph = Integer.parseInt(y3.getText().toString());
                y4Graph = Integer.parseInt(y4.getText().toString());
                y5Graph = Integer.parseInt(y5.getText().toString());
                y6Graph = Integer.parseInt(y6.getText().toString());

                //****a null check and array are needed to finish this off
                //**** try catch block with arithmetic error catch
                int[] xCoordinates = {x1Graph, x2Graph, x3Graph, x4Graph, x5Graph, x6Graph};
                int[] yCoordinates = {y1Graph, y2Graph, y3Graph, y4Graph, y5Graph, y6Graph};

                //Implement for loop or condition when i =5 to start data points
                /*
                for(int i = 0; i < 6; i++){
                    if( xCoordinates[i] == null || yCoordinates[i] == null){
                        //error message
                        Toast.makeText(this, "Enter value in all fields", Toast.LENGTH_SHORT).show();
                    }else if( i == 5){
                        //use code to finish of process
                    }
                }
                   */

                // instantiating new dataPoints
                DataPoint Point1 = new DataPoint(xCoordinates[0], yCoordinates[0]);
                DataPoint Point2 = new DataPoint(xCoordinates[1], yCoordinates[1]);
                DataPoint Point3 = new DataPoint(xCoordinates[2], yCoordinates[2]);
                DataPoint Point4 = new DataPoint(xCoordinates[3], yCoordinates[3]);
                DataPoint Point5 = new DataPoint(xCoordinates[4], yCoordinates[4]);
                DataPoint Point6 = new DataPoint(xCoordinates[5], yCoordinates[5]);

                GraphView graph = (GraphView) findViewById(R.id.graph);
                LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[] {
//                        new DataPoint(2, 2),
//                        new DataPoint(3, 4),
                        Point1,
                        Point2
                });
                graph.addSeries(series);
            }
        });
    }
    //method to transfer user input onto graph
//    protected void convertToVariable(EditText xy, int xyGraph) {
//        if(xy.getText().toString().isEmpty()) {
//            //***********make a Toast
//        } else {
//            xyGraph = Integer.parseInt(xy.getText().toString());
//        }
//    }
}
