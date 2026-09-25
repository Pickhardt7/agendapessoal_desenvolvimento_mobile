package com.example.agendapessoal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.agendapessoal.ui.theme.AgendaPessoalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AgendaPessoalTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp)
                ) {
                    Text(
                        text = "Agenda",
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF1A1A1A)
                    )
                    Text(
                        text = "Segunda, 21 de setembro",
                        fontSize = 14.sp,
                        color = Color(0xFF666666),
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp)
                    ) {
                        Text("D  S  T  Q  Q  S  S", color = Color(0xFF888888), fontSize = 12.sp)
                    }

                    Text(
                        text = "21",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF5B3FF0),
                        modifier = Modifier.padding(bottom = 16.dp)
                    )

                    Text(
                        text = "Compromissos de hoje",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF1A1A1A),
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    LazyColumn {
                        item { CardCompromisso("Reunião de alinhamento", "09:00", Color(0xFFE8E5FF), Color(0xFF5B3FF0)) }
                        item { CardCompromisso("Aula de inglês", "14:00", Color(0xFFE0F7F4), Color(0xFF00897B)) }
                        item { CardCompromisso("Treino na academia", "18:30", Color(0xFFFDF2E3), Color(0xFF8D6E63)) }
                    }
                    Button(
                        onClick = { },
                        modifier = Modifier
                            .padding(top = 16.dp)
                            .align(Alignment.End),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF5B3FF0)),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Text("+", fontSize = 24.sp, color = Color.White)
                    }
                }
            }
        }
    }
}

@Composable
fun CardCompromisso(titulo: String, horario: String, corFundo: Color, corBarra: Color) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = corFundo)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Card(
                modifier = Modifier
                    .padding(end = 12.dp)
                    .fillMaxWidth(0.02f),
                colors = CardDefaults.cardColors(containerColor = corBarra)
            ) {}

            Column {
                Text(
                    text = titulo,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    color = Color(0xFF1A1A1A)
                )
                Text(
                    text = horario,
                    fontSize = 13.sp,
                    color = Color(0xFF666666)
                )
            }
        }
    }
}