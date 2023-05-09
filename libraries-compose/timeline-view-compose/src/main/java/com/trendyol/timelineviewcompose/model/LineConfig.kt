package com.trendyol.timelineviewcompose.model

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.Dp

@Immutable
data class LineConfig(
    val strokeCap: StrokeCap = StrokeCap.Butt,
    val color: Color,
    val size: Dp = TimelineViewDefaults.LineSize,
    val thickness: Dp = TimelineViewDefaults.LineThickness,
    val lineType: LineType = LineType.Solid,
    val animation: LineAnimation? = null,
)

@Immutable
sealed class LineType {
    object Solid : LineType()

    class Dashed(
        val intervals: FloatArray = TimelineViewDefaults.LineDashedIntervals,
        val phase: Float = TimelineViewDefaults.LineDashedPhase,
    ) : LineType()
}

@Immutable
data class LineAnimation(
    val initialValue: Float = 0f,
    val durationMillis: Int = 1000,
    val targetColor: Color,
    val targetValue: Float = 1f,
)
