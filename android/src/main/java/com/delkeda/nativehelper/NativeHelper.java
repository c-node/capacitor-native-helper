package com.delkeda.nativehelper;

import android.util.Log;

public class NativeHelper {

    public String echo(String value) {
        Log.i("Echo", value);
        return value;
    }
}
