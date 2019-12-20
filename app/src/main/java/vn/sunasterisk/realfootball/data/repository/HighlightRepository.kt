package vn.sunasterisk.realfootball.data.repository

import androidx.lifecycle.LiveData
import vn.sunasterisk.realfootball.base.BaseResponse
import vn.sunasterisk.realfootball.base.ContextProviders
import vn.sunasterisk.realfootball.base.NetworkBoundResource
import vn.sunasterisk.realfootball.data.local.HighlightDao
import vn.sunasterisk.realfootball.data.model.Highlight
import vn.sunasterisk.realfootball.di.HighlightService

class HighlightRepository(
    val coroutines: ContextProviders,
    val highlightService: HighlightService,
    val highlightDao: HighlightDao
) {
    fun getHighlight(): LiveData<BaseResponse<List<Highlight>>> =
        object : NetworkBoundResource<List<Highlight>, List<Highlight>>(coroutines) {
            override suspend fun saveCallResult(item: List<Highlight>) {
                highlightDao.saveHighlight(item)
            }

            override fun createCall(): LiveData<BaseResponse<List<Highlight>>> =
                highlightService.getHighlight()

            override fun shouldFetch(data: List<Highlight>?) = true

            override suspend fun loadFromDatabase(): LiveData<List<Highlight>> =
                highlightDao.getHighlight()
        }.asLiveData()
}
