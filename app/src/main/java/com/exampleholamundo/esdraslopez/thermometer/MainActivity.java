package com.exampleholamundo.esdraslopez.thermometer;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import java.text.DecimalFormat;
import android.widget.Button;
import android.widget.EditText;
import java.text.DecimalFormatSymbols;

import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;

public class MainActivity extends AppCompatActivity {
    Spinner sp1,sp2;
    EditText editText;
    Button button2;
    TextView tv;

    DecimalFormat objFormato = (DecimalFormat) NumberFormat.getInstance(Locale.US);





    Spinner sp_temperatura;
    Spinner sp_temperatura2;
    String[] items;
    String[] items2;
    private boolean isFirstTime = true;

    public void clean(){
        tv.setText("");
        editText.setText("");
    }

    @Optional @OnClick(R.id.button) void buttonClear() {
        clean();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    sp1=(Spinner)findViewById(R.id.spinners);
    sp2=(Spinner)findViewById(R.id.spinners1);
    editText=(EditText)findViewById(R.id.editText);
        List listsp1= new ArrayList();
        listsp1.add("CELSIUS");
        listsp1.add("FARENHEIT");
        listsp1.add("KELVIN");
        listsp1.add("RANKINE");

        final ArrayAdapter arrayAdapter= new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line,listsp1);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp1.setAdapter(arrayAdapter);

        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        List listsp2= new ArrayList();
        listsp2.add("CELSIUS");
        listsp2.add("FARENHEIT");
        listsp2.add("KELVIN");
        listsp2.add("RANKINE");

        ArrayAdapter arrayAdapter2= new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line,listsp2);
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp2.setAdapter(arrayAdapter2);

        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    tv=(TextView)findViewById(R.id.textView);



        button2=(Button)findViewById(R.id.button2);

        button2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                String spn1=sp1.getSelectedItem().toString();
                String spn2=sp2.getSelectedItem().toString();
       //         tv.setText(spn1);









                Context context = getApplicationContext();
                CharSequence text = "NO SE PUEDE CONVERTIR";
                int duration = Toast.LENGTH_SHORT;



                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.custom_dialog,
                        (ViewGroup) findViewById(R.id.toast_layout_root));

                TextView textToast = (TextView) layout.findViewById(R.id.text_toast);


                Toast toast = new Toast(context);
                toast.setDuration(duration);

                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 200);

                //toast.setView(layout);
                //toast.show();








try{

                if (spn1.equals(spn2)){
                    tv.setText("");
                    textToast.setText(text);
                    toast.setView(layout);
                    toast.show();
                    //Toast.makeText(MainActivity.this,"No se puede convertir", Toast.LENGTH_SHORT).show();
                    return;
                }
                     if(spn1.equals("CELSIUS") && spn2.equals("FARENHEIT")){
                         double valor=  Double.parseDouble(editText.getText().toString());
                         double form=(9*valor/5)+32;
                         //objFormato.format(form);
                         tv.setText(String.valueOf(objFormato.format(form)));
                          }else if(spn1.equals("CELSIUS") && spn2.equals("KELVIN")){
                         double valor=  Double.parseDouble(editText.getText().toString());
                         double form=valor+273.15;
                         tv.setText(String.valueOf(objFormato.format(form)));
                     }else if(spn1.equals("CELSIUS") && spn2.equals("RANKINE")) {
                         double valor = Double.parseDouble(editText.getText().toString());
                         double form = (9 * valor / 5) + 491.67;
                         tv.setText(String.valueOf(objFormato.format(form)));
                     }


                      if(spn1.equals("FARENHEIT") && spn2.equals("CELSIUS")){
                    double valor=  Double.parseDouble(editText.getText().toString());
                    double form=(5*(valor-32))/9;
                         tv.setText(String.valueOf(objFormato.format(form)));
                }else if(spn1.equals("FARENHEIT") && spn2.equals("KELVIN")){
                    double valor=  Double.parseDouble(editText.getText().toString());
                    double form=((5*(valor-32))/9)+273.15;
                         tv.setText(String.valueOf(objFormato.format(form)));
                }else if(spn1.equals("FARENHEIT") && spn2.equals("RANKINE")) {
                    double valor = Double.parseDouble(editText.getText().toString());
                    double form = valor+459.67;
                         tv.setText(String.valueOf(objFormato.format(form)));
                }


                     if(spn1.equals("KELVIN") && spn2.equals("CELSIUS")){
                         double valor=  Double.parseDouble(editText.getText().toString());
                         double form=valor-273.15;
                         tv.setText(String.valueOf(objFormato.format(form)));
                     }else if(spn1.equals("KELVIN") && spn2.equals("FARENHEIT")){
                         double valor=  Double.parseDouble(editText.getText().toString());
                         double form=((9*(valor-273.15))/5)+32;
                         tv.setText(String.valueOf(objFormato.format(form)));
                     }else if(spn1.equals("KELVIN") && spn2.equals("RANKINE")) {
                         double valor = Double.parseDouble(editText.getText().toString());
                         double form = ((9*(valor-273.15))/5)+491.67;
                         tv.setText(String.valueOf(objFormato.format(form)));
                     }


                     else if(spn1.equals("RANKINE") && spn2.equals("CELSIUS")){
                         double valor=  Double.parseDouble(editText.getText().toString());
                             double form=(5*(valor-491.67)/9);
                         tv.setText(String.valueOf(objFormato.format(form)));
                     }else if(spn1.equals("RANKINE") && spn2.equals("FARENHEIT")){
                         double valor=  Double.parseDouble(editText.getText().toString());
                         double form=valor-459.67;
                         tv.setText(String.valueOf(objFormato.format(form)));
                     }else if(spn1.equals("RANKINE") && spn2.equals("KELVIN")) {
                         double valor = Double.parseDouble(editText.getText().toString());
                         double form = ((5 * (valor - 491.67)) / 9) + 273.15;
                         tv.setText(String.valueOf(objFormato.format(form)));
                     }
                }catch (Exception e){
                    
                }
            }
        });

    }
}
