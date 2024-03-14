package ua.edu.lntu.ipz_cw_4

import androidx.compose.ui.graphics.Color

class Task(val name: String, val description: String, var isActive: Boolean){
    fun getColor() = if (isActive) Color.Red else Color.Green
}