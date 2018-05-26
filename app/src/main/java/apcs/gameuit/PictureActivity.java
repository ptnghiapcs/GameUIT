package apcs.gameuit;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;


public class PictureActivity extends AppCompatActivity {

    public final static ArrayList<PictureInfo> picArr=new ArrayList<>();
    public final static ArrayList<PictureInfo> cutePic=new ArrayList<>();
    public final static ArrayList<PictureInfo> sweetPictures=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        initNavHandler();

       final Spinner mySpinner=findViewById(R.id.spinner);

        Button mybtn=findViewById(R.id.selectSpinner);


        mybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String type=mySpinner.getSelectedItem().toString();
                PictureAdapter adapter;
                if(type.equals("Memes Pictures"))
                {
                    uploadFile();
                    adapter=new PictureAdapter(PictureActivity.this,R.layout.rowlayout,picArr);
                    ListView displayPic=(ListView)findViewById(R.id.listViewPictures);
                    displayPic.setAdapter(adapter);
                }
                else
                if(type.equals("Sweet Pictures"))
                {
                    uploadFileSweet();
                    adapter=new PictureAdapter(PictureActivity.this,R.layout.rowlayout,sweetPictures);
                    ListView displayPic=(ListView)findViewById(R.id.listViewPictures);
                    displayPic.setAdapter(adapter);
                }
                else
                if(type.equals("Cute Pictures"))
                {
                    uploadFileCute();
                    adapter=new PictureAdapter(PictureActivity.this,R.layout.rowlayout,cutePic);
                    ListView displayPic=(ListView)findViewById(R.id.listViewPictures);
                    displayPic.setAdapter(adapter);
                }
                else
                    Toast.makeText(PictureActivity.this, "Nothing", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void initNavHandler() {
        ImageButton photoBtn = findViewById(R.id.imageButton);
        ImageButton musicBtn = findViewById(R.id.imageButton2);
        ImageButton diaryBtn = findViewById(R.id.imageButton3);

        musicBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(PictureActivity.this, MusicActivity.class);
                startActivity(myIntent);
            }
        });

        diaryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(PictureActivity.this, DairyActivity.class);
                startActivity(myIntent);
            }
        });

    }

    public void uploadFile()
    {
        picArr.add(new PictureInfo("Your first bike",R.drawable.firstbike));
        picArr.add(new PictureInfo("Ass fake??",R.drawable.assface));
        picArr.add(new PictureInfo("Bathroom problems",R.drawable.bathproblem));
        picArr.add(new PictureInfo("Savage boy",R.drawable.savage));
        picArr.add(new PictureInfo("Awkward Dinner Talk",R.drawable.dinnertalk));
        picArr.add(new PictureInfo("Always happens",R.drawable.ipone));
        picArr.add(new PictureInfo("Don't skip leg day",R.drawable.legday));
        picArr.add(new PictureInfo("Dog problem",R.drawable.dogproblem));
        picArr.add(new PictureInfo("Cheap Cosplay",R.drawable.isthis));
        picArr.add(new PictureInfo("Fat people problem",R.drawable.fatproblem));
        picArr.add(new PictureInfo("Couple problem",R.drawable.couple));
        picArr.add(new PictureInfo("When you realized that you were born in America",R.drawable.americankid));
        picArr.add(new PictureInfo("How she thinks And How you think",R.drawable.relation));
        picArr.add(new PictureInfo("That picture",R.drawable.thattool));
        picArr.add(new PictureInfo("Same things for same guys",R.drawable.facebook));
        picArr.add(new PictureInfo("Say that again!?",R.drawable.sister));
        picArr.add(new PictureInfo("Misunderstood",R.drawable.dontknow));
        picArr.add(new PictureInfo("You Know It's True",R.drawable.anime));
        picArr.add(new PictureInfo("Easy Math",R.drawable.easy));
        picArr.add(new PictureInfo("Sounds similar",R.drawable.meinclass));
        picArr.add(new PictureInfo("Calculated",R.drawable.calculated));
        picArr.add(new PictureInfo("Sharing with 2 girls, which is mine?",R.drawable.sharin));
        picArr.add(new PictureInfo("Our love be like",R.drawable.cute));
        picArr.add(new PictureInfo("Real talk",R.drawable.realtalk));
        picArr.add(new PictureInfo("Boys vs Girls",R.drawable.boyandgirl));
        picArr.add(new PictureInfo("Not so fast",R.drawable.win10));
        picArr.add(new PictureInfo("Nothing to say",R.drawable.nothing));
        picArr.add(new PictureInfo("Me vs. Life",R.drawable.life));
        picArr.add(new PictureInfo("True story",R.drawable.realstory));
        picArr.add(new PictureInfo("Waiting and Waiting",R.drawable.waiting));
        picArr.add(new PictureInfo("What a dragg",R.drawable.whatadrag));
        picArr.add(new PictureInfo("Try yoga . . . ",R.drawable.yoga));
        picArr.add(new PictureInfo("Laughing",R.drawable.vill));
        picArr.add(new PictureInfo("Christian Lion",R.drawable.lion));
        picArr.add(new PictureInfo("Replacing Nemo",R.drawable.nemo));





    }
    public void uploadFileCute()
    {
        cutePic.add(new PictureInfo("",R.drawable.cute1));
        cutePic.add(new PictureInfo("",R.drawable.cute2));
        cutePic.add(new PictureInfo("",R.drawable.cute3));
        cutePic.add(new PictureInfo("",R.drawable.cute4));
        cutePic.add(new PictureInfo("",R.drawable.cute5));
        cutePic.add(new PictureInfo("",R.drawable.cute6));
        cutePic.add(new PictureInfo("",R.drawable.cute7));
        cutePic.add(new PictureInfo("",R.drawable.cute8));
        cutePic.add(new PictureInfo("",R.drawable.cute9));
        cutePic.add(new PictureInfo("",R.drawable.cute10));
        cutePic.add(new PictureInfo("",R.drawable.cute11));
        cutePic.add(new PictureInfo("",R.drawable.cute12));
        cutePic.add(new PictureInfo("",R.drawable.cute13));
        cutePic.add(new PictureInfo("",R.drawable.cute14));
        cutePic.add(new PictureInfo("",R.drawable.cute15));
        cutePic.add(new PictureInfo("",R.drawable.cute16));
        cutePic.add(new PictureInfo("",R.drawable.cute17));
        cutePic.add(new PictureInfo("",R.drawable.cute18));
        cutePic.add(new PictureInfo("",R.drawable.cute19));
        cutePic.add(new PictureInfo("",R.drawable.cute20));
        cutePic.add(new PictureInfo("",R.drawable.cute21));
        cutePic.add(new PictureInfo("",R.drawable.cute22));


    }
    public void uploadFileSweet()
    {
       // sweetPictures.add(new PictureInfo("",R.drawable.sweet1));
        sweetPictures.add(new PictureInfo("",R.drawable.sweet2));
        sweetPictures.add(new PictureInfo("",R.drawable.sweet3));
        sweetPictures.add(new PictureInfo("",R.drawable.sweet4));
        sweetPictures.add(new PictureInfo("",R.drawable.sweet5));
        sweetPictures.add(new PictureInfo("",R.drawable.sweer6));
        sweetPictures.add(new PictureInfo("",R.drawable.sweet7));
        sweetPictures.add(new PictureInfo("",R.drawable.sweet8));
        sweetPictures.add(new PictureInfo("",R.drawable.sweet9));
        sweetPictures.add(new PictureInfo("",R.drawable.sweet10));
        sweetPictures.add(new PictureInfo("",R.drawable.sweet11));
        sweetPictures.add(new PictureInfo("",R.drawable.sweet12));
        sweetPictures.add(new PictureInfo("",R.drawable.sweet13));
        sweetPictures.add(new PictureInfo("",R.drawable.sweet14));
        sweetPictures.add(new PictureInfo("",R.drawable.sweet15));
        sweetPictures.add(new PictureInfo("",R.drawable.sweet16));
        sweetPictures.add(new PictureInfo("",R.drawable.sweet17));
        sweetPictures.add(new PictureInfo("",R.drawable.sweet18));
        sweetPictures.add(new PictureInfo("",R.drawable.sweet19));
        sweetPictures.add(new PictureInfo("",R.drawable.sweet20));
        sweetPictures.add(new PictureInfo("",R.drawable.sweet21));
        sweetPictures.add(new PictureInfo("",R.drawable.sweet22));
        sweetPictures.add(new PictureInfo("",R.drawable.sweet23));
    }
}
