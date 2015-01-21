package org.brometheus.passwordgenerator;

import android.content.ClipData;
import android.text.ClipboardManager;
import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


public class Generation extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generation);
    }




    public void generate(View view) {
        PasswordGenerator generator = new PasswordGenerator(setSpecials(), setLength());
        String password = generator.generatePassword();
        TextView textview = (TextView)findViewById(R.id.passwordField);
        textview.setText(password);
    }

    public void copyToClipboard(View view){
        ClipboardManager clipboardManager = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
        clipboardManager.setText(((TextView)findViewById(R.id.passwordField)).getText());

    }




    public char setSpecials() {
        CheckBox upperbox=(CheckBox)findViewById(R.id.upperCheckBox);
        CheckBox numberbox = (CheckBox)findViewById(R.id.numbersCheckBox);
        CheckBox specialbox = (CheckBox)findViewById(R.id.specialCheckBox);
        int temp =0;
        if (upperbox.isChecked())
            temp=temp+1;
        if (numberbox.isChecked())
            temp=temp+2;
        if (specialbox.isChecked())
            temp=temp+4;
        return (char)temp;

    }


    public int setLength()
    {
        if (((RadioButton)findViewById(R.id.length20)).isChecked())
        {
            return 20;
        }
        if (((RadioButton)findViewById(R.id.length12)).isChecked())
        {
            return 12;
        }
        return 8;

    }
}

