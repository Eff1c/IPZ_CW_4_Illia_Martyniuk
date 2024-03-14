package ua.edu.lntu.ipz_cw_4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import ua.edu.lntu.ipz_cw_4.ui.theme.IPZ_CW_4_Illia_MartyniukTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IPZ_CW_4_Illia_MartyniukTheme { NavigationFun() }
        }
    }
}