package com.example.valentinerutto.chatapp.mRealm;

import io.realm.RealmObject;

public class Messages extends RealmObject {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}