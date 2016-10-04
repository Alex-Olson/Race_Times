package com.alex;


import java.util.ArrayList;
import java.util.HashMap;

public class LakeTimes {

    private HashMap<String, ArrayList<Double>> lakeTimes;


    public LakeTimes(){
        lakeTimes = new HashMap<String, ArrayList<Double>>();
    }


    public HashMap<String, ArrayList<Double>> updateLakeHashmap(String lake, double lakeLap){
        ArrayList<Double> lapList = new ArrayList<>();

        //if theres already times for this lake key, get the list before adding the new one
        if (lakeTimes.containsKey(lake)){
            lapList = lakeTimes.get(lake);
        }
        //add the newest time to the list and update the hashmap
        lapList.add(lakeLap);
        lakeTimes.put(lake, lapList);

        return lakeTimes;
    }

    public HashMap<String, Double> getFastestLakeTimes(){
        HashMap<String, Double> fastestLakeTimes = new HashMap<String, Double>();

        for (String s : lakeTimes.keySet()){
            ArrayList<Double> lapList = lakeTimes.get(s);
            double fastestTime = Double.POSITIVE_INFINITY;
            //check the list for the fastest time for each lake
            for (double d : lapList){
                if (fastestTime > d){
                    fastestTime = d;
                }
            }
            //add the fastest time of each lake into the hashmap
            fastestLakeTimes.put(s, fastestTime);
        }
        return fastestLakeTimes;
    }




}
