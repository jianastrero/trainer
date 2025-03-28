package dev.jianastrero.trainer.ui.atom

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.jianastrero.trainer.ui.theme.TrainerTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun LabelAndValue(
    label: String,
    value: String?,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Text(
            text = label,
            color = MaterialTheme.colors.onBackground.copy(alpha = 0.72f),
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Start,
            modifier = Modifier
        )
        Spacer(
            modifier = Modifier
                .background(MaterialTheme.colors.onBackground.copy(alpha = 0.24f))
                .height(1.dp)
                .weight(1f)
        )
        AnimatedContent(
            targetState = value,
            label = "ValueAnim",
        ) { text ->
            if (text == null) {
                Skeleton(
                    modifier = Modifier.size(128.dp, 16.dp)
                )
            } else {
                Text(
                    text = text,
                    color = MaterialTheme.colors.onBackground,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.ExtraBold,
                    textAlign = TextAlign.End,
                    modifier = Modifier
                )
            }
        }
    }
}

@Preview
@Composable
private fun PreviewLabelAndValue() {
    TrainerTheme {
        LabelAndValue(
            label = "Height",
            value = "0.7 m",
            modifier = Modifier
        )
    }
}
