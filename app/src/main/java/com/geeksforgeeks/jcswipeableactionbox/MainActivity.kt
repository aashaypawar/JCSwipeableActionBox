package com.geeksforgeeks.jcswipeableactionbox

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import me.saket.swipe.SwipeAction
import me.saket.swipe.SwipeableActionsBox

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            // Creating a Simple Scaffold Layout for the application
            Scaffold(

                // Creating a Top Bar
                topBar = { TopAppBar(title = { Text("GFG | Swipeable Action Box", color = Color.White) }, backgroundColor = Color(0xff0f9d58)) },

                // Creating Content
                content = {

                    // Creating a Column Layout
                    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {

                        // Fetching local context
                        val mLocalContext = LocalContext.current

                        // Creating a Swipe Action for Calling; setting icon, background and what happens when swiped
                        val mCall = SwipeAction(
                            icon = painterResource(R.drawable.ic_call),
                            background = Color.Green,
                            isUndo = true,
                            onSwipe = { Toast.makeText(mLocalContext, "Calling",Toast.LENGTH_SHORT).show()}
                        )

                        // Creating a Swipe Action for Sending a message; setting icon, background and what happens when swiped
                        val mMessage = SwipeAction(
                            icon = painterResource(R.drawable.ic_message),
                            background = Color.Yellow,
                            isUndo = true,
                            onSwipe = { Toast.makeText(mLocalContext, "Sending Message",Toast.LENGTH_SHORT).show()}
                        )

                        // Creating a Swipe Action Box with start action as calling and end action as sending message
                        SwipeableActionsBox(startActions = listOf(mCall), endActions = listOf(mMessage)) {

                            // Creating a Button inside Swipe Action Box
                            Button(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(backgroundColor = Color(0XFF0F9D58))) {
                                Text(text = "Swipe Left or Right", fontSize = 25.sp, color = Color.White)
                            }
                        }

                    }
                }
            )
        }
    }
}

/*
Res:
https://github.com/saket/swipe
implementation "me.saket.swipe:swipe:1.0.0"
 */
