package com.dcss.cordova.plugins;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONObject;
import android.content.Context;
import android.telephony.TelephonyManager;

public class TelephoneNumber extends CordovaPlugin {

    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) {
        if (action.equals("get")) {
            TelephonyManager telephonyManager =
                (TelephonyManager)this.cordova.getActivity().getSystemService(Context.TELEPHONY_SERVICE);
            String result = telephonyManager.getLine1Number();
            if (result != null) {
                callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, result));
               return true;
            }
        } else if (action.equals("getInfo")) {
          TelephonyManager telephonyManager =
                (TelephonyManager)this.cordova.getActivity().getSystemService(Context.TELEPHONY_SERVICE);
                    
          JSONObject result = new JSONObject();
          try {result.put("Line1Number", telephonyManager.getLine1Number());} catch(Exception e) {result.put("excp", e);}
          try {result.put("VoiceMailNumber", telephonyManager.getVoiceMailNumber());} catch(Exception e) {result.put("excp1", e);}
          try {result.put("DeviceId", telephonyManager.getDeviceId());} catch(Exception e) {result.put("excp2", e);}
          try {result.put("SimCountryIso", telephonyManager.getSimCountryIso());} catch(Exception e) {result.put("excp3", e);}
          try {result.put("SimOperator", telephonyManager.getSimOperator());} catch(Exception e) {result.put("excp4", e);}
          try {result.put("SimOperatorName", telephonyManager.getSimOperatorName());} catch(Exception e) {result.put("excp5", e);}
          try {result.put("SimSerialNumber", telephonyManager.getSimSerialNumber());} catch(Exception e) {result.put("excp6", e);}
          try {result.put("SimState", telephonyManager.getSimState());} catch(Exception e) {result.put("excp7", e);}
          try {result.put("SubscriberId", telephonyManager.getSubscriberId());} catch(Exception e) {result.put("excp8", e);}
          callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, result));
             return true;
        }
        callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.ERROR));
        return false;
    }
}
