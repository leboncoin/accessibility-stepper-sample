package com.example.accessibilitysteppersample.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.accessibilitysteppersample.MenuItem
import com.example.accessibilitysteppersample.R
import com.example.accessibilitysteppersample.ui.components.BasicStepper
import com.example.accessibilitysteppersample.ui.components.CustomActionsStepper

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComponentScreen(
    menuItem: MenuItem,
    onBackClick: () -> Unit,
) {
    BackHandler { onBackClick() }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        contentWindowInsets = WindowInsets.safeDrawing,
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = menuItem.title))
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_back),
                            contentDescription = stringResource(id = R.string.back_button_content_description),
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        var travellersCount by rememberSaveable { mutableIntStateOf(1) }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
        ) {
            when (menuItem) {
                MenuItem.BasicStepper ->
                    BasicStepper(
                        currentValue = travellersCount,
                        onValueChange = { newValue -> travellersCount = newValue },
                    )
                MenuItem.CustomActionsStepper ->
                    CustomActionsStepper(
                        currentValue = travellersCount,
                        onValueChange = { newValue -> travellersCount = newValue },
                    )
            }
        }
    }
}

@Preview
@Composable
fun ComponentScreenPreview() {
    ComponentScreen(
        menuItem = MenuItem.BasicStepper,
        onBackClick = { },
    )
}