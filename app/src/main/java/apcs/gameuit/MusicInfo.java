package apcs.gameuit;

public class MusicInfo {
    String musicname;
    int resource;
    int musicphoto=R.drawable.goldisk;

    MusicInfo(String name,int res)
    {
        musicname=name;
        resource=res;
    }

    public int getResource() {
        return resource;
    }

    public String getMusicname() {
        return musicname;
    }

    public int getMusicphoto() {
        return musicphoto;
    }
}
