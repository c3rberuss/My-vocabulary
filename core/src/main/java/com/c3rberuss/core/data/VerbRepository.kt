package com.c3rberuss.core.data

import com.c3rberuss.core.domain.Verb

class VerbRepository(private val dataSource: VerbDataSource) {
    suspend fun add(verb: Verb): Verb? = dataSource.add(verb)
    suspend fun edit(verb: Verb): Verb? = dataSource.edit(verb)
    suspend fun remove(verb: Verb): Boolean = dataSource.remove(verb)
    suspend fun getAllVerbs(): List<Verb> = dataSource.getVerbs()
}