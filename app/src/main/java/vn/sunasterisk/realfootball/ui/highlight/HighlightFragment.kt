package vn.sunasterisk.realfootball.ui.highlight

import android.os.Bundle
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_highlight.*
import org.koin.android.viewmodel.ext.android.viewModel
import vn.sunasterisk.realfootball.R
import vn.sunasterisk.realfootball.base.BaseFragment
import vn.sunasterisk.realfootball.databinding.FragmentHighlightBinding

class HighlightFragment : BaseFragment<HighlightViewModel, FragmentHighlightBinding>() {
    override val viewModel: HighlightViewModel by viewModel()
    override val contentViewId get() = R.layout.fragment_highlight
    override fun initializeView(savedInstanceState: Bundle?) {
    }

    private val adapter by lazy { HighlightAdapter() }

    override fun initializeComponents() {
        setupList()
    }

    private fun setupList() {
        recyclerHighlight.adapter = adapter
        viewModel.highlight.observe(viewLifecycleOwner, Observer {
            handlerError(it)
            it.result?.let {
                adapter.submitList(it)
            }
        })
    }
}
