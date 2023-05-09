package com.trendyol.uicomponents.samplecompose

import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.trendyol.uicomponents.librariescompose.timelineview.TimelineView
import com.trendyol.uicomponents.librariescompose.timelineview.model.TimelineOrientation
import com.trendyol.uicomponents.samplecompose.TimelineViewItemProvider.createTimelineImageItems
import com.trendyol.uicomponents.samplecompose.TimelineViewItemProvider.createTimelineItems
import com.trendyol.uicomponents.samplecompose.ui.theme.ColorPrimary

@Composable
fun TimelineViewScreen() {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 16.dp, horizontal = 8.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Horizontal TimelineViews", style = MaterialTheme.typography.h6)

        ContentWithBorder {
            TimelineView(
                modifier = Modifier.horizontalScroll(rememberScrollState()),
                items = createTimelineItems(
                    lineAnimationEnabled = true,
                    pointAnimationEnabled = true
                ),
                orientation = TimelineOrientation.HORIZONTAL,
            )
            ItemDescription("point items with animation")
        }

        ContentWithBorder {
            TimelineView(
                modifier = Modifier.horizontalScroll(rememberScrollState()),
                items = createTimelineImageItems(),
                orientation = TimelineOrientation.HORIZONTAL,
            )

            ItemDescription("image items with animation")
        }

        Divider(thickness = 1.dp, color = colorGray, modifier = Modifier.padding(vertical = 8.dp))

        Text(text = "Vertical TimelineViews", style = MaterialTheme.typography.h6)

        ContentWithBorder {
            TimelineView(
                items = createTimelineItems(
                    lineAnimationEnabled = true,
                    pointAnimationEnabled = true
                ),
                orientation = TimelineOrientation.VERTICAL,
            )
            ItemDescription("point items with animation")
        }

        ContentWithBorder {
            TimelineView(
                items = createTimelineImageItems(),
                orientation = TimelineOrientation.VERTICAL,
            )
            ItemDescription("image items with animation")
        }
    }
}

@Composable
private fun ContentWithBorder(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .border(1.dp, ColorPrimary, RoundedCornerShape(8.dp))
            .padding(4.dp),
        content = content,
        horizontalAlignment = Alignment.CenterHorizontally,
    )
}

@Composable
private fun ItemDescription(description: String, modifier: Modifier = Modifier) {
    Text(
        modifier = modifier.padding(vertical = 4.dp),
        text = description,
        color = Color.DarkGray,
        fontStyle = FontStyle.Italic,
    )
}
