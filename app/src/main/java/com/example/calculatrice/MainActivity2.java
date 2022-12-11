package com.example.calculatrice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import org.mariuszgromada.math.mxparser.Expression;

public class MainActivity2 extends AppCompatActivity {
    boolean b=true ,p=true ;
    boolean e=true;
    private EditText display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        display=findViewById(R.id.t1);
        display.setShowSoftInputOnFocus(false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.caculator_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id= item.getItemId();
        if(id==R.id.standard){
            Intent intent = new Intent(MainActivity2.this,MainActivity.class);
            startActivity(intent);
        }
        if(id==R.id.science){
            Intent intent = new Intent(MainActivity2.this,MainActivity2.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
    public  boolean verify(String s){
        String disp= display.getText().toString();
        boolean b=false;
        if( disp.substring(disp.length()-1).equals(s))
            b=true;
        return b;
    }
    public  void updateText(String strToAdd){

        int index=display.getSelectionStart();
        if (display.getText().toString().equals("0")) {
            display.setText(strToAdd);
        }
        else{
            String oldStr= display.getText().toString();
            String lStr= oldStr.substring(0,index);
            String rStr=oldStr.substring(index);
            display.setText(String.format("%s%s",oldStr,strToAdd));
        }
        display.setSelection(index+strToAdd.length());

        if(display.getText().toString().equals("0") && strToAdd.equals("0")){
            display.setSelection(display.getSelectionStart()-1);
        }
    }
    public void zeroBtn(View view){
        if(e==true)
            updateText("0");
    }
    public void oneBtn(View view){
        if(e==true)
            updateText("1");

    }
    public void twoBtn(View view){
        if(e==true)
            updateText("2");

    }
    public void threeBtn(View view){
        if(e==true)
            updateText("3");

    }
    public void forBtn(View view){
        if(e==true)
            updateText("4");

    }
    public void fiveBtn(View view){
        if(e==true)
            updateText("5");

    }
    public void sixBtn(View view){
        if(e==true)
            updateText("6");
    }
    public void sevenBtn(View view){
        if(e==true)
            updateText("7");
    }
    public void eightBtn(View view){
        if(e==true)
            updateText("8");
    }
    public void nineBtn(View view){
        if(e==true)
            updateText("9");
    }
    public void pointBtn(View view){
        if (b== true && e==true){
            updateText(".");
            b=false;}
    }
    public void plusBtn(View view)
    {
        if (verify("+") == false){
            updateText("+");
            b=e=true;}
    }
    public void moinsBtn(View view){
        if (verify("-") == false){

           if (verify("+") == true){
               deleteBtn(view);
            }
            updateText("-");
            b=e=true;
        }

    }
    public void produitBtn(View view){
        if (verify("*") == false && verify("/") == false ){
            updateText("*");
            p=e=true;}
    }
    public void divisionBtn(View view){
        if (verify("/") == false && verify("*") == false){
            updateText("/");
            p=e=true;}

    }

    public void piBtn(View view){
        if (verify("π") == false) {
            if (e == true) {
                updateText("π");
                b = false;
            }
        }
    }
    public void clearBtn(View view){
        display.setText("");
        b=e=true;
    }
    public void deleteBtn(View view){
        if(e==true) {
            int index = display.getSelectionStart();
            int n = display.getText().length();
            if (index != 0 && n != 0) {
                SpannableStringBuilder selector = (SpannableStringBuilder) display.getText();
                selector.replace(index - 1, index, "");
                display.setText(selector);
                display.setSelection(index - 1);
            }
        }
    }



    public void closeBtn(View view)
    {
        if(e==true) {
            updateText(")");
        }

    }

    public void openBtn(View view){
        if(e==true) {
            updateText("(");
        }
    }
    public void powBtn(View view){
        updateText("^");
        b=true;
        e=true;
    }
    public void tgBtn(View view){
            updateText("tg(");
            b=true;
            e=true;

    }
    public void lnBtn(View view){
            updateText("ln(");
            b=true;
            e=true;
    }
    public void sinBtn(View view){

            updateText("sin(");
            b=true;
            e=true;

    }
    public void cosBtn(View view){
            updateText("cos(");
            b=true;
            e=true;
    }
    public void expoBtn(View view){

            updateText("exp(");
            b=true;
            e=true;
    }
    public void racineBtn(View view){
            updateText("√(");
            b=true;
            e=true;
    }
    public void factBtn(View view){
        if (verify("!") == false && verify("(") == false  ) {
            updateText("!");
            e = false;
            b = false;
        }
    }
    public void pBtn(View view){
        if (verify("!") == false && verify("%") == false && verify("+") == false  && verify("-") == false  && verify("*") == false  && verify("/") == false ) {
            updateText("%");
            b = false;
            e = false;
        }

    }
    public void equalBtn(View view){
        String s=display.getText().toString();
        Expression exp=  new Expression(s);
        String result= String.valueOf(exp.calculate());
        int n=result.length();
        if(result.equals("NaN")){
            display.setText("");
        }
        else {
            display.setText(result);
            display.setSelection(result.length());
            e = false;
        }

    }
}