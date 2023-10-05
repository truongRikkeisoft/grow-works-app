package com.trinity.growworks.data.model.remote

import androidx.compose.runtime.Stable

@Stable
data class APIError(val code: Long, val message: String)
