package ua.edu.lntu.ipz_cw_4

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ua.edu.lntu.ipz_cw_4.screens.TaskListScreen


@Composable
fun NavigationFun() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Router.TaskListScreen.route) {
        composable(route = Router.TaskListScreen.route) {
            TaskListScreen(navController = navController)
        }
    }
}