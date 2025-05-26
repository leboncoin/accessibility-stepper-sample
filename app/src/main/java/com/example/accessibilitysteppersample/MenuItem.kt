package com.example.accessibilitysteppersample

import androidx.annotation.StringRes

enum class MenuItem(@StringRes val title: Int, val navDestination: String) {
    BasicStepper(title = R.string.menu_item_title_basic_stepper, navDestination = "BasicStepper"),
}
