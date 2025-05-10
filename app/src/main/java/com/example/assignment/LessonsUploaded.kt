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
fun CoursesUploaded_Preview() {
    CoursesUploaded("Figma Master Class for Beginners")
}


@Composable
fun CoursesUploaded(title: String, modifier: Modifier = Modifier) {
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        ImageUploaded(R.drawable.figma)
        Text(title,
            modifier = Modifier.padding(start = 24.dp,bottom = 16.dp),
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold)
        CoursePartHolder()
    }
}


@Composable
fun ImageUploaded(image: Int, modifier: Modifier = Modifier) {
    Image(painter = painterResource(image),
        contentDescription = "Figma",
        modifier = Modifier
            .padding(24.dp)
            .clip(shape = RoundedCornerShape(16.dp)))
}

@Composable
fun CoursePartHolder(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.padding(top = 16.dp)) {
        CourseComponent("Videos", R.drawable.video_icon) { VideoHolder() }
        CourseComponent("Notes", R.drawable.notes) { VideoHolder() }
        CourseComponent("Assignments", R.drawable.assignment) { VideoHolder() }
    }
}


@Composable
fun CourseSubcomponent(text: String, icon: Int, modifier: Modifier = Modifier) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(painter = painterResource(icon),
            contentDescription = "icon",
            modifier = Modifier
                .size(32.dp)
                .padding(end = 8.dp))
        Text(text,
            style = MaterialTheme.typography.titleMedium,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold)
    }

    HorizontalDivider(modifier = Modifier.padding(8.dp), 0.5.dp, Color(0xFF9A4DFF))
}

@Composable
fun VideoHolder(modifier: Modifier = Modifier) {
    Column() {
        CourseSubcomponent("1.1 Part 1.mp4", R.drawable.video_icon)
        CourseSubcomponent("1.1 Part 1.mp4", R.drawable.video_icon)
        CourseSubcomponent("1.1 Part 1.mp4", R.drawable.video_icon)
        CourseSubcomponent("1.1 Part 1.mp4", R.drawable.video_icon)
    }
}

@Composable
fun NoteHolder(modifier: Modifier = Modifier) {
    Column() {
        CourseSubcomponent("1.1 Part 1.mp4", R.drawable.notes)
        CourseSubcomponent("1.1 Part 1.mp4", R.drawable.notes)
        CourseSubcomponent("1.1 Part 1.mp4", R.drawable.notes)
        CourseSubcomponent("1.1 Part 1.mp4", R.drawable.notes)
    }
}

@Composable
fun AssignmentHolder(modifier: Modifier = Modifier) {
    Column() {
        CourseSubcomponent("1.1 Part 1.mp4", R.drawable.assignment)
        CourseSubcomponent("1.1 Part 1.mp4", R.drawable.assignment)
        CourseSubcomponent("1.1 Part 1.mp4", R.drawable.assignment)
        CourseSubcomponent("1.1 Part 1.mp4", R.drawable.assignment)
    }
}



@Composable
fun CourseComponent(
    text: String,
    icon: Int,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {

    var isExpanded by remember { mutableStateOf(false) }

    Column(modifier = Modifier
        .padding(horizontal = 24.dp, vertical = 16.dp)
        .then(
            if (isExpanded) Modifier
                .border(1.dp, Color(0xFF9A4DFF), RoundedCornerShape(8.dp))
            else Modifier
        )
    ) {
        Row(horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
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
                    contentDescription = "icon",
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








