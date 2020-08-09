package com.c3rberuss.core.data

import com.c3rberuss.core.domain.Verb

interface VerbDataSource {
    suspend fun add(verb: Verb) : Verb?
    suspend fun remove(verb: Verb) : Boolean
    suspend fun edit(verb: Verb) : Verb?
    suspend fun getVerbs() : List<Verb>
}