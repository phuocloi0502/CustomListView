package com.example.customlistview;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class AdapterDanhBa extends ArrayAdapter<DanhBa> {
    Context context;
    int layout;
    ArrayList<DanhBa> arrayListdanhba;
    public AdapterDanhBa(@NonNull Context context, int layout, @NonNull ArrayList<DanhBa> arrayListdanhba) {
        super(context, layout, arrayListdanhba);
        this.context=context;
        this.layout = layout;
        this.arrayListdanhba=arrayListdanhba;

    }
    public class ViewHolder{
        TextView txvHoten;
        TextView txvSdt;
        Button txvMau;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null){
            convertView= LayoutInflater.from(context).inflate(layout,parent,false);
            viewHolder=new ViewHolder();
            viewHolder.txvHoten=convertView.findViewById(R.id.txvhoten);
            viewHolder.txvSdt=convertView.findViewById(R.id.txvsdt);
            viewHolder.txvMau=convertView.findViewById(R.id.mau);
            convertView.setTag(viewHolder);

        }else {
            viewHolder=(ViewHolder) convertView.getTag();
        }
        viewHolder.txvHoten.setText(arrayListdanhba.get(position).hoten);
        viewHolder.txvSdt.setText(arrayListdanhba.get(position).sdt);
        viewHolder.txvMau.setBackgroundColor(arrayListdanhba.get(position).mau);

        return convertView;
    }
}
