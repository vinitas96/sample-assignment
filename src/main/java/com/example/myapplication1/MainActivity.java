package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.google.android.material.bottomappbar.BottomAppBar;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class MainActivity extends AppCompatActivity {
    ImageView mMore,mCloseButton;
    ConstraintLayout mBottomPage;
Adapter NewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMore = (ImageView) findViewById(R.id.moreButton);
        mBottomPage = (ConstraintLayout) findViewById(R.id.bottomsheet);
        mCloseButton = (ImageView) findViewById(R.id.popup);

        mMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBottomPage.setVisibility(View.VISIBLE);
                mCloseButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mBottomPage.setVisibility(View.INVISIBLE);
                    }
                });

                mBottomPage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mBottomPage.setVisibility(View.INVISIBLE);
                    }
                });
            }
        });

        RecyclerView listofpeople =(RecyclerView) findViewById(R.id.listofpeople);
        listofpeople.setLayoutManager(new LinearLayoutManager(this));

        NewAdapter= new Adapter(this,getMyList());

        listofpeople.setAdapter(NewAdapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        listofpeople.addItemDecoration(dividerItemDecoration);


    }

    private ArrayList<model> getMyList(){
        ArrayList<model> models = new ArrayList<>();

        String[] names={"Ana Shriyan","Marine li","Josh Radnor","Summit Sharma","Mark Lee","Jen Smith","Lucy Rake","Janardhan Trivedi"};
        Integer images[]={R.drawable.img1,R.drawable.img4,R.drawable.img5,R.drawable.img9,R.drawable.img3,R.drawable.img6,R.drawable.img7,R.drawable.img8,R.drawable.img2};
        for(int i=0 ;i<names.length;i++){

            model m= new model();
            m.setName(names[i]);
            if(i==2)
                m.setMessage("typing...");
            else
                m.setMessage("Lorem ipsum dolor sit amet");
            m.setImg(images[i]);
            if(i==0)
               m.setPending("3");
            models.add(m);

        }
        return models;
    }


}
