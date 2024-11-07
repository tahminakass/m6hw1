package com.example.m6hw1.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.m6hw1.R

@Composable
fun ProfileScreen() {
    UserProfileScreen(
        userName = "Tahmina",
        isOnline = true,
        bio = "Master of sports in Taekwondo \n, sometimes like cooking \n, and I like being a lazy person",
        interests = listOf(
            Pair(R.drawable.poomsae, "Sports"),
            Pair(R.drawable.piano, "Music"),
        ),
        friends = listOf(R.drawable.img, R.drawable.piano, R.drawable.poomsae, R.drawable.img_1)
    )
}

@Composable
fun UserProfileScreen(
    userName: String,
    isOnline: Boolean,
    bio: String,
    interests: List<Pair<Int, String>>,
    friends: List<Int>
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.img),
                contentDescription = "User Avatar",
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = userName,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(8.dp)
                            .clip(CircleShape)
                            .background(if (isOnline) Color.Blue else Color.Gray)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = if (isOnline) "Online" else "Offline",
                        fontSize = 14.sp,
                        color = Color.Blue
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Обо мне", fontSize = 32.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = bio, fontSize = 16.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = {},
                modifier = Modifier.align(Alignment.End)
            ) {
                Text(text = "Edit")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Интересы", fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(8.dp))
            interests.forEach { (icon, interest) ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = icon),
                        contentDescription = interest,
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = interest, fontSize = 16.sp)
                }
                Spacer(modifier = Modifier.height(8.dp))
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Друзья", fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
        Spacer(modifier = Modifier.height(22.dp))
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            items(friends) { friendAvatar ->
                Image(
                    painter = painterResource(id = friendAvatar),
                    contentDescription = "Friend Avatar",
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                )
            }
        }
    }
}

