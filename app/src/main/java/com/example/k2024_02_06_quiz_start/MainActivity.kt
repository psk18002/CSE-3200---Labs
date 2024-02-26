package com.example.k2024_02_06_quiz_start

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.k2024_02_06_quiz_start.model.AllQuestions
import com.example.k2024_02_06_quiz_start.controller.NextQuestion
import com.example.k2024_02_06_quiz_start.controller.ScoreController
import com.example.k2024_02_06_quiz_start.model.Score
import com.example.k2024_02_06_quiz_start.model.UserIdentification
import com.example.k2024_02_06_quiz_start.ui.theme.Pink40
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

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

                Column(modifier = Modifier
                    .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("Welcome to the Quiz", fontSize = 30.sp, textAlign = TextAlign.Center)
                }

                Column(modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                    ) {

                    if (!isNameEntered) {
                        TextField(
                            value = userName,
                            onValueChange = { newUN -> userName = newUN },
                            label = { Text("Enter your name!") },
                            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                            keyboardActions = KeyboardActions(onDone = { isNameEntered = true }),
                            maxLines = 1
                            )
                    } else {
                        user.setName((userName))
                        Spacer(modifier = Modifier.size(20.dp))
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
    val scoreController = ScoreController(uID)

    var questionNumber by remember { mutableIntStateOf(0) }
    var question by remember { mutableStateOf(allQuestions.getQuestion(questionNumber).questionText) }
    var answer by remember { mutableStateOf(allQuestions.getQuestion(questionNumber).answer) }
    var userTextAnswer by remember { mutableStateOf("") }
    var isAnswered by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 2.dp,
                color = Pink40,
                shape = cardShape
            )
            .clip(cardShape),
        colors = CardDefaults.cardColors()
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
            ) {
            Text(question, fontSize = TextUnit(30F, TextUnitType.Sp), textAlign = TextAlign.Center, lineHeight = 45.sp)
        }
    }

    Spacer(modifier = Modifier.size(60.dp))
    Row(
        verticalAlignment = Alignment.Bottom,
    ) {
            if (allQuestions.getQuestion(questionNumber).textRequirement) {
                if (!isAnswered) {
                    TextField(
                        value = userTextAnswer,
                        onValueChange = { newUTA -> userTextAnswer = newUTA },
                        label = { Text("Enter your answer!") },
                        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                        keyboardActions = KeyboardActions(onDone = {

                            if (answer == userTextAnswer) {
                                scoreController.difficultyIncrement(allQuestions.getQuestion(questionNumber).difficulty)
                                userTextAnswer = ""
                            }
                            isAnswered = true;

                        }),
                        maxLines = 1
                    )
                }

        } else {

            if (!isAnswered) {
                Button(onClick = {
                    if (answer as Boolean) {
                        scoreController.difficultyIncrement(allQuestions.getQuestion(questionNumber).difficulty)
                    }
                    isAnswered = true

                },
                    modifier = Modifier.size(90.dp, 70.dp)
                ) {
                    Text("True")
                }
                Button(onClick = {
                    if (!(answer as Boolean)) {
                        scoreController.difficultyIncrement(allQuestions.getQuestion(questionNumber).difficulty)
                    }
                    isAnswered = true

                },
                    modifier = Modifier.size(90.dp, 70.dp)
                ) {
                    Text("False")
                }
            }
        }
    }


    Row(
        verticalAlignment = Alignment.Bottom,
    ) {

        Button(onClick = {
            questionNumber = nextQuestion.getNextIncQuestionNumber()
            question = allQuestions.getQuestion(questionNumber).questionText
            answer = allQuestions.getQuestion(questionNumber).answer
            isAnswered = false
        }) {
            Text("Next Question")
        }
    }
    Row(
        verticalAlignment = Alignment.Bottom
    ) {
        Text("Score: ${scoreController.getScore()}")
        Spacer(modifier = Modifier.size(20.dp))
        Text("User: ${uID.getName()}")
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