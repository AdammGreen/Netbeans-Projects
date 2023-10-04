/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tourui;

/**
 *
 * @author adamdanielgreen
 */
public class Route {

    private char routeCode;
    private boolean isCircular;
    private Stop[] stops;
    
    public Route(char inRouteCode, boolean inIsCircular) {
        this.routeCode = inRouteCode;
        this.isCircular = inIsCircular;
    }

    public void setStops(Stop[] stops) {
        this.stops = stops;
    }

    public char getRouteCode() {
        return routeCode;
    }

    public Stop getStopAt(int num) {

        if (num >= 0 && num < stops.length) {
            return stops[num];

        } else {
            return null;
        }
    }

    public String ToString() {
        String toRet = routeCode + " - ";

        if (stops.length == 0) {
            toRet += "inVALID";
        } else {
            toRet += "linear";
        }

        for (int i = 0; i < stops.length; i++) {
            toRet += "\n" + (i + 1) + "\t" + stops[i];
        }
        if (isCircular) {
            toRet += "\n -> \t" + stops[0];
        } else {
            for (int i = stops.length - 2; i >= 0; i--) {
                toRet += "\n ->" + (i + 1) + "\t" + stops[i];
            }
        }

        return toRet;
    }

}
