package com.alex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static Scanner numberScanner = new Scanner(System.in);
    public static Scanner stringScanner = new Scanner(System.in);

    public static void main(String[] args) {

        LakeTimes lakeTimes = new LakeTimes();

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
            lakeTimes.updateLakeHashmap(lake, lakeLap);


        }

        //figure out the fastest time for each lake and make a new hashmap with those values
        HashMap<String, Double> fastestLakeTimes = lakeTimes.getFastestLakeTimes();

        //display each lake and the fastest time for the lake
        System.out.println("Fastest times:");
        for (String s : fastestLakeTimes.keySet()){
            System.out.println(s +  ", " + fastestLakeTimes.get(s));
        }

        //scanners close; don't put stuff past here in main code block
        stringScanner.close();
        numberScanner.close();

    }
}
