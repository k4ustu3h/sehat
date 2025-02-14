package k4ustu3h.sehat

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import k4ustu3h.sehat.analytics.AnalyticsEvents
import k4ustu3h.sehat.analytics.AnalyticsHelper
import k4ustu3h.sehat.feature.addmedication.navigation.AddMedicationDestination
import k4ustu3h.sehat.feature.history.HistoryDestination
import k4ustu3h.sehat.feature.home.LensFAB
import k4ustu3h.sehat.feature.home.navigation.HomeDestination
import k4ustu3h.sehat.navigation.SehatNavHost
import k4ustu3h.sehat.navigation.SehatTopLevelNavigation
import k4ustu3h.sehat.navigation.TOP_LEVEL_DESTINATIONS
import k4ustu3h.sehat.navigation.TopLevelDestination
import k4ustu3h.sehat.ui.theme.SehatTheme
import k4ustu3h.sehat.util.SnackbarUtil

@Composable
fun Sehat(
    analyticsHelper: AnalyticsHelper
) {
    SehatTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
        ) {

            val navController = rememberNavController()
            val sehatTopLevelNavigation = remember(navController) {
                SehatTopLevelNavigation(navController)
            }

            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination

            val bottomBarVisibility = rememberSaveable { (mutableStateOf(true)) }
            val fabVisibility = rememberSaveable { (mutableStateOf(true)) }

            Scaffold(modifier = Modifier.padding(16.dp, 0.dp),
                containerColor = Color.Transparent,
                contentColor = MaterialTheme.colorScheme.onBackground,
                floatingActionButton = {
                    AnimatedVisibility(visible = fabVisibility.value,
                        enter = slideInVertically(initialOffsetY = { it }),
                        exit = slideOutVertically(targetOffsetY = { it }),
                        content = {
                            Column(
                                horizontalAlignment = Alignment.End,
                                verticalArrangement = Arrangement.spacedBy(16.dp)
                            ) {
                                LensFAB()
                                SehatFAB(navController, analyticsHelper)
                            }

                        })
                },
                bottomBar = {
                    Box {
                        SnackbarUtil.SnackbarWithoutScaffold(
                            SnackbarUtil.getSnackbarMessage().component1(),
                            SnackbarUtil.isSnackbarVisible().component1()
                        ) {
                            SnackbarUtil.hideSnackbar()
                        }
                        AnimatedVisibility(visible = bottomBarVisibility.value,
                            enter = slideInVertically(initialOffsetY = { it }),
                            exit = slideOutVertically(targetOffsetY = { it }),
                            content = {
                                SehatBottomBar(
                                    onNavigateToTopLevelDestination = sehatTopLevelNavigation::navigateTo,
                                    currentDestination = currentDestination,
                                    analyticsHelper = analyticsHelper
                                )
                            })
                    }
                }) { padding ->
                Row(
                    Modifier
                        .fillMaxSize()
                        .windowInsetsPadding(
                            WindowInsets.safeDrawing.only(
                                WindowInsetsSides.Horizontal
                            )
                        )
                ) {

                    SehatNavHost(
                        bottomBarVisibility = bottomBarVisibility,
                        fabVisibility = fabVisibility,
                        navController = navController,
                        modifier = Modifier
                            .padding(padding)
                            .consumeWindowInsets(padding)
                            .zIndex(1f)
                    )
                }
            }
        }
    }
}

@Composable
private fun SehatBottomBar(
    onNavigateToTopLevelDestination: (TopLevelDestination) -> Unit,
    currentDestination: NavDestination?,
    analyticsHelper: AnalyticsHelper
) {
    // Wrap the navigation bar in a surface so the color behind the system
    // navigation is equal to the container color of the navigation bar.
    Surface(color = MaterialTheme.colorScheme.surface) {
        NavigationBar(
            modifier = Modifier.windowInsetsPadding(
                WindowInsets.safeDrawing.only(
                    WindowInsetsSides.Horizontal + WindowInsetsSides.Bottom
                )
            ), tonalElevation = 0.dp
        ) {

            TOP_LEVEL_DESTINATIONS.forEach { destination ->
                val selected =
                    currentDestination?.hierarchy?.any { it.route == destination.route } == true
                NavigationBarItem(selected = selected, onClick = {
                    trackTabClicked(analyticsHelper, destination.route)
                    onNavigateToTopLevelDestination(destination)
                }, icon = {
                    Icon(
                        if (selected) {
                            destination.selectedIcon
                        } else {
                            destination.unselectedIcon
                        }, contentDescription = null
                    )
                }, label = { Text(stringResource(destination.iconTextId)) })
            }
        }
    }
}

private fun trackTabClicked(analyticsHelper: AnalyticsHelper, route: String) {
    if (route == HomeDestination.route) {
        analyticsHelper.logEvent(AnalyticsEvents.HOME_TAB_CLICKED)
    }

    if (route == HistoryDestination.route) {
        analyticsHelper.logEvent(AnalyticsEvents.HISTORY_TAB_CLICKED)
    }
}

@Composable
fun SehatFAB(navController: NavController, analyticsHelper: AnalyticsHelper) {
    ExtendedFloatingActionButton(text = { Text(text = stringResource(id = R.string.add_medication)) },
        icon = {
            Icon(
                imageVector = Icons.Default.Add, contentDescription = stringResource(R.string.add)
            )
        },
        onClick = {
            analyticsHelper.logEvent(AnalyticsEvents.ADD_MEDICATION_CLICKED_FAB)
            navController.navigate(AddMedicationDestination.route)
        },
        elevation = FloatingActionButtonDefaults.elevation(0.dp, 0.dp),
        containerColor = MaterialTheme.colorScheme.tertiary
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val context = LocalContext.current
    SehatTheme {
        Sehat(analyticsHelper = AnalyticsHelper(context = context))
    }
}
