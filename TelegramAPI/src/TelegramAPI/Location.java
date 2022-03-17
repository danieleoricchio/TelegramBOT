/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TelegramAPI;

/**
 *
 * @author oricchio_daniele
 */
public class Location {
    private double lat, lon;
    private String display_name;

    public Location(double lat, double lon, String display_name) {
        this.lat = lat;
        this.lon = lon;
        this.display_name = display_name;
    }

    @Override
    public String toString() {
        return lat + ", " + lon + ", " + display_name;
    }

    public double getLatitude() {
        return lat;
    }

    public double getLongitude() {
        return lon;
    }
    
    
}
