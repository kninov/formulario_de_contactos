package com.example.formulario_de_contacto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {


    String nombreContacto ;
    String fechaNacimiento ;
    String telContacto ;
    String emailContacto ;
    String descContanto;

    EditText edtNombre ;
    EditText edtFecha ;
    EditText edtTelefono ;
    EditText edtEmail ;
    EditText edtDescripcionContacto ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            Bundle parametros = getIntent().getExtras();

             nombreContacto = parametros.getString(getResources().getString(R.string.paramNombres));
            fechaNacimiento = parametros.getString(getResources().getString(R.string.paramFecha));
             telContacto = parametros.getString(getResources().getString(R.string.paramTelefono));
             emailContacto = parametros.getString(getResources().getString(R.string.paramEmail));
             descContanto = parametros.getString(getResources().getString(R.string.paramDescripcion));

             edtNombre = (EditText) findViewById(R.id.edtNombre);
             edtFecha = (EditText) findViewById(R.id.edtFecha);
             edtTelefono = (EditText) findViewById(R.id.edtTelefono);
             edtEmail = (EditText) findViewById(R.id.edtEmail);
            edtDescripcionContacto = (EditText) findViewById(R.id.edtDescripcionContacto);

            edtNombre.setText(nombreContacto);
            edtFecha.setText(fechaNacimiento);
            edtTelefono.setText(telContacto);
            edtEmail.setText(emailContacto);
            edtDescripcionContacto.setText(descContanto);
        } catch (Exception e){

        }
    }


    public static class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener{

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {

            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);


            return new DatePickerDialog(getActivity(),this, year,month,day);
        }

        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int day) {

            String fecha = Integer.toString(day)+"/"+Integer.toString(month+1)+"/"+Integer.toString(year);
            ((EditText) getActivity().findViewById(R.id.edtFecha)).setText(fecha);
        }
    }

    public void showDatePickerDialog(View v){
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(),"datePicker");
    }




    public void PresionarSiguiente(View view){
        Intent intent = new Intent(MainActivity.this,Confirmar_Datos.class);

        EditText edtNombre              = (EditText) findViewById(R.id.edtNombre);
        EditText edtFecha               = (EditText) findViewById(R.id.edtFecha);
        EditText edtTelefono            = (EditText) findViewById(R.id.edtTelefono);
        EditText edtEmail               = (EditText) findViewById(R.id.edtEmail);
        EditText edtDescripcionContacto = (EditText) findViewById(R.id.edtDescripcionContacto);

        if((!edtNombre.getText().toString().equals("")) && (!edtFecha.getText().toString().equals("")) && (!edtTelefono.getText().toString().equals("")) && (!edtEmail.getText().toString().equals("")) && (!edtDescripcionContacto.getText().toString().equals(""))) {
            intent.putExtra(getResources().getString(R.string.pNombres), edtNombre.getText().toString());
            intent.putExtra(getResources().getString(R.string.pFecha), edtFecha.getText().toString());
            intent.putExtra(getResources().getString(R.string.pTelefono), edtTelefono.getText().toString());
            intent.putExtra(getResources().getString(R.string.pEmail), edtEmail.getText().toString());
            intent.putExtra(getResources().getString(R.string.pDescripcion), edtDescripcionContacto.getText().toString());

            startActivity(intent);
            finish();
        } else {
            Toast.makeText(getBaseContext(), getResources().getString(R.string.mensaje_precaucion) ,Toast.LENGTH_LONG).show();
        }

    }



}