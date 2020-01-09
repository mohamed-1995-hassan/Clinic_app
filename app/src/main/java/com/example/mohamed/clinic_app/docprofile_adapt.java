package com.example.mohamed.clinic_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Mohamed on 15/10/2018.
 */
public class docprofile_adapt extends BaseAdapter {
    List<selectallhagz> d;
    Context con;

    public docprofile_adapt(List<selectallhagz>d,Context con)
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
            view= LayoutInflater.from(con).inflate(R.layout.docprof_adapt,viewGroup,false);
            vh=new ViewHolder(view);
            view.setTag(vh);
        }
        else {
            vh = (ViewHolder) view.getTag();
        }
       // Picasso.with(con).load("https://www.domaaaaain.com/"+d.get(i).getImage()).into(vh.iv);
           vh.tv.setText(d.get(i).getFull_name());
           vh.tdd.setText(d.get(i).getDate());
        return view;
    }
    private class ViewHolder{

        TextView tv,tdd;
        public ViewHolder(View v)
        {

            tv=(TextView) v.findViewById(R.id.patx);
            tdd=(TextView) v.findViewById(R.id.dft);
        }

    }
}
