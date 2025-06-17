package studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.AppTypography
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.backgroundDark
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.backgroundDarkHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.backgroundDarkMediumContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.backgroundLight
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.backgroundLightHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.backgroundLightMediumContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.customColor1ContainerDark
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.customColor1ContainerDarkHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.customColor1ContainerDarkMediumContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.customColor1ContainerLight
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.customColor1ContainerLightHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.customColor1ContainerLightMediumContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.customColor1Dark
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.customColor1DarkHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.customColor1DarkMediumContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.customColor1Light
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.customColor1LightHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.customColor1LightMediumContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.errorContainerDark
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.errorContainerDarkHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.errorContainerDarkMediumContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.errorContainerLight
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.errorContainerLightHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.errorContainerLightMediumContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.errorDark
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.errorDarkHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.errorDarkMediumContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.errorLight
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.errorLightHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.errorLightMediumContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.inverseOnSurfaceDark
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.inverseOnSurfaceDarkHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.inverseOnSurfaceDarkMediumContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.inverseOnSurfaceLight
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.inverseOnSurfaceLightHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.inverseOnSurfaceLightMediumContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.inversePrimaryDark
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.inversePrimaryDarkHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.inversePrimaryDarkMediumContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.inversePrimaryLight
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.inversePrimaryLightHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.inversePrimaryLightMediumContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.inverseSurfaceDark
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.inverseSurfaceDarkHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.inverseSurfaceDarkMediumContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.inverseSurfaceLight
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.inverseSurfaceLightHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.inverseSurfaceLightMediumContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onBackgroundDark
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onBackgroundDarkHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onBackgroundDarkMediumContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onBackgroundLight
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onBackgroundLightHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onBackgroundLightMediumContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onCustomColor1ContainerDark
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onCustomColor1ContainerDarkHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onCustomColor1ContainerDarkMediumContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onCustomColor1ContainerLight
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onCustomColor1ContainerLightHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onCustomColor1ContainerLightMediumContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onCustomColor1Dark
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onCustomColor1DarkHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onCustomColor1DarkMediumContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onCustomColor1Light
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onCustomColor1LightHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onCustomColor1LightMediumContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onErrorContainerDark
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onErrorContainerDarkHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onErrorContainerDarkMediumContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onErrorContainerLight
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onErrorContainerLightHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onErrorContainerLightMediumContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onErrorDark
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onErrorDarkHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onErrorDarkMediumContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onErrorLight
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onErrorLightHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onErrorLightMediumContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onPrimaryContainerDark
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onPrimaryContainerDarkHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onPrimaryContainerDarkMediumContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onPrimaryContainerLight
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onPrimaryContainerLightHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onPrimaryContainerLightMediumContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onPrimaryDark
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onPrimaryDarkHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onPrimaryDarkMediumContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onPrimaryLight
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onPrimaryLightHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onPrimaryLightMediumContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onSecondaryContainerDark
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onSecondaryContainerDarkHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onSecondaryContainerDarkMediumContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onSecondaryContainerLight
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onSecondaryContainerLightHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onSecondaryContainerLightMediumContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onSecondaryDark
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onSecondaryDarkHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onSecondaryDarkMediumContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onSecondaryLight
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onSecondaryLightHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onSecondaryLightMediumContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onSurfaceDark
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onSurfaceDarkHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onSurfaceDarkMediumContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onSurfaceLight
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onSurfaceLightHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onSurfaceLightMediumContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onSurfaceVariantDark
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onSurfaceVariantDarkHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onSurfaceVariantDarkMediumContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onSurfaceVariantLight
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onSurfaceVariantLightHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onSurfaceVariantLightMediumContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onTertiaryContainerDark
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onTertiaryContainerDarkHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onTertiaryContainerDarkMediumContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onTertiaryContainerLight
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onTertiaryContainerLightHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onTertiaryContainerLightMediumContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onTertiaryDark
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onTertiaryDarkHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onTertiaryDarkMediumContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onTertiaryLight
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onTertiaryLightHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.onTertiaryLightMediumContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.outlineDark
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.outlineDarkHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.outlineDarkMediumContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.outlineLight
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.outlineLightHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.outlineLightMediumContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.outlineVariantDark
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.outlineVariantDarkHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.outlineVariantDarkMediumContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.outlineVariantLight
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.outlineVariantLightHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.outlineVariantLightMediumContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.primaryContainerDark
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.primaryContainerDarkHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.primaryContainerDarkMediumContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.primaryContainerLight
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.primaryContainerLightHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.primaryContainerLightMediumContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.primaryDark
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.primaryDarkHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.primaryDarkMediumContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.primaryLight
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.primaryLightHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.primaryLightMediumContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.scrimDark
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.scrimDarkHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.scrimDarkMediumContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.scrimLight
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.scrimLightHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.scrimLightMediumContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.secondaryContainerDark
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.secondaryContainerDarkHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.secondaryContainerDarkMediumContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.secondaryContainerLight
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.secondaryContainerLightHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.secondaryContainerLightMediumContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.secondaryDark
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.secondaryDarkHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.secondaryDarkMediumContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.secondaryLight
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.secondaryLightHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.secondaryLightMediumContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.surfaceBrightDark
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.surfaceBrightDarkHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.surfaceBrightDarkMediumContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.surfaceBrightLight
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.surfaceBrightLightHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.surfaceBrightLightMediumContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.surfaceContainerDark
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.surfaceContainerDarkHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.surfaceContainerDarkMediumContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.surfaceContainerHighDark
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.surfaceContainerHighDarkHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.surfaceContainerHighDarkMediumContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.surfaceContainerHighLight
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.surfaceContainerHighLightHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.surfaceContainerHighLightMediumContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.surfaceContainerHighestDark
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.surfaceContainerHighestDarkHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.surfaceContainerHighestDarkMediumContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.surfaceContainerHighestLight
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.surfaceContainerHighestLightHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.surfaceContainerHighestLightMediumContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.surfaceContainerLight
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.surfaceContainerLightHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.surfaceContainerLightMediumContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.surfaceContainerLowDark
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.surfaceContainerLowDarkHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.surfaceContainerLowDarkMediumContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.surfaceContainerLowLight
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.surfaceContainerLowLightHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.surfaceContainerLowLightMediumContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.surfaceContainerLowestDark
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.surfaceContainerLowestDarkHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.surfaceContainerLowestDarkMediumContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.surfaceContainerLowestLight
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.surfaceContainerLowestLightHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.surfaceContainerLowestLightMediumContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.surfaceDark
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.surfaceDarkHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.surfaceDarkMediumContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.surfaceDimDark
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.surfaceDimDarkHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.surfaceDimDarkMediumContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.surfaceDimLight
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.surfaceDimLightHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.surfaceDimLightMediumContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.surfaceLight
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.surfaceLightHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.surfaceLightMediumContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.surfaceVariantDark
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.surfaceVariantDarkHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.surfaceVariantDarkMediumContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.surfaceVariantLight
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.surfaceVariantLightHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.surfaceVariantLightMediumContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.tertiaryContainerDark
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.tertiaryContainerDarkHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.tertiaryContainerDarkMediumContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.tertiaryContainerLight
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.tertiaryContainerLightHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.tertiaryContainerLightMediumContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.tertiaryDark
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.tertiaryDarkHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.tertiaryDarkMediumContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.tertiaryLight
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.tertiaryLightHighContrast
import studio.lunabee.amicrogallery.android.core.ui.theme.redmaterial.tertiaryLightMediumContrast

