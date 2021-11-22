package com.example.quranapp.data.contents.net

import com.google.gson.annotations.SerializedName

data class QuranContentsModel(
    @SerializedName("quran")
    val quran : List<ContentCloudModel>
)