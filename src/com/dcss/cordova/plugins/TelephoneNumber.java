package com.dcss.cordova.plugins;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;
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
          
          try {result.put("Line1Number", telephonyManager.getLine1Number());} catch(JSONException e) {}
          try {result.put("VoiceMailNumber", telephonyManager.getVoiceMailNumber());} catch(JSONException e) {}
          try {result.put("DeviceId", telephonyManager.getDeviceId());} catch(JSONException e) {}
          try {result.put("SimCountryIso", telephonyManager.getSimCountryIso());} catch(JSONException e) {}
          try {result.put("SimOperator", telephonyManager.getSimOperator());} catch(JSONException e) {}
          try {result.put("SimOperatorName", telephonyManager.getSimOperatorName());} catch(JSONException e) {}
          try {result.put("SimSerialNumber", telephonyManager.getSimSerialNumber());} catch(JSONException e) {}
          try {result.put("SimState", telephonyManager.getSimState());} catch(JSONException e) {}
          try {result.put("SubscriberId", telephonyManager.getSubscriberId());} catch(JSONException e) {}
          callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, result));
          return true;
          
        }
        callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.ERROR));
        return false;
    }
}
