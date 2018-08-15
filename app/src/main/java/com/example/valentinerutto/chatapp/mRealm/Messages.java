package com.example.valentinerutto.chatapp.mRealm;

import android.widget.EditText;

import io.realm.RealmObject;

public class Messages extends RealmObject {

    private String mesgcontent;
    private String ClientID;
    private  String topic;

    public String getMesgcontent() {
        return mesgcontent;
    }


    public void setMesgcontent(EditText name) {
        this.mesgcontent = mesgcontent;
    }

    public String getClientID() {
        return ClientID;
    }

    public void setClientID(String clientID)
    {
        ClientID = clientID;
    }

    public String getTopic() {

        return topic;
    }

    public void setMesgcontent(String mesgcontent)
    {
        this.mesgcontent = mesgcontent;
    }

    @Override
    public String toString() {
        return
//                '\n'+ "ClientID='" + ClientID + '\n' +
//                ", topic='" + topic + '\n' +
                mesgcontent + '\n'
                ;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
