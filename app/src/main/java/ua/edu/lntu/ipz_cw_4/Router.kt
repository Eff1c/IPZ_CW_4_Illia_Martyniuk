package ua.edu.lntu.ipz_cw_4

sealed class Router(val route:String){
    class TaskListScreen(name: String? = null, isActive: Boolean = false):
        Router(route = "task_list_screen?name=$name&isActive=$isActive")

    class TaskInfoScreen(name: String, description: String, isActive: Boolean):
        Router(
            route = "list_item_screen?name=$name&description=$description&isActive=$isActive"
        )
}