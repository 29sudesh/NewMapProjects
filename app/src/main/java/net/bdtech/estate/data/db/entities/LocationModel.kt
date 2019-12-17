package net.bdtech.estate.data.db.entities

import androidx.room.Entity

@Entity
data class LocationModel (val lattitude:Double,
                          val longitude:Double)