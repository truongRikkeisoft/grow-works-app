package com.trinity.growworks.data.model.remote

import android.os.Parcelable
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class EpisodesResultResponse(
    val id: Int?,
    val name: String?,
    @SerializedName("air_date")
    val airDate: String?,
    val episode: String?,
    val characters: List<String>?,
    val created: String?,
    val url: String?
) : Parcelable {

    fun convertToJSON(): String {
        return Gson().toJson(this)
    }

    companion object {
        fun create(jsonString: String): EpisodesResultResponse? {
            return try {
                Gson().fromJson(jsonString, EpisodesResultResponse::class.java)
            } catch (e: Exception) {
                return null
            }
        }
    }
}
