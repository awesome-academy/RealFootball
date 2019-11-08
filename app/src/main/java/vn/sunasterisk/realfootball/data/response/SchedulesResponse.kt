package com.rifqimfahmi.foorballapps.data.source.remote.json

import com.google.gson.annotations.SerializedName
import vn.sunasterisk.realfootball.data.model.Match


data class SchedulesResponse(@SerializedName("events") val events: List<Match?>?)
