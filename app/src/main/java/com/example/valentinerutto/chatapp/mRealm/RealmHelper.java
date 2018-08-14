package com.example.valentinerutto.chatapp.mRealm;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmMigration;
import io.realm.RealmResults;

public class RealmHelper  {

    Realm realm;

  public RealmHelper(Realm realm){
    this.realm= realm;
   }
//WRITE
public void save(final Messages spacecraft)
{
    realm.executeTransaction(new Realm.Transaction() {
        @Override
        public void execute(Realm realm) {

             Messages sp=realm.copyToRealm(spacecraft);

        }
    });

}

//READ



}
