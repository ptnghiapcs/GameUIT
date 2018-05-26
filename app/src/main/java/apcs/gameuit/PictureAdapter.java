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

public class PictureAdapter extends ArrayAdapter {
    int resource;
    Context context;
    ArrayList<PictureInfo> picArr;

    PictureAdapter(Context context, int res, ArrayList<PictureInfo> picArr)
    {
        super(context,res,picArr);
        this.resource=res;
        this.context=context;
        this.picArr=picArr;
    }
    public class ViewHolder{
        ImageView picDisplay;
        TextView picName;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null)
        {
            viewHolder=new ViewHolder();
            convertView= LayoutInflater.from(context).inflate(R.layout.rowlayout,parent,false);
            viewHolder.picDisplay=(ImageView)convertView.findViewById(R.id.pictureDisplay);
            viewHolder.picName=(TextView)convertView.findViewById(R.id.pictureName);
            convertView.setTag(viewHolder);
        }
        else
            viewHolder=(ViewHolder)convertView.getTag();

        PictureInfo myPicture=picArr.get(position);

       viewHolder.picName.setText(myPicture.getPicName());
        viewHolder.picDisplay.setImageResource(myPicture.getPicresource());
       return convertView;
    }
}
