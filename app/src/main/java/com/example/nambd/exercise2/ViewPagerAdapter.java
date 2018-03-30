package com.example.nambd.exercise2;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by NamBD on 3/29/2018.
 */

public class ViewPagerAdapter extends PagerAdapter {

    private Context mContext;
    private List<Integer> data;

    public ViewPagerAdapter(Context mContext, List<Integer> data) {
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.item_gridview, container, false);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.img);
        imageView.setImageResource(data.get(position));
        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
