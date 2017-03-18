package com.example.jess.myapplicationmaps;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

public class Fragment1 extends Fragment {

    private static String[] from = new String[]{"nom","descripcio"};
    private static int[] to = new int[]{R.id.nom_lloc, R.id.descripcio_lloc};

    private dadesDataSource bd ;
    private cursorAdapterLlocs cAdapter;
    public static MainActivity context;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment1_layout, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        bd = new dadesDataSource(context);
        cargarLlocs();

    }



    private void cargarLlocs() {
        Cursor cursor = bd.cargaLlocs();

        cAdapter = new cursorAdapterLlocs (getView().getContext(), R.layout.row_lloc,cursor, from, to, 1);
        ListView lv = (ListView) getView().findViewById(R.id.llocs_list);
        lv.setAdapter(cAdapter);

        lv.setOnItemClickListener(
                new AdapterView.OnItemClickListener()
                {
                    @Override
                    public void onItemClick(AdapterView<?> arg0, View view,
                                            int position, long id) {

                        mostrarPreguntes(id);
                    }
                }
        );

    }

    private void mostrarPreguntes(long id){
        Bundle b = new Bundle();
        b.putLong("id",id);

        Intent i = new Intent(getActivity(), preguntes.class);
        i.putExtras(b);
        startActivity(i);

    }


}
