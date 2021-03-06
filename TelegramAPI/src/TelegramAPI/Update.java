/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TelegramAPI;

/**
 *
 * @author Daniele
 */
public class Update {
    private long update_id;
    private Message message;

    public Update(long update_id, Message message) {
        this.update_id = update_id;
        this.message = message;
    }

    public Update() {
        update_id = 0;
        message = null;
    }
    
    
    public String getUpdate(){
        return "GET_UPDATES" + "\n"
               + "update_id: " + update_id + "\n"
               + "message: " + message.getMessage() + "\n";
    }

    public long getUpdate_id() {
        return update_id;
    }

    public Message getMessage() {
        return message;
    }
    
    
    
    
}
