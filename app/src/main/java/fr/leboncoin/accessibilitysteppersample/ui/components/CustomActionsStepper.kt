package fr.leboncoin.accessibilitysteppersample.ui.components

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
import androidx.compose.ui.semantics.CustomAccessibilityAction
import androidx.compose.ui.semantics.LiveRegionMode
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.customActions
import androidx.compose.ui.semantics.liveRegion
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.leboncoin.accessibilitysteppersample.R

@Composable
fun CustomActionsStepper(
    modifier: Modifier = Modifier,
    currentValue: Int,
    onValueChange: (Int) -> Unit,
) {
    val stepperContentDescription = pluralStringResource(
        id = R.plurals.stepper_value_content_description,
        count = currentValue,
        currentValue,
    )
    val stepperCustomActions = defineStepperCustomActions(
        currentValue = currentValue,
        onValueChange = onValueChange,
    )
    Row(
        modifier = modifier.clearAndSetSemantics {
            contentDescription = stepperContentDescription
            liveRegion = LiveRegionMode.Polite
            customActions = stepperCustomActions
        },
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(text = stringResource(id = R.string.stepper_title))
        Stepper(
            currentValue = currentValue,
            onValueChange = onValueChange,
        )
    }
}

@Composable
private fun Stepper(
    modifier: Modifier = Modifier,
    currentValue: Int,
    onValueChange: (Int) -> Unit,
) {
    Row(
        modifier = modifier,
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

@Composable
private fun defineStepperCustomActions(
    currentValue: Int,
    onValueChange: (Int) -> Unit,
): List<CustomAccessibilityAction> =
    listOf(
        CustomAccessibilityAction(
            label = stringResource(id = R.string.stepper_action_decrease_content_description),
            action = {
                onValueChange(currentValue - 1)
                true
            },
        ),
        CustomAccessibilityAction(
            label = stringResource(id = R.string.stepper_action_increase_content_description),
            action = {
                onValueChange(currentValue + 1)
                true
            },
        ),
    )

@Preview(showBackground = true)
@Composable
fun CustomActionsStepperPreview() {
    CustomActionsStepper(
        modifier = Modifier.fillMaxWidth(),
        currentValue = 1,
        onValueChange = { },
    )
}
