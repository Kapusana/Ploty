package com.example.graphapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;

import static android.widget.Toast.makeText;

public class MainActivity extends AppCompatActivity {
    Toast toast;//toast apparently cant be declared in catch block*****

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toast = Toast.makeText(this, "Please enter a value in all fields", Toast.LENGTH_LONG);

        //Create onClickListener when confirm plot -> check for null,plot graph
        Button plot = (Button) findViewById(R.id.plot);
        plot.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Variables to plot to graph
                int x1Graph = 0, x2Graph = 0, x3Graph = 0, x4Graph = 0, x5Graph = 0, x6Graph = 0;
                int y1Graph = 0, y2Graph = 0, y3Graph = 0, y4Graph = 0, y5Graph = 0, y6Graph = 0;

                int[] xCoordinates = {x1Graph, x2Graph, x3Graph, x4Graph, x5Graph, x6Graph};
                int[] yCoordinates = {y1Graph, y2Graph, y3Graph, y4Graph, y5Graph, y6Graph};

                //getting from xml file
                //********* create arrayList and do null check for empty edit text
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

                //ArrayLists
                ArrayList<EditText> xCoordinatesList = new ArrayList<EditText>();
                xCoordinatesList.add(x1);
                xCoordinatesList.add(x2);
                xCoordinatesList.add(x3);
                xCoordinatesList.add(x4);
                xCoordinatesList.add(x5);
                xCoordinatesList.add(x6);

                ArrayList<EditText> yCoordinatesList = new ArrayList<EditText>();
                yCoordinatesList.add(y1);
                yCoordinatesList.add(y2);
                yCoordinatesList.add(y3);
                yCoordinatesList.add(y4);
                yCoordinatesList.add(y5);
                yCoordinatesList.add(y6);

                //ArrayList<DataPoint> dataPointArrayList = new ArrayList<DataPoint>();

                //for loop to validate
                //parse only when validated*********
                //it still tries to plot and run lines below despite conditions
                for (int i = 0; i < xCoordinatesList.size(); i++) { //converts editTexts in list to try and validates string
                    if (xCoordinatesList.get(i).getText().toString().matches("") || yCoordinatesList.get(i).getText().toString().matches("")) {
                        toast.show();
                    }else if(i < xCoordinatesList.size()){
                        //parses to int when validated using the method
                        convertToInt(xCoordinatesList.get(i), xCoordinates[i]);
                        convertToInt(yCoordinatesList.get(i), yCoordinates[i]);
                    }else if(i == xCoordinatesList.size()-1){ //when the counter reaches last number and parses then its plotting time
                        try{
                            DataPoint Point1 = new DataPoint(xCoordinates[0], yCoordinates[0]);
                            DataPoint Point2 = new DataPoint(xCoordinates[1], yCoordinates[1]);
                            DataPoint Point3 = new DataPoint(xCoordinates[2], yCoordinates[2]);
                            DataPoint Point4 = new DataPoint(xCoordinates[3], yCoordinates[3]);
                            DataPoint Point5 = new DataPoint(xCoordinates[4], yCoordinates[4]);
                            DataPoint Point6 = new DataPoint(xCoordinates[5], yCoordinates[5]);

                            GraphView graph = (GraphView) findViewById(R.id.graph);
                            LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[] {
                                new DataPoint(2, 2),
                                new DataPoint(3, 4),
//                                    Point1,
//                                    Point2,
//                                    Point3,
//                                    Point4,
//                                    Point5,
//                                    Point6
                            });
                            graph.addSeries(series);

                        }catch(NumberFormatException e){
                            toast.show();
                        }
                    }
                }
                //remember that the coordinates still stay at zero when its empty


                //maybe do validation as string before its parsed????????
                //use try catch block after verifying attemps************
            }
        });
    }
    //Converts edit text values from arrayList to String then to int
    protected void convertToInt(EditText xy, int xyGraph) {
        xyGraph = Integer.parseInt(xy.getText().toString());
    }
}
