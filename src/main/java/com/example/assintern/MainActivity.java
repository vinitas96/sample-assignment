package com.example.assintern;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        tabLayout = (TabLayout) findViewById( R.id.tablayout_id );
        viewPager = (ViewPager) findViewById( R.id.viewpager_id );
        adapter = new ViewPagerAdapter( getSupportFragmentManager() );

        adapter.AddFragment( new FragmentConference(),"Conference" );
        adapter.AddFragment( new FragmentDiscussion(),"Discussion" );
        adapter.AddFragment( new FragmentBoard(),"" );

        viewPager.setAdapter( adapter );
        tabLayout.setupWithViewPager( viewPager );

        tabLayout.getTabAt(0).setCustomView(R.layout.custom_tab);

        TextView textView1 = (TextView) tabLayout.getTabAt(0).getCustomView().findViewById(R.id.text);
        ImageView imageView1 = (ImageView) tabLayout.getTabAt( 0 ).getCustomView().findViewById( R.id.custom_image );
        textView1.setText("Conference");
        textView1.setTextColor( getResources().getColor( R.color.white ) );
        imageView1.setImageResource( R.drawable.ic_chat );

        tabLayout.getTabAt(1).setCustomView(R.layout.custom_tab);

        TextView textView2 = (TextView) tabLayout.getTabAt(1).getCustomView().findViewById(R.id.text);
        ImageView imageView2 = (ImageView) tabLayout.getTabAt( 1 ).getCustomView().findViewById( R.id.custom_image );
        textView2.setText("Discussion");
        imageView2.setImageResource( R.drawable.ic_chat );
        imageView2.setColorFilter( getResources().getColor( R.color.colorFadeText ) );

        tabLayout.getTabAt(2).setCustomView(R.layout.custom_tab);

        TextView textView3 = (TextView) tabLayout.getTabAt(2).getCustomView().findViewById(R.id.text);
        ImageView imageView3 = (ImageView) tabLayout.getTabAt( 2 ).getCustomView().findViewById( R.id.custom_image );
        textView3.setText("Board");
        imageView3.setImageResource( R.drawable.ic_chat );
        imageView3.setColorFilter( getResources().getColor( R.color.colorFadeText ) );

        tabLayout.addOnTabSelectedListener( new TabLayout.BaseOnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //tabLayout.getTabAt(tab.getPosition()).getIcon().setColorFilter(getResources().getColor(android.R.color.white), PorterDuff.Mode.SRC_IN);
                TextView text = (TextView) tabLayout.getTabAt(tab.getPosition()).getCustomView().findViewById(R.id.text);
                text.setTextColor( getResources().getColor( R.color.white ) );
                ImageView image = (ImageView) tabLayout.getTabAt( tab.getPosition() ).getCustomView().findViewById( R.id.custom_image );
                image.setColorFilter( getResources().getColor( R.color.white ) );
            }

            @SuppressLint("ResourceAsColor")
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                //tabLayout.getTabAt(tab.getPosition()).getIcon().setColorFilter(getResources().getColor(R.color.colorFadText), PorterDuff.Mode.SRC_IN);
                TextView text = (TextView) tabLayout.getTabAt(tab.getPosition()).getCustomView().findViewById(R.id.text);
                ImageView image = (ImageView) tabLayout.getTabAt( tab.getPosition() ).getCustomView().findViewById( R.id.custom_image );
                text.setTextColor( getResources().getColor( R.color.colorFadeText ) );
                image.setColorFilter( getResources().getColor( R.color.colorFadeText ) );
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        } );

    }
}
