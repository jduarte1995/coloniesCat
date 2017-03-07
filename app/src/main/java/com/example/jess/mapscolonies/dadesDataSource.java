package com.example.jess.mapscolonies;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Jesús on 24/02/2017.
 */

public class dadesDataSource {

    private static SQLiteDatabase db;
    private coloniesOpenHelper admin;

    public dadesDataSource(Context context){
        admin = new coloniesOpenHelper(context);

        open();
    }

    private void open() {
        db = admin.getWritableDatabase();
    }

    private void finlize(){
        db.close();
    }




    public Cursor cargaLlocs() {
        // Retornem tots els llocs
        Cursor cursor = db.rawQuery("SELECT * FROM lloc",null);
        return cursor;
    }

    public Cursor retornaTag(long id){

        String[] s = new String[] {Long.toString(id)};

        Cursor cursor = db.rawQuery("Select tag from lloc where _id = ? ",s);

        return cursor;
    }

    public Cursor retornaPregunta(int iden){


        String[] pregunta = new String[] {Integer.toString(iden)};
        Cursor cursor = db.rawQuery("select * from pregunta where id_pregunta = ? ",pregunta);


        return cursor;
    }
    public Cursor retornaResposta(int id){

        String[] s = new String[] {Integer.toString(id)};

        Cursor cursor = db.rawQuery("Select resposta from resposta where id_pregunta = ? ",s);

        return cursor;
    }

    public void insertaRespostes(String nomNen ,int id_pregunta, String resposta){

        String[] s = new String[]{nomNen,Integer.toString(id_pregunta),resposta};

        db.execSQL("insert into resultat (nom_usuari,id_pregunta,resposta) values (?,?,?)",s);

    }

    public Cursor retornaRespostes(int id_pregunta){
        String[] s = new String[]{Integer.toString(id_pregunta)};

        Cursor cursor = db.rawQuery("Select resposta from resultat where id_pregunta = ?",s);

        return cursor;
    }

    public Cursor retornaDescripcio(int id_lloc){
        String[] s = new String[]{Integer.toString(id_lloc)};

        Cursor cursor = db.rawQuery("Select descripcio from lloc where _id = ?",s);

        return cursor;
    }

}
