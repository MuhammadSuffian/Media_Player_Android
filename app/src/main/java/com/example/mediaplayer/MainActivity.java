package com.example.mediaplayer;

import static android.media.AudioManager.STREAM_MUSIC;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.mediaplayer.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
//    AudioManager audio;
    MediaPlayer mediaplayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initlization();
    }
        void initlization(){
            binding=ActivityMainBinding.inflate(getLayoutInflater());
            setContentView(binding.getRoot());
            mediaplayer=new MediaPlayer();
            mediaplayer.setAudioStreamType(STREAM_MUSIC);
            initMusic();
            buttonsLogic();
        }
        void buttonsLogic(){
        binding.btnPlay.setOnClickListener(v->{
            mediaplayer.start();
            Snackbar.make(v,"Playing",Snackbar.LENGTH_SHORT).show();
        });
        binding.btnPause.setOnClickListener(v->{
            mediaplayer.pause();
            Snackbar.make(v,"Pause",Snackbar.LENGTH_SHORT).show();

        });
        binding.btnStop.setOnClickListener(v->{
            mediaplayer.stop();
            mediaplayer.reset();
            initMusic();
            Snackbar.make(v,"Stop",Snackbar.LENGTH_SHORT).show();

        });
        }
        void initMusic(){
            String offlinemusic="android.resource://"+getPackageName()+"/"+R.raw.baby_cry;
            Uri uri=Uri.parse(offlinemusic);
            try{
                mediaplayer.setDataSource(this,uri);
                mediaplayer.prepare();
            }
            catch (Exception e){
                e.printStackTrace();
                Log.e("Error",e.getMessage());
            }
        }
}