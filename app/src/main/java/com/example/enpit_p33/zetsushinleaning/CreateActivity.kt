package com.example.enpit_p33.zetsushinleaning

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.kotlin.createObject
import kotlinx.android.synthetic.main.activity_create.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.yesButton

class CreateActivity : AppCompatActivity() {
    private lateinit var realm: Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val realmConfig = RealmConfiguration.Builder()
                .name("zetsushinlerning.realm")
                .deleteRealmIfMigrationNeeded()
                .schemaVersion(0)
                .build()
        setContentView(R.layout.activity_create)
        realm = Realm.getDefaultInstance()
        create_button.setOnClickListener{ create() }

    }
    fun create(){
        val id = new_id.text.toString()
        val pass = new_password.text.toString()
        val check_account = realm.where(Zetsushin::class.java).equalTo("user_id", id).findFirst()

        realm.executeTransaction {
            if (check_account == null) {
                realm.createObject<Zetsushin>(id).apply {
                    password = pass
                }
                alert("作りました") { yesButton { finish() } }.show()
            } else {
                alert("すでにIDが存在します") { yesButton {} }.show()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }
}