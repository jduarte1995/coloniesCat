package com.example.jess.mapscolonies;

import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import static com.example.jess.mapscolonies.inici.nomAlumne;

/**
 * Created by Jesús on 28/02/2017.
 */

public class preguntes extends AppCompatActivity {
    //region variables y elements
    String tag;
    TextView pregunta;
    String[] correctes = new String[] {"Un museu","Un mirall","De 11:00 a 20:00","Qualsevol acció duta a terme al barri","Museu arxiu","Romànic","X - XII","Temps de recuperació d'una enfermetat","HVGVET","A internet","A l´ ajuntament","A veïns del barri"};
    String[] correctescb1 = new String[] {"Cultura i oci","Educació","Movilitat", "Treball"};
    String[] correctescb2 = new String[] {"Gòtic","Barceloneta","St Pere", "Sta Caterina","la Ribera"};



    private dadesDataSource bd ;
    long identificador;

    boolean sortir = false;
    static boolean cccb = false;
    static boolean macba = false;
    static boolean llatzer = false;
    static boolean creu = false;
    static boolean teatre = false;
    static boolean municipal = false;
    static boolean modernisme = false;

    ImageView imgNext;
    ImageView imgBack;
    ImageView imgTick;

    TextView tvDescripcio;

    RadioButton resposta1;
    RadioButton resposta2;
    RadioButton resposta3;

    CheckBox cbResposta1;
    CheckBox cbResposta2;
    CheckBox cbResposta3;
    CheckBox cbResposta4;
    CheckBox cbResposta5;
    CheckBox cbResposta6;
    CheckBox cbResposta7;

    EditText txtRespota;
    int i;

    String respostaPregunta1;
    String respostaPregunta2;
    String respostaPregunta3;
    String respostaPregunta4;
    String respostaPregunta5;
    String respostaPregunta6;
    String respostaPregunta7;
    String respostaPregunta8;
    String respostaPregunta9;
    String respostaPregunta10;
    String respostaPregunta11;
    String respostaPregunta12;
    String respostaPregunta13;
    String respostaPregunta14;
    String respostaPregunta15;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preguntas);

        //region Instancies
        ImageView img = (ImageView) findViewById(R.id.imgPreguntas);
        imgNext = (ImageView) findViewById(R.id.imgNext);
        imgBack = (ImageView) findViewById(R.id.imgBack);
        imgTick = (ImageView) findViewById(R.id.imgTick);

        tvDescripcio = (TextView) findViewById(R.id.tvDescripcio);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txtRespota = (EditText) findViewById(R.id.txtResposta);

        pregunta = (TextView) findViewById(R.id.pregunta);

        resposta1 = (RadioButton) findViewById(R.id.resposta1);
        resposta2 = (RadioButton) findViewById(R.id.resposta2);
        resposta3 = (RadioButton) findViewById(R.id.resposta3);

        cbResposta1 = (CheckBox) findViewById(R.id.cbResposta1);
        cbResposta2 = (CheckBox) findViewById(R.id.cbResposta2);
        cbResposta3 = (CheckBox) findViewById(R.id.cbResposta3);
        cbResposta4 = (CheckBox) findViewById(R.id.cbResposta4);
        cbResposta5 = (CheckBox) findViewById(R.id.cbResposta5);
        cbResposta6 = (CheckBox) findViewById(R.id.cbResposta6);
        cbResposta7 = (CheckBox) findViewById(R.id.cbResposta7);
