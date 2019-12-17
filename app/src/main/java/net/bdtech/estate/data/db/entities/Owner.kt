package net.bdtech.estate.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.JsonObject

@Entity
data class Owner(
    @PrimaryKey(autoGenerate = false)
    val userId: String,
//    val location: JsonObject,
    val rent: Long,
    val flatType: String,
    val contactDetails: String,
    val ownerName: String,
    val furnishType: String,
    val flatImageURLs: String
)
