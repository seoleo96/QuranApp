package com.example.quranapp.data.chapters.net

import com.google.gson.annotations.SerializedName

data class QuranChaptersModel(
    @SerializedName("chapters")
    val chapters: List<QuranCloudModel>
)