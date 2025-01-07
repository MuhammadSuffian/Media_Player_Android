package com.example.mediaplayer;

import static android.media.AudioManager.STREAM_MUSIC;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.mediaplayer.databinding.ActivityMainBinding;

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
        });
        binding.btnPause.setOnClickListener(v->{
            mediaplayer.pause();
            });
        binding.btnStop.setOnClickListener(v->{
            mediaplayer.stop();
            mediaplayer.reset();
            initMusic();
            });
        }
        void initMusic(){
            String offlinemusic="android.resourse://"+getPackageName()+"/"+R.raw.baby_cry;
            Uri uri=Uri.parse(offlinemusic);
            try{
                mediaplayer.setDataSource(this,uri);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
}