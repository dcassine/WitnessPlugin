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
          result.put("Line1Number", telephonyManager.getLine1Number());
          result.put("VoiceMailNumber", telephonyManager.getVoiceMailNumber());
          result.put("DeviceId", telephonyManager.getDeviceId());
          result.put("SimCountryIso", telephonyManager.getSimCountryIso());
          result.put("SimOperator", telephonyManager.getSimOperator());
          result.put("SimOperatorName", telephonyManager.getSimOperatorName());
          result.put("SimSerialNumber", telephonyManager.getSimSerialNumber());
          result.put("SimState", telephonyManager.getSimState());
          result.put("SubscriberId", telephonyManager.getSubscriberId());

          callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, result));
             return true;
        }
        callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.ERROR));
        return false;
    }
}
