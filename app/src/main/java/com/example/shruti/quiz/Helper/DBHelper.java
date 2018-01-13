package com.example.shruti.quiz.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.shruti.quiz.Admin_Setter;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by shruti on 10/21/16.
 */

public class DBHelper extends SQLiteOpenHelper{
    public static final String  db_name="DBNewProject";
    public static final int  db_version=1;
    public static final String  tb_name="quiz";
    public static final String id="id";
    public static final String  question="question";
    public static final String  option1="option1";
    public static final String  option2="option2";
    public static final String  option3="option3";
    public static final String  option4="option4";
    public static final String  rightAnswer="rightAnswer";


    public DBHelper(Context context) {
        super(context, db_name, null, db_version);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="Create table "+tb_name+" ( "+
                    id+" INTEGER PRIMARY KEY, " +
                question+" text, "+
                option1+" text, "+
                option2+" text, "+
                option3+" text, "+
                option4+" text, "+
                rightAnswer+" text )";

    db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public long addPerson(Admin_Setter p){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(question,p.getQuestion());
        values.put(option1,p.getOption1());
        values.put(option2,p.getOption2());
        values.put(option3,p.getOption3());
        values.put(option4,p.getOption4());
        values.put(rightAnswer,p.getRightAnswer());

        long id=db.insert(tb_name,null,values);
        return id;
    }

    public List<Admin_Setter> getAllInqueries(){
        List<Admin_Setter> display=new ArrayList<>();
        SQLiteDatabase db=this.getWritableDatabase();
        String query="Select * from "+tb_name;
        Cursor cursor=db.rawQuery(query,null);

        if(cursor.moveToFirst()){
            do{
            Admin_Setter dp=new Admin_Setter();
            dp.setId(cursor.getInt(0));
            dp.setQuestion(cursor.getString(1));
            dp.setOption1(cursor.getString(2));
            dp.setOption2(cursor.getString(3));
            dp.setOption3(cursor.getString(4));
            dp.setOption4(cursor.getString(5));
            dp.setRightAnswer(cursor.getString(6));
            display.add(dp);
        }while(cursor.moveToNext());
        }
        return display;
    }
}
