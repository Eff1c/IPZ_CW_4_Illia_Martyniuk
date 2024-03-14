package ua.edu.lntu.ipz_cw_4.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ua.edu.lntu.ipz_cw_4.Task
import ua.edu.lntu.ipz_cw_4.ui.theme.IPZ_CW_4_Illia_MartyniukTheme

@Composable
fun TaskInfoScreen(modifier: Modifier = Modifier, navController: NavController, task: Task) {
    Column(
        modifier = Modifier.background(
            color = task.getColor()
        )
    ) {
        Text(task.name, style = TextStyle(fontSize = 62.sp))
        Text(task.description)
    }
}

@Preview
@Composable
fun TaskInfoScreenPreview() {
    IPZ_CW_4_Illia_MartyniukTheme {
        TaskInfoScreen(
            navController = NavController(LocalContext.current),
            task = Task("Title", "Description", true)
        )
    }
}