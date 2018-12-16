package com.way.rapid.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;


public class MainActivity2 extends AppCompatActivity {
    private Button bt1,bt2;
    private EditText ed1,ed2;






    private Boolean aBoolean = false,bBoolean=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        bt1 = (Button) findViewById(R.id.bt1);
        bt2 = (Button) findViewById(R.id.bt2);
        ed1 = (EditText) findViewById(R.id.ed1);
        ed2 = (EditText) findViewById(R.id.ed2);
        //ÊµÏÖ×¢²áÒ³ÃæÌø×ª
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this,SecondActivity.class);
                startActivity(intent);
            }
        });
        //µÇÂ¼Ò³ÃæÌø×ª
       bt1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {








              String name = ed1.getText().toString();
             String  password =ed2.getText().toString();



               if (login(name,password)) {

                   Intent intent = new Intent(MainActivity2.this,MainActivity.class);
                startActivity(intent);
            }
           else
               {
                   Toast.makeText(MainActivity2.this, "µÇÂ¼Ê§°Ü", Toast.LENGTH_SHORT).show();
               }
           }
        });


    }

    @Override


    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public boolean login(String name,String password) {

        SQLiteDatabase db = openOrCreateDatabase("client", MODE_PRIVATE, null);

        String sql = "select * from User where UserName= ? and UserPasswd=?";
        Cursor cursor = db.rawQuery(sql, new String[]{name, password});
        if (cursor.moveToFirst()) {
            cursor.close();
            return true;
        }
        return false;
    }

}