//endregion

        bd = new dadesDataSource(this);

        Bundle b = getIntent().getExtras();
        identificador = b.getLong("id");
        Cursor cursor = bd.retornaTag(identificador);
        cursor.moveToFirst();

        tag = cursor.getString(cursor.getColumnIndex("tag"));

        switch(tag){
            case "cccb":
                cccb = true;
                setTitle("Questionari CCCB");
                Cursor cursorDescripcio1 = bd.retornaDescripcio(1);
                cursorDescripcio1.moveToFirst();
                tvDescripcio.setText(cursorDescripcio1.getString(cursorDescripcio1.getColumnIndex("descripcio")));

                //region Funcionament PreguntaResposta i joc amb imagesViews CCCB
                img.setImageResource(R.drawable.cccb);


                i = 1;
                preguntaResposta(i);

                //region imgTick Funcional
                imgTick.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    if(sortir) {
                        LatLng cccb = new LatLng(41.383885,2.1645923);
                        Fragment2.googleMap.addMarker(new MarkerOptions().position(cccb).title("CCCB").icon(BitmapDescriptorFactory.fromResource(R.drawable.green_marker)));

                        onBackPressed();
                        sortir=false;
                    }else {
                        if (i == 1) {
                            respostaPregunta1 = retornaCorrecta();
                            //region insert
                            try {

                                bd.insertaRespostes(nomAlumne, 1, respostaPregunta1);
                                myDialogs.showToast(preguntes.this, "Resposta enviada");

                            } catch (Exception e) {

                                myDialogs.showToast(preguntes.this, "Error al enviar");

                            }
                            //endregion
                            i++;
                            preguntaResposta(i);
                            aFalse();
                            return;
                        }

                        if (i == 2) {
                            respostaPregunta2 = retornaCorrecta();
                            //region insert
                            try {

                                bd.insertaRespostes(nomAlumne, 2, respostaPregunta2);
                                myDialogs.showToast(preguntes.this, "Resposta enviada");

                            } catch (Exception e) {

                                myDialogs.showToast(preguntes.this, "Error al enviar");

                            }
                            //endregion
                            i++;
                            preguntaResposta(i);
                            aFalse();
                            return;
                        }
                        if (i == 3) {
                            respostaPregunta3 = retornaCorrecta();
                            //region insert
                            try {

                                bd.insertaRespostes(nomAlumne, 3, respostaPregunta3);
                                myDialogs.showToast(preguntes.this, "Resposta enviada");
                                onBackPressed();

                            } catch (Exception e) {

                                myDialogs.showToast(preguntes.this, "Error al enviar");

                            }
                            //endregion
                        }
                    }
                        LatLng cccb = new LatLng(41.383885,2.1645923);
                        Fragment2.googleMap.addMarker(new MarkerOptions().position(cccb).title("CCCB").icon(BitmapDescriptorFactory.fromResource(R.drawable.green_marker)));

                    }
                });
                imgNext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        i++;
                        preguntaResposta(i);
                        if(i==1){
                            imgBack.setVisibility(View.INVISIBLE);
                            imgTick.setVisibility(View.GONE);
                            imgNext.setVisibility(View.VISIBLE);
                        }
                        if(i==2){
                            imgBack.setVisibility(View.VISIBLE);
                            imgTick.setVisibility(View.GONE);
                            imgNext.setVisibility(View.VISIBLE);
                        }
                        if(i==3) {
                           imgNext.setVisibility(View.GONE);
                           imgBack.setVisibility(View.VISIBLE);
                           imgTick.setVisibility(View.VISIBLE);
                           sortir =true;

                        }
                    }
                });

                imgBack.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        i--;
                        preguntaResposta(i);
                        if(i==1){
                            imgBack.setVisibility(View.GONE);
                            imgTick.setVisibility(View.GONE);
                            imgNext.setVisibility(View.VISIBLE);
                        }
                        if(i==2){
                            imgBack.setVisibility(View.VISIBLE);
                            imgTick.setVisibility(View.GONE);
                            imgNext.setVisibility(View.VISIBLE);
                        }
                        if(i==3) {
                            imgNext.setVisibility(View.GONE);
                            imgBack.setVisibility(View.VISIBLE);
                            imgTick.setVisibility(View.VISIBLE);
                            sortir =true;

                        }

                    }
                });
                //endregion

                //endregion
                break;

            case "macba":
                macba = true;
                setTitle("Questionari MACBA");
                Cursor cursorDescripcio2 = bd.retornaDescripcio(2);
                cursorDescripcio2.moveToFirst();
                tvDescripcio.setText(cursorDescripcio2.getString(cursorDescripcio2.getColumnIndex("descripcio")));

                //region Funcionament PreguntaResposta i joc amb imagesViews macba

                img.setImageResource(R.drawable.macba);
                i = 4;
                preguntaResposta(i);

                //region imgTick Funcional
                imgTick.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    if(sortir) {
                        LatLng macba = new LatLng(41.3828463,2.1649398);
                        Fragment2.googleMap.addMarker(new MarkerOptions().position(macba).title("MACBA").icon(BitmapDescriptorFactory.fromResource(R.drawable.green_marker)));

                        onBackPressed();
                        sortir=false;
                    }else {
                        if (i == 4) {
                            respostaPregunta4 = retornaCorrecta();
                            //region insert
                            try {

                                bd.insertaRespostes(nomAlumne, 4, respostaPregunta4);
                                myDialogs.showToast(preguntes.this, "Resposta enviada");

                            } catch (Exception e) {

                                myDialogs.showToast(preguntes.this, "Error al enviar");

                            }
                            //endregion
                            i++;
                            preguntaResposta(i);
                            aFalse();
                            return;
                        }

                        if (i == 5) {
                            respostaPregunta5 = retornaCorrecta();
                            //region insert
                            try {

                                bd.insertaRespostes(nomAlumne, 5, respostaPregunta5);
                                myDialogs.showToast(preguntes.this, "Resposta enviada");

                            } catch (Exception e) {

                                myDialogs.showToast(preguntes.this, "Error al enviar");

                            }
                            //endregion
                            i++;
                            preguntaResposta(i);
                            aFalse();
                            return;
                        }

                        if (i == 6) {
                            respostaPregunta6 = retornaCorrecta();
                            //region insert
                            try {

                                bd.insertaRespostes(nomAlumne, 6, respostaPregunta6);
                                myDialogs.showToast(preguntes.this, "Resposta enviada");
                                onBackPressed();

                            } catch (Exception e) {

                                myDialogs.showToast(preguntes.this, "Error al enviar");

                            }
                            //endregion

                        }
                    }
                        LatLng macba = new LatLng(41.3828463,2.1649398);
                        Fragment2.googleMap.addMarker(new MarkerOptions().position(macba).title("MACBA").icon(BitmapDescriptorFactory.fromResource(R.drawable.green_marker)));

                    }
                });
                imgNext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        sortir = true;
                        i++;

                        preguntaResposta(i);
                    if(i==4) {
                        imgBack.setVisibility(View.INVISIBLE);
                        imgTick.setVisibility(View.GONE);
                        imgNext.setVisibility(View.VISIBLE);

                    }
                    if(i==5){
                        imgNext.setVisibility(View.VISIBLE);
                        imgBack.setVisibility(View.VISIBLE);
                        imgTick.setVisibility(View.GONE);

                    }
                    if(i==6){
                        imgNext.setVisibility(View.GONE);
                        imgTick.setVisibility(View.VISIBLE);
                        imgBack.setVisibility(View.VISIBLE);


                    }

                    }
                });

                imgBack.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    sortir = true;
                    i--;
                    preguntaResposta(i);
                    if(i==4) {
                        imgNext.setVisibility(View.VISIBLE);
                        imgBack.setVisibility(View.INVISIBLE);
                        imgTick.setVisibility(View.GONE);

                    }
                    if(i==5){
                        imgNext.setVisibility(View.VISIBLE);
                        imgBack.setVisibility(View.VISIBLE);
                        imgTick.setVisibility(View.GONE);

                    }
                    if(i==6){
                        imgNext.setVisibility(View.GONE);
                        imgTick.setVisibility(View.VISIBLE);
                        imgBack.setVisibility(View.VISIBLE);

                    }

                    }
                });

                //endregion

                //endregion
                break;

            case "llatzer":
                llatzer = true;
                setTitle("Questionari esglèsia");
                Cursor cursorDescripcio3 = bd.retornaDescripcio(3);
                cursorDescripcio3.moveToFirst();
                tvDescripcio.setText(cursorDescripcio3.getString(cursorDescripcio3.getColumnIndex("descripcio")));

                //region Funcionament PreguntaResposta i joc amb imagesViews llatzer

                img.setImageResource(R.drawable.llatzer);
                i = 7;
                preguntaResposta(i);

                //region imgTick Funcional
                imgTick.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (sortir) {
                            LatLng llatzer = new LatLng(41.3828463,2.1649398);
                            Fragment2.googleMap.addMarker(new MarkerOptions().position(llatzer).title("Esglèsia").icon(BitmapDescriptorFactory.fromResource(R.drawable.green_marker)));

                            onBackPressed();
                            sortir = false;
                        } else {

                            if (i == 7) {
                                respostaPregunta7 = retornaCorrecta();

                                //region insert
                                try {

                                    bd.insertaRespostes(nomAlumne, 7, respostaPregunta7);
                                    myDialogs.showToast(preguntes.this, "Resposta enviada");

                                } catch (Exception e) {

                                    myDialogs.showToast(preguntes.this, "Error al enviar");

                                }
                                //endregion
                                i++;
                                preguntaResposta(i);
                                aFalse();
                                return;
                            }

                            if (i == 8) {
                                respostaPregunta8 = retornaCorrecta();

                                //region insert
                                try {

                                    bd.insertaRespostes(nomAlumne, 8, respostaPregunta8);
                                    myDialogs.showToast(preguntes.this, "Resposta enviada");
                                    onBackPressed();

                                } catch (Exception e) {

                                    myDialogs.showToast(preguntes.this, "Error al enviar");

                                }
                                //endregion

                            }
                        }
                        LatLng llatzer = new LatLng(41.3828463,2.1649398);
                        Fragment2.googleMap.addMarker(new MarkerOptions().position(llatzer).title("Esglèsia").icon(BitmapDescriptorFactory.fromResource(R.drawable.green_marker)));

                    }

                });

                imgNext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    sortir = true;
                    i++;
                    preguntaResposta(i);
                    if(i==7) {
                        imgNext.setVisibility(View.VISIBLE);
                        imgBack.setVisibility(View.INVISIBLE);
                        imgTick.setVisibility(View.GONE);

                    }
                    if(i==8){
                        imgNext.setVisibility(View.GONE);
                        imgBack.setVisibility(View.VISIBLE);
                        imgTick.setVisibility(View.VISIBLE);
                    }
                    }
                });

                imgBack.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    sortir = true;
                    i--;
                    preguntaResposta(i);
                        if(i==7) {
                            imgNext.setVisibility(View.VISIBLE);
                            imgBack.setVisibility(View.INVISIBLE);
                            imgTick.setVisibility(View.GONE);

                        }
                        if(i==8){
                            imgNext.setVisibility(View.GONE);
                            imgBack.setVisibility(View.VISIBLE);
                            imgTick.setVisibility(View.VISIBLE);
                        }
                    }
                });

                //endregion

                //endregion
                break;

            case "creu":
                creu = true;
                setTitle("Questionari Santa Creu");
                Cursor cursorDescripcio4 = bd.retornaDescripcio(4);
                cursorDescripcio4.moveToFirst();
                tvDescripcio.setText(cursorDescripcio4.getString(cursorDescripcio4.getColumnIndex("descripcio")));

                //region Funcionament PreguntaResposta i joc amb imagesViews creu

                img.setImageResource(R.drawable.creu);
                i = 9;
                preguntaResposta(i);

                //region imgTick Funcional
                imgTick.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(sortir){
                            LatLng creu = new LatLng(41.415727,2.1727505);
                            Fragment2.googleMap.addMarker(new MarkerOptions().position(creu).title("Hospital").icon(BitmapDescriptorFactory.fromResource(R.drawable.green_marker)));

                            onBackPressed();
                            sortir = false;
                        }else {

                            if (i == 9) {
                                respostaPregunta9 = retornaCorrecta();

                                //region insert
                                try {

                                    bd.insertaRespostes(nomAlumne, 9, respostaPregunta9);
                                    myDialogs.showToast(preguntes.this, "Resposta enviada");

                                } catch (Exception e) {

                                    myDialogs.showToast(preguntes.this, "Error al enviar");

                                }
                                //endregion
                                i++;
                                preguntaResposta(i);
                                aFalse();
                                return;
                            }

                            if (i == 10) {
                                respostaPregunta10 = retornaCorrecta();

                                //region insert
                                try {

                                    bd.insertaRespostes(nomAlumne, 10, respostaPregunta10);
                                    myDialogs.showToast(preguntes.this, "Resposta enviada");
                                    onBackPressed();

                                } catch (Exception e) {

                                    myDialogs.showToast(preguntes.this, "Error al enviar");

                                }
                                //endregion

                            }
                        }
                        LatLng creu = new LatLng(41.415727,2.1727505);
                        Fragment2.googleMap.addMarker(new MarkerOptions().position(creu).title("Hospital").icon(BitmapDescriptorFactory.fromResource(R.drawable.green_marker)));

                    }
                });
                imgNext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    sortir = true;
                    i++;
                    preguntaResposta(i);
                    if(i==9) {
                        imgNext.setVisibility(View.VISIBLE);
                        imgBack.setVisibility(View.INVISIBLE);
                        imgTick.setVisibility(View.GONE);

                    }
                    if(i==10){
                        imgNext.setVisibility(View.GONE);
                        imgTick.setVisibility(View.VISIBLE);
                        imgBack.setVisibility(View.VISIBLE);

                    }

                    }
                });

                imgBack.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    sortir = true;
                    i--;
                    preguntaResposta(i);
                    if(i==9) {
                        imgNext.setVisibility(View.VISIBLE);
                        imgBack.setVisibility(View.INVISIBLE);
                        imgTick.setVisibility(View.GONE);

                    }
                    if(i==10){
                        imgNext.setVisibility(View.GONE);
                        imgTick.setVisibility(View.VISIBLE);
                        imgBack.setVisibility(View.VISIBLE);

                    }

                    }
                });

                //endregion

               //endregion
                break;

            case "teatre":
                teatre = true;
                setTitle("Questionari Teatre");
                Cursor cursorDescripcio5 = bd.retornaDescripcio(5);
                cursorDescripcio5.moveToFirst();
                tvDescripcio.setText(cursorDescripcio5.getString(cursorDescripcio5.getColumnIndex("descripcio")));

                //region Funcionament PreguntaResposta i joc amb imagesViews teatre

                img.setImageResource(R.drawable.teatre);
                imgTick.setVisibility(View.VISIBLE);

                i = 11;
                preguntaResposta(i);

                imgTick.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (sortir) {
                            LatLng municipal = new LatLng(41.3839306,2.167326);
                            Fragment2.googleMap.addMarker(new MarkerOptions().position(municipal).title("Ajuntament").icon(BitmapDescriptorFactory.fromResource(R.drawable.green_marker)));

                            onBackPressed();
                            sortir = false;
                        }else{
                            bd.insertaRespostes(nomAlumne, 11, txtRespota.getText().toString());
                            myDialogs.showToast(preguntes.this, "Resposta enviada");
                            onBackPressed();
                        }
                        LatLng teatre = new LatLng(41.3793714,2.1630354);
                        Fragment2.googleMap.addMarker(new MarkerOptions().position(teatre).title("Teatre").icon(BitmapDescriptorFactory.fromResource(R.drawable.green_marker)));

                    }
                });
                //endregion
                break;

            case "municipal":
                municipal = true;
                setTitle("Questionari Ajuntament");
                Cursor cursorDescripcio6 = bd.retornaDescripcio(6);
                cursorDescripcio6.moveToFirst();
                tvDescripcio.setText(cursorDescripcio6.getString(cursorDescripcio6.getColumnIndex("descripcio")));

                //region Funcionament PreguntaResposta i joc amb imagesViews municipal

                img.setImageResource(R.drawable.municipal);
                i = 12;
                preguntaResposta(i);

                //region imgTick Funcional
                imgTick.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    if(sortir){
                        LatLng municipal = new LatLng(41.3839306,2.167326);
                        Fragment2.googleMap.addMarker(new MarkerOptions().position(municipal).title("Ajuntament").icon(BitmapDescriptorFactory.fromResource(R.drawable.green_marker)));

                        onBackPressed();
                        sortir = false;
                    }else {
                        if (i == 12) {
                            retornaCorrectaDif(12);
                            i++;
                            preguntaResposta(i);
                            aFalse();
                            return;
                        }
                        if (i == 13) {
                            retornaCorrectaDif(13);
                            onBackPressed();
                        }
                    }
                        LatLng municipal = new LatLng(41.3839306,2.167326);
                        Fragment2.googleMap.addMarker(new MarkerOptions().position(municipal).title("Ajuntament").icon(BitmapDescriptorFactory.fromResource(R.drawable.green_marker)));


                    }
                });
                imgNext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    sortir = true;
                    i++;
                    preguntaResposta(i);
                    if(i==12) {
                        imgNext.setVisibility(View.VISIBLE);
                        imgBack.setVisibility(View.INVISIBLE);
                        imgTick.setVisibility(View.GONE);

                    }
                    if(i==13){
                        imgNext.setVisibility(View.GONE);
                        imgTick.setVisibility(View.VISIBLE);
                        imgBack.setVisibility(View.VISIBLE);
                    }
                    }
                });

                imgBack.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        sortir=true;
                        i--;
                        preguntaResposta(i);
                        if(i==12) {
                            imgNext.setVisibility(View.VISIBLE);
                            imgBack.setVisibility(View.INVISIBLE);
                            imgTick.setVisibility(View.GONE);

                        }
                        if(i==13){
                            imgNext.setVisibility(View.GONE);
                            imgTick.setVisibility(View.VISIBLE);
                            imgBack.setVisibility(View.VISIBLE);
                        }
                    }
                });
                //endregion
                //endregion
                break;

            case "modernista":
                modernisme = true;
                setTitle("Questionari Modernisme");
                Cursor cursorDescripcio7 = bd.retornaDescripcio(7);
                cursorDescripcio7.moveToFirst();
                tvDescripcio.setText(cursorDescripcio7.getString(cursorDescripcio7.getColumnIndex("descripcio")));

                //region Funcionament PreguntaResposta i joc amb imagesViews modernista

                img.setImageResource(R.drawable.modernista);

                i = 14;
                preguntaResposta(i);

                //region imtTick Funcional
                imgTick.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                if(sortir){
                    LatLng modernista = new LatLng(41.3814243,2.1665269);
                    Fragment2.googleMap.addMarker(new MarkerOptions().position(modernista).title("Modernisme").icon(BitmapDescriptorFactory.fromResource(R.drawable.green_marker)));
                    onBackPressed();
                    sortir = false;
                }else {
                    if (i == 14) {
                        try {
                            bd.insertaRespostes(nomAlumne, 14, txtRespota.getText().toString());
                            myDialogs.showToast(preguntes.this, "Resposta enviada");
                        } catch (Exception e) {
                            myDialogs.showToast(preguntes.this, "Error al enviar");
                        }
                        i++;
                        preguntaResposta(i);
                        txtRespota.setText("");
                        return;
                    }
                    if (i == 15) {
                        try {
                            bd.insertaRespostes(nomAlumne, 15, txtRespota.getText().toString());
                            myDialogs.showToast(preguntes.this, "Resposta enviada");
                        } catch (Exception e) {
                            myDialogs.showToast(preguntes.this, "Error al enviar");
                        }
                    }

                    onBackPressed();
                }
                        LatLng modernista = new LatLng(41.3814243,2.1665269);
                        Fragment2.googleMap.addMarker(new MarkerOptions().position(modernista).title("Modernisme").icon(BitmapDescriptorFactory.fromResource(R.drawable.green_marker)));

                    }
                });
                imgNext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        sortir = true;
                        i++;
                        preguntaResposta(i);
                    if(i==14) {
                        imgNext.setVisibility(View.VISIBLE);
                        imgTick.setVisibility(View.GONE);
                        imgBack.setVisibility(View.INVISIBLE);
                    }
                    if(i==15){
                        imgNext.setVisibility(View.GONE);
                        imgTick.setVisibility(View.VISIBLE);
                        imgBack.setVisibility(View.VISIBLE);
                    }
                    }
                });

                imgBack.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        sortir = true;
                        i--;
                        preguntaResposta(i);
                        if(i==14) {
                            imgNext.setVisibility(View.VISIBLE);
                            imgTick.setVisibility(View.GONE);
                            imgBack.setVisibility(View.INVISIBLE);
                        }
                        if(i==15){
                            imgTick.setVisibility(View.VISIBLE);
                            imgNext.setVisibility(View.GONE);
                            imgBack.setVisibility(View.VISIBLE);
                        }
                    }
                });
                //endregion


                //endregion
                break;
        }
    }

    private void preguntaResposta(int i){
        String respostaBD;
        switch (i) {

            //region case 12
            case 12:
                aFalse();
                resposta1.setVisibility(View.GONE);
                resposta2.setVisibility(View.GONE);
                resposta3.setVisibility(View.GONE);

                Cursor cursorPregunta12 = bd.retornaPregunta(i);
                cursorPregunta12.moveToFirst();
                pregunta.setText(cursorPregunta12.getString(cursorPregunta12.getColumnIndex("text")));

                Cursor cursorRespota12 = bd.retornaResposta(i);
                cursorRespota12.moveToFirst();

                Cursor cursorRespostesBD = bd.retornaRespostes(12);

                if(cursorRespostesBD.getCount()>0) {
                    int x = 0;
                    cbResposta1.setVisibility(View.VISIBLE);
                    cbResposta1.setText(cursorRespota12.getString(cursorRespota12.getColumnIndex("resposta")));
                    cbResposta1.setTextColor(Color.parseColor("#ff0000"));

                    cursorRespostesBD.moveToFirst();

                    while (x < cursorRespostesBD.getCount()) {

                        String respostaBD12 = cursorRespostesBD.getString(cursorRespostesBD.getColumnIndex("resposta"));
                        for (int y = 0; y < correctescb1.length; y++) {
                            if (cbResposta1.getText().equals(correctescb1[y])) {
                                cbResposta1.setTextColor(Color.parseColor("#00ff00"));
                            }
                        }
                        if (cbResposta1.getText().equals(respostaBD12)) {
                            cbResposta1.setChecked(true);

                            noClick();
                        }
                        cursorRespostesBD.moveToNext();
                        x++;
                    }

                    cursorRespota12.moveToNext();

                    cbResposta2.setVisibility(View.VISIBLE);
                    cbResposta2.setText(cursorRespota12.getString(cursorRespota12.getColumnIndex("resposta")));
                    cbResposta2.setTextColor(Color.parseColor("#ff0000"));

                    cursorRespostesBD.moveToFirst();
                    x = 0;
                    while (x < cursorRespostesBD.getCount()) {

                        String respostaBD12 = cursorRespostesBD.getString(cursorRespostesBD.getColumnIndex("resposta"));
                        for (int y = 0; y < correctescb1.length; y++) {
                            if (cbResposta2.getText().equals(correctescb1[y])) {
                                cbResposta2.setTextColor(Color.parseColor("#00ff00"));
                            }
                        }
                        if (cbResposta2.getText().equals(respostaBD12)) {
                            cbResposta2.setChecked(true);

                            noClick();


                        }
                        cursorRespostesBD.moveToNext();
                        x++;
                    }

                    cursorRespota12.moveToNext();


                    cbResposta3.setVisibility(View.VISIBLE);
                    cbResposta3.setText(cursorRespota12.getString(cursorRespota12.getColumnIndex("resposta")));
                    cbResposta3.setTextColor(Color.parseColor("#ff0000"));

                    cursorRespostesBD.moveToFirst();
                    x = 0;
                    while (x < cursorRespostesBD.getCount()) {

                        String respostaBD12 = cursorRespostesBD.getString(cursorRespostesBD.getColumnIndex("resposta"));
                        for (int y = 0; y < correctescb1.length; y++) {
                            if (cbResposta3.getText().equals(correctescb1[y])) {
                                cbResposta3.setTextColor(Color.parseColor("#00ff00"));
                            }
                        }
                        if (cbResposta3.getText().equals(respostaBD12)) {
                            cbResposta3.setChecked(true);

                            noClick();


                        }
                        cursorRespostesBD.moveToNext();
                        x++;
                    }

                    cursorRespota12.moveToNext();

                    cbResposta4.setVisibility(View.VISIBLE);
                    cbResposta4.setText(cursorRespota12.getString(cursorRespota12.getColumnIndex("resposta")));
                    cbResposta4.setTextColor(Color.parseColor("#ff0000"));

                    cursorRespostesBD.moveToFirst();
                    x = 0;
                    while (x < cursorRespostesBD.getCount()) {

                        String respostaBD12 = cursorRespostesBD.getString(cursorRespostesBD.getColumnIndex("resposta"));
                        for (int y = 0; y < correctescb1.length; y++) {
                            if (cbResposta4.getText().equals(correctescb1[y])) {
                                cbResposta4.setTextColor(Color.parseColor("#00ff00"));
                            }
                        }
                        if (cbResposta4.getText().equals(respostaBD12)) {
                            cbResposta4.setChecked(true);

                            noClick();


                        }
                        cursorRespostesBD.moveToNext();
                        x++;
                    }
                    cursorRespota12.moveToNext();

                    cbResposta5.setVisibility(View.VISIBLE);
                    cbResposta5.setText(cursorRespota12.getString(cursorRespota12.getColumnIndex("resposta")));
                    cbResposta5.setTextColor(Color.parseColor("#ff0000"));

                    cursorRespostesBD.moveToFirst();
                    x = 0;
                    while (x < cursorRespostesBD.getCount()) {

                        String respostaBD12 = cursorRespostesBD.getString(cursorRespostesBD.getColumnIndex("resposta"));
                        for (int y = 0; y < correctescb1.length; y++) {
                            if (cbResposta5.getText().equals(correctescb1[y])) {
                                cbResposta5.setTextColor(Color.parseColor("#00ff00"));
                            }
                        }
                        if (cbResposta5.getText().equals(respostaBD12)) {
                            cbResposta5.setChecked(true);

                            noClick();


                        }
                        cursorRespostesBD.moveToNext();
                        x++;
                    }

                    cursorRespota12.moveToNext();

                    cbResposta6.setVisibility(View.VISIBLE);
                    cbResposta6.setText(cursorRespota12.getString(cursorRespota12.getColumnIndex("resposta")));
                    cbResposta6.setTextColor(Color.parseColor("#ff0000"));

                    cursorRespostesBD.moveToFirst();
                    x = 0;
                    while (x < cursorRespostesBD.getCount()) {

                        String respostaBD12 = cursorRespostesBD.getString(cursorRespostesBD.getColumnIndex("resposta"));
                        for (int y = 0; y < correctescb1.length; y++) {
                            if (cbResposta6.getText().equals(correctescb1[y])) {
                                cbResposta6.setTextColor(Color.parseColor("#00ff00"));
                            }
                        }
                        if (cbResposta6.getText().equals(respostaBD12)) {
                            cbResposta6.setChecked(true);

                            noClick();


                        }
                        cursorRespostesBD.moveToNext();
                        x++;
                    }

                    cursorRespota12.moveToNext();

                    cbResposta7.setVisibility(View.VISIBLE);
                    cbResposta7.setText(cursorRespota12.getString(cursorRespota12.getColumnIndex("resposta")));
                    cbResposta7.setTextColor(Color.parseColor("#ff0000"));

                    cursorRespostesBD.moveToFirst();
                    x = 0;
                    while (x < cursorRespostesBD.getCount()) {

                        String respostaBD12 = cursorRespostesBD.getString(cursorRespostesBD.getColumnIndex("resposta"));

                        for (int y = 0; y < correctescb1.length; y++) {
                            if (cbResposta7.getText().equals(correctescb1[y])) {
                                cbResposta7.setTextColor(Color.parseColor("#00ff00"));
                            }
                        }
                        if (cbResposta7.getText().equals(respostaBD12)) {
                            cbResposta7.setChecked(true);

                            noClick();


                        }
                        cursorRespostesBD.moveToNext();
                        x++;
                    }
                    imgTick.setVisibility(View.GONE);
                    imgNext.setVisibility(View.VISIBLE);
                }else{
                    cbResposta1.setVisibility(View.VISIBLE);
                    cbResposta1.setText(cursorRespota12.getString(cursorRespota12.getColumnIndex("resposta")));
                    cbResposta1.setTextColor(Color.parseColor("#000000"));

                    cursorRespota12.moveToNext();

                    cbResposta2.setVisibility(View.VISIBLE);
                    cbResposta2.setText(cursorRespota12.getString(cursorRespota12.getColumnIndex("resposta")));
                    cbResposta2.setTextColor(Color.parseColor("#000000"));

                    cursorRespota12.moveToNext();

                    cbResposta3.setVisibility(View.VISIBLE);
                    cbResposta3.setText(cursorRespota12.getString(cursorRespota12.getColumnIndex("resposta")));
                    cbResposta3.setTextColor(Color.parseColor("#000000"));

                    cursorRespota12.moveToNext();

                    cbResposta4.setVisibility(View.VISIBLE);
                    cbResposta4.setText(cursorRespota12.getString(cursorRespota12.getColumnIndex("resposta")));
                    cbResposta4.setTextColor(Color.parseColor("#000000"));

                    cursorRespota12.moveToNext();

                    cbResposta5.setVisibility(View.VISIBLE);
                    cbResposta5.setText(cursorRespota12.getString(cursorRespota12.getColumnIndex("resposta")));
                    cbResposta5.setTextColor(Color.parseColor("#000000"));

                    cursorRespota12.moveToNext();

                    cbResposta6.setVisibility(View.VISIBLE);
                    cbResposta6.setText(cursorRespota12.getString(cursorRespota12.getColumnIndex("resposta")));
                    cbResposta6.setTextColor(Color.parseColor("#000000"));

                    cursorRespota12.moveToNext();

                    cbResposta7.setVisibility(View.VISIBLE);
                    cbResposta7.setText(cursorRespota12.getString(cursorRespota12.getColumnIndex("resposta")));
                    cbResposta7.setTextColor(Color.parseColor("#000000"));


                }

                //endregion

            break;

            //region case 13
            case 13:
                aFalse();
                resposta1.setVisibility(View.GONE);
                resposta2.setVisibility(View.GONE);
                resposta3.setVisibility(View.GONE);

                Cursor cursorPregunta13 = bd.retornaPregunta(i);
                cursorPregunta13.moveToFirst();
                pregunta.setText(cursorPregunta13.getString(cursorPregunta13.getColumnIndex("text")));

                Cursor cursorRespota13 = bd.retornaResposta(i);
                cursorRespota13.moveToFirst();

                Cursor cursorRespostesBD13 = bd.retornaRespostes(13);

                if(cursorRespostesBD13.getCount()>0) {
                    int x2 = 0;
                    cbResposta1.setVisibility(View.VISIBLE);
                    cbResposta1.setText(cursorRespota13.getString(cursorRespota13.getColumnIndex("resposta")));
                    cbResposta1.setTextColor(Color.parseColor("#ff0000"));

                    cursorRespostesBD13.moveToFirst();

                    while (x2 < cursorRespostesBD13.getCount()) {

                        String respostaBD13 = cursorRespostesBD13.getString(cursorRespostesBD13.getColumnIndex("resposta"));
                        for (int y = 0; y < correctescb1.length; y++) {
                            if (cbResposta1.getText().equals(correctescb2[y])) {
                                cbResposta1.setTextColor(Color.parseColor("#00ff00"));
                            }
                        }
                        if (cbResposta1.getText().equals(respostaBD13)) {
                            cbResposta1.setChecked(true);
                            noClick();


                        }
                        cursorRespostesBD13.moveToNext();
                        x2++;
                    }

                    cursorRespota13.moveToNext();

                    cbResposta2.setVisibility(View.VISIBLE);
                    cbResposta2.setText(cursorRespota13.getString(cursorRespota13.getColumnIndex("resposta")));
                    cbResposta2.setTextColor(Color.parseColor("#ff0000"));

                    cursorRespostesBD13.moveToFirst();
                    x2 = 0;
                    while (x2 < cursorRespostesBD13.getCount()) {

                        String respostaBD13 = cursorRespostesBD13.getString(cursorRespostesBD13.getColumnIndex("resposta"));
                        for (int y = 0; y < correctescb1.length; y++) {
                            if (cbResposta2.getText().equals(correctescb2[y])) {
                                cbResposta2.setTextColor(Color.parseColor("#00ff00"));
                            }
                        }
                        if (cbResposta2.getText().equals(respostaBD13)) {
                            cbResposta2.setChecked(true);
                            noClick();


                        }
                        cursorRespostesBD13.moveToNext();
                        x2++;
                    }

                    cursorRespota13.moveToNext();


                    cbResposta3.setVisibility(View.VISIBLE);
                    cbResposta3.setText(cursorRespota13.getString(cursorRespota13.getColumnIndex("resposta")));
                    cbResposta3.setTextColor(Color.parseColor("#ff0000"));

                    cursorRespostesBD13.moveToFirst();
                    x2 = 0;
                    while (x2 < cursorRespostesBD13.getCount()) {

                        String respostaBD13 = cursorRespostesBD13.getString(cursorRespostesBD13.getColumnIndex("resposta"));
                        for (int y = 0; y < correctescb1.length; y++) {
                            if (cbResposta3.getText().equals(correctescb2[y])) {
                                cbResposta3.setTextColor(Color.parseColor("#00ff00"));
                            }
                        }
                        if (cbResposta3.getText().equals(respostaBD13)) {
                            cbResposta3.setChecked(true);
                            noClick();

                        }
                        cursorRespostesBD13.moveToNext();
                        x2++;
                    }

                    cursorRespota13.moveToNext();

                    cbResposta4.setVisibility(View.VISIBLE);
                    cbResposta4.setText(cursorRespota13.getString(cursorRespota13.getColumnIndex("resposta")));
                    cbResposta4.setTextColor(Color.parseColor("#ff0000"));

                    cursorRespostesBD13.moveToFirst();
                    x2 = 0;
                    while (x2 < cursorRespostesBD13.getCount()) {

                        String respostaBD13 = cursorRespostesBD13.getString(cursorRespostesBD13.getColumnIndex("resposta"));
                        for (int y = 0; y < correctescb1.length; y++) {
                            if (cbResposta4.getText().equals(correctescb2[y])) {
                                cbResposta4.setTextColor(Color.parseColor("#00ff00"));
                            }
                        }
                        if (cbResposta4.getText().equals(respostaBD13)) {
                            cbResposta4.setChecked(true);
                            noClick();

                        }
                        cursorRespostesBD13.moveToNext();
                        x2++;
                    }
                    cursorRespota13.moveToNext();

                    cbResposta5.setVisibility(View.VISIBLE);
                    cbResposta5.setText(cursorRespota13.getString(cursorRespota13.getColumnIndex("resposta")));

                    cbResposta5.setTextColor(Color.parseColor("#ff0000"));

                    cursorRespostesBD13.moveToFirst();
                    x2 = 0;
                    while (x2 < cursorRespostesBD13.getCount()) {

                        String respostaBD13 = cursorRespostesBD13.getString(cursorRespostesBD13.getColumnIndex("resposta"));
                        for (int y = 0; y < correctescb1.length; y++) {
                            if (cbResposta5.getText().equals(correctescb2[y])) {
                                cbResposta5.setTextColor(Color.parseColor("#00ff00"));
                            }
                        }
                        if (cbResposta5.getText().equals(respostaBD13)) {
                            cbResposta5.setChecked(true);
                            noClick();

                        }
                        cursorRespostesBD13.moveToNext();
                        x2++;
                    }

                    cursorRespota13.moveToNext();

                    cbResposta6.setVisibility(View.VISIBLE);
                    cbResposta6.setText(cursorRespota13.getString(cursorRespota13.getColumnIndex("resposta")));
                    cbResposta6.setTextColor(Color.parseColor("#ff0000"));

                    cursorRespostesBD13.moveToFirst();
                    x2 = 0;
                    while (x2 < cursorRespostesBD13.getCount()) {

                        String respostaBD13 = cursorRespostesBD13.getString(cursorRespostesBD13.getColumnIndex("resposta"));
                        for (int y = 0; y < correctescb1.length; y++) {
                            if (cbResposta6.getText().equals(correctescb2[y])) {
                                cbResposta6.setTextColor(Color.parseColor("#00ff00"));
                            }
                        }
                        if (cbResposta6.getText().equals(respostaBD13)) {
                            cbResposta6.setChecked(true);
                            noClick();

                        }
                        cursorRespostesBD13.moveToNext();
                        x2++;
                    }

                    cursorRespota13.moveToNext();

                    cbResposta7.setVisibility(View.VISIBLE);
                    cbResposta7.setText(cursorRespota13.getString(cursorRespota13.getColumnIndex("resposta")));
                    cbResposta7.setTextColor(Color.parseColor("#ff0000"));

                    cursorRespostesBD13.moveToFirst();
                    x2 = 0;
                    while (x2 < cursorRespostesBD13.getCount()) {

                        String respostaBD13 = cursorRespostesBD13.getString(cursorRespostesBD13.getColumnIndex("resposta"));
                        for (int y = 0; y < correctescb1.length; y++) {
                            if (cbResposta7.getText().equals(correctescb2[y])) {
                                cbResposta7.setTextColor(Color.parseColor("#00ff00"));
                            }
                        }
                        if (cbResposta7.getText().equals(respostaBD13)) {
                            cbResposta7.setChecked(true);
                            noClick();

                        }
                        cursorRespostesBD13.moveToNext();
                        x2++;
                    }
                    imgTick.setVisibility(View.GONE);
                    imgNext.setVisibility(View.VISIBLE);
                }else{
                    cbResposta1.setVisibility(View.VISIBLE);
                    cbResposta1.setText(cursorRespota13.getString(cursorRespota13.getColumnIndex("resposta")));
                    cbResposta1.setTextColor(Color.parseColor("#000000"));

                    cursorRespota13.moveToNext();

                    cbResposta2.setVisibility(View.VISIBLE);
                    cbResposta2.setText(cursorRespota13.getString(cursorRespota13.getColumnIndex("resposta")));
                    cbResposta2.setTextColor(Color.parseColor("#000000"));

                    cursorRespota13.moveToNext();

                    cbResposta3.setVisibility(View.VISIBLE);
                    cbResposta3.setText(cursorRespota13.getString(cursorRespota13.getColumnIndex("resposta")));
                    cbResposta3.setTextColor(Color.parseColor("#000000"));

                    cursorRespota13.moveToNext();

                    cbResposta4.setVisibility(View.VISIBLE);
                    cbResposta4.setText(cursorRespota13.getString(cursorRespota13.getColumnIndex("resposta")));
                    cbResposta4.setTextColor(Color.parseColor("#000000"));

                    cursorRespota13.moveToNext();

                    cbResposta5.setVisibility(View.VISIBLE);
                    cbResposta5.setText(cursorRespota13.getString(cursorRespota13.getColumnIndex("resposta")));
                    cbResposta5.setTextColor(Color.parseColor("#000000"));

                    cursorRespota13.moveToNext();

                    cbResposta6.setVisibility(View.VISIBLE);
                    cbResposta6.setText(cursorRespota13.getString(cursorRespota13.getColumnIndex("resposta")));
                    cbResposta6.setTextColor(Color.parseColor("#000000"));

                    cursorRespota13.moveToNext();

                    cbResposta7.setVisibility(View.VISIBLE);
                    cbResposta7.setText(cursorRespota13.getString(cursorRespota13.getColumnIndex("resposta")));
                    cbResposta7.setTextColor(Color.parseColor("#000000"));

                }


                //endregion

            break;

            //region case 11
            case 11:
                resposta1.setVisibility(View.INVISIBLE);
                resposta2.setVisibility(View.INVISIBLE);
                resposta3.setVisibility(View.INVISIBLE);
                txtRespota.setVisibility(View.VISIBLE);


                Cursor cursorPregunta11 = bd.retornaPregunta(i);
                cursorPregunta11.moveToFirst();
                pregunta.setText(cursorPregunta11.getString(cursorPregunta11.getColumnIndex("text")));
                Cursor resultat11 = bd.retornaRespostes(i);
                resultat11.moveToFirst();

                if(resultat11.getCount() > 0) {
                    txtRespota.setEnabled(false);
                    txtRespota.setText(resultat11.getString(resultat11.getColumnIndex("resposta")));
                    sortir = true;
                }
             //endregion

            break;

            //region case 14

            case 14:
                txtRespota.setVisibility(View.VISIBLE);
                resposta1.setVisibility(View.INVISIBLE);
                resposta2.setVisibility(View.INVISIBLE);
                resposta3.setVisibility(View.INVISIBLE);

                Cursor cursorPregunta14 = bd.retornaPregunta(i);
                cursorPregunta14.moveToFirst();
                pregunta.setText(cursorPregunta14.getString(cursorPregunta14.getColumnIndex("text")));

                Cursor resultat14 = bd.retornaRespostes(i);
                resultat14.moveToFirst();

                if(resultat14.getCount() > 0) {
                    txtRespota.setEnabled(false);
                    txtRespota.setText(resultat14.getString(resultat14.getColumnIndex("resposta")));
                    imgTick.setVisibility(View.GONE);
                    imgNext.setVisibility(View.VISIBLE);
                }

            //endregion

            break;

            //region case 15

            case 15:
                resposta1.setVisibility(View.INVISIBLE);
                resposta2.setVisibility(View.INVISIBLE);
                resposta3.setVisibility(View.INVISIBLE);
                txtRespota.setVisibility(View.VISIBLE);


                Cursor cursorPregunta15 = bd.retornaPregunta(i);
                cursorPregunta15.moveToFirst();
                pregunta.setText(cursorPregunta15.getString(cursorPregunta15.getColumnIndex("text")));
                Cursor resultat15 = bd.retornaRespostes(i);
                resultat15.moveToFirst();

                if(resultat15.getCount() > 0) {
                    txtRespota.setEnabled(false);
                    txtRespota.setText(resultat15.getString(resultat15.getColumnIndex("resposta")));
                    imgTick.setVisibility(View.VISIBLE);
                    imgBack.setVisibility(View.VISIBLE);
                }

                //endregion

            break;

            //region default

            default:

            Cursor cursorPregunta = bd.retornaPregunta(i);
            cursorPregunta.moveToFirst();
            pregunta.setText(cursorPregunta.getString(cursorPregunta.getColumnIndex("text")));
            Cursor cursorRespota = bd.retornaResposta(i);
            Cursor resultat = bd.retornaRespostes(i);

            //retorna
            if (resultat.getCount() > 0) {
                resultat.moveToFirst();

                cursorRespota.moveToFirst();
                respostaBD = resultat.getString(resultat.getColumnIndex("resposta"));

                resposta1.setText(cursorRespota.getString(cursorRespota.getColumnIndex("resposta")));
                resposta1.setTextColor(Color.parseColor("#ff0000"));

                for (int y = 0; y < correctes.length; y++) {
                    if (resposta1.getText().equals(correctes[y])) {
                        resposta1.setTextColor(Color.parseColor("#00ff00"));
                    }

                }
                if(resposta1.getText().equals(respostaBD)){
                    resposta1.setChecked(true);

                    noClick();

                    imgNext.setVisibility(View.VISIBLE);
                    imgTick.setVisibility(View.GONE);

                }

                cursorRespota.moveToNext();
                resposta2.setText(cursorRespota.getString(cursorRespota.getColumnIndex("resposta")));
                resposta2.setTextColor(Color.parseColor("#ff0000"));

                for (int y = 0; y < correctes.length; y++) {
                    if (resposta2.getText().equals(correctes[y])) {
                         resposta2.setTextColor(Color.parseColor("#00ff00"));
                    }
                }
                if(resposta2.getText().equals(respostaBD)){
                    resposta2.setChecked(true);

                    noClick();
                    imgNext.setVisibility(View.VISIBLE);
                    imgTick.setVisibility(View.GONE);
                }

                cursorRespota.moveToNext();
                resposta3.setText(cursorRespota.getString(cursorRespota.getColumnIndex("resposta")));
                resposta3.setTextColor(Color.parseColor("#ff0000"));

                for (int y = 0; y < correctes.length; y++) {
                    if (resposta3.getText().equals(correctes[y])) {
                        resposta3.setTextColor(Color.parseColor("#00ff00"));
                    }
                }
                if(resposta3.getText().equals(respostaBD)){
                    resposta3.setChecked(true);

                    noClick();
                    imgNext.setVisibility(View.VISIBLE);
                    imgTick.setVisibility(View.GONE);
                }

            }else{

                cursorRespota.moveToFirst();
                resposta1.setText(cursorRespota.getString(cursorRespota.getColumnIndex("resposta")));
                resposta1.setTextColor(Color.parseColor("#000000"));
                cursorRespota.moveToNext();
                resposta2.setText(cursorRespota.getString(cursorRespota.getColumnIndex("resposta")));
                resposta2.setTextColor(Color.parseColor("#000000"));

                cursorRespota.moveToNext();
                resposta3.setText(cursorRespota.getString(cursorRespota.getColumnIndex("resposta")));
                resposta3.setTextColor(Color.parseColor("#000000"));

            }
                //endregion

            break;
        }
    }

    private String retornaCorrectaDif(int i){
      String resposta = "";

        switch (i){
            //region case 12
            case 12:
                try {
                    if (cbResposta1.isChecked()) {
                        resposta = cbResposta1.getText().toString();
                        bd.insertaRespostes(nomAlumne, 12, resposta);
                    }
                    if (cbResposta2.isChecked()) {
                        resposta = cbResposta2.getText().toString();
                        bd.insertaRespostes(nomAlumne, 12, resposta);
                    }
                    if (cbResposta3.isChecked()) {
                        resposta = cbResposta3.getText().toString();
                        bd.insertaRespostes(nomAlumne, 12, resposta);
                    }
                    if (cbResposta4.isChecked()) {
                        resposta = cbResposta4.getText().toString();
                        bd.insertaRespostes(nomAlumne, 12, resposta);
                    }
                    if (cbResposta5.isChecked()) {
                        resposta = cbResposta5.getText().toString();
                        bd.insertaRespostes(nomAlumne, 12, resposta);
                    }
                    if (cbResposta6.isChecked()) {
                        resposta = cbResposta6.getText().toString();
                        bd.insertaRespostes(nomAlumne, 12, resposta);
                    }
                    if (cbResposta7.isChecked()) {
                        resposta = cbResposta7.getText().toString();
                        bd.insertaRespostes(nomAlumne, 12, resposta);
                    }
                    myDialogs.showToast(preguntes.this,"Respostes enviades");
                }catch (Exception e){
                    myDialogs.showToast(preguntes.this, "Error el enviar");
                }
                //endregion
                break;
            //region case 13
            case 13:
                try {
                    if (cbResposta1.isChecked()) {
                        resposta = cbResposta1.getText().toString();
                        bd.insertaRespostes(nomAlumne, 13, resposta);
                    }
                    if (cbResposta2.isChecked()) {
                        resposta = cbResposta2.getText().toString();
                        bd.insertaRespostes(nomAlumne, 13, resposta);
                    }
                    if (cbResposta3.isChecked()) {
                        resposta = cbResposta3.getText().toString();
                        bd.insertaRespostes(nomAlumne, 13, resposta);
                    }
                    if (cbResposta4.isChecked()) {
                        resposta = cbResposta4.getText().toString();
                        bd.insertaRespostes(nomAlumne, 13, resposta);
                    }
                    if (cbResposta5.isChecked()) {
                        resposta = cbResposta5.getText().toString();
                        bd.insertaRespostes(nomAlumne, 13, resposta);
                    }
                    if (cbResposta6.isChecked()) {
                        resposta = cbResposta6.getText().toString();
                        bd.insertaRespostes(nomAlumne, 13, resposta);
                    }
                    if (cbResposta7.isChecked()) {
                        resposta = cbResposta7.getText().toString();
                        bd.insertaRespostes(nomAlumne, 13, resposta);
                    }
                    myDialogs.showToast(preguntes.this, "Respostes enviades");

                } catch(Exception e){
                    myDialogs.showToast(preguntes.this, "Error al enviar");
                }
                //endregion
                break;
        }
        return resposta;
    }

    private String retornaCorrecta(){
        String marcada = "";

            if(resposta1.isChecked()){
                marcada = resposta1.getText().toString();
            }
             if(resposta2.isChecked()){
                marcada = resposta2.getText().toString();
            }
             if(resposta3.isChecked()){
                marcada = resposta3.getText().toString();
            }

        return marcada;
    }

    private void aFalse(){
        resposta1.setChecked(false);
        resposta2.setChecked(false);
        resposta3.setChecked(false);
        cbResposta1.setChecked(false);
        cbResposta2.setChecked(false);
        cbResposta3.setChecked(false);
        cbResposta4.setChecked(false);
        cbResposta5.setChecked(false);
        cbResposta6.setChecked(false);
        cbResposta7.setChecked(false);
    }

    private void noClick(){
        resposta1.setClickable(false);
        resposta2.setClickable(false);
        resposta3.setClickable(false);
        cbResposta1.setClickable(false);
        cbResposta2.setClickable(false);
        cbResposta3.setClickable(false);
        cbResposta4.setClickable(false);
        cbResposta5.setClickable(false);
        cbResposta6.setClickable(false);
        cbResposta7.setClickable(false);
    }


}
