package com.c3rberuss.core.interactors

import com.c3rberuss.core.data.VerbRepository
import com.c3rberuss.core.domain.Verb

class RemoveVerb(private val verbRepository: VerbRepository) {
    suspend operator fun invoke(verb: Verb): Boolean = verbRepository.remove(verb)
}