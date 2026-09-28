package com.hieuwu.groceriesstore.presentation.core

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.lightColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.hieuwu.groceriesstore.R

/** Keeps legacy Material and Material 3 screens on the same warm palette. */
@Composable
fun StoreTheme(content: @Composable () -> Unit) {
    val primary = colorResource(R.color.colorPrimary)
    val dark = colorResource(R.color.colorPrimaryDark)
    val accent = colorResource(R.color.colorAccent)
    val ivory = colorResource(R.color.warm_white)
    val background = colorResource(R.color.warm_background)
    val ink = colorResource(R.color.text_primary)
    val muted = colorResource(R.color.text_secondary)
    val rose = colorResource(R.color.soft_rose)
    val outline = colorResource(R.color.warm_outline)
    androidx.compose.material.MaterialTheme(
        colors = lightColors(
            primary = primary, primaryVariant = dark, secondary = accent,
            background = background, surface = ivory,
            onPrimary = ivory, onSecondary = ivory, onBackground = ink, onSurface = ink,
            error = dark, onError = ivory
        ),
        shapes = androidx.compose.material.Shapes(
            small = RoundedCornerShape(12.dp), medium = RoundedCornerShape(16.dp),
            large = RoundedCornerShape(24.dp)
        )
    ) {
        MaterialTheme(
            colorScheme = lightColorScheme(
                primary = primary, onPrimary = ivory,
                primaryContainer = rose, onPrimaryContainer = dark,
                secondary = accent, onSecondary = ivory,
                secondaryContainer = rose, onSecondaryContainer = dark,
                tertiary = dark, onTertiary = ivory,
                background = background, onBackground = ink,
                surface = ivory, onSurface = ink,
                surfaceVariant = background, onSurfaceVariant = muted,
                outline = outline, outlineVariant = outline,
                error = dark, onError = ivory,
                errorContainer = rose, onErrorContainer = dark
            ),
            shapes = androidx.compose.material3.Shapes(
                small = RoundedCornerShape(12.dp), medium = RoundedCornerShape(16.dp),
                large = RoundedCornerShape(24.dp)
            )
        ) {
            Surface(color = background, content = content)
        }
    }
}
