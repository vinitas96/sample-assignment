package com.example.assintern;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class FragmentDiscussion extends Fragment {

    private RecyclerView myrecyclerview;
    private List<Discussion> lstDiscussion;
    ImageView mMore,mCloseButton;
    ConstraintLayout mBottomPage;
    EditText search;

    public FragmentDiscussion() {
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_discussion ,container,false );

        myrecyclerview =(RecyclerView) v.findViewById(R.id.discussion_recyclerview);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(),getMyList());
        myrecyclerview.setAdapter(recyclerViewAdapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL);
        myrecyclerview.addItemDecoration(dividerItemDecoration);

        mMore=(ImageView) v.findViewById( R.id.moreButton );
        search=(EditText) v.findViewById( R.id.search_box );
        mBottomPage = (ConstraintLayout) v.findViewById(R.id.bottomsheet);
        mCloseButton = (ImageView) v.findViewById(R.id.popup);

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


        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

        lstDiscussion = new ArrayList<>();

    }

    private ArrayList<Discussion> getMyList(){
        ArrayList<Discussion> models = new ArrayList<>();

        String[] names={"Ana Shriyan","Marine li","Josh Radnor","Summit Sharma","Mark Lee","Jen Smith","Lucy Rake","Janardhan Trivedi"};
        Integer images[]={R.drawable.img1,R.drawable.img4,R.drawable.img5,R.drawable.img9,R.drawable.img3,R.drawable.img6,R.drawable.img7,R.drawable.img8,R.drawable.img2};
        for(int i=0 ;i<names.length;i++){

            Discussion m= new Discussion();
            m.setName(names[i]);
            if(i==2)
                m.setMessage("typing...");
            else
                m.setMessage("Lorem ipsum dolor sit amet");
            m.setPhoto(images[i]);
            if(i==0)
                m.setPending("3");
            models.add(m);

        }
        return models;
    }
}
