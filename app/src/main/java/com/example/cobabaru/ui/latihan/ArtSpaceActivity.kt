package com.example.cobabaru.ui.latihan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cobabaru.R
import com.example.cobabaru.ui.theme.CobaBaruTheme

class ArtSpaceActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CobaBaruTheme {
                Surface(
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.background)
                        .fillMaxSize()
                ) {
                    ArtSpaceGallery()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceGallery() {
    var currentPosition by remember { mutableStateOf(1) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .weight(1F)
        ) {
            ArtImage(
                artImage = when (currentPosition) {
                    1 -> R.drawable.lemon_drink
                    2 -> R.drawable.lemon_squeeze
                    else -> R.drawable.lemon_tree
                }
            )
        }
        when (currentPosition) {
            1 -> {
                ArtInfo(
                    artTitle = R.string.title,
                    artCreator = R.string.bill_amount,
                    artYear = R.string.empty_glass
                )
            }
            2 -> {
                ArtInfo(
                    artTitle = R.string.android_dev,
                    artCreator = R.string.aqil,
                    artYear = R.string.all_task_completed
                )
            }
            else -> {
                ArtInfo(
                    artTitle = R.string.calculate_tip,
                    artCreator = R.string.body_1,
                    artYear = R.string.tip_amount
                )
            }
        }
        Spacer(modifier = Modifier.height(28.dp))
        ButtonNavigation(
            onPreviousClick = {
                currentPosition--
            }, onNextClick = {
                currentPosition++
            }
        )
    }
}

@Composable
fun ArtImage(@DrawableRes artImage: Int) {
    Box(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 64.dp)
            .fillMaxWidth()
            .fillMaxHeight()
            .shadow(
                elevation = 8.dp,
                shape = RoundedCornerShape(8.dp)
            )
            .background(Color.Gray)
    ) {
        Image(
            painter = painterResource(id = artImage),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
        )
    }
}

@Composable
fun ArtInfo(
    @StringRes artTitle: Int,
    @StringRes artCreator: Int,
    @StringRes artYear: Int
) {
    Column(
        modifier = Modifier
            .shadow(elevation = 2.dp, shape = RoundedCornerShape(4.dp))
            .background(Color.LightGray)
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Text(text = stringResource(id = artTitle), fontSize = 18.sp)
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(fontSize = 14.sp, fontWeight = FontWeight.Bold)) {
                    append(stringResource(id = artCreator))
                    append(" ")
                }
                withStyle(style = SpanStyle(fontSize = 14.sp)) {
                    append(stringResource(id = artYear))
                }
            }
        )
    }
}

@Composable
fun ButtonNavigation(onPreviousClick: () -> Unit, onNextClick: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Button(
            onClick = { onPreviousClick.invoke() },
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .weight(1F)
        ) {
            Text(text = "Previous")
        }
        Button(
            onClick = { onNextClick.invoke() },
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .weight(1F)
        ) {
            Text(text = "Next")
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceGallery()
}