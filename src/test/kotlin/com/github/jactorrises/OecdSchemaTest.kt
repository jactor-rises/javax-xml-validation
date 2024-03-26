package com.github.jactorrises

import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import assertk.assertThat
import assertk.assertions.isNotNull

internal class OecdSchemaTest {
    @Test
    @Disabled("wip - fix load schema")
    fun `should load xsd to prepare a schema to validate xml`() {
        val load = runCatching { OecdSchema.load() }
            .onFailure { System.err.println(it) }

        assertThat(load.getOrNull()).isNotNull()
    }
}