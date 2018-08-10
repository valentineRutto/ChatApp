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
public void save(final Spacecraft spacecraft)
{
    realm.executeTransaction(new Realm.Transaction() {
        @Override
        public void execute(Realm realm) {

            Spacecraft s=realm.copyToRealm(spacecraft);

        }
    });

}
//READ
public ArrayList<String> retrieve()
{
    ArrayList<String> spacecraftNames=new ArrayList<>();
    RealmResults<Spacecraft> spacecrafts=realm.where(Spacecraft.class).findAll();

    for(Spacecraft s:spacecrafts)
    {
        spacecraftNames.add(s.getName());
    }

    return spacecraftNames;
}


}
