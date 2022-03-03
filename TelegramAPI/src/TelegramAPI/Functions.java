/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TelegramAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.*;

/**
 *
 * @author Daniele
 */
public class Functions {

    private static BufferedReader br;
    private static From f;

    public static void getMe(String token) {
        try {
            URL url = new URL(token);
            StringBuilder sb = readUrl(url);
            JSONObject obj = new JSONObject(sb.toString().trim());
            String pageName = obj.getBoolean("ok") ? "true" : "false";
            User u = new User(obj.getJSONObject("result").getLong("id"),
                    obj.getJSONObject("result").getBoolean("is_bot"),
                    obj.getJSONObject("result").getString("first_name"),
                    obj.getJSONObject("result").getString("username"),
                    obj.getJSONObject("result").getBoolean("can_join_groups"),
                    obj.getJSONObject("result").getBoolean("can_read_all_group_messages"),
                    obj.getJSONObject("result").getBoolean("supports_inline_queries"));

            System.out.println(u.getUser());
        } catch (MalformedURLException ex) {
            Logger.getLogger(Functions.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Functions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void getUpdates(String token) {
        try {
            URL url = new URL(token);
            StringBuilder sb = readUrl(url);
            JSONObject obj = new JSONObject(sb.toString().trim());
            String pageName = obj.getBoolean("ok") ? "true" : "false";

            JSONArray arr = obj.getJSONArray("result");
            for (int i = 0; i < arr.length(); i++) {
                Chat c = new Chat(arr.getJSONObject(i).getJSONObject("message").getJSONObject("chat").getLong("id"),
                        arr.getJSONObject(i).getJSONObject("message").getJSONObject("chat").getString("first_name"),
                        arr.getJSONObject(i).getJSONObject("message").getJSONObject("chat").getString("username"),
                        arr.getJSONObject(i).getJSONObject("message").getJSONObject("chat").getString("type"));

                f = new From(arr.getJSONObject(i).getJSONObject("message").getJSONObject("from").getLong("id"),
                        arr.getJSONObject(i).getJSONObject("message").getJSONObject("from").getBoolean("is_bot"),
                        arr.getJSONObject(i).getJSONObject("message").getJSONObject("from").getString("first_name"),
                        arr.getJSONObject(i).getJSONObject("message").getJSONObject("from").getString("username"),
                        arr.getJSONObject(i).getJSONObject("message").getJSONObject("from").getString("language_code"));

                Message m = new Message(arr.getJSONObject(i).getJSONObject("message").getLong("message_id"), f, c,
                        arr.getJSONObject(i).getJSONObject("message").getLong("date"),
                        arr.getJSONObject(i).getJSONObject("message").getString("text"));

                Update u = new Update(arr.getJSONObject(i).getLong("update_id"), m);
                System.out.println(u.getUpdate());
            }

        } catch (MalformedURLException ex) {
            Logger.getLogger(Functions.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Functions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void sendMessage(String token, long id_chat, String message) {
        try {
            if (f != null) {
                URL url = new URL("https://api.telegram.org/bot" + token + "/sendMessage?chat_id=" + id_chat + "&text=" + message);
                url.openStream();
            }
            System.out.println("Messaggio inviato a " + f.getFirst_name());
        } catch (MalformedURLException ex) {
            Logger.getLogger(Functions.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Functions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static StringBuilder readUrl(URL u) throws IOException {
        br = new BufferedReader(new InputStreamReader(u.openStream()));
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
