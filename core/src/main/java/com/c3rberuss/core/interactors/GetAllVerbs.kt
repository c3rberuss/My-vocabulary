package com.c3rberuss.core.interactors

import com.c3rberuss.core.data.VerbRepository
import com.c3rberuss.core.domain.Verb

class GetAllVerbs(private val verbRepository: VerbRepository) {
    suspend operator fun invoke(): List<Verb> = verbRepository.getAllVerbs()
}