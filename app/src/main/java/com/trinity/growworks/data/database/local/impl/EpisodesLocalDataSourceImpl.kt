package com.trinity.growworks.data.database.local.impl

import com.trinity.growworks.data.database.local.EpisodesLocalDataSource
import com.trinity.growworks.data.model.local.Episode
import io.realm.kotlin.Realm
import io.realm.kotlin.UpdatePolicy
import io.realm.kotlin.ext.query
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class EpisodesLocalDataSourceImpl @Inject constructor(
    private val realm: Realm
) : EpisodesLocalDataSource {
    override suspend fun insertEpisode(episodes: List<Episode>) {
        realm.write {
            episodes.map {
                copyToRealm(it, updatePolicy = UpdatePolicy.ALL)
            }
        }
    }

    override fun getAllEpisode(): Flow<List<Episode>> = realm.query<Episode>().asFlow().map { it.list }
}