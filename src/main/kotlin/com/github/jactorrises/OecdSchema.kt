package com.github.jactorrises

import java.io.InputStream
import javax.xml.XMLConstants
import javax.xml.transform.stream.StreamSource
import javax.xml.validation.SchemaFactory

internal const val XSD_ISOTYPES = "isotypes_v2.2.xsd"
internal const val XSD_OECDTYPES = "oecdtypes_v1.xsd"
internal const val XSD_SPECIFICTYPES = "specifictypes_v2.xsd"
internal const val XSD_STFTYPES = "stftypes-2.2.xsd"

object OecdSchema {
    private val classLoader = OecdSchema::class.java.classLoader
    private val inputStreams: List<InputStream> = listOf(
        classLoader.getResourceAsStream(XSD_ISOTYPES)!!,
        classLoader.getResourceAsStream(XSD_OECDTYPES)!!,
        classLoader.getResourceAsStream(XSD_SPECIFICTYPES)!!,
        classLoader.getResourceAsStream(XSD_STFTYPES)!!,
    )

    fun load() {
        val schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI)
        val xsdSources = inputStreams.map { StreamSource(it) }.toTypedArray()
        val schema = schemaFactory.newSchema(xsdSources)

        println(schema)
    }
}
