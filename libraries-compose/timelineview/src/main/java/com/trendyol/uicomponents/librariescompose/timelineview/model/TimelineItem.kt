package com.trendyol.uicomponents.librariescompose.timelineview.model

import androidx.compose.runtime.Stable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

sealed class TimelineItem {

    @Stable
    data class Point(
        val text: String,
        val textStyle: TextStyle = TimelineViewDefaults.TextStyle,
        val pointConfig: PointConfig,
        val contentMargin: Dp = 4.dp,
        val lineConfig: LineConfig,
    ) : TimelineItem()

    @Stable
    data class Image(
        val text: String,
        val textStyle: TextStyle = TimelineViewDefaults.TextStyle,
        val imageContentDescription: String? = null,
        val imageConfig: ImageConfig,
        val lineConfig: LineConfig,
        val marginFromPoint: Dp = 4.dp,
    ) : TimelineItem()
}