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

    public static void getMe(String token) {
        try {
            URL url = new URL(token);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));

            StringBuilder sb = new StringBuilder();

            String inputLine;
            while ((inputLine = br.readLine()) != null) {
                sb.append(inputLine);
                sb.append(System.lineSeparator());
            }

            br.close();

            JSONObject obj = new JSONObject(sb.toString().trim());
            String pageName = obj.getBoolean("ok") ? "true" : "false";
            System.out.println(pageName);

            String username = obj.getJSONObject("result").getString("username");
            System.out.println(username);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Functions.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Functions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
