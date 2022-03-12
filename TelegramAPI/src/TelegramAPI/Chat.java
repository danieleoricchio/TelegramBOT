/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TelegramAPI;

/**
 *
 * @author Daniele
 */
public class Chat {
    private long id;
    private String first_name;
    private String username;
    private String type;

    public Chat(long id, String first_name, String username, String type) {
        this.id = id;
        this.first_name = first_name;
        this.username = username;
        this.type = type;
    }
    
    public String getChat(){
        return "\n" + "id: " + id + "\n" 
               + "first_name: " + first_name + "\n"
               + "username: " + username + "\n"
               + "type: " + type + "\n";
    }

    public long getId() {
        return id;
    }
}
