package com.example.jess.mapscolonies;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Jesús on 31/01/2017.
 */

public class cursorAdapterLlocs extends android.widget.SimpleCursorAdapter {




    public cursorAdapterLlocs(Context context, int layout, Cursor c, String[] from, int[] to, int flags) {
        super(context, layout, c, from, to, flags);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = super.getView(position, convertView, parent);

        Cursor actual = (Cursor) getItem(position);

        String tag = actual.getString(actual.getColumnIndexOrThrow("tag"));

        switch(tag){

            case "cccb":
                view.findViewById(R.id.img).setBackgroundResource(R.drawable.cccb);
                break;
            case "macba":
                view.findViewById(R.id.img).setBackgroundResource(R.drawable.macba);
                break;
            case "llatzer":
                view.findViewById(R.id.img).setBackgroundResource(R.drawable.llatzer);
                break;
            case "creu":
                view.findViewById(R.id.img).setBackgroundResource(R.drawable.creu);
                break;
            case "teatre":
                view.findViewById(R.id.img).setBackgroundResource(R.drawable.teatre);
                break;
            case "municipal":
                view.findViewById(R.id.img).setBackgroundResource(R.drawable.municipal);
                break;
            case "modernista":
                view.findViewById(R.id.img).setBackgroundResource(R.drawable.modernista);
                break;

        }





        return view;
    }
}
