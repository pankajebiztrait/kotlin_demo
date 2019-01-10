package com.ebiztrait.apps.data.models

/**
 * Created by ebiztrait on 18/01/18.
 */
class ErrorData(message: String = "", errorCode: String = "", throwable: Throwable? = null) {
    var message: String = message
    var errorCode: String = errorCode
    var throwable: Throwable? = throwable
}