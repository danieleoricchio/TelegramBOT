/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TelegramAPI;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Daniele
 */
public class Functions {

    private static BufferedReader br;
    private static From f;
    private static ArrayList<Update> updates;
    private final static String percorso = "src//bot//dati.txt";

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

    public static ArrayList<Update> getUpdates() {
        try {
            updates = new ArrayList<Update>();
            URL url = new URL("https://api.telegram.org/bot5275177108:AAEdwgLIJEf04JOh3NAF4a0jCCC6QXSbohU/getUpdates");
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
                updates.add(u);
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(Functions.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Functions.class.getName()).log(Level.SEVERE, null, ex);
        }
        return updates;
    }

    public static void checkMessage(Message msg) {
        String comando = msg.getText().substring(0, 6);
        String text = msg.getText().substring(7);
        long chat_id = msg.getChat().getId();
        if (comando.equals("/citta")) {
            sendMessage(ParseXml.getLocation(text).toString(), chat_id);
            sendLocation(ParseXml.getLocation(text), chat_id);
            saveOnCsv(chat_id, ParseXml.getLocation(text));
        }
    }

    private static void sendMessage(String message, long chat_id) {
        try {
            URL url = new URL("https://api.telegram.org/bot5275177108:AAEdwgLIJEf04JOh3NAF4a0jCCC6QXSbohU/sendMessage?chat_id=" + chat_id + "&text=" + message);
            url.openStream();
        } catch (MalformedURLException ex) {
            Logger.getLogger(Functions.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Functions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void sendLocation(Location location, long chat_id) {
        try {
            URL url = new URL("https://api.telegram.org/bot5275177108:AAEdwgLIJEf04JOh3NAF4a0jCCC6QXSbohU/sendLocation?chat_id=" + chat_id + "&latitude=" + location.getLatitude() + "&longitude=" + location.getLongitude());
            url.openStream();
        } catch (MalformedURLException ex) {
            Logger.getLogger(Functions.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Functions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void saveOnCsv(long chat_id, Location loc) {
        FileWriter fw = null;
        try {
            File file = new File(percorso);
            fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.append(chat_id + ";" + f.getFirst_name() + ";" + loc.getLatitude() + ";" + loc.getLongitude() + "\n");
            System.out.println("Utente salvato su csv");
            bw.flush();
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(Functions.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(Functions.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private static StringBuilder readUrl(URL u) {
        try {
            br = new BufferedReader(new InputStreamReader(u.openStream()));
            StringBuilder sb = new StringBuilder();
            String inputLine = "";
            while ((inputLine = br.readLine()) != null) {
                sb.append(inputLine);
                sb.append(System.lineSeparator());
            }
            br.close();
            return sb;
        } catch (IOException ex) {
            Logger.getLogger(Functions.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
