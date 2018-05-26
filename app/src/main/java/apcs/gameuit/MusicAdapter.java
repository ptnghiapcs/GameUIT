package apcs.gameuit;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;



import java.lang.reflect.Array;
import java.util.ArrayList;

public class MusicAdapter extends ArrayAdapter {
    int resource;
    Context context;
    ArrayList<MusicInfo> musicArr;

    MusicAdapter(Context context, int res, ArrayList<MusicInfo> picArr)
    {
        super(context,res,picArr);
        this.resource=res;
        this.context=context;
        this.musicArr=picArr;
    }
    public class musicViewHolder{
        ImageView picDisplay;
        TextView picName;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        musicViewHolder viewHolder;
        if(convertView==null)
        {
            viewHolder=new musicViewHolder();
            convertView= LayoutInflater.from(context).inflate(R.layout.musicrowlayout,parent,false);
            viewHolder.picDisplay=(ImageView)convertView.findViewById(R.id.musicPhoto);
            viewHolder.picName=(TextView)convertView.findViewById(R.id.musicName);
            convertView.setTag(viewHolder);
        }
        else
            viewHolder=(musicViewHolder)convertView.getTag();

        MusicInfo mymusic=musicArr.get(position);
        viewHolder.picDisplay.setImageResource(mymusic.getMusicphoto());
        viewHolder.picName.setText(mymusic.getMusicname());
        return convertView;
    }
}

