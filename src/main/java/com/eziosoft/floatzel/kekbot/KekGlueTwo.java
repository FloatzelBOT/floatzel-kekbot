package com.eziosoft.floatzel.kekbot;

import com.eziosoft.floatzel.Util.Error;
import com.jagrosh.jdautilities.command.CommandEvent;

import java.lang.reflect.Field;

public class KekGlueTwo {

    public static void throwException(Throwable t, KekGlue.CommandEvent fuck, String trash){
        // disregard the string and just throw the rest
        throwException(t, fuck);
    }

    public static void throwException(Throwable t, KekGlue.CommandEvent fuck){
        // first we need to extract the command event
        // this can be accomplished with some java fuckery
        // namely, raw class IO shit, which means we need the raw class type!
        Class<?> type = fuck.getClass();
        // with this, we can access its fields directly!
        // we're after its "e" field
        CommandEvent baseevent;
        try {
            Field meme = type.getDeclaredField("e");
            meme.setAccessible(true);
            // now we can read it entirely!
            baseevent = (CommandEvent) meme.get(fuck);
        } catch (Exception e){
            Error.CatchOld(e);
            return;
        }
        // now we can use the regular floatzel error handler!
        Error.Catch(t, baseevent);
    }
}
