package com.mabn.calendar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mabn.calendarlibrary.ExpandableCalendar
import com.mabn.calendar.ui.theme.CalendarTheme
import com.mabn.calendarlibrary.core.calendarDefaultTheme
import java.time.LocalDate

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalendarTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Calendar()
                }
            }
        }
    }
}

@Composable
fun Calendar() {
    val customFontFamily = FontFamily(
        Font(R.font.poppins_semibold),
    )

    val customFontFamilyOutfit = FontFamily(
        Font(R.font.outfit_light),
    )

    val currentDate = remember { mutableStateOf(LocalDate.now()) }
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        Row(
            modifier = Modifier.padding(top = 15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(id = R.string.date_childbirth),
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = customFontFamily,
                color = Color(46, 44, 44),
            )
        }

        Row(
            modifier = Modifier.padding(top = 5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 30.dp),
                text = stringResource(id = R.string.date_childbirth_description),
                fontSize = 17.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = customFontFamilyOutfit,
                color = Color(46, 44, 44),
            )
        }

    }

    Column(
        Modifier
            .verticalScroll(scrollState)
            .padding(top = 150.dp),
    ) {
        ExpandableCalendar(
            theme = calendarDefaultTheme.copy(
                dayShape = CircleShape,
                backgroundColor = Color(243, 243, 243),
                selectedDayBackgroundColor = Color(182, 182, 246),
                dayValueTextColor = Color.Black,
                selectedDayValueTextColor = Color.White,
                headerTextColor = Color.Black,
                weekDaysTextColor = Color.Black,
            ), onDayClick = {
                currentDate.value = it
            })
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
            Text("Selected date: ${currentDate.value}", fontFamily = customFontFamily)
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {},
                modifier = Modifier
                    .width(327.dp)
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(Color(182, 182, 246))
            ) {
                Text(
                    text = stringResource(id = R.string.button_f), color = Color.White
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CalendarTheme {
        Calendar()
    }
}