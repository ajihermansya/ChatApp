package com.rumahcerita.chappappclonewa.model

import java.sql.Timestamp

data class MessageModel(
    var message : String? = "",
    var senderId : String? = "",
    var timestamp: Long? = 0
)
