package com.gold.book.pexelsploer.ui.top.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.FrameLayout
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import com.gold.book.pexelsploer.R
import com.gold.book.pexelsploer.databinding.TopToolbarBinding
import com.gold.book.pexelsploer.ui.top.TopViewModel
import com.gold.book.pexelsploer.ui.utils.hideSoftKeyboard
import com.gold.book.pexelsploer.ui.utils.onSubmit

class ToolbarView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val binding: TopToolbarBinding

    init {
        val inflater = LayoutInflater.from(context)
        binding = DataBindingUtil.inflate(inflater, R.layout.top_toolbar, this, true)

        layoutParams = LayoutParams(MATCH_PARENT, MATCH_PARENT)
    }

    fun setLifeCycleOwner(lifecycleOwner: LifecycleOwner) {
        binding.lifecycleOwner = lifecycleOwner
    }

    fun setTopViewModel(viewModel: TopViewModel) {
        binding.viewModel = viewModel

        binding.searchBox.run {
            onSubmit {
                hideSoftKeyboard(binding.toolbarViewRoot)
                viewModel.onClickSearch()
            }
        }

        binding.searchIcon.run {
            setOnClickListener {
                hideSoftKeyboard(binding.toolbarViewRoot)
                viewModel.onClickSearch()
            }
        }
    }
}
