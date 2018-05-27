package apcs.gameuit;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class NewDairyEntryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_dairy_entry);

        InsertNewEntryToDB();

    }

    private void InsertNewEntryToDB() {
        Date c = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd-mm-yyyy");
        String formattedDate = df.format(c);

        MyDatabaseHelper dbHelper = new MyDatabaseHelper(this);

        SQLiteDatabase dairy = dbHelper.getWritableDatabase();

        String newTitle = ((EditText)findViewById(R.id.newStoryTitleInput)).toString();
        String newContent = ((EditText)findViewById(R.id.newStoryInput)).toString();
        String todaySotry = ((TextView)findViewById(R.id.todayStory)).toString();

        String query = "INSERT INTO dairy VALUES("+"'"+newTitle+"','"+todaySotry+"','"+newContent+"','"+formattedDate+"','"++"')";

        dairy.execSQL(query);
    }
}
