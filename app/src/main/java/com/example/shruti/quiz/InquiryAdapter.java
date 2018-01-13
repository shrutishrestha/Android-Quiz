package com.example.shruti.quiz;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shruti on 10/22/16.
 */

public class InquiryAdapter extends ArrayAdapter {
    Context context;
    int layoutResourceId;
    List<Admin_Setter> inquiryList;
    List<Admin_Setter> personInfoList=new ArrayList<Admin_Setter>();

    public InquiryAdapter(Context context, int layoutResourceId, List<Admin_Setter> inquiryList) {
        super(context, layoutResourceId, inquiryList);
        this.context=context;
        this.layoutResourceId=layoutResourceId;
        this.inquiryList=inquiryList;

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {//auta row banauna lai position on screen,tesko view i.e. position ma view kasto xa and tesko parent i.e. layout chahinxa
        View row=convertView;//just auta name coz list ko view=row wise
        InquiryHolder inquiryHolder;//a static class

        if(row==null){//paila tyo view or layout ma kunai row chaina bhanney naya banaunxa
            inquiryHolder=new InquiryHolder();
            LayoutInflater inflater=((Activity) context).getLayoutInflater();//tyo layout lai inflate(join) garnu paryo so layoutInflater chahinxa like bich ko sw
            row= inflater.inflate(layoutResourceId,parent,false);//yo id bhayeko and parent ko layout(row) yo view ma inflate garney i.e join garney
            inquiryHolder.mName=(TextView) row.findViewById(R.id.name_display);
            inquiryHolder.mPhone=(TextView) row.findViewById(R.id.phone_display);
            inquiryHolder.mId=(TextView) row.findViewById(R.id.id_display);
            row.setTag(inquiryHolder);//paila kei chaina bhanney yo method ma chirxa and sab detail bhako i.e. inquiryHolder lai settag gardinxa

        }else{
            inquiryHolder=(InquiryHolder)row.getTag();// pailai xa i.e getTag garney ,pailai ko info lina lai
        }

        Admin_Setter dp=inquiryList.get(position);

//
//        inquiryHolder.mName.setText(dp.getName());
//        inquiryHolder.mPhone.setText(dp.getPhone());
//        inquiryHolder.mId.setText(String.valueOf(position+1));
//



return row;
    }

    static class InquiryHolder{//bairako class le yeslai access garna object chahinxa but yesle baira ko class ko static members lai atikai access garna paunxa
        TextView mName,mPhone,mId;
    }
}
