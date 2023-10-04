/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tourui;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author adamdanielgreen
 */
public class TourManager {

    private Stop[] allStops = new Stop[100];
    private int count = 0;

    public TourManager(String fileName) {

        try {

            Scanner ScFile = new Scanner(new File(fileName));
            while (ScFile.hasNext()) {
                Scanner ScLine = new Scanner(ScFile.nextLine());
                ScLine.useDelimiter(",");
                
                String stopName = ScLine.next();
                int StopType = ScLine.nextInt();
                String RouteCode = ScLine.next();

                allStops[count] = new Stop(stopName, RouteCode,StopType);
                count++;

            }
            ScFile.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Error with File");
        }
    }

    public Route getRouteWithCode(char routeCode, boolean isCircular){
        Route r = new Route(routeCode, isCircular);
        int size = 0;
        for (int i =0; i < count; i++){
            if(allStops[i].isPartOfRoute(routeCode)){
              size++;  
            }
        }
        Stop[] routeStops = new Stop[size];
        size = 0;
        for(int j = 0; j < count; j++){
            if(allStops[j].isPartOfRoute(routeCode)) {
                routeStops[size] = allStops[j];
                size++;
            }
        }
        r.setStops(routeStops);
        
        
        return r;
    }

    public String workOutStopPoints(Route r1, Route r2) {
        String toret = "";

        int count = 0;
        Stop s = r1.getStopAt(count);
        while (s != null) {
            if (s.isPartOfRoute(r2.getRouteCode())) {
                toret += s + "\n";
            }
            count++;
            s = r1.getStopAt(count);
        }
        return toret;
    }

}
