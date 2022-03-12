/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bot;

import TelegramAPI.Functions;
import TelegramAPI.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oricchio_daniele
 */
public class ThreadUpdates extends Thread {

    private ArrayList<Update> messaggi = new ArrayList<Update>();
    SendMessage sm = new SendMessage();

    @Override
    public void run() {
        try {
            while (true) {
                messaggi = Functions.getUpdates();
                int size = messaggi.size();
                for (int i = 0; i < size; i++) {
                    sm.add(messaggi.get(i));
                }
                Thread.sleep(150);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadUpdates.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ThreadUpdates.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
