package com.example.pc.calculator;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import bsh.EvalError;
import bsh.Interpreter;


public class MainActivity extends ActionBarActivity {

    private Button btnAdvance;
    private Button btnEquals;
    private Button btnAdd;
    private Button btnSub;
    private Button btnDivide;
    private Button btnMult;
    private Button btnDecimal;
    private Button btnClear;

    private String numbers = "";
    private String value = "0";
    private EditText display;

    private Button btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine, btnZero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdvance = (Button) findViewById(R.id.btnadv);

        //***********  INTEGER BUTTONS **************//
        btnOne = (Button) findViewById(R.id.btn1);
        btnTwo = (Button) findViewById(R.id.btn2);
        btnThree = (Button) findViewById(R.id.btn3);
        btnFour = (Button) findViewById(R.id.btn4);
        btnFive = (Button) findViewById(R.id.btn5);
        btnSix = (Button) findViewById(R.id.btn6);
        btnSeven = (Button) findViewById(R.id.btn7);
        btnEight = (Button) findViewById(R.id.btn8);
        btnNine = (Button) findViewById(R.id.btn9);
        btnZero = (Button) findViewById(R.id.btn0);

        //***********  FUNCTION BUTTONS **************//
        btnDivide = (Button) findViewById(R.id.btndiv);
        btnMult = (Button) findViewById(R.id.btnmul);
        btnSub = (Button) findViewById(R.id.btnsub);
        btnAdd = (Button) findViewById(R.id.btnadd);
        btnDecimal = (Button) findViewById(R.id.btndecimal);
        btnEquals = (Button) findViewById(R.id.btnequals);
        btnClear = (Button) findViewById(R.id.btnclr1);

        btnDecimal.setEnabled(false);

        final scientific sci = new scientific();

        display = (EditText) findViewById(R.id.editText);

        Intent intent = getIntent();
        try {
            value = intent.getExtras().getString("value");
            numbers = value;
        } catch (Exception e) {

        }
        display.setText(numbers);


        //***********  FUNCTION BUTTONS **************//


        //*********** ONCLICK FUNCTIONS **************//
        btnAdvance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, scientific.class);
                value = display.getText().toString();
                intent.putExtra("value", value);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
            }
        });

        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numbers += "1";
                display.setText(numbers);
                btnDecimal.setEnabled(true);
            }
        });

        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numbers += "2";
                display.setText(numbers);
                btnDecimal.setEnabled(true);
            }
        });

        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numbers += "3";
                display.setText(numbers);
                btnDecimal.setEnabled(true);
            }
        });

        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numbers += "4";
                display.setText(numbers);
                btnDecimal.setEnabled(true);
            }
        });

        btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numbers += "5";
                display.setText(numbers);
                btnDecimal.setEnabled(true);
            }
        });

        btnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numbers += "6";
                display.setText(numbers);
                btnDecimal.setEnabled(true);
            }
        });

        btnSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numbers += "7";
                display.setText(numbers);
                btnDecimal.setEnabled(true);
            }
        });

        btnEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numbers += "8";
                display.setText(numbers);
                btnDecimal.setEnabled(true);

            }
        });

        btnNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numbers += "9";
                display.setText(numbers);
                btnDecimal.setEnabled(true);
            }
        });

        btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numbers += "0";
                display.setText(numbers);
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numbers += "/";
                display.setText(numbers);
                btnDecimal.setEnabled(true);
            }
        });

        btnMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numbers += "*";
                display.setText(numbers);
                btnDecimal.setEnabled(true);
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numbers += "-";
                display.setText(numbers);
                btnDecimal.setEnabled(true);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numbers += "+";
                display.setText(numbers);
                btnDecimal.setEnabled(true);
            }
        });

        btnEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (sci.expFlag == false) {
                    power(numbers);
                    display.setText(numbers);
                    value = "";
                    numbers = "";
                } else {
                    Interpreter interpreter = new Interpreter();
                    try {
                        value = interpreter.eval(numbers).toString();
                        display.setText(value);
                        numbers = value;
                        value = "";
                        numbers = "";
                    } catch (EvalError evalError) {
                        evalError.printStackTrace();
                    }
                    btnDecimal.setEnabled(true);
                }
            }
        });

        btnDecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numbers += ".";
                display.setText(numbers);
                btnDecimal.setEnabled(false);
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value = "";
                numbers = "";
                display.setText(value);
            }
        });

        /*display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                public static void disableSoftInputFromAppearing(EditText display) {
                    if (Build.VERSION.SDK_INT >= 11) {
                        display.setRawInputType(InputType.TYPE_CLASS_TEXT);
                        display.setTextIsSelectable(true);
                    } else {
                        display.setRawInputType(InputType.TYPE_NULL);
                        display.setFocusable(true);
                    }
                }

            }
        });*/
    }

    public double power(String strValue) {
        String var[] = strValue.split("^",2);
        double base = Double.parseDouble(var[0]);
        double exp = Double.parseDouble(var[1]);

        double powResult = Math.pow(base,exp);
        return powResult;
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
