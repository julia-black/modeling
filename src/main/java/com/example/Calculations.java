package com.example;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;

public class Calculations {

    public ArrayList<Pair> modeling1_1_12() {

        double x0 = 0.1;
        double dt = 0.001;
        double t = 0;
        double countCalculate = 10;
        double x = x0;
        double lambda = 0.5;
        ArrayList<Pair> listXT = new ArrayList<Pair>();

        while (t <= countCalculate) {
            listXT.add(new Pair(x, t));
            System.out.println(x + " " + t);
            x = x + dt * (-lambda * x);
            t += dt;
        }
        return listXT;
    }

    public ArrayList<Pair> modeling_1_2_24(double xk) {
        double dt = 0.1;
        double t = 0;
        double countCalculate = 100;
        double x = xk;
        double y = 1;
        double xn;
        double yn;
        double a1 = 0.1;
        double a2 = 0.5;
        double b1 = 0.4;
        double b2 = 0.2;
        double X = 100;
        double Y = 100;

        ArrayList<Pair> listXY = new ArrayList<Pair>();
        while (t <= countCalculate) {
            listXY.add(new Pair(x, y));
            xn = x + dt * a1 * x * (X - (x + b1 * y)) / X;
            yn = y + dt * a2 * y * (Y - (y + b2 * x)) / Y;
            t += dt;
            x = xn;
            y = yn;
        }
        return listXY;
    }
}
