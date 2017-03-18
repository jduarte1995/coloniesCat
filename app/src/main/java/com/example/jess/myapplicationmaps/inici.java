package com.example.jess.myapplicationmaps;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Jesús on 06/03/2017.
 */

public class inici extends AppCompatActivity {

    static String nomAlumne ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inici);

        Button btn = (Button) findViewById(R.id.btnInici);
        final EditText txt = (EditText) findViewById(R.id.txtNom);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txt.getText().toString().equals("")){
                    myDialogs.showToast(inici.this, "Entra el teu nom!");

                }else {
                    nomAlumne = txt.getText().toString();
                    Intent intent = new Intent(inici.this, MainActivity.class);
                    startActivity(intent);
                }

            }

        });
    }
}
