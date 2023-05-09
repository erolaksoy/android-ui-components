package com.trendyol.uicomponents.librariescompose.timelineview

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.trendyol.uicomponents.librariescompose.timelineview.item.HorizontalTimelineImageItem
import com.trendyol.uicomponents.librariescompose.timelineview.item.HorizontalTimelineItem
import com.trendyol.uicomponents.librariescompose.timelineview.model.FakeTimelineItemProvider.provideTimelineItemList
import com.trendyol.uicomponents.librariescompose.timelineview.model.TimelineItem
import com.trendyol.uicomponents.librariescompose.timelineview.model.TimelineOrientation
import com.trendyol.uicomponents.librariescompose.timelineview.item.VerticalTimelineImageItem
import com.trendyol.uicomponents.librariescompose.timelineview.item.VerticalTimelineItem

@Composable
fun TimelineView(
    items: List<TimelineItem>,
    orientation: TimelineOrientation,
    modifier: Modifier = Modifier,
    onClick: (TimelineItem) -> Unit = {},
) {
    when (orientation) {
        TimelineOrientation.VERTICAL -> VerticalTimelineView(
            items = items,
            modifier = modifier,
            onClick = onClick
        )

        TimelineOrientation.HORIZONTAL -> HorizontalTimelineView(
            items = items,
            modifier = modifier,
            onClick = onClick
        )
    }
}

@Composable
private fun VerticalTimelineView(
    items: List<TimelineItem>,
    modifier: Modifier = Modifier,
    onClick: (TimelineItem) -> Unit = {},
) {
    Column(modifier = modifier) {
        items.forEachIndexed { index, item ->
            when (item) {
                is TimelineItem.Point -> {
                    VerticalTimelineItem(
                        item = item,
                        itemIndex = index,
                        isLastItem = items.isLastItem(index),
                        onClick = { onClick(items[index]) },
                    )
                }

                is TimelineItem.Image -> {
                    VerticalTimelineImageItem(
                        item = item,
                        isLastItem = items.isLastItem(index),
                        itemIndex = index,
                        onClick = { onClick(items[index]) },
                    )
                }
            }
        }
    }
}

@Composable
private fun HorizontalTimelineView(
    items: List<TimelineItem>,
    modifier: Modifier = Modifier,
    onClick: (TimelineItem) -> Unit = {},
) {
    Row(modifier = modifier) {
        items.forEachIndexed { index, item ->
            val isFirstItem = index == 0
            when (item) {
                is TimelineItem.Point -> {
                    HorizontalTimelineItem(
                        item = item,
                        itemIndex = index,
                        isFirstItem = isFirstItem,
                        isLastItem = items.isLastItem(index),
                        onClick = { onClick(items[index]) },
                    )
                }

                is TimelineItem.Image -> {
                    HorizontalTimelineImageItem(
                        item = item,
                        isFirstItem = isFirstItem,
                        isLastItem = items.isLastItem(index),
                        itemIndex = index,
                        onClick = { onClick(items[index]) },
                    )
                }
            }
        }
    }
}

private fun List<TimelineItem>.isLastItem(index: Int): Boolean {
    return index == size - 1
}

@Composable
@Preview(showBackground = true)
private fun TimelineViewHorizontalPreview() {
    TimelineView(
        orientation = TimelineOrientation.HORIZONTAL,
        items = provideTimelineItemList()
    )
}

@Composable
@Preview(showBackground = true)
private fun TimelineViewVerticalPreview() {
    TimelineView(
        orientation = TimelineOrientation.VERTICAL,
        items = provideTimelineItemList()
    )
}