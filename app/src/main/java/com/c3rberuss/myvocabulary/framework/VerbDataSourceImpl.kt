package com.c3rberuss.myvocabulary.framework

import com.c3rberuss.core.data.VerbDataSource
import com.c3rberuss.core.domain.Verb
import com.c3rberuss.myvocabulary.framework.db.dao.VerbDao
import com.c3rberuss.myvocabulary.framework.db.entities.VerbEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class VerbDataSourceImpl @Inject constructor(val verbDao: VerbDao) : VerbDataSource {
    override suspend fun add(verb: Verb): Verb? {
        return withContext(Dispatchers.IO) {
            val id = verbDao.insert(
                VerbEntity(
                    baseForm = verb.baseForm,
                    presentProgressive = verb.presentProgressive,
                    past = verb.past
                )
            )

            if (id > 0) {
                verbDao.getById(id)
            }else{
                null
            }
        }
    }

    override suspend fun remove(verb: Verb): Boolean {
        return withContext(Dispatchers.IO) {

            val value = verbDao.delete(
                VerbEntity(
                    id = verb.id,
                    baseForm = verb.baseForm,
                    presentProgressive = verb.presentProgressive,
                    past = verb.past
                )
            )

            value > 0
        }
    }

    override suspend fun edit(verb: Verb): Verb? {
        return withContext(Dispatchers.IO) {

            val value = verbDao.edit(
                VerbEntity(
                    id = verb.id,
                    baseForm = verb.baseForm,
                    presentProgressive = verb.presentProgressive,
                    past = verb.past
                )
            )

            if (value > 0) {
                verbDao.getById(verb.id.toLong())
            }else{
                null
            }
        }
    }

    override suspend fun getVerbs(): List<Verb> {
        return withContext(Dispatchers.IO) {
            verbDao.getAll().map {
                Verb(
                    id = it.id,
                    baseForm = it.baseForm,
                    presentProgressive = it.presentProgressive,
                    past = it.past
                )
            }
        }
    }
}