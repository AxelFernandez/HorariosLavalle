package com.sistemas51.horarioslavalle.resource

data class Resource<out T>(val status: Status, val data: T?, val messageError: String? = null) {

    companion object {
        fun <T> loading(): Resource<T> = Resource(Status.LOADING, null)
        fun <T> success(data: T): Resource<T> = Resource(Status.SUCCESS, data)
        fun <T> error(data: T?, messageError: String?): Resource<T> = Resource(Status.ERROR, data, messageError)


    }
}