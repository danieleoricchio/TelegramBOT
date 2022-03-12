/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bot;

import TelegramAPI.Functions;
import TelegramAPI.Update;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oricchio_daniele
 */
public class SendMessage {

    List<Update> list = new ArrayList<Update>();

    public void add(Update u) throws IOException {
        list.add(u);
        sendMessage(132497411, "ciao");
    }

    public void sendMessage(long id_chat, String message) throws IOException {

        try {
            URL url = new URL("https://api.telegram.org/bot5275177108:AAEdwgLIJEf04JOh3NAF4a0jCCC6QXSbohU" + "/sendMessage?chat_id=" + id_chat + "&text=" + message);
            url.openStream();
        } catch (MalformedURLException ex) {
            Logger.getLogger(Functions.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Functions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