@Immutable
data class ExtendedColorScheme(
    val customColor1: ColorFamily,
)

private val lightScheme = lightColorScheme(
    primary = primaryLight,
    onPrimary = onPrimaryLight,
    primaryContainer = primaryContainerLight,
    onPrimaryContainer = onPrimaryContainerLight,
    secondary = secondaryLight,
    onSecondary = onSecondaryLight,
    secondaryContainer = secondaryContainerLight,
    onSecondaryContainer = onSecondaryContainerLight,
    tertiary = tertiaryLight,
    onTertiary = onTertiaryLight,
    tertiaryContainer = tertiaryContainerLight,
    onTertiaryContainer = onTertiaryContainerLight,
    error = errorLight,
    onError = onErrorLight,
    errorContainer = errorContainerLight,
    onErrorContainer = onErrorContainerLight,
    background = backgroundLight,
    onBackground = onBackgroundLight,
    surface = surfaceLight,
    onSurface = onSurfaceLight,
    surfaceVariant = surfaceVariantLight,
    onSurfaceVariant = onSurfaceVariantLight,
    outline = outlineLight,
    outlineVariant = outlineVariantLight,
    scrim = scrimLight,
    inverseSurface = inverseSurfaceLight,
    inverseOnSurface = inverseOnSurfaceLight,
    inversePrimary = inversePrimaryLight,
    surfaceDim = surfaceDimLight,
    surfaceBright = surfaceBrightLight,
    surfaceContainerLowest = surfaceContainerLowestLight,
    surfaceContainerLow = surfaceContainerLowLight,
    surfaceContainer = surfaceContainerLight,
    surfaceContainerHigh = surfaceContainerHighLight,
    surfaceContainerHighest = surfaceContainerHighestLight,
)

