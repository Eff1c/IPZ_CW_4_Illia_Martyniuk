package ua.edu.lntu.ipz_cw_4.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ua.edu.lntu.ipz_cw_4.Router
import ua.edu.lntu.ipz_cw_4.Task
import ua.edu.lntu.ipz_cw_4.ui.theme.IPZ_CW_4_Illia_MartyniukTheme

@Composable
fun TaskListScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    name: String?,
    isActive: Boolean
) {
    val taskList = rememberSaveable {
        (1..30).map {
            val taskName = "Task $it"
            Task(taskName, "Description $it", listOf(true, false).random())
        }.toMutableList()
    }

    if (name != null) {
        taskList.firstOrNull { it.name == name }?.let { task ->
            taskList.replaceAll { task }
        }
    }


    LazyColumn {
        items(taskList) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.cardColors(
                    containerColor = it.getColor()
                )
            ) {
                Column(
                    Modifier.clickable {
                        navController.navigate(
                            Router.TaskInfoScreen(
                                it.name,
                                it.description,
                                it.isActive
                            ).route
                        )
                    }
                ) {
                    Text(text = it.name, style = TextStyle(fontSize = 34.sp))
                }
            }
        }
    }
}

@Preview
@Composable
fun TaskListScreenPrev() {
    IPZ_CW_4_Illia_MartyniukTheme {
        TaskListScreen(
            navController = NavController(LocalContext.current),
            name = null,
            isActive = false
        )
    }
}
