/**
 */
package com.example;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;
import org.apache.cordova.PluginResult.Status;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import java.net.URL;
import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.util.Log;
import android.widget.VideoView;
import java.io.IOException;
import java.net.URL;
import android.util.Log;

import java.util.Date;

import es.lombrinus.projects.mods.playercore.audioplayer.model.Asset;
import es.lombrinus.projects.mods.playercore.audioplayer.model.ContentType;
import es.lombrinus.projects.mods.playercore.audioplayer.player.AJCPlayer;
import es.lombrinus.projects.mods.playercore.audioplayer.player.VideoPlayer;

public class cndStream extends CordovaPlugin {
  private static final String TAG = "cndStream";
   private String urlStream;

    private URL url;
    private  AJCPlayer videoPlayer;


  public void initialize(CordovaInterface cordova, CordovaWebView webView) {
    super.initialize(cordova, webView);
    videoPlayer = new VideoPlayer(this.cordova.getActivity().getApplicationContext(), new MediaPlayer());
    Log.d(TAG, "Initializing cndStream");
  }

 public void prepareAudio(String videoLink){
        videoPlayer.release();
        Asset asset = new Asset("cndStream", videoLink, ContentType.VIDEO);
        videoPlayer.play(asset, true); // autoplay=true

    }

     public void playAudio(String streamUrl){
        if(videoPlayer.isPaused()){

            videoPlayer.play();
        }
        else {
            prepareAudio(streamUrl);
        }

    }

     public void reset(){
        videoPlayer.pause();
        videoPlayer.seekTo(0);
        videoPlayer.release();
    }

    public void pauseAudio(){
        videoPlayer.pause();
    }

    public void stopAudio(){

        videoPlayer.pause();
        videoPlayer.seekTo(0);
        videoPlayer.release();

    }


  public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
    if(action.equals("play")){
    String videoLink = args.getString(0);
    playAudio(videoLink);
    }
     else if(action.equals("pause")){
      pauseAudio();
     }
       else if(action.equals("reset")){
      reset();
     }
      else if(action.equals("stop")){
        stopAudio();
      }
    return true;
  }

}