private val darkScheme = darkColorScheme(
    primary = primaryDark,
    onPrimary = onPrimaryDark,
    primaryContainer = primaryContainerDark,
    onPrimaryContainer = onPrimaryContainerDark,
    secondary = secondaryDark,
    onSecondary = onSecondaryDark,
    secondaryContainer = secondaryContainerDark,
    onSecondaryContainer = onSecondaryContainerDark,
    tertiary = tertiaryDark,
    onTertiary = onTertiaryDark,
    tertiaryContainer = tertiaryContainerDark,
    onTertiaryContainer = onTertiaryContainerDark,
    error = errorDark,
    onError = onErrorDark,
    errorContainer = errorContainerDark,
    onErrorContainer = onErrorContainerDark,
    background = backgroundDark,
    onBackground = onBackgroundDark,
    surface = surfaceDark,
    onSurface = onSurfaceDark,
    surfaceVariant = surfaceVariantDark,
    onSurfaceVariant = onSurfaceVariantDark,
    outline = outlineDark,
    outlineVariant = outlineVariantDark,
    scrim = scrimDark,
    inverseSurface = inverseSurfaceDark,
    inverseOnSurface = inverseOnSurfaceDark,
    inversePrimary = inversePrimaryDark,
    surfaceDim = surfaceDimDark,
    surfaceBright = surfaceBrightDark,
    surfaceContainerLowest = surfaceContainerLowestDark,
    surfaceContainerLow = surfaceContainerLowDark,
    surfaceContainer = surfaceContainerDark,
    surfaceContainerHigh = surfaceContainerHighDark,
    surfaceContainerHighest = surfaceContainerHighestDark,
)

private val mediumContrastLightColorScheme = lightColorScheme(
    primary = primaryLightMediumContrast,
    onPrimary = onPrimaryLightMediumContrast,
    primaryContainer = primaryContainerLightMediumContrast,
    onPrimaryContainer = onPrimaryContainerLightMediumContrast,
    secondary = secondaryLightMediumContrast,
    onSecondary = onSecondaryLightMediumContrast,
    secondaryContainer = secondaryContainerLightMediumContrast,
    onSecondaryContainer = onSecondaryContainerLightMediumContrast,
    tertiary = tertiaryLightMediumContrast,
    onTertiary = onTertiaryLightMediumContrast,
    tertiaryContainer = tertiaryContainerLightMediumContrast,
    onTertiaryContainer = onTertiaryContainerLightMediumContrast,
    error = errorLightMediumContrast,
    onError = onErrorLightMediumContrast,
    errorContainer = errorContainerLightMediumContrast,
    onErrorContainer = onErrorContainerLightMediumContrast,
    background = backgroundLightMediumContrast,
    onBackground = onBackgroundLightMediumContrast,
    surface = surfaceLightMediumContrast,
    onSurface = onSurfaceLightMediumContrast,
    surfaceVariant = surfaceVariantLightMediumContrast,
    onSurfaceVariant = onSurfaceVariantLightMediumContrast,
    outline = outlineLightMediumContrast,
    outlineVariant = outlineVariantLightMediumContrast,
    scrim = scrimLightMediumContrast,
    inverseSurface = inverseSurfaceLightMediumContrast,
    inverseOnSurface = inverseOnSurfaceLightMediumContrast,
    inversePrimary = inversePrimaryLightMediumContrast,
    surfaceDim = surfaceDimLightMediumContrast,
    surfaceBright = surfaceBrightLightMediumContrast,
    surfaceContainerLowest = surfaceContainerLowestLightMediumContrast,
    surfaceContainerLow = surfaceContainerLowLightMediumContrast,
    surfaceContainer = surfaceContainerLightMediumContrast,
    surfaceContainerHigh = surfaceContainerHighLightMediumContrast,
    surfaceContainerHighest = surfaceContainerHighestLightMediumContrast,
)

