package fr.leboncoin.accessibilitysteppersample.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.progressSemantics
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.setProgress
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.leboncoin.accessibilitysteppersample.R
import kotlin.math.roundToInt

private const val MAX_VALUE = 9

@Composable
fun ProgressStepper(
    modifier: Modifier = Modifier,
    currentValue: Int,
    onValueChange: (Int) -> Unit,
) {
    val stepperStateDescription = pluralStringResource(
        id = R.plurals.stepper_value_content_description,
        count = currentValue,
        currentValue,
    )
    Row(
        modifier = modifier.semantics(mergeDescendants = true) {
            stateDescription = stepperStateDescription
            setProgress { newValue ->
                onValueChange(newValue.roundToInt())
                true
            }
        }.progressSemantics(
            value = currentValue.toFloat(),
            valueRange = 0f..MAX_VALUE.toFloat(),
            steps = MAX_VALUE,
        ),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            modifier = Modifier
                .weight(1f)
                .clearAndSetSemantics {  },
            text = stringResource(id = R.string.stepper_title),
        )
        Row(
            modifier = Modifier.clearAndSetSemantics {  },
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            OutlinedIconButton(onClick = { onValueChange(currentValue - 1) }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_decrease),
                    contentDescription = null,
                )
            }
            Text(text = currentValue.toString())
            OutlinedIconButton(onClick = { onValueChange(currentValue + 1) }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_increase),
                    contentDescription = null,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProgressStepperPreview() {
    ProgressStepper(
        modifier = Modifier.fillMaxWidth(),
        currentValue = 1,
        onValueChange = { },
    )
}
