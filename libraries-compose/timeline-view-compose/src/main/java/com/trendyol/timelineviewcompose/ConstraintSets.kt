package com.trendyol.timelineviewcompose

import androidx.compose.ui.unit.Dp
import androidx.constraintlayout.compose.ConstraintSet

internal const val PointLayoutId = "point"
internal const val LineLayoutId = "line"
internal const val TextLayoutId = "text"

internal fun getHorizontalConstraintSet(marginFromPoint: Dp): ConstraintSet {
    return ConstraintSet {
        val point = createRefFor(PointLayoutId)
        val text = createRefFor(TextLayoutId)
        val line = createRefFor(LineLayoutId)

        constrain(point) {
            start.linkTo(parent.start)
            top.linkTo(parent.top)
        }

        constrain(text) {
            centerHorizontallyTo(point)
            top.linkTo(point.bottom, marginFromPoint)
        }

        constrain(line) {
            centerVerticallyTo(point)
            start.linkTo(point.end)
        }
    }
}

internal fun getVerticalConstraintSet(marginFromPoint: Dp): ConstraintSet {
    return ConstraintSet {
        val point = createRefFor(PointLayoutId)
        val text = createRefFor(TextLayoutId)
        val line = createRefFor(LineLayoutId)

        constrain(point) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            bottom.linkTo(line.top)
        }

        constrain(text) {
            centerVerticallyTo(point)
            start.linkTo(point.end, margin = marginFromPoint)
            end.linkTo(parent.end)
        }

        constrain(line) {
            top.linkTo(point.bottom)
            start.linkTo(point.start)
            end.linkTo(point.end)
        }
    }
}