private val highContrastLightColorScheme = lightColorScheme(
    primary = primaryLightHighContrast,
    onPrimary = onPrimaryLightHighContrast,
    primaryContainer = primaryContainerLightHighContrast,
    onPrimaryContainer = onPrimaryContainerLightHighContrast,
    secondary = secondaryLightHighContrast,
    onSecondary = onSecondaryLightHighContrast,
    secondaryContainer = secondaryContainerLightHighContrast,
    onSecondaryContainer = onSecondaryContainerLightHighContrast,
    tertiary = tertiaryLightHighContrast,
    onTertiary = onTertiaryLightHighContrast,
    tertiaryContainer = tertiaryContainerLightHighContrast,
    onTertiaryContainer = onTertiaryContainerLightHighContrast,
    error = errorLightHighContrast,
    onError = onErrorLightHighContrast,
    errorContainer = errorContainerLightHighContrast,
    onErrorContainer = onErrorContainerLightHighContrast,
    background = backgroundLightHighContrast,
    onBackground = onBackgroundLightHighContrast,
    surface = surfaceLightHighContrast,
    onSurface = onSurfaceLightHighContrast,
    surfaceVariant = surfaceVariantLightHighContrast,
    onSurfaceVariant = onSurfaceVariantLightHighContrast,
    outline = outlineLightHighContrast,
    outlineVariant = outlineVariantLightHighContrast,
    scrim = scrimLightHighContrast,
    inverseSurface = inverseSurfaceLightHighContrast,
    inverseOnSurface = inverseOnSurfaceLightHighContrast,
    inversePrimary = inversePrimaryLightHighContrast,
    surfaceDim = surfaceDimLightHighContrast,
    surfaceBright = surfaceBrightLightHighContrast,
    surfaceContainerLowest = surfaceContainerLowestLightHighContrast,
    surfaceContainerLow = surfaceContainerLowLightHighContrast,
    surfaceContainer = surfaceContainerLightHighContrast,
    surfaceContainerHigh = surfaceContainerHighLightHighContrast,
    surfaceContainerHighest = surfaceContainerHighestLightHighContrast,
)

private val mediumContrastDarkColorScheme = darkColorScheme(
    primary = primaryDarkMediumContrast,
    onPrimary = onPrimaryDarkMediumContrast,
    primaryContainer = primaryContainerDarkMediumContrast,
    onPrimaryContainer = onPrimaryContainerDarkMediumContrast,
    secondary = secondaryDarkMediumContrast,
    onSecondary = onSecondaryDarkMediumContrast,
    secondaryContainer = secondaryContainerDarkMediumContrast,
    onSecondaryContainer = onSecondaryContainerDarkMediumContrast,
    tertiary = tertiaryDarkMediumContrast,
    onTertiary = onTertiaryDarkMediumContrast,
    tertiaryContainer = tertiaryContainerDarkMediumContrast,
    onTertiaryContainer = onTertiaryContainerDarkMediumContrast,
    error = errorDarkMediumContrast,
    onError = onErrorDarkMediumContrast,
    errorContainer = errorContainerDarkMediumContrast,
    onErrorContainer = onErrorContainerDarkMediumContrast,
    background = backgroundDarkMediumContrast,
    onBackground = onBackgroundDarkMediumContrast,
    surface = surfaceDarkMediumContrast,
    onSurface = onSurfaceDarkMediumContrast,
    surfaceVariant = surfaceVariantDarkMediumContrast,
    onSurfaceVariant = onSurfaceVariantDarkMediumContrast,
    outline = outlineDarkMediumContrast,
    outlineVariant = outlineVariantDarkMediumContrast,
    scrim = scrimDarkMediumContrast,
    inverseSurface = inverseSurfaceDarkMediumContrast,
    inverseOnSurface = inverseOnSurfaceDarkMediumContrast,
    inversePrimary = inversePrimaryDarkMediumContrast,
    surfaceDim = surfaceDimDarkMediumContrast,
    surfaceBright = surfaceBrightDarkMediumContrast,
    surfaceContainerLowest = surfaceContainerLowestDarkMediumContrast,
    surfaceContainerLow = surfaceContainerLowDarkMediumContrast,
    surfaceContainer = surfaceContainerDarkMediumContrast,
    surfaceContainerHigh = surfaceContainerHighDarkMediumContrast,
    surfaceContainerHighest = surfaceContainerHighestDarkMediumContrast,
)

