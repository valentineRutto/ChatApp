package com.example.valentinerutto.chatapp;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MyApplication extends Application {
        @Override
        public void onCreate() {
            super.onCreate();
            // The default Realm file is "default.realm" in Context.getFilesDir();
            // we'll change it to "myrealm.realm"
            Realm.init(this);
            RealmConfiguration config = new RealmConfiguration.Builder().build();
//            RealmConfiguration config = new RealmConfiguration.Builder().name("myrealm.realm").build();
            Realm.setDefaultConfiguration(config);
        }

}
