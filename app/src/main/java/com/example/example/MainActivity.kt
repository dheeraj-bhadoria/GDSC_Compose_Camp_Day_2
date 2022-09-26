package com.example.example

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.compiler.plugins.kotlin.ComposeFqNames.remember
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.example.ui.theme.ExampleTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MyLoginScreen()
                }
            }
        }
    }

    fun checkLogin(username: String, password: String){
        // Call API get response  from API
        // do whatever you want on response
        if(username.equals("GDSC") && password.equals("SDFC")){
            Toast.makeText(this, "Correct credentials", Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(this, "In Correct credentials", Toast.LENGTH_LONG).show()
        }
    }

    @Composable
    fun MyLoginScreen() {

        // Automatically get the values from the views
        var username = remember { mutableStateOf("")}
        var password = remember { mutableStateOf("")}


        // Box is like layout may
        Box (
            modifier = Modifier.background(Color.Yellow)
        ){
            Column(
                modifier = Modifier.fillMaxSize().padding(20.dp),
                verticalArrangement = Arrangement.Center
            ) {

                Text(text = "Enter your",)
                Text(text = "Crentials", color = Color.Blue)
                Spacer(modifier = Modifier.height(20.dp))
                OutlinedTextField(
                    value = username.value,
                    onValueChange = {
                        username.value = it
                    },
                    label = {  // Floating label top of input box
                        Text(text = "User name")
                    },
                    placeholder = {   // hint
                        Text(text = "Enter user name")
                    },
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    value = password.value,
                    onValueChange = {
                        password.value = it
                    },
                    label = {
                        Text(text = "Password")
                    },
                    placeholder = {
                        Text(text = "Enter Password")
                    },
                    modifier = Modifier.fillMaxWidth()

                )

                OutlinedButton(
                    onClick = {  // onclick listner
                        checkLogin(username.value, password.value )
                    },
                    modifier = Modifier.fillMaxWidth()) {
                    Text(text = "Login")
                }
            }
        }


    }


    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        ExampleTheme {
            MyLoginScreen()
        }
    }
}




