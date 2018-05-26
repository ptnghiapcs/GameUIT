package apcs.gameuit;

import android.app.ActionBar;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.security.AccessController;


public class DairyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dairy);
        
        readStoriesFromDatabase();
    }

    private void readStoriesFromDatabase() {
        MyDatabaseHelper dbHelper = new MyDatabaseHelper(this);



        //dairy.execSQL("INSERT INTO dairy VALUES(1,'Fuck today', 'I fucking hate this stupid day')");

        Cursor cr = dairy.rawQuery("SELECT * FROM dairy",null);

        if (cr.moveToFirst()){
            do {
                displayThisDairy(cr);
            } while (cr.moveToNext());
            cr.close();
        }

    }

    private void displayThisDairy(Cursor cr) {

        LinearLayout mainLayout = findViewById(R.id.dairymain);

        String title = cr.getString(cr.getColumnIndex("TILTE"));
        String content = cr.getString(cr.getColumnIndex("CONTENT"));


        CardView dairyCard = new CardView(this);

        CardView.LayoutParams layoutParams = new CardView.LayoutParams(CardView.LayoutParams.WRAP_CONTENT,CardView.LayoutParams.WRAP_CONTENT);
        dairyCard.setLayoutParams(layoutParams);

        LinearLayout cardLinearLayout = new LinearLayout(this);

        cardLinearLayout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams linearLayoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        cardLinearLayout.setLayoutParams(linearLayoutParams);

        dairyCard.setRadius(15);
        dairyCard.setPadding(25,25,25,25);
        dairyCard.setMaxCardElevation(30f);

        TextView titleBox = new TextView(this);
        TextView contentBox = new TextView(this);

        titleBox.setText(title);
        contentBox.setText(content);

        titleBox.setTextSize(30f);

        cardLinearLayout.addView(titleBox);
        cardLinearLayout.addView(contentBox);

        dairyCard.addView(cardLinearLayout);



        mainLayout.addView(dairyCard);

    }


}
