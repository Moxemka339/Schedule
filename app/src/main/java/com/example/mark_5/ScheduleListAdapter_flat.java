package com.example.mark_5;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class ScheduleListAdapter_flat extends BaseAdapter {
    private LayoutInflater inflater;
    private int layout;
    private ArrayList<ScheduleItem> objects;

    ScheduleListAdapter_flat(Context context, int resource, ArrayList<ScheduleItem> items) {
        this.layout = resource;
        this.objects = items;
        this.inflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return objects.size();
    }


    @Override
    public Object getItem(int position) {
        return objects.get(position);
    }


    @Override
    public long getItemId(int position) {
        return position;
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        final ViewHolder viewHolder;

        if (convertView == null) {
            convertView = inflater.inflate(this.layout, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final ScheduleItem Item = objects.get(position);

        viewHolder.Time0.setText(Item.getTime0());
        viewHolder.Time1.setText(Item.getTime1());
        viewHolder.Item_Name.setText(Item.getItem_Name());
        viewHolder.Teacher_Name.setText(Item.getTeacher_Name());
        viewHolder.Item_Mode.setText(Item.getItem_Mode());
        viewHolder.Item_Auditorium.setText("ауд. " + Item.getItem_Auditorium());
        viewHolder.Item_Building.setText("к. " + Item.getItem_Building());

        final View finalView = convertView;

        if (Item.getTeacher_Mail().equals("")) viewHolder.Mail_button.setVisibility(View.INVISIBLE);
        else viewHolder.Mail_button.setVisibility(View.VISIBLE);

        if (Item.getTeacher_Phone().equals(""))
            viewHolder.Phone_button.setVisibility(View.INVISIBLE);
        else viewHolder.Phone_button.setVisibility(View.VISIBLE);


        viewHolder.File_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(finalView.getContext(), ItemNoteActivity.class);

                intent.putExtra("Item_Name", Item.getItem_Name());
                intent.putExtra("Note", Item.getItem_Notes());

                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                finalView.getContext().startActivity(intent);
            }
        });

        viewHolder.List_Item_Layout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                viewHolder.List_Item_Layout.setBackground(ContextCompat.getDrawable(finalView.getContext(), R.drawable.ic_mainlistrow_v3_background_picture_flat_selected));
                return false;
            }
        });

        viewHolder.Phone_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(finalView.getContext(), "Номер телефона: " + Item.getTeacher_Phone(), Toast.LENGTH_LONG).show();
            }
        });

        viewHolder.Mail_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(finalView.getContext(), "Пошта: " + Item.getTeacher_Mail(), Toast.LENGTH_LONG).show();
            }
        });

        return convertView;
    }

    private class ViewHolder {
        final TextView Time0, Time1, Item_Name, Teacher_Name, Item_Mode, Item_Auditorium, Item_Building;
        final Button File_button, Mail_button, Phone_button;
        final ConstraintLayout List_Item_Layout;

        ViewHolder(View view) {
            Time0 = view.findViewById(R.id.textView_time0_flat);
            Time1 = view.findViewById(R.id.textView_time1_flat);
            Item_Name = view.findViewById(R.id.textView_item_name_flat);
            Teacher_Name = view.findViewById(R.id.textView_item_teacher_flat);
            Item_Mode = view.findViewById(R.id.textView_item_mode_flat);
            Item_Auditorium = view.findViewById(R.id.textView_item_auditorium_flat);
            Item_Building = view.findViewById(R.id.textView_item_building_flat);
            File_button = view.findViewById(R.id.File_button);
            Mail_button = view.findViewById(R.id.Mail_button);
            Phone_button = view.findViewById(R.id.Phone_button);
            List_Item_Layout = view.findViewById(R.id.Item_layout_flat);
        }
    }
}


