package com.example.k2024_02_06_quiz_start

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.k2024_02_06_quiz_start.ui.theme.K2024_02_06_quiz_startTheme
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.k2024_02_06_quiz_start.model.AllQuestions
import com.example.k2024_02_06_quiz_start.controller.NextQuestion
import com.example.k2024_02_06_quiz_start.controller.Score
import com.example.k2024_02_06_quiz_start.model.UserIdentification
import com.example.k2024_02_06_quiz_start.ui.theme.Pink40

//val myStringList: List<String> = listOf("Alan", "Ada", "Charles", "Alonzo")
//var index = 0

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            K2024_02_06_quiz_startTheme {
                val user = UserIdentification()
                var userName by remember { mutableStateOf(("")) }
                var isNameEntered by remember { mutableStateOf(false)}

                Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("Welcome to the Quiz", fontSize = 30.sp)
                    if (!isNameEntered) {
                        TextField(
                            value = userName,
                            onValueChange = { newUN -> userName = newUN },
                            label = { Text("Enter your name!") },
                            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                            keyboardActions = KeyboardActions(onDone = { isNameEntered = true }))
                    } else {
                        user.setName((userName))
                        QuizComponent(user)
                    }

                }
            }
        }
    }
}

val cardShape = RoundedCornerShape(size = 32.dp)

@Composable
fun QuizComponent(uID : UserIdentification) {
    val allQuestions = AllQuestions()
    val nextQuestion = NextQuestion()

    Card(
        modifier = Modifier
            .width(500.dp)
            .height(200.dp)
            .border(
                width = 2.dp,
                color = Pink40,
                shape = cardShape
            )
            .clip(cardShape),
        colors = CardDefaults.cardColors()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            var questionNumber by remember { mutableIntStateOf(0) }

            var question by remember {
                mutableStateOf(allQuestions.getQuestion(questionNumber).questionText)
            }
            var answer by remember {
                mutableStateOf(allQuestions.getQuestion(questionNumber).answer)
            }

            Text(question, fontSize = TextUnit(20F, TextUnitType.Sp))
            Row() {
                Button(onClick = {
                    if (answer) {
                        uID.userScore.incrementScore()
                    }
                }) {
                    Text("True")
                }
                Button(onClick = {
                    if (!answer) {
                        uID.userScore.incrementScore()
                    }
                }) {
                    Text("False")
                }

                Button(onClick = {
                    questionNumber = nextQuestion.getNextIncQuestionNumber()
                    question = allQuestions.getQuestion(questionNumber).questionText
                    answer = allQuestions.getQuestion(questionNumber).answer
                }) {
                    Text("Next Question")
                }
            }
            Text("Score: ${uID.userScore.getScore()}")
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    K2024_02_06_quiz_startTheme {
        Greeting("Android")
    }
}