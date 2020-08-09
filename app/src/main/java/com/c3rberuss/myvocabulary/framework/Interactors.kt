package com.c3rberuss.myvocabulary.framework

import com.c3rberuss.core.interactors.AddVerb
import com.c3rberuss.core.interactors.EditVerb
import com.c3rberuss.core.interactors.GetAllVerbs
import com.c3rberuss.core.interactors.RemoveVerb

data class Interactors(
    val addVerb: AddVerb,
    val editVerb: EditVerb,
    val removeVerb: RemoveVerb,
    val getAllVerbs: GetAllVerbs
)