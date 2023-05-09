package com.trendyol.timelineviewcompose.model

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random

object FakeTimelineItemProvider {

    internal fun provideTimelineItem(
        text: String = "Step Name",
        outsideColor: Color = Color.LightGray,
        insideColor: Color = getRandomColor(),
        textStyle: TextStyle = TextStyle(fontSize = 10.sp, fontFamily = FontFamily.Serif),
        lineColor: Color = getRandomColor(),
        borderWidth: Dp = 2.dp,
        pointSize: Dp = 28.dp,
        lineWidth: Dp = 25.dp,
    ): TimelineItem.Point {
        return TimelineItem.Point(
            textStyle = textStyle,
            pointConfig = PointConfig(
                outSideColor = outsideColor,
                insideColor = insideColor,
                size = pointSize,
                borderWidth = borderWidth
            ),
            text = text,
            lineConfig = LineConfig(
                color = lineColor,
                size = lineWidth,
            ),
        )
    }

    internal fun provideTimelineImageItem(): TimelineItem.Image {
        return TimelineItem.Image(
            imageConfig = ImageConfig(
                size = 32.dp,
                imageUrl = "https://dummyimage.com/100x100/000/fff"
            ),
            text = "Text\nText",
            textStyle = TextStyle(fontSize = 12.sp, textAlign = TextAlign.Center),
            lineConfig = LineConfig(
                size = 54.dp,
                color = Color.Red,
            ),
        )
    }

    internal fun provideTimelineItemList(): List<TimelineItem> {
        return (0..10).map { provideTimelineItem(text = "Step $it") }
    }

    private fun getRandomColor(): Color = Color(
        Random.nextInt(0, 255),
        Random.nextInt(0, 255),
        Random.nextInt(0, 255),
    )
}