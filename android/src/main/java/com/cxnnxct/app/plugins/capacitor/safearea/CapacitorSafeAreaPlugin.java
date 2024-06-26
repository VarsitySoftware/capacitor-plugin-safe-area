package com.cxnnxct.app.plugins.capacitor.safearea;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;

import androidx.annotation.RequiresApi;


@CapacitorPlugin(name = "CapacitorSafeArea")
public class CapacitorSafeAreaPlugin extends Plugin implements SensorEventListener{

    private CapacitorSafeArea implementation = new CapacitorSafeArea();
    private static final String KEY_INSET = "insets";
    private static final String Bar_Height = "statusBarHeight";

    @PluginMethod
    public void getSafeAreaInsets(PluginCall call) {
        JSObject ret = new JSObject();
        ret.put(KEY_INSET, implementation.getSafeAreaInsets(this.getBridge()));
        call.resolve(ret);
    }

    @PluginMethod
    public void getStatusBarHeight(PluginCall call) {
        JSObject ret = new JSObject();
        ret.put(Bar_Height, implementation.getStatusBarHeight(this.getBridge()));
        call.resolve(ret);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void handleOnResume() {
        super.handleOnResume();
        SensorManager sm = (SensorManager) this.getBridge().getActivity().getSystemService(Context.SENSOR_SERVICE);
        sm.registerListener((SensorEventListener) this, sm.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR), SensorManager.SENSOR_DELAY_NORMAL);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void handleOnPause() {
        super.handleOnPause();
        SensorManager sm = (SensorManager) this.getBridge().getActivity().getSystemService(Context.SENSOR_SERVICE);
        sm.unregisterListener((SensorEventListener) this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
