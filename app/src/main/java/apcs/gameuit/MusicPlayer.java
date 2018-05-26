package apcs.gameuit;


import android.content.Context;
import android.media.MediaPlayer;

public class MusicPlayer{
    private MediaPlayer mPlayer;
    private Context context;

    MusicPlayer(Context context){
        mPlayer = new MediaPlayer();
        this.context = context;
    }

    public void loadMedia(int resourceId) {
        mPlayer = MediaPlayer.create(context,resourceId);
    }

    public void release() {
        mPlayer.release();
    }


    public boolean isPlaying() {
        return mPlayer.isPlaying();
    }

    public void play() {
        mPlayer.start();
    }

    public void reset() {
        mPlayer.reset();
    }

    public void pause() {
        if (mPlayer.isPlaying())
            mPlayer.pause();
    }

}

