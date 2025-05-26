package com.example.accessibilitysteppersample

import androidx.annotation.StringRes

enum class MenuItem(@StringRes val title: Int, val navDestination: String) {
    BasicStepper(title = R.string.menu_item_title_basic_stepper, navDestination = "BasicStepper"),
    CustomActionsStepper(title = R.string.menu_item_title_custom_actions_stepper, navDestination = "CustomActionsStepper"),
    ProgressStepper(title = R.string.menu_item_title_progress_stepper, navDestination = "ProgressStepper"),
}
