package com.example.jess.mapscolonies;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by rafafernandezdominguez on 26/1/17.
 */

public class coloniesOpenHelper extends SQLiteOpenHelper {

    // database version
    private static final int database_VERSION = 1;
    // database name
    private static final String database_NAME = "coloniescat";

    public coloniesOpenHelper(Context context) {
        super(context, database_NAME, null, database_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_LLOC =
                "CREATE TABLE lloc ( _id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "nom TEXT," +
                        "descripcio TEXT," +
                        "direccio TEXT," +
                        "tag TEXT " +
                        ")";

        String CREATE_PREGUNTES =
                "CREATE TABLE pregunta ( _id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "id_lloc INTEGER,"+
                        "id_pregunta INTEGER," +
                        "text TEXT" +
                        ")";

        String CREATE_RESPOSTES =
                "CREATE TABLE resposta ( _id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "id_pregunta INTEGER," +
                        "resposta TEXT)";

        //per a les respostes dels nens
        String CREATE_RESULTATS = "CREATE TABLE resultat (_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "nom_usuari TEXT,"+
                        "id_pregunta INTEGER," +
                        "resposta TEXT)";

        db.execSQL(CREATE_LLOC);
        db.execSQL(CREATE_PREGUNTES);
        db.execSQL(CREATE_RESPOSTES);
        db.execSQL(CREATE_RESULTATS);



            //region llocs
            db.execSQL("insert into lloc (nom,descripcio,direccio,tag) values " +
                    "(" +
                    "'Centre de Cultura Contemporania de Barcelona (CCCB)'," +
                    "'Centre cultural i expositiu més visitat de la ciutat de Barcelona. Té com a temàtica principal la ciutat i la cultura urbana.'," +
                    "'Carrer de Montalegre, 5, 08001 Barcelona'," +
                    "'cccb'"+
                    ")");

            db.execSQL("insert into lloc (nom,descripcio,direccio,tag) values " +
                    "(" +
                    "'Museu d´ Art Contemporani de Barcelona (MACBA)'," +
                    "'Conegut també per les seves sigles MACBA, està dedicat a l´exposició d´obres realitzades durant la segona meitat del segle XX.'," +
                    "'Plaça dels Àngels, 1, 08001 Barcelona'," +
                    "'macba'"+
                    ")");

            db.execSQL("insert into lloc (nom,descripcio,direccio,tag) values " +
                    "(" +
                    "'Esglèsia de Sant Llàtzer'," +
                    "'Capella romànica que havia format part d´un hospital situat en aquest lloc entre els segles XII i XV, anomenat dels Messells o dels Malalts, dedicat a atendre els leprosos.'," +
                    "'Plaça del Pedró, 1, 08001 Barcelona'," +
                    "'llatzer'" +
                    ")");

            db.execSQL("insert into lloc (nom,descripcio,direccio,tag) values " +
                    "(" +
                    "'Hospital de la Santa Cruz'," +
                    "'Lloc on es recuperaven els malalts que ja havien estat atesos a l´hospital abans de poder tornar a casa.'," +
                    "'Carrer de Sant Quintí, 89, 08026 Barcelona'," +
                    "'creu'"+
                    ")");

            db.execSQL("insert into lloc (nom,descripcio,direccio,tag) values " +
                    "(" +
                    "'Teatre del Raval'," +
                    "'El Teatre del Raval és un espai teatral situat dins dels espais parroquials de l´Església de Nuestra Señora de Carmen.'," +
                    "'Carrer de Sant Antoni Abat, 12, 08001 Barcelona'," +
                    "'teatre'"+
                    ")");

            db.execSQL("insert into lloc (nom,descripcio,direccio,tag) values " +
                    "(" +
                    "'Consell Municipal del Districte de Ciutat Vella'," +
                    "'Centre d´ espai públic i municipal amb funció d´ atendre i gestionar les peticions socials.'," +
                    "'Plaça del Bonsuccés, 08001 Barcelona'," +
                    "'municipal'"+
                    ")");

            db.execSQL("insert into lloc (nom,descripcio,direccio,tag) values " +
                    "(" +
                    "'Edificis del Modernisme'," +
                    "'Conjunt d´edificis d´estil modernista.'," +
                    "'Carrer del Carme, 08001 Barcelona'," +
                    "'modernista'"+
                    ")");
        //endregion

            //region preguntes
            db.execSQL("insert into pregunta (id_lloc, id_pregunta,text) values " +
                    "(" +
                    "1,"+
                    "1," +
                    "'Que és?'" +
                    ")");

            db.execSQL("insert into pregunta (id_lloc, id_pregunta,text) values " +
                    "(" +
                    "1,"+
                    "2," +
                    "'Que hi ha al sostre del vestíbul?'" +
                    ")");

            db.execSQL("insert into pregunta (id_lloc, id_pregunta,text) values " +
                    "(" +
                    "1," +
                    "3," +
                    "'Quin és el seu horari?'" +
                    ")");

            //pregunta2 macba
            db.execSQL("insert into pregunta (id_lloc, id_pregunta,text) values " +
                    "(" +
                    "2," +
                    "4," +
                    "'Que significa Ravalejar?'" +
                    ")");
            db.execSQL("insert into pregunta (id_lloc, id_pregunta,text) values " +
                    "(" +
                    "2," +
                    "5," +
                    "'A on has trobat el significat?'" +
                    ")");
            db.execSQL("insert into pregunta (id_lloc, id_pregunta,text) values " +
                    "(" +
                    "2," +
                    "6," +
                    "'Quina funció té actualment el Convent dels Àngels?'" +
                    ")");

            //pregunta3
            db.execSQL("insert into pregunta (id_lloc, id_pregunta,text) values " +
                    "(" +
                    "3," +
                    "7," +
                    "'Quin estil arquitectònic té?'" +
                    ")");
            db.execSQL("insert into pregunta (id_lloc, id_pregunta,text) values " +
                    "(" +
                    "3," +
                    "8," +
                    "'Entre quins segles creus que es va construïr?'" +
                    ")");

            //pregunta4
            db.execSQL("insert into pregunta (id_lloc, id_pregunta,text) values " +
                    "(" +
                    "4," +
                    "9," +
                    "'Que significa Convalescència?'" +
                    ")");

            db.execSQL("insert into pregunta (id_lloc, id_pregunta,text) values " +
                    "(" +
                    "4," +
                    "10," +
                    "'Quines lletres trobem sota l´escut?'" +
                    ")");

            //pregunta5
            db.execSQL("insert into pregunta (id_lloc, id_pregunta,text) values " +
                    "(" +
                    "5," +
                    "11," +
                    "'Quina obra s´està representant?'" +
                    ")");

            //pregunta6
            db.execSQL("insert into pregunta (id_lloc, id_pregunta,text) values " +
                    "(" +
                    "6," +
                    "12," +
                    "'Selecciona 4 serveis de l´ ajuntament'" +
                    ")");

            db.execSQL("insert into pregunta (id_lloc, id_pregunta,text) values " +
                    "(" +
                    "6," +
                    "13," +
                    "'Quins barris comprenen el districte de Ciutat Vella?'" +
                    ")");

            //pregunta7
            db.execSQL("insert into pregunta (id_lloc, id_pregunta,text) values " +
                    "(" +
                    "7," +
                    "14," +
                    "'Adreça del edifici'" +
                    ")");

            db.execSQL("insert into pregunta (id_lloc, id_pregunta,text) values " +
                    "(" +
                    "7," +
                    "15," +
                    "'Quins elements t´ho fan pensar?'" +
                    ")");

                //endregion

            //region respostes
            //pregunta 1.1
            db.execSQL("insert into resposta ( id_pregunta, resposta) values " +
                    "(" +
                    "1," +
                    "'Una escola'" +
                    ")");

            db.execSQL("insert into resposta ( id_pregunta, resposta) values " +
                    "(" +
                    "1," +
                    "'Una fabrica'" +
                    ")");

            db.execSQL("insert into resposta ( id_pregunta, resposta) values " +
                    "(" +
                    "1," +
                    "'Un museu'" +
                    ")");

            //respostes pregunta 1.2
            db.execSQL("insert into resposta ( id_pregunta, resposta) values " +
                    "(" +
                    "2," +
                    "'Un dinosaure'" +
                    ")");

            db.execSQL("insert into resposta ( id_pregunta, resposta) values " +
                    "(" +
                    "2," +
                    "'Un mirall'" +
                    ")");

            db.execSQL("insert into resposta ( id_pregunta, resposta) values " +
                    "(" +
                    "2," +
                    "'Un avió'" +
                    ")");

            //respostes pregunta 1.3
            db.execSQL("insert into resposta ( id_pregunta, resposta) values " +
                    "(" +
                    "3," +
                    "'De 09:00 a 18:00'" +
                    ")");

            db.execSQL("insert into resposta ( id_pregunta, resposta) values " +
                    "(" +
                    "3," +
                    "'De 11:00 a 20:00'" +
                    ")");

            db.execSQL("insert into resposta ( id_pregunta, resposta) values " +
                    "(" +
                    "3," +
                    "'De 14:00 a 22:00'" +
                    ")");

            //respostes pregunta 2.1
            db.execSQL("insert into resposta (id_pregunta,resposta) values " +
                    "(" +
                    "4," +
                    "'Qualsevol acció duta a terme al barri'" +
                    ")");

            db.execSQL("insert into resposta (id_pregunta,resposta) values " +
                    "(" +
                    "4," +
                    "'Comprar peres al barri'" +
                    ")");

            db.execSQL("insert into resposta (id_pregunta,resposta) values " +
                    "(" +
                    "4," +
                    "'Anar a misa'" +
                    ")");

            //respostes pregunta 2.2
            db.execSQL("insert into resposta (id_pregunta,resposta) values " +
                    "(" +
                    "5," +
                    "'A internet'" +
                    ")");

            db.execSQL("insert into resposta (id_pregunta,resposta) values " +
                    "(" +
                    "5," +
                    "'A l´ ajuntament'" +
                    ")");

            db.execSQL("insert into resposta (id_pregunta,resposta) values " +
                    "(" +
                    "5," +
                    "'A veïns del barri'" +
                    ")");

            //respostes pregunta 2.3
            db.execSQL("insert into resposta (id_pregunta,resposta) values " +
                    "(" +
                    "6," +
                    "'Cafeteria'" +
                    ")");

            db.execSQL("insert into resposta (id_pregunta,resposta) values " +
                    "(" +
                    "6," +
                    "'Església'" +
                    ")");

            db.execSQL("insert into resposta (id_pregunta,resposta) values " +
                    "(" +
                    "6," +
                    "'Museu arxiu'" +
                    ")");

            //respostes pregunta 3.1
            db.execSQL("insert into resposta (id_pregunta,resposta) values " +
                    "(" +
                    "7," +
                    "'Romànic'" +
                    ")");

            db.execSQL("insert into resposta (id_pregunta,resposta) values " +
                    "(" +
                    "7," +
                    "'Gòtic'" +
                    ")");

            db.execSQL("insert into resposta (id_pregunta,resposta) values " +
                    "(" +
                    "7," +
                    "'Modernista'" +
                    ")");

            //respostes pregunta 3.2
            db.execSQL("insert into resposta (id_pregunta,resposta) values " +
                    "(" +
                    "8," +
                    "'X - XII'" +
                    ")");
            db.execSQL("insert into resposta (id_pregunta,resposta) values " +
                    "(" +
                    "8," +
                    "'XIII - XVI'" +
                    ")");
            db.execSQL("insert into resposta (id_pregunta,resposta) values " +
                    "(" +
                    "8," +
                    "'IX - XII'" +
                    ")");

            //respostes pregunta 4.1
            db.execSQL("insert into resposta (id_pregunta,resposta) values " +
                    "(" +
                    "9," +
                    "'Temps d´ espera en una operació'" +
                    ")");

            db.execSQL("insert into resposta (id_pregunta,resposta) values " +
                    "(" +
                    "9," +
                    "'Temps d´ espera per arribar a casa'" +
                    ")");

            db.execSQL("insert into resposta (id_pregunta,resposta) values " +
                    "(" +
                    "9," +
                    "'Temps de recuperació d´una enfermetat'" +
                    ")");

            //respostes pregunta 4.2
            db.execSQL("insert into resposta (id_pregunta,resposta) values " +
                    "(" +
                    "10," +
                    "'HVGVET'" +
                    ")");
            db.execSQL("insert into resposta (id_pregunta,resposta) values " +
                    "(" +
                    "10," +
                    "'HGVEVT'" +
                    ")");
            db.execSQL("insert into resposta (id_pregunta,resposta) values " +
                    "(" +
                    "10," +
                    "'HTVEGR'" +
                    ")");

            //respostes pregunta 6.1
            db.execSQL("insert into resposta (id_pregunta,resposta) values " +
                    "(" +
                    "12," +
                    "'Cultura i oci'" +
                    ")");

            db.execSQL("insert into resposta (id_pregunta,resposta) values " +
                    "(" +
                    "12," +
                    "'Festes i menjars'" +
                    ")");

            db.execSQL("insert into resposta (id_pregunta,resposta) values " +
                    "(" +
                    "12," +
                    "'Educació'" +
                    ")");

            db.execSQL("insert into resposta (id_pregunta,resposta) values " +
                    "(" +
                    "12," +
                    "'Venda ambulant'" +
                    ")");

            db.execSQL("insert into resposta (id_pregunta,resposta) values " +
                    "(" +
                    "12," +
                    "'Movilitat'" +
                    ")");

            db.execSQL("insert into resposta (id_pregunta,resposta) values " +
                    "(" +
                    "12," +
                    "'Taxis'" +
                    ")");

            db.execSQL("insert into resposta (id_pregunta,resposta) values " +
                    "(" +
                    "12," +
                    "'Treball'" +
                    ")");

            //respostes pregunta 6.2
            db.execSQL("insert into resposta (id_pregunta,resposta) values " +
                    "(" +
                    "13," +
                    "'Gòtic'" +
                    ")");

            db.execSQL("insert into resposta (id_pregunta,resposta) values " +
                    "(" +
                    "13," +
                    "'Raval'" +
                    ")");

            db.execSQL("insert into resposta (id_pregunta,resposta) values " +
                    "(" +
                    "13," +
                    "'Barcelonata'" +
                    ")");

            db.execSQL("insert into resposta (id_pregunta,resposta) values " +
                    "(" +
                    "13," +
                    "'Eixample'" +
                    ")");

            db.execSQL("insert into resposta (id_pregunta,resposta) values " +
                    "(" +
                    "13," +
                    "'St Pere'" +
                    ")");

            db.execSQL("insert into resposta (id_pregunta,resposta) values " +
                    "(" +
                    "13," +
                    "'Sta Caterina'" +
                    ")");

            db.execSQL("insert into resposta (id_pregunta,resposta) values " +
                    "(" +
                    "13," +
                    "'La Ribera'" +
                    ")");
            //endregion

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
