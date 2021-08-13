package com.example.airpollution;


public class Region{
    private String name;
    private float[] points; // borders of the region
    private double pollution;

    public Region()
    {
        name = "unknown";
        //points = new float[100];
    }

    public Region(String newName, float[] newPoints)
    {
        points = new float[newPoints.length];

        setName(newName);
        setPoints(newPoints);

    }

    public String getName() {
        return name;
    }

    public float[] getPoints() {

        float[] arr = new float[points.length];
        for(int i = 0; i < points.length; i++)
        {
            points[i]*=0.7;
            arr[i] = points[i];
        }

        return arr;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPoints(float[] newPoints) {
        for(int i = 0; i < newPoints.length; i++)
        {
            points[i] = newPoints[i];
        }
    }

    public void setPollution(double pollution) {
        this.pollution = pollution;
    }

    public double getPollution() {
        return pollution;
    }
}
