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
public class TourUI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        TourManager sm = new TourManager("data.txt");

        Route routeR = sm.getRouteWithCode('R', true);
        Route routeY = sm.getRouteWithCode('Y', false);

        System.out.println(routeR);
        System.out.println(routeY);

        System.out.println(sm.workOutStopPoints(routeR, routeY));
    }
}
