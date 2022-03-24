/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TelegramAPI;

/**
 *
 * @author Daniele
 */
public class GetDistance {
    public static double GetDistanceKilometers(Location location1, Location location2) {
        double R = 6371.0088;
        Double lat1 = location1.getLatitude();
        Double lon1 = location1.getLongitude();
        Double lat2 = location2.getLatitude();
        Double lon2 = location2.getLongitude();
        Double latDistance = Math.toRadians((lat2 - lat1));
        Double lonDistance = Math.toRadians((lon2 - lon1));
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);
        double a = haversin(latDistance) + Math.cos(lat1) * Math.cos(lat2) * haversin(lonDistance);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c;
    }
    private static double haversin(double val){
        return Math.pow(Math.sin(val / 2), 2);
    }
}
