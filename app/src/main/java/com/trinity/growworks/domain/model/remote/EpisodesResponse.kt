package com.trinity.growworks.domain.model.remote

import android.os.Parcelable
import com.trinity.growworks.data.model.remote.EpisodesResultResponse
import com.trinity.growworks.data.model.remote.InfoResponse
import kotlinx.parcelize.Parcelize

@Parcelize
data class EpisodesResponse(
    val info: InfoResponse,
    val results: List<EpisodesResultResponse>
): Parcelable
