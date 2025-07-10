package com.example.juansuarez_p2_ap2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.juansuarez_p2_ap2.presentation.navigation.ViajeNavHost
import com.example.juansuarez_p2_ap2.ui.theme.JuanSuarez_P2_Ap2Theme
import dagger.hilt.android.AndroidEntryPoint

class MainActivity : ComponentActivity() {

    @AndroidEntryPoint
    class MainActivity : ComponentActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            enableEdgeToEdge()
            setContent {
                ViajeTheme {
                    val navHost = rememberNavController()
                    ViajeNavHost (navHost)
                }
            }
        }
    }
