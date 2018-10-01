package com.example.enpit_p33.zetsushinleaning

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.kotlin.where
import kotlinx.android.synthetic.main.activity_pastdata.*

class PastdataActivity : AppCompatActivity() {
    private lateinit var realm: Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val realmConfig = RealmConfiguration.Builder()
                .name("zetsushinlerning.realm")
                .deleteRealmIfMigrationNeeded()
                .schemaVersion(0)
                .build()
        realm = Realm.getInstance(realmConfig)
        setContentView(R.layout.activity_pastdata)
        realm = Realm.getDefaultInstance()
        val zetsushin = realm.where<Zetsushin>().findAll()
        listView.adapter = ZetsushinAdapter(zetsushin)
    }

    override fun onDestroy(){
        super.onDestroy()
        realm.close()
    }
}
