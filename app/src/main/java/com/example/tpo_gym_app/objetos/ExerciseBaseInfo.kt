package com.example.tpo_gym_app.objetos

import com.google.gson.annotations.SerializedName

data class ExerciseBaseInfo (
    val id: Long? = null,
    val uuid: String? = null,
    val category: Category? = null,
    val muscles: List<Muscle>? = null,

    @SerializedName("muscles_secondary")
    val musclesSecondary: List<Any?>? = null,

    val equipment: List<Any?>? = null,
    val license: License? = null,

    @SerializedName("license_author")
    val licenseAuthor: String? = null,

    val images: List<Any?>? = null,
    val exercises: List<Exercise>? = null,
    val variations: Any? = null
)