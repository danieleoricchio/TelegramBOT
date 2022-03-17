/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bot;

import TelegramAPI.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GetLastUpdate_thread extends Thread {
   
    private ArrayList<Update> oldUpdates, newUpdates;

    public GetLastUpdate_thread() {
        oldUpdates = Functions.getUpdates();
    }
    
    @Override
    public void run() {
        while (true) {
            try {
                newUpdates = Functions.getUpdates();
                if(newUpdates.size() != oldUpdates.size()){
                    Functions.checkMessage(newUpdates.get(newUpdates.size() - 1).getMessage());
                }
                Thread.sleep(300);
            } catch (InterruptedException ex) {
                Logger.getLogger(GetLastUpdate_thread.class.getName()).log(Level.SEVERE, null, ex);
            }
            oldUpdates = newUpdates;
        }
    }
}
