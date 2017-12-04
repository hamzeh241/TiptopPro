package com.tiptap.tda_user.tiptap.main.activity.view.function;

import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.tiptap.tda_user.tiptap.R;

import java.util.ArrayList;
import java.util.List;

public class CardPagerAdapter extends PagerAdapter implements CardAdapter {

    private List<CardView> mViews;
    private List<CardItem> mData;
    private float mBaseElevation;

    public CardPagerAdapter() {
        mData = new ArrayList<>();
        mViews = new ArrayList<>();
    }

    public void addCardItem(CardItem item) {
        mViews.add(null);
        mData.add(item);
    }

    public float getBaseElevation() {
        return mBaseElevation;
    }

    @Override
    public CardView getCardViewAt(int position) {
        return mViews.get(position);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.func, container, false);
        container.addView(view);
        bind(mData.get(position), view);
        CardView cardView = (CardView) view.findViewById(R.id.cardView);

        if (mBaseElevation == 0) {
            mBaseElevation = cardView.getCardElevation();
        }

        cardView.setMaxCardElevation(mBaseElevation * MAX_ELEVATION_FACTOR);
        mViews.set(position, cardView);
        return view;
    }

    @Override
    public void destroyItem(final ViewGroup container, int position, Object object) {
        container.removeView((View) object);
        mViews.set(position, null);
    }

    private void bind(final CardItem item, View view) {
        TextView titleTextView = (TextView) view.findViewById(R.id.title);
        titleTextView.setText(item.getTitle());
        ImageView img = (ImageView) view.findViewById(R.id.img);

        Button btn = (Button) view.findViewById(R.id.next);
//        switch (item.getTitle()){
//            case "Function 1":
//                titleTextView.setText("Introduction");
//                btn.setText("Redo");
//                btn.setBackgroundColor(btn.getContext().getResources().getColor(R.color.green));
//                img.setBackgroundResource(R.drawable.f1);
//                break;
//            case "Function 2":
//                titleTextView.setText("Greeting");
//                btn.setText("Start");
//                btn.setBackgroundColor(btn.getContext().getResources().getColor(R.color.red));
//                img.setBackgroundResource(R.drawable.f2);
//                break;
//            case "Function 3":
//                titleTextView.setText("Jobs");
//                img.setBackgroundResource(R.drawable.f3);
//                break;
//            case "Function 4":
//                titleTextView.setText("Other jobs");
//                img.setBackgroundResource(R.drawable.f4);
//                break;
//            case "Function 5":
//                titleTextView.setText("Alphabet");
//                img.setBackgroundResource(R.drawable.f5);
//                break;
//            case "Function 6":
//                titleTextView.setText("Countries");
//                img.setBackgroundResource(R.drawable.f6);
//                break;
//            case "Function 7":
//                titleTextView.setText("Adjectives");
//                img.setBackgroundResource(R.drawable.f7);
//                break;
//            case "Function 8":
//                break;
//            case "Function 9":
//                break;
//            case "Function 10":
//                break;
//            case "Function 11":
//                break;
//            case "Function 12":
//                break;
//            case "Function 13":
//                break;
//            case "Function 14":
//                break;
//            case "Function 15":
//                break;
//            case "Function 16":
//                break;
//            case "Function 17":
//                break;
//            case "Function 18":
//                break;
//            case "Function 19":
//                break;
//            case "Function 20":
//                break;
//            case "Function 21":
//                break;
//            case "Function 22":
//                break;
//            case "Function 23":
//                break;
//            case "Function 24":
//                break;
//            case "Function 25":
//                break;
//            case "Function 26":
//                break;
//            case "Function 27":
//                break;
//            case "Function 28":
//                break;
//            case "Function 29":
//                break;
//            case "Function 30":
//                break;
//            case "Function 31":
//                break;
//        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if(item.getTitle().equals("Function 1")){
//                    Lesson.function =  item.getTitle();
//                    view.getContext().startActivity(new Intent(view.getContext(), Lesson.class));
//                }
//                if(item.getTitle().equals("Function 2")){
//                    Lesson.function =  item.getTitle();
//                    view.getContext().startActivity(new Intent(view.getContext(), Lesson.class));
//                }
            }
        });
    }
}