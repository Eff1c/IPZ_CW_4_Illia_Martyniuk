package ua.edu.lntu.ipz_cw_4.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
        modifier = Modifier
            .fillMaxSize()
            .background(color = task.getColor()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(task.name, style = TextStyle(fontSize = 62.sp))
        Text(task.description, style = TextStyle(fontSize = 24.sp))
        Switch(checked = task.isActive, onCheckedChange ={navController.popBackStack()})
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

@Preview
@Composable
fun TaskInfoFalsePreviewScreen() {
    IPZ_CW_4_Illia_MartyniukTheme {
        TaskInfoScreen(
            navController = NavController(LocalContext.current),
            task = Task("Title", "Description", false)
        )
    }
}