package com.trinity.growworks.data.model.local

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

class Episode : RealmObject {
    @PrimaryKey
    var id: String = ""
    var name: String? = null
    var airDate: String? = null
    var episode: String? = null
}