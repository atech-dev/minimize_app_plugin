package com.vanethos.minimize_app

import android.app.Activity
import androidx.annotation.NonNull;
import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.embedding.engine.plugins.activity.ActivityAware
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result
import io.flutter.plugin.common.PluginRegistry.Registrar
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding



/** MinimizeAppPlugin */
public class MinimizeAppPlugin(): FlutterPlugin, MethodCallHandler, ActivityAware {
  private lateinit var channel : MethodChannel
  private lateinit var activity: Activity

  override fun onAttachedToEngine(@NonNull flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
    channel = MethodChannel(flutterPluginBinding.binaryMessenger, "minimize_app")
    channel.setMethodCallHandler(this)
  }
  
  override fun onMethodCall(@NonNull call: MethodCall, @NonNull result: Result) {
    result.notImplemented()
  }

  override fun onDetachedFromEngine(@NonNull binding: FlutterPlugin.FlutterPluginBinding) {
    channel.setMethodCallHandler(null)
  }

  override fun onAttachedToActivity(@NonNull activityPluginBinding: ActivityPluginBinding) {
    activity = activityPluginBinding.getActivity();
  }

  override fun onReattachedToActivityForConfigChanges(@NonNull activityPluginBinding: ActivityPluginBinding) {
    activity = activityPluginBinding.getActivity();
  }

  override fun onDetachedFromActivityForConfigChanges() {
    // no op
  }

  override fun onDetachedFromActivity() {
    // no op
  }
}
