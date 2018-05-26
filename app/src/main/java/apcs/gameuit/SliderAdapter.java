package apcs.gameuit;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.transition.Slide;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context)
    {
        this.context = context;
    }

    public int[] slide_images = {
            R.drawable.stop_hand,
            R.drawable.brain,
            R.drawable.boyandgirl
    };

    public String[] slide_headings = {
            "VIOLENCE IS BAD",
            "REDUCE STRESS",
            "CHILLME MEDITATION"
    };

    public String[] slide_desc = {
            "Lorem ipsum texts dolor sit amet consetetur amet consetetur texts dolor sit Lorem ipsum texts dolor sit " +
                    "Lorem ipsum texts dolor sit amet consetetur amet consetetur texts dolor sit Lorem ipsum texts dolor sit",
            "Lorem ipsum texts dolor sit amet consetetur amet consetetur texts dolor sit Lorem ipsum texts dolor sit ",
            "Lorem ipsum texts dolor sit amet consetetur amet consetetur texts dolor sit Lorem ipsum texts dolor sit "
    };
    @Override
    public int getCount() {
        return slide_headings.length;

    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView slideImageView = view.findViewById(R.id.imageView);
        TextView slideHeading = view.findViewById(R.id.textView);
        TextView slideDescription = view.findViewById(R.id.textView2);

        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        slideDescription.setText(slide_desc[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((LinearLayout)object);
    }
}
