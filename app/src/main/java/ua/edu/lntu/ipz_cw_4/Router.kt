package ua.edu.lntu.ipz_cw_4

sealed class Router(val route:String){
    data object TaskListScreen : Router(route = "task_list_screen")
}