package com.llprdctn.homeautomation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.llprdctn.homeautomation.ui.theme.HomeAutomationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeAutomationTheme {
                // A surface container using the 'background' color from the theme
                TestButton()
            }
        }
    }
}




@Composable
fun TestButton() {
    /*val mutableState by remember {mutableStateOf(false)}
    Button(onClick = { *//**//* }) {
        
    }*/
    Text(text = "Hello")
}