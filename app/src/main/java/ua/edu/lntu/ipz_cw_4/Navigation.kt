package ua.edu.lntu.ipz_cw_4

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import ua.edu.lntu.ipz_cw_4.screens.TaskInfoScreen
import ua.edu.lntu.ipz_cw_4.screens.TaskListScreen


@Composable
fun NavigationFun() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Router.TaskListScreen().route) {
        composable(
            route = Router.TaskListScreen().route, arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                    defaultValue = "default"
                    nullable = true
                },
                navArgument("isActive") {
                    type = NavType.BoolType
                    defaultValue = false
                },
            )
        ) { entry ->
            TaskListScreen(
                navController = navController,
                name = entry.arguments?.getString("name"),
                isActive = entry.arguments?.getBoolean("isActive") ?: false
            )
        }

        composable(
            route = "list_item_screen?name={name}&description={description}&isActive={isActive}",
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                    defaultValue = "default"
                    nullable = true
                },
                navArgument("description") {
                    type = NavType.StringType
                    defaultValue = "default"
                    nullable = true
                },
                navArgument("isActive") {
                    type = NavType.BoolType
                    defaultValue = false
                },
            )
        ) { entry ->
            TaskInfoScreen(
                navController = navController,
                task = Task(
                    entry.arguments?.getString("name") ?: "5",
                    entry.arguments?.getString("description") ?: "5",
                    entry.arguments?.getBoolean("isActive") ?: false
                )
            )
        }
    }
}