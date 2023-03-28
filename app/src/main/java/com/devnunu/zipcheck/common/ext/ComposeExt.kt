package com.devnunu.zipcheck.common.ext

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import kotlinx.coroutines.launch

@Composable
fun Modifier.applyIf(
    condition: Boolean,
    modifierBlock: @Composable Modifier.() -> Modifier
): Modifier {
    return if (condition) {
        modifierBlock.invoke(this)
    } else {
        this
    }
}

@Composable
fun Modifier.clickableRipple(
    bounded: Boolean = false,
    enabled: Boolean = true,
    onClick: () -> Unit,
) = this.clickable(
    interactionSource = remember { MutableInteractionSource() },
    indication = rememberRipple(bounded = bounded),
    onClick = onClick,
    enabled = enabled
)

@Composable
fun Modifier.clickableNonIndication(
    enabled: Boolean = true,
    onClick: () -> Unit,
) = this.clickable(
    interactionSource = remember { MutableInteractionSource() },
    indication = null,
    onClick = onClick,
    enabled = enabled
)

@Composable
fun showToast(text: String) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val showToast: () -> Unit = {
        scope.launch {
            Toast.makeText(
                context,
                text,
                Toast.LENGTH_LONG
            ).show()
        }
    }
    showToast()
}