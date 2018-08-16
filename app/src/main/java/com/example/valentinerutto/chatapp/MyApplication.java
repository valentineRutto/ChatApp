package com.example.valentinerutto.chatapp;

import android.app.Application;

import com.example.valentinerutto.chatapp.mRealm.RealmMigration;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // The default Realm file is "default.realm" in Context.getFilesDir();
        // we'll change it to "myrealm.realm"
        Realm.init(this);
        final RealmConfiguration config= new RealmConfiguration.Builder().name("myrealm.realm").schemaVersion(2).migration(new RealmMigration()).build();
        Realm.setDefaultConfiguration(config);
        Realm.getInstance(config);


    }


    @Override
    public void onTerminate() {
        Realm.getDefaultInstance().close();
        super.onTerminate();
    }
}