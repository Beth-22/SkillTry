package com.example.assignment

import android.graphics.drawable.Icon
import android.media.Image
import android.media.browse.MediaBrowser
import android.net.Uri
import android.util.Log
import android.widget.VideoView
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.exoplayer.ExoPlayer
import com.example.assignment.ui.theme.Primary


@Preview(showBackground = true, widthDp = 400)
@Composable
fun LessonsUploaded_Preview() {
    LessonsUploaded()
}


@Composable
fun LessonsUploaded(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        VideoUploaded()
        Text("Figma Master class for beginners",
            modifier = Modifier.padding(start = 24.dp, bottom = 8.dp),
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold)
        Text("28 lessons",
            modifier = Modifier.padding(start = 24.dp, bottom = 8.dp),
            style = MaterialTheme.typography.titleMedium)
        Text("Lessons",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
                .wrapContentWidth()
                .drawWithContent {
                    drawContent()
                    drawLine(
                        color = Primary,
                        start = Offset(0f, size.height + 4.dp.toPx()), // 4dp below text
                        end = Offset(size.width, size.height + 4.dp.toPx()),
                        strokeWidth = 1.dp.toPx()
                    )
                },
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleMedium,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Primary,
            )
        Lessons()
        NewLessonBtn()
    }
}
@Composable
fun VideoUploaded(modifier: Modifier = Modifier) {
    Image(painter = painterResource(R.drawable.figma),
        contentDescription = "Figma",
        modifier = Modifier
            .padding(24.dp)
            .clip(shape = RoundedCornerShape(16.dp)))
}

@Composable
fun Lessons(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.padding(top = 16.dp)) {
        Text("Lesson 1: Introduction to Figma",
            modifier = Modifier.padding(start = 24.dp, bottom = 16.dp),
            style = MaterialTheme.typography.titleMedium,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )

        LessonComponent("Videos", R.drawable.video_icon) { VideoHolder() }
        LessonComponent("Notes", R.drawable.notes) { VideoHolder() }
        LessonComponent("Assignments", R.drawable.assignment) { VideoHolder() }




    }
}

//@Composable
//fun LessonComponent(modifier: Modifier = Modifier) {
//    Row(horizontalArrangement = Arrangement.SpaceBetween,
//        verticalAlignment = Alignment.CenterVertically,
//        modifier = Modifier
//        .padding(horizontal = 24.dp, vertical = 8.dp)
//        .fillMaxWidth()
//        .border(1.dp, Color.Black, RoundedCornerShape(8.dp))
//        .padding(horizontal = 16.dp, vertical = 8.dp)) {
//        Row(verticalAlignment = Alignment.CenterVertically) {
//            Image(painter = painterResource(R.drawable.video_icon),
//                contentDescription = "video icon",
//                modifier = Modifier
//                    .size(32.dp)
//                    .padding(end = 8.dp))
//            Text("Videos",
//                style = MaterialTheme.typography.titleMedium,
//                fontSize = 18.sp,
//                fontWeight = FontWeight.Bold)
//        }
//        Image(imageVector = Icons.Outlined.KeyboardArrowDown,
//            contentDescription = "Keyboard ArrowDown")
//    }
//}


//////////////////////////////////////////////////////////////////////////////////////

@Composable
fun Videos (modifier: Modifier = Modifier) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(painter = painterResource(R.drawable.video_icon),
            contentDescription = "video icon",
            modifier = Modifier
                .size(32.dp)
                .padding(end = 8.dp))
        Text("1.1 Part 1.mp4",
            style = MaterialTheme.typography.titleMedium,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold)
    }
}

@Composable
fun VideoHolder(modifier: Modifier = Modifier) {
    Column() {
        Videos()
        HorizontalDivider(modifier = Modifier.padding(8.dp), 0.5.dp, Color(0xFF9A4DFF))
        Videos()
        HorizontalDivider(modifier = Modifier.padding(8.dp), 0.5.dp, Color(0xFF9A4DFF))
        Videos()
        HorizontalDivider(modifier = Modifier.padding(8.dp), 0.5.dp, Color(0xFF9A4DFF))
        Videos()
    }
}

@Composable
fun LessonComponent(
    text: String,
    icon: Int,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {

    var isExpanded by remember { mutableStateOf(false) }

    Column(modifier = Modifier
        .padding(horizontal = 24.dp, vertical = 8.dp)
        .then(
            if (isExpanded) Modifier
                .border(1.dp, Color(0xFF9A4DFF), RoundedCornerShape(8.dp))
            else Modifier
        )
    ) {
        Row(horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
//                .padding(horizontal = 24.dp, vertical = 8.dp)
                .fillMaxWidth()
                .border(
                    if (!isExpanded) 1.dp else 0.5.dp,
                    color = if (!isExpanded) Color.Black else Color(0xFF9A4DFF),
                    shape = if (!isExpanded) RoundedCornerShape(8.dp) else RoundedCornerShape(
                        topStart = 8.dp,
                        topEnd = 8.dp
                    )
                )
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null
                ) { isExpanded = !isExpanded }) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(painter = painterResource(icon),
                    contentDescription = "video icon",
                    modifier = Modifier
                        .size(32.dp)
                        .padding(end = 8.dp))
                Text(text,
                    style = MaterialTheme.typography.titleMedium,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold)
            }
            Image(if (isExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                contentDescription = if (isExpanded) "Collapse" else "Expand")
        }

        AnimatedVisibility(
            visible = isExpanded,
            enter = fadeIn() + expandVertically(),
            exit = fadeOut() + shrinkVertically()
        ) {
            Box(modifier = Modifier.padding(start = 24.dp, top = 16.dp, end = 16.dp, bottom = 16.dp)) {
                content()
            }
        }

    }
}

// Add New Lesson Button

@Composable
fun NewLessonBtn (modifier: Modifier = Modifier) {
    Column(modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally) {
            Button(
                onClick = {},
                modifier = Modifier
                    .padding(start = 8.dp, top = 16.dp, bottom = 16.dp)
                    .wrapContentWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Primary,
                    contentColor = Color.White
                )
            ) {
                Text("Add New Lesson",
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold)
            }
    }
}



