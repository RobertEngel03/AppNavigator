package com.example.twopageapp



import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            MaterialTheme {
                val navController = rememberNavController()
                AppNavHost(navController = navController)
            }
        }
    }
}


object Routes {
    const val HOME = "home"
    const val CONTACT = "contact"
}

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Routes.HOME
    ) {
        composable(Routes.HOME) {
            HomeScreen(
                onContactClick = { navController.navigate(Routes.CONTACT) }
            )
        }
        composable(Routes.CONTACT) {
            ContactScreen(
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(onContactClick: () -> Unit) {
    val items = listOf(
        "Item 1: Welcome to the app",
        "Item 2: This is a scrollable list",
        "Item 3: You can add whatever content you want",
        "Item 4: Maybe class notes or descriptions",
        "Item 5: More content...",
        "Item 6: Even more content...",
        "Item 7: Enough items to scroll",
        "Item 8: Keep going",
        "Item 9: Almost there",
        "Item 10: Last example item"
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Home Page") }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            Image(painter = painterResource(id = R.drawable.contact_photo),
                contentDescription = "Welcome Image",
                )
            // Scrollable content
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                items(items) { itemText ->
                    Text(
                        text = itemText,
                        fontSize = 16.sp,
                        modifier = Modifier
                            .padding(vertical = 8.dp)
                    )
                }
            }

            // Button to navigate to contact page
            Button(
                onClick = onContactClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text("Go to Contact Page")
            }
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactScreen(onBackClick: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Contact") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {


            Image(
                painter = painterResource(id = R.drawable.item1),
                contentDescription = "Contact Photo",
                modifier = Modifier
                    .size(150.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Robert Engel (SNAKE)",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Email: engelrobert0730@gmail.com",
                fontSize = 16.sp,
                textAlign = TextAlign.Center
            )

            Text(
                text = "Phone: (123) 456-7890",
                fontSize = 16.sp,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Thank you for using my app!",
                fontSize = 14.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}
