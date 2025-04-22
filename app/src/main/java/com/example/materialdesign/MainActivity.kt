package com.example.materialdesign

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.materialdesign.ui.theme.MaterialDesignTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialDesignTheme {

                TopAppBarSearchPage()
                }
            }
        }
    }

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MaterialDesignTheme {
        TopAppBarSearchPage()
    }
}
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarPage() {
    val menuOpen= remember { mutableStateOf(false) }
Scaffold(
    topBar = {
        TopAppBar(
            title = {
                Column{
                    Text("Başlık")
                    Text("Alt Başlık", fontSize = 12.sp)
                }
                    },
            colors = TopAppBarDefaults.mediumTopAppBarColors(
                containerColor = colorResource(id = R.color.anaRenk),
                titleContentColor = colorResource(id = R.color.white)
            ),
            actions = {
                Text(
                    text = "Çıkış",
                    modifier = Modifier.clickable { Log.e("Topbar","Çıkış yapıldı") })
                IconButton(
                    onClick = {
                        Log.e("İnfo","İnfo seçildi")
                    }
                ) {
                    Icon(painter = painterResource(id =R.drawable.info_image),
                        contentDescription = "")
                }
                IconButton(
                    onClick = {
                        menuOpen.value=true
                    }
                ) {
                    Icon(painter = painterResource(id =R.drawable.more_image),
                        contentDescription = "")
                }
                DropdownMenu(
                    expanded = menuOpen.value,
                    onDismissRequest = {menuOpen.value=false}
                ) {
                    DropdownMenuItem(
                        text = {
                            Text(text = "Sil") },
                        onClick = {
                            Log.e("Sil","silme butınuna bastınız")
                        }
                    )
                    DropdownMenuItem(
                        text = {
                            Text(text = "Güncelle") },
                        onClick = {
                            Log.e("Güncelle","güncelle butonuna basıldı")
                        }
                    )

                }
            }
        )
    },
    content = {

    }
)
}
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarSearchPage() {
    val searchControl= remember { mutableStateOf(false) }
    val tfSearch= remember { mutableStateOf("") }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    if (searchControl.value){
                    TextField(value = tfSearch.value,
                        onValueChange = {
                            tfSearch.value=it

                        },
                        label = {
                            Text("Ara")
                        },
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            focusedTextColor = Color.Black,
                            unfocusedLabelColor = Color.Black,

                        )


                        )
                    }else
                    {
                        Text("Başlık")
                    }


                },

                actions = {
                    if (searchControl.value){
                        IconButton(
                            onClick = {
                                searchControl.value=false
                                tfSearch.value=""
                            }
                        ) {
                            Icon(painterResource(id = R.drawable.close_image),
                                contentDescription = "")
                        }
                    }else{
                        IconButton(
                            onClick = {
                                searchControl.value=true
                            }
                        ) {
                            Icon(painterResource(id = R.drawable.search_image),
                                contentDescription = "")
                        }
                    }

                }
            )
        },
        content = {

        }
    )
}