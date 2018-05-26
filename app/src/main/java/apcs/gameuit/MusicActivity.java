package apcs.gameuit;

import android.app.Dialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MusicActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    ArrayList<MusicInfo> musicArr=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        //set_title_color();
        getMusicArr();

        MusicAdapter musicAdapter=new MusicAdapter(MusicActivity.this,R.layout.musicrowlayout,musicArr);
        ListView musicList=(ListView)findViewById(R.id.listViewMusics);
        musicList.setAdapter(musicAdapter);
        BottomNavigationView navigation =  (BottomNavigationView) findViewById(R.id.navigationViewMusic);
        navigation.setOnNavigationItemSelectedListener(this);

        final Dialog mydialog=new Dialog(MusicActivity.this);
        mydialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        musicList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                MusicInfo mymusic= musicArr.get(position);
                mydialog.setContentView(R.layout.playmusiclayout);

                ((TextView)mydialog.findViewById(R.id.playMusicName)).setText(mymusic.getMusicname());
                ((ImageView)mydialog.findViewById(R.id.playMusicPhoto)).setImageResource(mymusic.getMusicphoto());

                final MediaPlayer mp =MediaPlayer.create(MusicActivity.this,mymusic.resource);

                Button playBtn=(Button)mydialog.findViewById(R.id.playBtn);
                Button pauseBtn=(Button)mydialog.findViewById(R.id.pauseBtn);
                Button stopBtn=(Button)mydialog.findViewById(R.id.stopBtn);

                playBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MusicActivity.this, "Hope that this song will make you better", Toast.LENGTH_SHORT).show();
                        mp.start();
                    }
                });
                pauseBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MusicActivity.this, "Just keep listening until you get better", Toast.LENGTH_SHORT).show();
                        mp.pause();
                    }
                });
                stopBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mp.reset();
                        Toast.makeText(MusicActivity.this, "Feel better yet?", Toast.LENGTH_SHORT).show();
                    }
                });
                mydialog.show();
            }

        });

    }

    /*private void set_title_color () {
        TextView tv = (TextView) findViewById(R.id.title_id);
        String chill = "<font color = #f5a623> CHILL </font>";
        String me = "<font color = #000000> ME' </font>";
        tv.setText(Html.fromHtml(chill + me));
    }*/

    void getMusicArr()
    {
        musicArr.add(new MusicInfo("Amazing Natural Bird Sounds",R.raw.naturalbird));
        musicArr.add(new MusicInfo("Meditation 1",R.raw.meditation1));
        musicArr.add(new MusicInfo("Meditation 2",R.raw.meditation2));
        musicArr.add(new MusicInfo("Fire Sound",R.raw.firesound));
        musicArr.add(new MusicInfo("Piano",R.raw.piano));
        musicArr.add(new MusicInfo("River",R.raw.river));
        musicArr.add(new MusicInfo("Wren Bird",R.raw.wrenbid));
        musicArr.add(new MusicInfo("Soft",R.raw.soft));
        musicArr.add(new MusicInfo("Soft 2",R.raw.soft2));
    }
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment=null;
        switch (item.getItemId())
        {
            case R.id.navigation_photos:
                Intent photos=new Intent(MusicActivity.this,Pictures.class);
                startActivity(photos);
                break;
            case R.id.navigation_musics:
                Intent musics=new Intent(MusicActivity.this,MusicActivity.class);
                startActivity(musics);
                break;

        }
        return false;
    }

}
