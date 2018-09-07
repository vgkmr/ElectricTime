package com.example.vgk.electrictimefinal;

public class TimeConverter {
    public static double timeWalking(double dist) {
        return dist/3.1;
    }
    public static double timeBoosted(double dist) {
        return dist/18;
    }
    public static double timeSegway(double dist) {
        return dist/12.5;
    }
    public static double timeEvolve(double dist) {
        return dist/26;
    }
    public static double timeHoverboard(double dist) {
        return dist/8;
    }


    public static double walkingTime(double time) {
        return 3.1*time;
    }
    public static double boostedTime(double time) {
        return 18*time;
    }
    public static double segwayTime(double time) {
        return 12.5*time;
    }
    public static double evolveTime(double time) {
        return 26*time;
    }
    public static double hoverboardTime(double time) {
        return 8*time;
    }



    //public static double convert (double time){

    //}



}
