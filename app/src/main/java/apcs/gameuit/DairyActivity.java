package apcs.gameuit;

import android.app.ActionBar;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.TextView;

import org.w3c.dom.Text;


public class DairyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dairy);
        
        readStoriesFromDatabase();
    }

    private void readStoriesFromDatabase() {
        SQLiteDatabase dairy = openOrCreateDatabase(
                "main", MODE_PRIVATE,null);

        dairy.execSQL("CREATE TABLE IF NOT EXISTS dairy(ID INTEGER PRIMARY KEY, TILTE TEXT, CONTENT TEXT)");

        //dairy.execSQL("INSERT INTO dairy VALUES(1,'Fuck today', 'I fucking hate this stupid day')");

        Cursor cr = dairy.rawQuery("SELECT * FROM dairy",null);

        if (cr.moveToFirst()){
            do {
                String title = cr.getString(cr.getColumnIndex("TILTE"));
                String content = cr.getString(cr.getColumnIndex("CONTENT"));
                displayThisDairy(title,content);
            } while (cr.moveToNext());
            cr.close();
        }

    }

    private void displayThisDairy(String title, String content) {

        CardView dairyCard = new CardView(this);

        CardView.LayoutParams layoutParams = new CardView.LayoutParams(CardView.LayoutParams.WRAP_CONTENT,CardView.LayoutParams.WRAP_CONTENT);

        dairyCard.setRadius(15);
        dairyCard.setPadding(25,25,25,25);
        dairyCard.setMaxCardElevation(30f);

        TextView titleBox = new TextView(this);
        TextView contentBox = new TextView(this);

        titleBox.setText(title);
        contentBox.setText(content);



    }


}
