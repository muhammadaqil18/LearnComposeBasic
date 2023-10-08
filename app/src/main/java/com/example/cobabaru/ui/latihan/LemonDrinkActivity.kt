package com.example.cobabaru.ui.latihan

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cobabaru.R
import com.example.cobabaru.ui.theme.CobaBaruTheme

class LemonDrinkActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CobaBaruTheme {
                LemonadeApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun LemonadeApp() {
    var currentStep by remember { mutableStateOf(1) }
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Lemonade App",
                        fontWeight = FontWeight.Bold
                    )
                }, colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) { innerPadding ->
        Surface(
            color = MaterialTheme.colorScheme.background,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            when (currentStep) {
                1 -> LemonadeTextImage(
                    currentStep = currentStep,
                    image = R.drawable.lemon_tree,
                    instruction = R.string.lemon_tree_value
                ) {
                    currentStep = 2
                }

                2 -> LemonadeTextImage(
                    currentStep = currentStep,
                    image = R.drawable.lemon_squeeze,
                    instruction = R.string.lemon_value
                ) {
                    currentStep = 3
                }

                3 -> LemonadeTextImage(
                    currentStep = currentStep,
                    image = R.drawable.lemon_drink,
                    instruction = R.string.glass_of_lemonade
                ) {
                    currentStep = 4
                }

                4 -> LemonadeTextImage(
                    currentStep = currentStep,
                    image = R.drawable.lemon_restart,
                    instruction = R.string.empty_glass_value
                ) {
                    currentStep = 1
                }
            }
        }
    }
}

@Composable
private fun LemonadeTextImage(currentStep: Int, image: Int, instruction: Int, onClick: () -> Unit) {
    val numberOfClicked by remember { mutableStateOf((2..4).random()) }
    var clicked by remember { mutableStateOf(1) }
    if (currentStep == 2) Toast.makeText(
        LocalContext.current,
        "Please tap $numberOfClicked times",
        Toast.LENGTH_SHORT
    ).show()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    ) {
        Button(
            onClick = {
                if (currentStep == 2) {
                    if (clicked == numberOfClicked) {
                        onClick.invoke()
                    }
                    clicked++
                } else {
                    onClick.invoke()
                }
            },
            shape = RoundedCornerShape(40.dp),
            colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.tertiaryContainer)
        ) {
            Image(painter = painterResource(id = image), contentDescription = null)
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = stringResource(id = instruction), fontSize = 18.sp)
    }
}

@Preview(showSystemUi = true)
@Composable
private fun LemonadePreview() {
    CobaBaruTheme {
        LemonadeApp()
    }
}