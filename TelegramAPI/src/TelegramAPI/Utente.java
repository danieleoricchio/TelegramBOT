/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TelegramAPI;

/**
 *
 * @author Daniele
 */
public class Utente {
    private long chat_id;
    private String nome;
    private double lat;
    private double lon;

    public Utente(long chat_id, String nome, double lat, double lon) {
        this.chat_id = chat_id;
        this.nome = nome;
        this.lat = lat;
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }
        
    
}
