package com.example.enpit_p33.zetsushinleaning

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

open class Zetsushin: RealmObject() {
    @PrimaryKey
    var user_id: String = ""
    var password: String = ""
    //ここから新しく追加
    var date: Date = Date()//テストを受けた日付

    //あとはどのテスト問題を受けたか分かるようにする変数を用意しないといけなさそう
}