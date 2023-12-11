package com.profilaksis.profilaksis.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.profilaksis.profilaksis.R

@Composable
fun Greeting(
    name: String,
    url: String,
    greeting: String,
    icon: Boolean,
    modifier: Modifier
) {

    Row(
        modifier = modifier.height(100.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        CircleImage(
            url = url,
            modifier = modifier
                .weight(1f)
                .size(50.dp),
        )
        Column(
            modifier = modifier.weight(2f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(text = greeting)
            Text(text = name)
        }
        if (icon) {
            Icon(
                imageVector = Icons.Filled.Settings,
                contentDescription = stringResource(R.string.user_image),
                modifier = modifier.weight(1f),
            )
        }
    }
}

@Composable
fun CircleImage(url: String, modifier: Modifier) {
    Column(
        modifier = modifier
            .wrapContentSize()
            .size(100.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.End
    ) {
        AsyncImage(
            modifier = modifier
                .clip(CircleShape),
            model = ImageRequest.Builder(LocalContext.current)
                .data(url)
                .crossfade(true)
                .build(),
//            placeholder = painterResource(R.drawable.placeholder), // skeleton
            contentDescription = stringResource(R.string.user_image),
            contentScale = ContentScale.Crop,
        )
    }
}

@Preview(showBackground = true, device = "id:pixel_5", backgroundColor = 0xFFFFFFFF)
@Composable
fun GreetingPreview() {
    Column {
        Greeting(
            name = "Android",
            url = "https://images.unsplash.com/photo-1633332755192-727a05c4013d?q=80&w=2960&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            greeting = "Hello",
            icon = true,
            modifier = Modifier
        )
        Greeting(
            name = "Android",
            url = "https://images.unsplash.com/photo-1633332755192-727a05c4013d?q=80&w=2960&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            greeting = "Hello",
            icon = false,
            modifier = Modifier
        )
    }
}