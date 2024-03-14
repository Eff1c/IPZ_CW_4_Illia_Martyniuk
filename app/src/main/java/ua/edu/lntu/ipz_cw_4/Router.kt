package ua.edu.lntu.ipz_cw_4

sealed class Router(val route:String){
    data object TaskListScreen : Router(route = "task_list_screen")

    class TaskInfoScreen(name: String, description: String, isActive: Boolean):
        Router(
            route = "list_item_screen?name=$name&description=$description&isActive=$isActive"
        )
}