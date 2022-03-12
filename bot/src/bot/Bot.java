/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bot;

import TelegramAPI.*;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Daniele
 */
public class Bot {

    public static void main(String[] args) throws IOException {
        getLastMessage glm = new getLastMessage();
        ThreadUpdates tu = new ThreadUpdates();
        tu.start();
    }
}
