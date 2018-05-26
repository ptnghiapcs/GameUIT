package apcs.gameuit;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

;

public class MyDatabaseHelper extends SQLiteOpenHelper{
    private SQLiteDatabase database;
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "main";

    public MyDatabaseHelper(Context context){
        super(context, DATABASE_NAME,null,DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE dairy(TITLE TEXT,STORY TEXT ,CONTENT TEXT,DATE TEXT, IMAGE TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS dairy");
        onCreate(db);

    }

}
