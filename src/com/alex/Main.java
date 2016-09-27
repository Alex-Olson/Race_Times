package com.alex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static Scanner numberScanner = new Scanner(System.in);
    public static Scanner stringScanner = new Scanner(System.in);

    public static void main(String[] args) {

        HashMap<String, ArrayList<Double>> lakeTimes = new HashMap<>();

        String lake;
        double lakeLap;

        while (true) {
            System.out.println("What lake are you running a lap around? Leave blank to stop adding laps.");
            lake = stringScanner.nextLine();
            if (lake.equals("")){
                break;
            }

            System.out.println("How long did it take you to run your lap?");
            lakeLap = numberScanner.nextDouble();


            //update the lake time hashmap with the new time
            lakeTimes = updateLakeHashmap(lake, lakeLap, lakeTimes);


        }

        //figure out the fastest time for each lake and make a new hashmap with those values
        HashMap<String, Double> fastestLakeTimes = getFastestLakeTimes(lakeTimes);

        //display each lake and the fastest time for the lake
        System.out.println("Fastest times:");
        for (String s : fastestLakeTimes.keySet()){
            System.out.println(s +  ", " + fastestLakeTimes.get(s));
        }

        //scanners close; don't put stuff past here in main code block
        stringScanner.close();
        numberScanner.close();

    }


    public static HashMap<String, ArrayList<Double>> updateLakeHashmap(String lake, double lakeLap, HashMap<String, ArrayList<Double>> lakeTimes){
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

    public static HashMap<String, Double> getFastestLakeTimes(HashMap<String, ArrayList<Double>> lakeTimes){
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
