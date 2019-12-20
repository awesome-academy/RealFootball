package vn.sunasterisk.realfootball.ui.highlight

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import vn.sunasterisk.realfootball.base.BaseResponse
import vn.sunasterisk.realfootball.data.model.Highlight
import vn.sunasterisk.realfootball.data.repository.HighlightRepository

class HighlightViewModel(
    application: Application,
    highlightRepository: HighlightRepository
) : AndroidViewModel(application) {
    val highlight: LiveData<BaseResponse<List<Highlight>>> = highlightRepository.getHighlight()
}
