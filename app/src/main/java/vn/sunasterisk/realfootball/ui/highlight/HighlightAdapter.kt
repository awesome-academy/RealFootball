package vn.sunasterisk.realfootball.ui.highlight

import androidx.recyclerview.widget.DiffUtil
import vn.sunasterisk.realfootball.R
import vn.sunasterisk.realfootball.base.BaseRecyclerAdapter
import vn.sunasterisk.realfootball.data.model.Highlight
import vn.sunasterisk.realfootball.databinding.ItemHighlightBinding

class HighlightAdapter :
    BaseRecyclerAdapter<Highlight, ItemHighlightBinding>(HighlightCallback()) {
    override fun getLayoutRes(viewType: Int) = R.layout.item_highlight
}

private class HighlightCallback : DiffUtil.ItemCallback<Highlight>() {

    override fun areItemsTheSame(oldItem: Highlight, newItem: Highlight): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: Highlight, newItem: Highlight): Boolean {
        return oldItem == newItem
    }
}
