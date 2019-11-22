package com.example.contact;

import android.content.Context;
import android.icu.text.Transliterator;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class customAdapter extends ArrayAdapter<contactjava> {
    private Context context;
    private int resource;
    private List<contactjava> listcontact;

    public customAdapter(Context context, int resource, List<contactjava> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.listcontact=objects;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder viewHolder;
        if (convertView==null)
        {
            convertView= LayoutInflater.from(context).inflate(R.layout.row_lvxml,parent,false);
            viewHolder=new ViewHolder();

            viewHolder.tvName=(TextView)convertView.findViewById(R.id.name);
            viewHolder.tvPhone=(TextView)convertView.findViewById(R.id.phone);
            convertView.setTag(viewHolder);


        }else {
            viewHolder=(ViewHolder) convertView.getTag();

        }
        contactjava contactjava=listcontact.get(position);

        viewHolder.tvName.setText(contactjava.getmName());
        viewHolder.tvPhone.setText(contactjava.getmPhone());


return convertView;
    }
    public class ViewHolder{

        private TextView tvName;
        private TextView tvPhone;
    }
}