private val highContrastDarkColorScheme = darkColorScheme(
    primary = primaryDarkHighContrast,
    onPrimary = onPrimaryDarkHighContrast,
    primaryContainer = primaryContainerDarkHighContrast,
    onPrimaryContainer = onPrimaryContainerDarkHighContrast,
    secondary = secondaryDarkHighContrast,
    onSecondary = onSecondaryDarkHighContrast,
    secondaryContainer = secondaryContainerDarkHighContrast,
    onSecondaryContainer = onSecondaryContainerDarkHighContrast,
    tertiary = tertiaryDarkHighContrast,
    onTertiary = onTertiaryDarkHighContrast,
    tertiaryContainer = tertiaryContainerDarkHighContrast,
    onTertiaryContainer = onTertiaryContainerDarkHighContrast,
    error = errorDarkHighContrast,
    onError = onErrorDarkHighContrast,
    errorContainer = errorContainerDarkHighContrast,
    onErrorContainer = onErrorContainerDarkHighContrast,
    background = backgroundDarkHighContrast,
    onBackground = onBackgroundDarkHighContrast,
    surface = surfaceDarkHighContrast,
    onSurface = onSurfaceDarkHighContrast,
    surfaceVariant = surfaceVariantDarkHighContrast,
    onSurfaceVariant = onSurfaceVariantDarkHighContrast,
    outline = outlineDarkHighContrast,
    outlineVariant = outlineVariantDarkHighContrast,
    scrim = scrimDarkHighContrast,
    inverseSurface = inverseSurfaceDarkHighContrast,
    inverseOnSurface = inverseOnSurfaceDarkHighContrast,
    inversePrimary = inversePrimaryDarkHighContrast,
    surfaceDim = surfaceDimDarkHighContrast,
    surfaceBright = surfaceBrightDarkHighContrast,
    surfaceContainerLowest = surfaceContainerLowestDarkHighContrast,
    surfaceContainerLow = surfaceContainerLowDarkHighContrast,
    surfaceContainer = surfaceContainerDarkHighContrast,
    surfaceContainerHigh = surfaceContainerHighDarkHighContrast,
    surfaceContainerHighest = surfaceContainerHighestDarkHighContrast,
)

val extendedLight = ExtendedColorScheme(
  customColor1 = ColorFamily(
      customColor1Light,
      onCustomColor1Light,
      customColor1ContainerLight,
      onCustomColor1ContainerLight,
  ),
)

val extendedDark = ExtendedColorScheme(
  customColor1 = ColorFamily(
      customColor1Dark,
      onCustomColor1Dark,
      customColor1ContainerDark,
      onCustomColor1ContainerDark,
  ),
)

val extendedLightMediumContrast = ExtendedColorScheme(
  customColor1 = ColorFamily(
      customColor1LightMediumContrast,
      onCustomColor1LightMediumContrast,
      customColor1ContainerLightMediumContrast,
      onCustomColor1ContainerLightMediumContrast,
  ),
)

val extendedLightHighContrast = ExtendedColorScheme(
  customColor1 = ColorFamily(
      customColor1LightHighContrast,
      onCustomColor1LightHighContrast,
      customColor1ContainerLightHighContrast,
      onCustomColor1ContainerLightHighContrast,
  ),
)

val extendedDarkMediumContrast = ExtendedColorScheme(
  customColor1 = ColorFamily(
      customColor1DarkMediumContrast,
      onCustomColor1DarkMediumContrast,
      customColor1ContainerDarkMediumContrast,
      onCustomColor1ContainerDarkMediumContrast,
  ),
)

val extendedDarkHighContrast = ExtendedColorScheme(
  customColor1 = ColorFamily(
      customColor1DarkHighContrast,
      onCustomColor1DarkHighContrast,
      customColor1ContainerDarkHighContrast,
      onCustomColor1ContainerDarkHighContrast,
  ),
)

@Immutable
data class ColorFamily(
    val color: Color,
    val onColor: Color,
    val colorContainer: Color,
    val onColorContainer: Color
)

val unspecified_scheme = ColorFamily(
    Color.Unspecified, Color.Unspecified, Color.Unspecified, Color.Unspecified
)

@Composable
fun RedMaterialTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+, serve to use system's theme if set to true
    dynamicColor: Boolean = false,
    content: @Composable() () -> Unit
) {
  val colorScheme = when {
      dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
          val context = LocalContext.current
          if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
      }
      
      darkTheme -> darkScheme
      else -> lightScheme
  }

  MaterialTheme(
    colorScheme = colorScheme,
    typography = AppTypography,
    content = content
  )
}

