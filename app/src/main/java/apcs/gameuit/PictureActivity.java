package apcs.gameuit;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.widget.TextView;

public class PictureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        set_title_color();



    }
    private void set_title_color () {
        TextView tv = (TextView) findViewById(R.id.title_id);
        String chill = "<font color = #f5a623> CHILL </font>";
        String me = "<font color = #000000> ME' </font>";
        tv.setText(Html.fromHtml(chill + me));
    }
}
