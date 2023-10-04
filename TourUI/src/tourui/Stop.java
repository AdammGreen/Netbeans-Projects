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
public class Stop {

    String stopName;
    String routeCodes;
    int stopType;

    public static final int STOPTYPE_CAFE = 1;
    static int STOPTYPE_SHELTER = 2;
    static int STOPTYPE_EXPRESS = 3;
    static int STOPTYPE_OTHER = 4;

    public Stop(String inStopName, String inRouteCodes, int inStopType) {
        this.stopName = inStopName;
        this.routeCodes = inRouteCodes;
        this.stopType = inStopType;

        if (inStopType == STOPTYPE_CAFE || inStopType == STOPTYPE_SHELTER || inStopType == STOPTYPE_EXPRESS) {
            stopType = inStopType;

        } else {

            stopType = STOPTYPE_OTHER;

        }

    }

    public String getStopTypeName() {

        switch (stopType) {
            case 1:
                return "cafe";
            case 2:
                return "express";
            case 3:
                return "shelter";
            case 4:
                return "other";
            default:
                return "other";

        }
    }

    public boolean isPartOfRoute(char ch) {
        if (routeCodes.contains("" + ch)) {

            return true;
        } else {
            return false;
        }

    }

    public String toString() {
        return getStopTypeName() + "/t" + stopName;
    }

}
