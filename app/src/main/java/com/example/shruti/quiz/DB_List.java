package com.example.shruti.quiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shruti.quiz.Helper.DBHelper;


import java.util.List;

/**
 * Created by Sushil on 6/3/2016.
 */
public class DB_List extends AppCompatActivity {

    DBHelper db;
    ListView mInquiryList;
    TextView mid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_db);

        mInquiryList = (ListView) findViewById(R.id.listview);

        db = new DBHelper(DB_List.this);
        List<Admin_Setter> inquiries=db.getAllInqueries();

        InquiryAdapter inquiryAdapter =  new InquiryAdapter(DB_List.this,R.layout.list_page,inquiries);
        mInquiryList.setAdapter(inquiryAdapter);

   mInquiryList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              Toast.makeText(DB_List.this, "click click", Toast.LENGTH_SHORT).show();
//                Admin_Setter inquiry = (Admin_Setter) parent.getItemAtPosition(position);
//                Intent queryIntent = new Intent(.this, DetailInquiryActivity.class);
//                queryIntent.putExtra("query_detail", inquiry);
//                startActivity(queryIntent);
//                finish();
//
//                //Toast.makeText(InquiryListActivity.this, "Name: " + vId, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
