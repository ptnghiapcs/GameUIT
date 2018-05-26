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

import java.util.ArrayList;

public class DairyAdapter extends ArrayAdapter {
    Context context;
    int res;
    ArrayList<DairyEntry> dairyArr=new ArrayList<>();

    DairyAdapter(Context context,int res,ArrayList<DairyEntry>dairyArr)
    {
        super(context,res,dairyArr);
        this.context=context;
        this.res=res;
        this.dairyArr=dairyArr;
    }
    public class ViewHolder
    {
        ImageView dairyimage;
        TextView dairyname;
        TextView dairydate;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null)
        {
            viewHolder=new ViewHolder();
            convertView= LayoutInflater.from(context).inflate(R.layout.dairyrowlayout,parent,false);
            viewHolder.dairyimage=(ImageView)convertView.findViewById(R.id.dairyImage);
            viewHolder.dairyname=(TextView)convertView.findViewById(R.id.dairyName);
            viewHolder.dairydate=(TextView)convertView.findViewById(R.id.dairydate);
            convertView.setTag(viewHolder);
        }
        else
            viewHolder=(ViewHolder)convertView.getTag();

        DairyEntry mydairy=dairyArr.get(position);
        viewHolder.dairydate.setText(mydairy.getDairydate());
        viewHolder.dairyname.setText(mydairy.getDairyname());
        viewHolder.dairyimage.setImageResource(mydairy.getRes());


        return convertView;
    }
}
