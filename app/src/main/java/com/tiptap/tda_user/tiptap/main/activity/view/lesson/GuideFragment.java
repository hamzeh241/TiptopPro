package com.tiptap.tda_user.tiptap.main.activity.view.lesson;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.tiptap.tda_user.tiptap.R;
import com.tiptap.tda_user.tiptap.main.activity.view.activity.Act_1;
import com.tiptap.tda_user.tiptap.main.activity.view.activity.Act_2;
import com.tiptap.tda_user.tiptap.main.activity.view.activity.Act_3;
import com.tiptap.tda_user.tiptap.main.activity.view.activity.Act_4;

public class GuideFragment extends Fragment {

    private int bgRes;
    private ImageView img1,img2,img3,img4,img5,img6,img7,img8,img9,img10;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bgRes = getArguments().getInt("data");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        img1 = (ImageView)getView().findViewById(R.id.img1); img1.setVisibility(View.INVISIBLE);
        img2 = (ImageView)getView().findViewById(R.id.img2); img2.setVisibility(View.INVISIBLE);
        img3 = (ImageView)getView().findViewById(R.id.img3); img3.setVisibility(View.INVISIBLE);
        img4 = (ImageView)getView().findViewById(R.id.img4); img4.setVisibility(View.INVISIBLE);
        img5 = (ImageView)getView().findViewById(R.id.img5); img5.setVisibility(View.INVISIBLE);
        img6 = (ImageView)getView().findViewById(R.id.img6); img6.setVisibility(View.INVISIBLE);
        img7 = (ImageView)getView().findViewById(R.id.img7); img7.setVisibility(View.INVISIBLE);
        img8 = (ImageView)getView().findViewById(R.id.img8); img8.setVisibility(View.INVISIBLE);
        img9 = (ImageView)getView().findViewById(R.id.img9); img9.setVisibility(View.INVISIBLE);
        img10 = (ImageView)getView().findViewById(R.id.img10); img10.setVisibility(View.INVISIBLE);

        switch (bgRes){
            case 1:
                /*img1.setBackground();*/
                img1.setVisibility(View.VISIBLE);
                break;
            case 2:
                img1.setVisibility(View.VISIBLE);
                img2.setVisibility(View.VISIBLE);
                break;
            case 3:
                img1.setVisibility(View.VISIBLE);
                img2.setVisibility(View.VISIBLE);
                img3.setVisibility(View.VISIBLE);
                break;
            case 4:
                img1.setVisibility(View.VISIBLE);
                img2.setVisibility(View.VISIBLE);
                img3.setVisibility(View.VISIBLE);
                img4.setVisibility(View.VISIBLE);
                break;
            case 5:
                img1.setVisibility(View.VISIBLE);
                img2.setVisibility(View.VISIBLE);
                img3.setVisibility(View.VISIBLE);
                img4.setVisibility(View.VISIBLE);
                img5.setVisibility(View.VISIBLE);
                break;
            case 6:
                img1.setVisibility(View.VISIBLE);
                img2.setVisibility(View.VISIBLE);
                img3.setVisibility(View.VISIBLE);
                img4.setVisibility(View.VISIBLE);
                img5.setVisibility(View.VISIBLE);
                img6.setVisibility(View.VISIBLE);
                break;
            case 7:
                img1.setVisibility(View.VISIBLE);
                img2.setVisibility(View.VISIBLE);
                img3.setVisibility(View.VISIBLE);
                img4.setVisibility(View.VISIBLE);
                img5.setVisibility(View.VISIBLE);
                img6.setVisibility(View.VISIBLE);
                img7.setVisibility(View.VISIBLE);
                break;
            case 8:
                img1.setVisibility(View.VISIBLE);
                img2.setVisibility(View.VISIBLE);
                img3.setVisibility(View.VISIBLE);
                img4.setVisibility(View.VISIBLE);
                img5.setVisibility(View.VISIBLE);
                img6.setVisibility(View.VISIBLE);
                img7.setVisibility(View.VISIBLE);
                img8.setVisibility(View.VISIBLE);
                break;
            case 9:
                img1.setVisibility(View.VISIBLE);
                img2.setVisibility(View.VISIBLE);
                img3.setVisibility(View.VISIBLE);
                img4.setVisibility(View.VISIBLE);
                img5.setVisibility(View.VISIBLE);
                img6.setVisibility(View.VISIBLE);
                img7.setVisibility(View.VISIBLE);
                img8.setVisibility(View.VISIBLE);
                img9.setVisibility(View.VISIBLE);
                break;
            case 10:
                img1.setVisibility(View.VISIBLE);
                img2.setVisibility(View.VISIBLE);
                img3.setVisibility(View.VISIBLE);
                img4.setVisibility(View.VISIBLE);
                img5.setVisibility(View.VISIBLE);
                img6.setVisibility(View.VISIBLE);
                img7.setVisibility(View.VISIBLE);
                img8.setVisibility(View.VISIBLE);
                img9.setVisibility(View.VISIBLE);
                img10.setVisibility(View.VISIBLE);
                break;
        }
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(),Act_1.class));
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(),Act_2.class));
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(),Act_3.class));
            }
        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(),Act_4.class));
            }
        });
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(view.getContext(),Act_5.class));
            }
        });
        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(view.getContext(),"6",Toast.LENGTH_LONG).show();
            }
        });
        img7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(view.getContext(),"7",Toast.LENGTH_LONG).show();
            }
        });
        img8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(view.getContext(),"8",Toast.LENGTH_LONG).show();
            }
        });
        img9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(view.getContext(),"9",Toast.LENGTH_LONG).show();
            }
        });
        img10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(view.getContext(),"10",Toast.LENGTH_LONG).show();
            }
        });

    }
}
