package com.example.pc.calculator;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class scientific extends ActionBarActivity {

    private Button basic;

    private Button btnSin, btnCos, btnTan, btnImaginary;
    private Button btnLn, btnLog, btnPie, btnExp;
    private Button btnPercent, btnFact, btnSqrt, btnSqr;
    private Button btnOpenBrac, btnCloseBrac, btnClr;

    private double eval;

    public boolean expFlag;

    private EditText display;

    private String value = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scientific);

        basic = (Button) findViewById(R.id.btnbasic);

        btnSin = (Button) findViewById(R.id.btnsin);
        btnCos = (Button) findViewById(R.id.btncos);
        btnTan = (Button) findViewById(R.id.btntan);
        btnImaginary = (Button) findViewById(R.id.btnimaginary);
        btnLn = (Button) findViewById(R.id.btnntrllog);
        btnLog = (Button) findViewById(R.id.btnlog);
        btnPie = (Button) findViewById(R.id.btnpie);
        btnExp = (Button) findViewById(R.id.btne);
        btnPercent = (Button) findViewById(R.id.btnpercentage);
        btnFact = (Button) findViewById(R.id.btnfact);
        btnSqrt = (Button) findViewById(R.id.btnsqrt);
        btnSqr = (Button) findViewById(R.id.btnexp);
        btnOpenBrac = (Button) findViewById(R.id.btnopenbracket);
        btnCloseBrac = (Button) findViewById(R.id.btnclosebracket);
        btnClr = (Button) findViewById(R.id.btndel);

        display = (EditText) findViewById(R.id.editText);

        Intent intent = getIntent();
        try {
            value = intent.getExtras().getString("value");
        } catch (Exception e) {

        }
        display.setText(value);

        basic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(scientific.this, MainActivity.class);
                value = display.getText().toString();
                intent.putExtra("value", value);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
            }
        });

        btnSin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eval = Double.parseDouble(value);
                eval = Math.sin(eval);
                value = Double.toString(eval);
                display.setText(value);
            }
        });

        btnCos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eval = Double.parseDouble(value);
                eval = Math.cos(eval);
                value = Double.toString(eval);
                display.setText(value);
            }
        });

        btnTan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eval = Double.parseDouble(value);
                eval = Math.tan(eval);
                value = Double.toString(eval);
                display.setText(value);
            }
        });

        btnFact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eval = Double.parseDouble(value);
                value = Double.toString(eval);
                display.setText(value);
            }
        });

        btnLn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eval = Double.parseDouble(value);
                eval = Math.log(eval);
                value = Double.toString(eval);
                display.setText(value);
            }
        });

        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eval = Double.parseDouble(value);
                eval = Math.log10(eval);
                value = Double.toString(eval);
                display.setText(value);
            }
        });

        btnPie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eval = Double.parseDouble(value);
                eval = 3.14159265358979 * eval;
                value = Double.toString(eval);
                display.setText(value);
            }
        });

        btnExp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eval = Double.parseDouble(value);
                eval = Math.exp(eval);
                value = Double.toString(eval);
                display.setText(value);
            }
        });

        btnPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eval = Double.parseDouble(value);
                eval = Math.tan(eval);
                value = Double.toString(eval);
                display.setText(value);
            }
        });

        btnSqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eval = Double.parseDouble(value);
                eval = Math.sqrt(eval);
                value = Double.toString(eval);
                display.setText(value);
            }
        });

        btnSqr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean expFlag = false;
                value += "^";
                display.setText(value);
            }
        });

        btnClr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value = "";
                display.setText(value);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
