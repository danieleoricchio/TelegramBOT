/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TelegramAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author oricchio_daniele
 */
public class getLastMessage {

    StringBuilder sb;

    public getLastMessage() {
        try {
            URL url = new URL("https://api.telegram.org/bot5275177108:AAEdwgLIJEf04JOh3NAF4a0jCCC6QXSbohU/getUpdates");
            sb = readUrl(url);
            JSONObject obj = new JSONObject(sb.toString().trim());
            String pageName = obj.getBoolean("ok") ? "true" : "false";
            int update_id = 0;
            JSONArray arr = obj.getJSONArray("result");
            for (int i = 0; i < arr.length(); i++) {
                update_id = arr.getJSONObject(i).getInt("update_id");
            }
            URL url1 = new URL("https://api.telegram.org/bot5275177108:AAEdwgLIJEf04JOh3NAF4a0jCCC6QXSbohU/getUpdates?offset=" + (update_id));
            url1.openStream();
        } catch (IOException ex) {
            Logger.getLogger(getLastMessage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static StringBuilder readUrl(URL u) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(u.openStream()));
        StringBuilder sb = new StringBuilder();
        String inputLine = "";
        while ((inputLine = br.readLine()) != null) {
            sb.append(inputLine);
            sb.append(System.lineSeparator());
        }
        br.close();
        return sb;
    }
}
