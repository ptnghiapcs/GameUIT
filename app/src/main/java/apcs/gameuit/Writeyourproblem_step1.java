package apcs.gameuit;
import android.content.Intent;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

public class Writeyourproblem_step1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_writeyourproblem_step1);
        EditText editText = (EditText) findViewById(R.id.bullyname);
        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)){
                    Intent secondintent = new Intent(Writeyourproblem_step1.this, Writeyourproblem_step2.class);
                    startActivity(secondintent);

                }
                return  false;
            }
        });
    }

}