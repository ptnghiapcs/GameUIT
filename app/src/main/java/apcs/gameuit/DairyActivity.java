package apcs.gameuit;

import android.app.ActionBar;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.security.AccessController;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class DairyActivity extends AppCompatActivity {

    public static ArrayList<DairyEntry> dairyArr=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dairy);
        
        readStoriesFromDatabase();
    }

    private void readStoriesFromDatabase() {
        MyDatabaseHelper dbHelper = new MyDatabaseHelper(this);

        SQLiteDatabase dairy = dbHelper.getWritableDatabase();


        //dairy.execSQL("INSERT INTO dairy VALUES(1,'Fuck today', 'I fucking hate this stupid day')");



       // CREATE TABLE dairy( TITLE TEXT,STORY TEXT ,CONTENT TEXT,DATE TEXT, IMAGE TEXT)



        Date c = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd-mm-yyyy");
        String formattedDate = df.format(c);

        //String query = "INSERT INTO dairy VALUES('Fuck my life','AAAAAAA','Fuck this shit im out'," + formattedDate + ",'cute15')";


        String query = "UPDATE dairy SET DATE='"+formattedDate+"'";
        Log.d("date",query);
        dairy.execSQL(query);

//        long newRowId = dairy.insert("dairy",null,values);

        //dairy.execSQL("DROP TABLE dairy");

        Cursor cr = dairy.rawQuery("SELECT * FROM dairy",null);
        getArrayDairy(cr);

        ListView dairyListView=(ListView)findViewById(R.id.dairyListview);
        DairyAdapter dairyAdapter=new DairyAdapter(DairyActivity.this,R.layout.dairyrowlayout,dairyArr);
        dairyListView.setAdapter(dairyAdapter);

    }

    private void getArrayDairy(Cursor cr) {

        while(cr.moveToNext())
        {
            String title = cr.getString(cr.getColumnIndex("TITLE"));
            String date = cr.getString(cr.getColumnIndex("DATE"));
            String imageName = cr.getString(cr.getColumnIndex("IMAGE"));
            int imageID = getResources().getIdentifier(imageName , "drawable", getPackageName());

            dairyArr.add(new DairyEntry(title,date,imageID));
        }



    }

}
