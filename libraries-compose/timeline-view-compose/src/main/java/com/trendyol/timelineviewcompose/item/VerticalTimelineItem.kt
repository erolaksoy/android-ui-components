package com.trendyol.timelineviewcompose.item

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.trendyol.uicomponents.librariescompose.timelineview.Line
import com.trendyol.timelineviewcompose.LineLayoutId
import com.trendyol.timelineviewcompose.PointLayoutId
import com.trendyol.timelineviewcompose.TextLayoutId
import com.trendyol.uicomponents.librariescompose.timelineview.TimelinePoint
import com.trendyol.timelineviewcompose.getVerticalConstraintSet
import com.trendyol.timelineviewcompose.model.FakeTimelineItemProvider
import com.trendyol.timelineviewcompose.model.TimelineItem
import com.trendyol.timelineviewcompose.model.TimelineOrientation
import com.trendyol.uicomponents.librariescompose.timelineview.scaleAnimation

@Composable
internal fun VerticalTimelineItem(
    modifier: Modifier = Modifier,
    item: TimelineItem.Point,
    isLastItem: Boolean,
    itemIndex: Int,
    onClick: () -> Unit = {},
) {
    ConstraintLayout(
        modifier = modifier,
        constraintSet = getVerticalConstraintSet(item.contentMargin),
    ) {
        TimelinePoint(
            onClick = onClick,
            config = item.pointConfig,
            modifier = Modifier
                .scaleAnimation(item.pointConfig.animation)
                .layoutId(PointLayoutId)
        )
        Text(
            text = item.text,
            style = item.textStyle,
            modifier = Modifier.layoutId(TextLayoutId)
        )
        if (!isLastItem) {
            Line(
                config = item.lineConfig,
                orientation = TimelineOrientation.VERTICAL,
                itemIndex = itemIndex,
                modifier = Modifier.layoutId(LineLayoutId)
            )
        }
    }
}

@Preview
@Composable
private fun VerticalTimelineItemPreview() {
    VerticalTimelineItem(
        item = FakeTimelineItemProvider.provideTimelineItem(
            borderWidth = 2.dp,
            pointSize = 28.dp,
            lineWidth = 25.dp,
        ),
        isLastItem = false,
        itemIndex = 2
    )
}