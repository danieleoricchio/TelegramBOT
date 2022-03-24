/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TelegramAPI;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniele
 */
public class Utente {

    private long chat_id;
    private String nome;
    private Location location;

    public Utente(long chat_id, String nome, Location location) throws IOException {
        this.chat_id = chat_id;
        this.nome = nome;
        this.location = location;
    }
    public Location getLocation() {
        return location;
    }
}
