/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TelegramAPI;

/**
 *
 * @author Daniele
 */
public class From {
    private long id;
    private boolean is_bot;
    private String first_name;
    private String username;
    private String language_code;

    public From(long id, boolean is_bot, String first_name, String username, String language_code) {
        this.id = id;
        this.is_bot = is_bot;
        this.first_name = first_name;
        this.username = username;
        this.language_code = language_code;
    }
    
    public String getFrom(){
        return "\n" + "id: " + id + "\n" 
               + "is_bot: " + is_bot + "\n"
               + "first_name: " + first_name + "\n"
               + "username: " + username + "\n"
               + "language_code: " + language_code + "\n";
    }

    public String getFirst_name() {
        return first_name;
    }
}
