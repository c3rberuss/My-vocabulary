package com.c3rberuss.myvocabulary.framework.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "verb")
data class VerbEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val baseForm: String,
    val presentProgressive: String,
    val past: String
)