/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TelegramAPI;

/**
 *
 * @author Daniele
 */
public class User {
    private long id;
    private boolean is_bot;
    private String first_name;
    private String username;
    private boolean can_join_groups;
    private boolean can_read_all_group_messages;
    private boolean supports_inline_queries;

    public User(long id, boolean is_bot, String first_name, String username, boolean can_join_groups, boolean can_read_all_group_messages, boolean supports_inline_queries) {
        this.id = id;
        this.is_bot = is_bot;
        this.first_name = first_name;
        this.username = username;
        this.can_join_groups = can_join_groups;
        this.can_read_all_group_messages = can_read_all_group_messages;
        this.supports_inline_queries = supports_inline_queries;
    }
    
    public String getUser(){
        return "GET_ME" + "\n" 
               + "id: " + id + "\n" 
               + "is_bot: " + is_bot + "\n"
               + "first_name: " + first_name + "\n"
               + "username: " + username + "\n"
               + "can_join_groups: " + can_join_groups + "\n"
               + "can_read_all_group_messages: " + can_read_all_group_messages + "\n"
               + "supports_inline_queries: " + supports_inline_queries + "\n";
    }

    public String getUsername() {
        return username;
    }    
}
