package com.example.cobabaru.ui.latihan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cobabaru.R
import com.example.cobabaru.ui.theme.CobaBaruTheme
import com.example.cobabaru.ui.theme.Purple80
import com.example.cobabaru.ui.theme.colorQ1
import com.example.cobabaru.ui.theme.colorQ3
import com.example.cobabaru.ui.theme.colorQ4

class ComposeQuadrantActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CobaBaruTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AllQuadrant()
                }
            }
        }
    }
}

@Composable
private fun AllQuadrant() {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.weight(1F)
        ) {
            TextLayout(
                color = colorQ1,
                title = R.string.text_composable,
                body = R.string.text_composable_label,
                modifier = Modifier.weight(1F)
            )
            TextLayout(
                color = Purple80,
                title = R.string.image_composable,
                body = R.string.image_composable_label,
                modifier = Modifier.weight(1F)
            )
        }
        Row(
            modifier = Modifier.weight(1F)
        ) {
            TextLayout(
                color = colorQ3,
                title = R.string.row_composable,
                body = R.string.row_composable_label,
                modifier = Modifier.weight(1F)
            )
            TextLayout(
                color = colorQ4,
                title = R.string.column_composable,
                body = R.string.column_composable_label,
                modifier = Modifier.weight(1F)
            )
        }
    }
}

@Composable
private fun TextLayout(color: Color, title: Int, body: Int, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()
            .background(color)
            .padding(16.dp)
    ) {
        Text(
            text = stringResource(id = title),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = stringResource(id = body),
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showSystemUi = true)
@Composable
private fun QuadrantPreview() {
    CobaBaruTheme {
        AllQuadrant()
    }
}