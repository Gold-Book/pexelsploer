package com.gold.book.pexelsploer.ui.top.views

import android.content.Context
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.gold.book.pexelsploer.R
import kotlin.math.ceil
import kotlin.math.floor


class EvenlyDivideRecyclerView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RecyclerView(context, attrs, defStyleAttr) {

    init {
        addItemDecoration(object : ItemDecoration() {
            override fun getItemOffsets(out: Rect, view: View, parent: RecyclerView, state: State) {
                val position = parent.getChildLayoutPosition(view)
                val spanCount = resources.getInteger(R.integer.top_evenly_divide_span_count)
                val space = resources.getDimensionPixelSize(R.dimen.divider_size)

                when {
                    isFirstPosition(position, spanCount) -> {
                        // 余剰は右に寄せるので切り捨てる
                        val margin = (floor((parent.width % spanCount) / 2.0)).toInt()
                        out.set(space + margin, 0, 0, space)
                    }
                    isLastPosition(position, spanCount) -> {
                        // 余剰を右に寄せるので切り上げ
                        val margin = ceil((parent.width % spanCount) / 2.0).toInt()
                        out.set(space, 0, margin, space)
                    }
                    else -> out.set(space, 0, 0, space)
                }
            }
        })
    }

    private fun isFirstPosition(position: Int, spanCount: Int) = position.inc() % spanCount == 1
    private fun isLastPosition(position: Int, spanCount: Int) = position.inc() % spanCount == 0
}
