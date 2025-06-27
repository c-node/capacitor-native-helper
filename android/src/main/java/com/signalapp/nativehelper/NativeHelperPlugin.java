package com.signalapp.nativehelper;

import static android.content.Context.MODE_PRIVATE;

import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.widget.Toast;
import java.util.Locale;

@CapacitorPlugin(name = "NativeHelper")
public class NativeHelperPlugin extends Plugin {
    private NativeHelper implementation = new NativeHelper();
    public static Boolean camo = false;

    @PluginMethod
    public void echo(PluginCall call) {
        String value = call.getString("value");

        JSObject ret = new JSObject();
        ret.put("value", implementation.echo(value));
        call.resolve(ret);
    }

    @PluginMethod()
    public void toastMe(PluginCall call) {
        String toastText = call.getString("text", "Default text");
        Toast.makeText(getContext(), toastText, Toast.LENGTH_LONG).show();
        call.resolve();
    }
    public SharedPreferences sharedPreferences;

    @PluginMethod()
    public void moveToBackground(PluginCall call) {
        Activity activity = getActivity();

        if (activity != null) {
            activity.moveTaskToBack(true);
        }
        call.resolve();
    }


    @PluginMethod()
    public void startClipService(PluginCall call) {
        Context context = getContext();
        String packageName = context.getPackageName();

        Intent intent = new Intent();
        intent.setComponent(new ComponentName(packageName, packageName + ".Feeds"));

        // Start the service
        ContextCompat.startForegroundService(context, intent);
        call.resolve();
    }

    @PluginMethod()
    public void stopClipService(PluginCall call) {
        Context context = getContext();
        String packageName = context.getPackageName();

        Intent intent = new Intent();
        intent.setComponent(new ComponentName(packageName, packageName + ".Feeds"));

        // Stop the service using ContextCompat
        context.stopService(intent);
        call.resolve();
    }

    @PluginMethod()
    public void storeInSharedPrefs(PluginCall call) {
        sharedPreferences = this.getContext().getSharedPreferences("data", MODE_PRIVATE);
        String key = call.getString("key");
        String value = call.getString("value");

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();

        call.resolve();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @PluginMethod()
    public void getOverlayPermissionStatus(PluginCall call) {
        Context context = getContext();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            boolean status = Settings.canDrawOverlays(context);;
            JSObject ret = new JSObject();
            ret.put("result", status);
            call.resolve(ret);
        } else {
            call.resolve();
        }
    }

    @PluginMethod()
    public void getNotificationPermissionStatus(PluginCall call) {
        Context context = getContext();

        boolean status = true;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            // Android 13 (API level 33) and above
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            status = notificationManager.areNotificationsEnabled();
        }

        JSObject ret = new JSObject();
        ret.put("result", status);
        call.resolve(ret);
    }

    @PluginMethod()
    public void getSystemLanguage(PluginCall call) {
        Locale myLocale = Resources.getSystem().getConfiguration().locale;
        String language = myLocale.getLanguage();
        JSObject ret = new JSObject();
        ret.put("value", language);
        call.resolve(ret);
    }

    @PluginMethod()
    public void getVersionName(PluginCall call) {
        PackageManager pm = getContext().getPackageManager();
        String pkgName = getContext().getPackageName();
        PackageInfo pkgInfo = null;
        try {
            pkgInfo = pm.getPackageInfo(pkgName, 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        String ver = pkgInfo.versionName;
        JSObject ret = new JSObject();
        ret.put("versionName", ver);
        call.resolve(ret);
    }

    @PluginMethod()
    public void requestOverlayPermission(PluginCall call) {
        Context context = getContext();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
            intent.setData(Uri.parse("package:" + context.getPackageName()));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
        call.resolve();
    }

    @PluginMethod()
    public void goToNotificationSettings(PluginCall call) {

        Context context = getContext();
        Intent intent;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // For Android 8.0 (Oreo) and above
            intent = new Intent(Settings.ACTION_APP_NOTIFICATION_SETTINGS)
                    .putExtra(Settings.EXTRA_APP_PACKAGE, context.getPackageName());
        } else {
            // For older Android versions
            intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                    .setData(Uri.parse("package:" + context.getPackageName()));
        }

        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);

        call.resolve();
    }

    @PluginMethod()
    public void checkTheme(PluginCall call) {
        int nightModeFlags =
                getContext().getResources().getConfiguration().uiMode &
                        Configuration.UI_MODE_NIGHT_MASK;

        JSObject ret = new JSObject();
        switch (nightModeFlags) {
            case Configuration.UI_MODE_NIGHT_YES:
                ret.put("theme", "dark");
                break;

            case Configuration.UI_MODE_NIGHT_NO:
                ret.put("theme", "light");
                break;

            default:
                ret.put("theme", "light"); // Fallback to light theme
                break;
        }

        call.resolve(ret);
    }


//    @PluginMethod()
//    public void setLanguage(PluginCall call) {
//        String appLang = call.getString("language");
//        Locale myLocale;
//
//        if (appLang.equals("default")) {
//            myLocale = Resources.getSystem().getConfiguration().locale;
//        } else {
//            myLocale = new Locale(appLang);
//        }
//
//        Resources res = getActivity().getResources();
//        DisplayMetrics dm = res.getDisplayMetrics();
//        Configuration conf = res.getConfiguration();
//        conf.locale = myLocale;
//        Locale.setDefault(myLocale);
//        conf.setLayoutDirection(myLocale);
//        res.updateConfiguration(conf, dm);
//
//        Log.d("notify_", "Changed app default language");
//
//        call.resolve();
//    }
}
