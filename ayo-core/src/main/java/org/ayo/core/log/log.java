package org.ayo.core.log;

import com.orhanobut.logger.Logger;

/**
 * Created by codeest on 2016/8/3.
 */
public class log {

    public static boolean isDebug = true;
    private static String TAG = "ayo";

    public static void init(boolean debug, String defaultTag){
        isDebug = debug;
        TAG = defaultTag;
        Logger.init(defaultTag).hideThreadInfo();
    }

    public static void e(String tag,Object o) {
        if(isDebug) {
            Logger.e(tag, o);
        }
    }

    public static void e(Object o) {
        log.e(TAG,o);
    }

    public static void w(String tag,Object o) {
        if(isDebug) {
            Logger.w(tag, o);
        }
    }

    public static void w(Object o) {
        log.w(TAG,o);
    }

    public static void d(String msg) {
        if(isDebug) {
            Logger.d(msg);
        }
    }

    public static void i(String msg) {
        if(isDebug) {
            Logger.i(msg);
        }
    }

    public static void json(String t, String json){
        if(isDebug){
            Logger.json(json);
        }
    }


}
