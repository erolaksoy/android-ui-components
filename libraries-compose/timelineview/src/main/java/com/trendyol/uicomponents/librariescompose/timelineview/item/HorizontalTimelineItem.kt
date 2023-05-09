package com.trendyol.uicomponents.librariescompose.timelineview.item

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.trendyol.uicomponents.librariescompose.timelineview.Line
import com.trendyol.uicomponents.librariescompose.timelineview.LineLayoutId
import com.trendyol.uicomponents.librariescompose.timelineview.PointLayoutId
import com.trendyol.uicomponents.librariescompose.timelineview.TextLayoutId
import com.trendyol.uicomponents.librariescompose.timelineview.TimelinePoint
import com.trendyol.uicomponents.librariescompose.timelineview.getHorizontalConstraintSet
import com.trendyol.uicomponents.librariescompose.timelineview.model.FakeTimelineItemProvider
import com.trendyol.uicomponents.librariescompose.timelineview.model.TimelineItem
import com.trendyol.uicomponents.librariescompose.timelineview.model.TimelineOrientation

@Composable
internal fun HorizontalTimelineItem(
    modifier: Modifier = Modifier,
    item: TimelineItem.Point,
    isFirstItem: Boolean = false,
    isLastItem: Boolean = false,
    itemIndex: Int,
    onClick: () -> Unit = {},
) {

    val itemWidth = if (isLastItem) {
        item.pointConfig.getSizeWithBorder() + item.lineConfig.size.div(2)
    } else {
        item.pointConfig.getSizeWithBorder() + item.lineConfig.size
    }

    val startPadding = if (isFirstItem) item.lineConfig.size.div(2) else 0.dp

    ConstraintLayout(
        constraintSet = getHorizontalConstraintSet(item.contentMargin),
        modifier = modifier
            .padding(start = startPadding)
            .width(itemWidth)
    ) {
        TimelinePoint(
            config = item.pointConfig,
            modifier = Modifier.layoutId(PointLayoutId),
            onClick = onClick,
        )
        Text(
            text = item.text,
            style = item.textStyle,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Center,
            maxLines = 2,
            modifier = Modifier
                .width(itemWidth)
                .layoutId(TextLayoutId)
        )
        if (!isLastItem) {
            Line(
                itemIndex = itemIndex,
                config = item.lineConfig,
                orientation = TimelineOrientation.HORIZONTAL,
                modifier = Modifier.layoutId(LineLayoutId)
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun HorizontalTimelineItemPreview() {
    HorizontalTimelineItem(
        item = FakeTimelineItemProvider.provideTimelineItem(text = "Siparişiniz hazırlanıyor DENEME"),
        isLastItem = false,
        isFirstItem = true,
        itemIndex = 0
    )
}