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
public class patient_profile_adapter extends BaseAdapter {
    List<select_all_chech> d;
    Context con;

    public patient_profile_adapter(List<select_all_chech> d, Context con)
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
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder vh;

        if (view==null)
        {
            view= LayoutInflater.from(con).inflate(R.layout.patient_profile_adapt,viewGroup,false);
            vh=new ViewHolder(view);
            view.setTag(vh);
        }
        else {
            vh = (ViewHolder) view.getTag();
        }
         Picasso.with(con).load("https://www.domaaaaain.com/"+d.get(i).getImage()).into(vh.imm);
        vh.tv1.setText(d.get(i).getFull_name());
        vh.tv2.setText(d.get(i).getDate());
        vh.tv3.setText(d.get(i).getCheckpat());
        return view;
    }
    private class ViewHolder{

        TextView tv1,tv2,tv3;
        ImageView imm;
        public ViewHolder(View v)
        {

            tv1=(TextView) v.findViewById(R.id.pattxt22);
            tv2=(TextView) v.findViewById(R.id.txt25);
            tv3=(TextView) v.findViewById(R.id.txt27);
            imm=(ImageView) v.findViewById(R.id.im22);
        }

    }
}
