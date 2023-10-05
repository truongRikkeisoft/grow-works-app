package com.trinity.growworks.domain.state.remotestate

import com.trinity.growworks.data.model.remote.APIError

sealed class DataState<T> {
    class Success<T>(val data: T) : DataState<T>()
    class Loading<T> : DataState<T>()
    class Error<T>(val apiError: APIError?) : DataState<T>()
}
