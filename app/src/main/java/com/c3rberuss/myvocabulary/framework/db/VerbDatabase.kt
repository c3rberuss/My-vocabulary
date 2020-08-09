package com.c3rberuss.myvocabulary.framework.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.c3rberuss.myvocabulary.framework.db.dao.VerbDao
import com.c3rberuss.myvocabulary.framework.db.entities.VerbEntity

@Database(
    entities = [VerbEntity::class],
    version = 1,
    exportSchema = false
)
abstract class VerbDatabase: RoomDatabase() {
    abstract fun verbDao() : VerbDao
}