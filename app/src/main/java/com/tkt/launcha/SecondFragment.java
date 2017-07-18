package com.tkt.launcha;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by n1120697 on 18/7/17.
 */

public class SecondFragment extends Fragment {


    String color_names[] = {"red", "green", "blue", "yellow", "pink", "brown"};
    Integer image_id[] = {R.drawable.pin, R.drawable.radar, R.drawable.pin, R.drawable.radar, R.drawable.pin, R.drawable.radar};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_contactos, container, false);

        TextView textView = (TextView) v.findViewById(R.id.section_label2);
        textView.setText("Contacts");

        //
        Customlistadapter adapter = new Customlistadapter(getActivity(), image_id, color_names);
        ListView lv = (ListView) v.findViewById(R.id.listView);
        lv.setAdapter(adapter);
        //

        return v;
    }

    public static SecondFragment newInstance(String text) {

        SecondFragment f = new SecondFragment();
        Bundle b = new Bundle();
        b.putString("msg", text);

        f.setArguments(b);

        return f;
    }
}
