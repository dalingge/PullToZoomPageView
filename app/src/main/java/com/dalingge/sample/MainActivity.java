package com.dalingge.sample;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;

    int images[]={R.drawable.a,R.drawable.b,R.drawable.c};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ViewPager viewPager =  (ViewPager) findViewById(R.id.image);
        ArrayList<View> arrayList =new ArrayList<>();

        for (int image : images){
            View view = LayoutInflater.from(this).inflate(
                    R.layout.image_content_pager, null);
            ImageView iv = (ImageView) view.findViewById(R.id.iv_img);
            iv.setImageResource(image);
            arrayList.add(view);
        }
        MyPagerAdapter myPagerAdapter=new MyPagerAdapter(this,arrayList);
        viewPager.setAdapter(myPagerAdapter);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setVerticalScrollBarEnabled(true);
        mRecyclerView.setOverScrollMode(View.OVER_SCROLL_NEVER);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new ItemAdapter());
    }

    private class ItemAdapter extends RecyclerView.Adapter<TextHolder>{

        @Override
        public TextHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new TextHolder(View.inflate(MainActivity.this,R.layout.item_main,null));
        }

        @Override
        public void onBindViewHolder(TextHolder holder, int position) {
            holder.bind();
        }

        @Override
        public int getItemCount() {
            return 100;
        }
    }
    class TextHolder extends RecyclerView.ViewHolder{

        private TextView mText;
        public TextHolder(View itemView) {
            super(itemView);
            mText = (TextView) itemView.findViewById(R.id.textView);
        }

        void bind(){
            mText.setText(String.format("Item %s",getAdapterPosition()));
        }
    }
}
