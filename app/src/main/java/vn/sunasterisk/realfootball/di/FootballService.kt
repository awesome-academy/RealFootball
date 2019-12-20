package vn.sunasterisk.realfootball.di

import androidx.lifecycle.LiveData
import com.rifqimfahmi.foorballapps.data.source.remote.json.PlayersResponse
import com.rifqimfahmi.foorballapps.data.source.remote.json.SchedulesResponse
import com.rifqimfahmi.foorballapps.data.source.remote.json.SearchSchedulesResponse
import com.rifqimfahmi.foorballapps.data.source.remote.json.TeamsResponse
import retrofit2.http.GET
import retrofit2.http.Query
import vn.sunasterisk.realfootball.base.BaseResponse
import vn.sunasterisk.realfootball.data.model.Highlight

interface FootballService {
    @GET("eventspastleague.php")
    fun getLastMatch(@Query("id") leagueId: String): LiveData<BaseResponse<SchedulesResponse>>

    @GET("eventsnextleague.php")
    fun getNextMatch(@Query("id") leagueId: String): LiveData<BaseResponse<SchedulesResponse>>

    @GET("lookup_all_teams.php")
    fun getTeams(@Query("id") leagueId: String): LiveData<BaseResponse<TeamsResponse>>

    @GET("lookup_all_players.php")
    fun getPlayers(@Query("id") teamId: String): LiveData<BaseResponse<PlayersResponse>>

    @GET("lookupteam.php")
    fun getTeam(@Query("id") teamId: String): LiveData<BaseResponse<TeamsResponse>>

    @GET("lookupevent.php")
    fun getMatchDetail(@Query("id") matchId: String): LiveData<BaseResponse<SchedulesResponse>>

    @GET("lookupplayer.php")
    fun getPlayer(@Query("id") playerId: String): LiveData<BaseResponse<PlayersResponse>>

    @GET("searchevents.php")
    fun searchMatch(@Query("e") query: String): LiveData<BaseResponse<SearchSchedulesResponse>>

    @GET("searchteams.php")
    fun searchTeam(@Query("t") query: String): LiveData<BaseResponse<TeamsResponse>>

    @GET("searchplayers.php")
    fun searchPlayer(@Query("p") query: String): LiveData<BaseResponse<PlayersResponse>>
}

interface HighlightService {
    @GET("/video-api/v1")
    fun getHighlight(): LiveData<BaseResponse<List<Highlight>>>
}

