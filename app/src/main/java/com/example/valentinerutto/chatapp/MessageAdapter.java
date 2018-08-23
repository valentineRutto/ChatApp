//package com.example.valentinerutto.chatapp;
//
//import android.app.Activity;
//import android.content.Context;
//import android.support.annotation.NonNull;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.TextView;
//
//import com.example.valentinerutto.chatapp.mRealm.Messages;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class MessageAdapter extends ArrayAdapter<Messages> {
//    List<Messages> messages;
//    Context context;
//
//    public MessageAdapter(@NonNull Context context, ArrayList resource, @NonNull ArrayList<String> objects) {
//        super();
//    }
//
//
//
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//
//
//        //get the message we are displaying
//        Messages messagelist = messages.get(position);
//
//        //get the inflater and inflate the XML layout for each item
//        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
//        View view = inflater.inflate(R.layout.my_message, null);
//
//        TextView mesgcontent = (TextView) view.findViewById(R.id.message_body);
//
//
//        //set message
//        String message = Messages.getMesgcontent() + " " + Messages.getTopic();
//
//        mesgcontent.setText(message);
//        return view;
//    }
//
//}
