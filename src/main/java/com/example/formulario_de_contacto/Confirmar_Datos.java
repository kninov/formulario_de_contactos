package com.example.formulario_de_contacto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class Confirmar_Datos extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar__datos);

        Bundle parametros = getIntent().getExtras();

        nombre_contacto = parametros.getString(getResources().getString(R.string.pNombres));
        fecha_contacto = parametros.getString(getResources().getString(R.string.pFecha));
        tel_contacto = parametros.getString(getResources().getString(R.string.pTelefono));
        email_contacto = parametros.getString(getResources().getString(R.string.pEmail));
        desc_contacto = parametros.getString(getResources().getString(R.string.pDescripcion));

        tvNombre_contacto = (TextView) findViewById(R.id.tvNombre_contacto);
        tvFechaNacimiento = (TextView) findViewById(R.id.tvFechaNacimiento);
        tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvCorfimDescripcion = (TextView) findViewById(R.id.tvCorfimDescripcion);

        tvNombre_contacto.setText(nombre_contacto);
        String fecha_nacimiento = "Fecha de Nacimiento: " + fecha_contacto;
        tvFechaNacimiento.setText(fecha_nacimiento);
        String tel = "Tel: " + tel_contacto;
        tvTelefono.setText(tel);
        String mail = "Email: " + email_contacto;
        tvEmail.setText(mail);
        String desc = "Descripción: " + desc_contacto;
        tvCorfimDescripcion.setText(desc);

    }



    public void PresionarEditarDatos(View view){
        Intent intent = new Intent(Confirmar_Datos.this, MainActivity.class);

        intent.putExtra(getResources().getString(R.string.paramNombres),nombre_contacto);
        intent.putExtra(getResources().getString(R.string.paramFecha),fecha_contacto);
        intent.putExtra(getResources().getString(R.string.paramTelefono),tel_contacto);
        intent.putExtra(getResources().getString(R.string.paramEmail),email_contacto);
        intent.putExtra(getResources().getString(R.string.paramDescripcion),desc_contacto);

        startActivity(intent);
        finish();
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(Confirmar_Datos.this, MainActivity.class);
        startActivity(intent);
    }

    private TextView tvNombre_contacto;
    private TextView tvFechaNacimiento;
    private TextView tvTelefono;
    private TextView tvEmail;
    private TextView tvCorfimDescripcion;

    private String nombre_contacto;
    private String fecha_contacto;
    private String tel_contacto;
    private String email_contacto;
    private String desc_contacto;
}