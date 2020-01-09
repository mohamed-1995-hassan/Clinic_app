package com.example.mohamed.clinic_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Mohamed on 18/10/2018.
 */
public class depat_apter extends BaseAdapter {
    List<getdoctors>d;
    Context con;

    public depat_apter(List<getdoctors>d,Context con)
    {
        this.d=d;
        this.con=con;
    }
    @Override
    public int getCount() {
        return d.size();
    }

    @Override
    public Object getItem(int i) {
        return d.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        ViewHolder vh;

        if (view==null)
        {
            view= LayoutInflater.from(con).inflate(R.layout.det_adapt,viewGroup,false);
            vh=new ViewHolder(view);
            view.setTag(vh);
        }
        else {
            vh = (ViewHolder) view.getTag();
        }
        Picasso.with(con).load("https://www.domaaaaain.com/"+d.get(i).getImage()).into(vh.iv);
        vh.fam.setText(d.get(i).getFull_name());

        return view;
    }
    private class ViewHolder{
        ImageView iv;
        TextView fam;
        public ViewHolder(View v)

        {
           iv= (ImageView) v.findViewById(R.id.idr);
            fam=v.findViewById(R.id.fam);
        }

    }
}
