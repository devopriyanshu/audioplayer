package com.example.audioplayer

import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainContent()
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainContent() {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Audio Player", color = Color.White) }, backgroundColor = Color(0xff0f9d58)) },
        content = { MyContent() }
    )
}

@Composable
fun MyContent(){

    // Fetching the local context
    val mContext = LocalContext.current

    // Declaring and Initializing
    // the MediaPlayer to play "audio.mp3"
    val mMediaPlayer = MediaPlayer.create(mContext, R.raw.audio)

    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {

        Row {
            // IconButton for Start Action
            IconButton(onClick = { mMediaPlayer.start() }) {
                Icon(painter = painterResource(id = R.drawable.ic_play), contentDescription = "", Modifier.size(100.dp))
            }

            // IconButton for Pause Action
            IconButton(onClick = { mMediaPlayer.pause() }) {
                Icon(painter = painterResource(id = R.drawable.ic_pause), contentDescription = "", Modifier.size(100.dp))
            }
        }
    }
}

// For displaying preview in
// the Android Studio IDE emulator
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainContent()
}