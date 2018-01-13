package com.example.shruti.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shruti.quiz.Helper.DBHelper;

/**
 * Created by shruti on 10/21/16.
 */

public class AdminSetPage extends AppCompatActivity{
    EditText mquestion,mOption1,mOption2,mOption3,mOption4,mrightAnswer;
    Button mnext,mviewAll,mSet;
    Admin_Setter dp;
    DBHelper dbHelper;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

setContentView(R.layout.admin_set);
        mquestion= (EditText) findViewById(R.id.admin_question);
        mOption1= (EditText) findViewById(R.id.admin_option1);
        mOption2= (EditText) findViewById(R.id.admin_option2);
        mOption3= (EditText) findViewById(R.id.admin_option3);
        mOption4= (EditText) findViewById(R.id.admin_option4);
        mOption4= (EditText) findViewById(R.id.admin_rightAnswer);
        mrightAnswer= (EditText) findViewById(R.id.admin_rightAnswer);
 mnext=(Button) findViewById(R.id.admin_Next);
 mviewAll=(Button) findViewById(R.id.admin_view);
 mSet=(Button) findViewById(R.id.admin_Set);
    mnext.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String question=mquestion.getText().toString();
            String Option1=mOption1.getText().toString();
            String Option2=mOption2.getText().toString();
            String Option3=mOption3.getText().toString();
            String Option4=mOption4.getText().toString();
            String rightAnswer=mrightAnswer.getText().toString();
dbHelper=new DBHelper(AdminSetPage.this);

            long id=dbHelper.addPerson(new Admin_Setter(question,Option1,Option2,Option3,Option4,rightAnswer));
           if(id<0){
               Toast.makeText(AdminSetPage.this, "error storing", Toast.LENGTH_SHORT).show();
           }
            else {
               Toast.makeText(AdminSetPage.this, "Succesfully stored.", Toast.LENGTH_SHORT).show();
           }startActivity(new Intent(AdminSetPage.this,DB_List.class));




        }
    });
    }
}
