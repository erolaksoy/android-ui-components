package com.trendyol.timelineview

import android.graphics.Typeface
import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter("timelineItems")
internal fun RecyclerView.submitList(items: List<TimelineItemViewState>?) {
    (adapter as? TimelineItemAdapter)?.submitList(items.orEmpty())
}

@BindingAdapter("tlv:layout_height")
fun setLayoutHeight(view: View, height: Float) {
    view.layoutParams = view.layoutParams.apply { this.height = height.toInt() }
}

@BindingAdapter("tlv:layout_width")
fun setLayoutWidth(view: View, width: Float) {
    view.layoutParams = view.layoutParams.apply { this.width = width.toInt() }
}

@BindingAdapter("tlv:fontFamily")
fun setFontFamily(textView: TextView, fontFamily: String) {
    textView.typeface = Typeface.create(fontFamily,Typeface.NORMAL)
}