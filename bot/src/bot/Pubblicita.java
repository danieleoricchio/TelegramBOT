/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bot;

import TelegramAPI.*;

/**
 *
 * @author Daniele
 */
public class Pubblicita {
    
    private String citta;
    private int raggio;
    private String testo;
    private Location locGestore;

    public Pubblicita(String citta, int raggio, String testo) {
        this.citta = citta;
        this.raggio = raggio;
        this.testo = testo;
        locGestore = ParseXml.getLocation(citta);
    }

    public Location getLocGestore() {
        return locGestore;
    }
    
    
}
