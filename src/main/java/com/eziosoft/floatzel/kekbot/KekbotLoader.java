package com.eziosoft.floatzel.kekbot;

public class KekbotLoader {

    // this is our init code, which the modloader calls when we go to load the mod
    public static void customInit(){
        System.out.println("Floatzel-kekbot mod");
        System.out.println("Based on Kekbot 1.6.1 by godson777");
        System.out.println("Now loading...");
        // idk what exactly we need to create a kekbot but here we go!
        System.setProperty("file.encoding", "UTF-8");

    }
}
