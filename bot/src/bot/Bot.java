/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bot;

import TelegramAPI.*;
import java.util.Scanner;

/**
 *
 * @author Daniele
 */
public class Bot {

    /**
     * @param args the command line arguments
     */
    private static final String token = "5275177108:AAEdwgLIJEf04JOh3NAF4a0jCCC6QXSbohU";
    private static final long id_chat = 132497411;
    private static boolean exit = false;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Inserisci 'getMe' per vedere le informazioni sul bot" + "\n"
                + "Inserisci 'getUpdates' per vedere le informazioni sulla cronologia dei messaggi della chat" + "\n"
                + "Inserisci 'send' per inviare un messaggio" + "\n"
                + "Scrivere esc per fermare l'applicazione" + "\n");
        while (true) {
            String choice = s.nextLine();
            switch (choice) {
                case "getMe":
                    Functions.getMe("https://api.telegram.org/bot" + token + "/getMe");
                    break;
                case "getUpdates":
                    Functions.getUpdates("https://api.telegram.org/bot" + token + "/getUpdates");
                    break;
                case "send":
                    System.out.println("Inserisci messaggio da inviare");
                    String msg = s.nextLine();
                    Functions.sendMessage(token, id_chat, msg);
                    break;
                case "esc":
                    System.exit(0);
                default:
                    break;
            }
        }
    }

}
