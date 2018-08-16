package com.example.valentinerutto.chatapp.mRealm;

import java.sql.Time;
import java.util.Date;

import io.realm.DynamicRealm;
import io.realm.RealmObjectSchema;
import io.realm.RealmSchema;

public class RealmMigration implements io.realm.RealmMigration {

    @Override
    public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {
        final RealmSchema schema = realm.getSchema();

        if (oldVersion == 1) {
            final RealmObjectSchema msgSchema = schema.get("Messages");
            msgSchema.addField("Topic", String.class);
            msgSchema.addField("time", Time.class);
        }
    }
}