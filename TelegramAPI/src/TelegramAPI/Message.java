/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TelegramAPI;

import java.util.Date;

/**
 *
 * @author Daniele
 */
class Message {
    private long message_id;
    private From f;
    private Chat c;
    private long date;
    private String text;

    public Message(long message_id, From f, Chat c, long date, String text) {
        this.message_id = message_id;
        this.f = f;
        this.c = c;
        this.date = date;
        this.text = text;
    }
    
    public String getMessage(){
        return "MESSAGE" + "\n"
               + "message_id: " + message_id + "\n"
               + "FROM " + f.getFrom() + "\n"
               + "CHAT " + c.getChat() + "\n"
               + "date: " + new Date(Long.parseLong(date+"") * 1000) + "\n"
               + "text: " + text + "\n"; 
    }

    public String getText() {
        return text;
    }

    public Chat getChat() {
        return c;
    }
}
