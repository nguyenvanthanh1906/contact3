package com.example.contact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
Button back;
Button ok;
List<contactjava> listcontact;
EditText name;
EditText phone;
customAdapter customAdapter;
manager dbmanager;
ListView lvcontact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        lvcontact=(ListView)findViewById(R.id.lvcontact);
        listcontact=dbmanager.getAllContact();
        setAdapter();
        name=(EditText) findViewById(R.id.edtname);
        phone=(EditText) findViewById(R.id.edtphone);
        back=(Button)findViewById(R.id.btnback);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Main2Activity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        ok=(Button) findViewById(R.id.ok);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contactjava contactjava=createContact();
                if (contactjava!=null){
                    dbmanager.addcontact(contactjava);
                }
            }
        });
    }
    private contactjava createContact(){
        String Name=name.getText().toString();
        String Phone=phone.getText().toString();
        contactjava contactjava=new contactjava(Name,Phone);
        return contactjava;
    }
    private void setAdapter(){
        if(customAdapter==null){
            customAdapter=new customAdapter(this,R.layout.row_lvxml,  listcontact);
        }
        lvcontact.setAdapter(customAdapter);
    }
}
