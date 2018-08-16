package com.example.valentinerutto.chatapp.mRealm;

import android.widget.EditText;

import java.util.Date;

import io.realm.RealmObject;

public class Messages extends RealmObject {

    private String mesgcontent;
    private String ClientID;
    private String Topic;
    private String time;


    public String getMesgcontent() {
        return mesgcontent;
    }


    public void setMesgcontent(EditText name) {
        this.mesgcontent = mesgcontent;
    }

    public String getClientID() {
        return ClientID;
    }

    public void setClientID(String clientID) {
        ClientID = clientID;
    }

    public String getTopic() {
        return Topic;
    }

    public void setMesgcontent(String mesgcontent) {
        this.mesgcontent = mesgcontent;
    }

    @Override
    public String toString() {
        return
                '\n' + "ClientID='" + ClientID + '\n' +
                        ", topic='" + Topic + '\n' +
                        ", time='" + time + '\n' +
                       ",message=" + mesgcontent + '\n'
                ;
    }

    public void setTopic(String topic) {
        Topic = topic;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
