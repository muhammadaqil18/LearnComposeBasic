package com.example.cobabaru.ui.latihan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cobabaru.R
import com.example.cobabaru.ui.theme.CobaBaruTheme

class BusinessCardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CobaBaruTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
private fun BusinessCard() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround,
        modifier = Modifier.fillMaxSize()
    ) {
        PersonalInfo()
        PersonalContact()
    }
}

@Composable
private fun PersonalInfo() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_aqil),
            contentDescription = null,
            modifier = Modifier
                .width(250.dp)
                .height(250.dp)
        )
        Text(
            text = stringResource(id = R.string.aqil),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 8.dp)
        )
        Spacer(modifier = Modifier.padding(2.dp))
        Text(
            text = stringResource(id = R.string.android_dev),
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
private fun PersonalContact() {
    Column(
        modifier = Modifier
            .shadow(elevation = 4.dp)
            .border(
                width = 1.dp,
                color = Color(0xFF378DF4),
                shape = RoundedCornerShape(size = 12.dp)
            )
            .background(color = Color(0xFFF1F8FD), shape = RoundedCornerShape(size = 12.dp))
            .padding(vertical = 12.dp, horizontal = 28.dp)
    ) {
        Row {
            Image(painter = painterResource(id = R.drawable.ic_phone), contentDescription = null)
            Text(
                text = stringResource(id = R.string.phone),
                modifier = Modifier.padding(start = 8.dp)
            )
        }
        Spacer(modifier = Modifier.padding(2.dp))
        Row {
            Image(painter = painterResource(id = R.drawable.ic_link), contentDescription = null)
            Text(
                text = stringResource(id = R.string.link),
                modifier = Modifier.padding(start = 8.dp)
            )
        }
        Spacer(modifier = Modifier.padding(2.dp))
        Row {
            Image(painter = painterResource(id = R.drawable.ic_email), contentDescription = null)
            Text(
                text = stringResource(id = R.string.email),
                modifier = Modifier.padding(start = 8.dp)
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun BusinessCardPreview() {
    CobaBaruTheme {
        BusinessCard()
    }
}