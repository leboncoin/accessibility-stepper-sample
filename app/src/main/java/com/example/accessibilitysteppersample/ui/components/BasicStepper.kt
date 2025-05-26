package com.example.accessibilitysteppersample.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.LiveRegionMode
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.liveRegion
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.accessibilitysteppersample.R

@Composable
fun BasicStepper(
    modifier: Modifier = Modifier,
    currentValue: Int,
    onValueChange: (Int) -> Unit,
) {
    val stepperContentDescription = pluralStringResource(
        id = R.plurals.stepper_value_content_description,
        count = currentValue,
        currentValue,
    )
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            modifier = Modifier
                .weight(1f)
                .semantics {
                    contentDescription = stepperContentDescription
                    liveRegion = LiveRegionMode.Polite
                },
            text = stringResource(id = R.string.stepper_title),
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            OutlinedIconButton(onClick = { onValueChange(currentValue - 1) }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_decrease),
                    contentDescription = stringResource(id = R.string.stepper_action_decrease_content_description),
                )
            }
            Text(
                modifier = Modifier.clearAndSetSemantics {  },
                text = currentValue.toString(),
            )
            OutlinedIconButton(onClick = { onValueChange(currentValue + 1) }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_increase),
                    contentDescription = stringResource(id = R.string.stepper_action_increase_content_description),
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BasicStepperPreview() {
    BasicStepper(
        modifier = Modifier.fillMaxWidth(),
        currentValue = 1,
        onValueChange = { },
    )
}
