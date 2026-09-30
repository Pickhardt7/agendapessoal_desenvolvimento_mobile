package com.example.agendapessoal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
                Scaffold(
                ) { innerPadding ->
                    AgendaPessoal(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    @Composable
    fun AgendaPessoal(modifier: Modifier) {
        var observacaoInput by remember { mutableStateOf("") }
        val observacoes = remember { mutableStateListOf<String>() }

        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp, bottom = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(48.dp)
                            .clip(CircleShape)
                            .background(Color(0xFF5B3FF0)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.DateRange,
                            contentDescription = "Agenda",
                            tint = Color.White
                        )
                    }

                    Spacer(modifier = Modifier.width(12.dp))

                    Column {
                        Text(
                            text = "Agenda",
                            fontSize = 32.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF1A1A1A)
                        )
                        Text(
                            text = "Segunda, 21 de setembro",
                            fontSize = 14.sp,
                            color = Color(0xFF666666)
                        )
                    }
                }

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 20.dp),
                    shape = RoundedCornerShape(14.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFEDEAFB))
                ) {
                    Column(
                        modifier = Modifier.padding(14.dp)
                    ) {
                        Text(
                            text = "Você tem 5 compromissos hoje",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF1A1A1A)
                        )
                        Text(
                            text = "O primeiro começa às 07:30",
                            fontSize = 13.sp,
                            color = Color(0xFF666666)
                        )
                    }
                }

                LazyColumn(
                    modifier = Modifier.padding(bottom = 72.dp)
                ) {
                    item {
                        Text(
                            text = "Compromissos de hoje",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF1A1A1A),
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                    }
                    item {
                        CardCompromisso(
                            "Caminhada matinal",
                            "07:30",
                            Color(0xFFFDF2E3),
                            Color(0xFF8D6E63)
                        )
                    }
                    item {
                        CardCompromisso(
                            "Reunião de alinhamento",
                            "09:00",
                            Color(0xFFE8E5FF),
                            Color(0xFF5B3FF0)
                        )
                    }
                    item {
                        CardCompromisso(
                            "Almoço com a equipe",
                            "12:00",
                            Color(0xFFFCE4E4),
                            Color(0xFFD64545)
                        )
                    }
                    item {
                        CardCompromisso(
                            "Apresentar projeto de Desenvolvimento Mobile",
                            "18:30",
                            Color(0xFFFDF2E3),
                            Color(0xFF8D6E63)
                        )
                    }
                    item {
                        Text(
                            text = "Amanhã",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF1A1A1A),
                            modifier = Modifier.padding(top = 12.dp, bottom = 8.dp)
                        )
                    }
                    item {
                        CardCompromisso(
                            "Consulta médica",
                            "10:00",
                            Color(0xFFE0F7F4),
                            Color(0xFF00897B)
                        )
                    }
                    item {
                        CardCompromisso(
                            "Entrega do projeto",
                            "17:00",
                            Color(0xFFE8E5FF),
                            Color(0xFF5B3FF0)
                        )
                    }

                    item {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 12.dp, bottom = 8.dp)
                        ) {
                            Text(
                                text = "Adicionar Observação",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF1A1A1A),
                                modifier = Modifier.padding(bottom = 8.dp)
                            )

                            OutlinedTextField(
                                value = observacaoInput,
                                onValueChange = { observacaoInput = it },
                                label = { Text("Digite sua observação") },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(bottom = 8.dp),
                                shape = RoundedCornerShape(12.dp)
                            )

                            Button(
                                onClick = {
                                    if (observacaoInput.isNotBlank()) {
                                        observacoes.add(observacaoInput.trim())
                                        observacaoInput = ""
                                    }
                                },
                                modifier = Modifier.fillMaxWidth(),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(
                                        0xFF5B3FF0
                                    )
                                ),
                                shape = RoundedCornerShape(12.dp)
                            ) {
                                Text("Salvar", color = Color.White, fontWeight = FontWeight.Bold)
                            }
                        }
                    }

                    items(observacoes.size) { index ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 8.dp),
                            shape = RoundedCornerShape(12.dp),
                            colors = CardDefaults.cardColors(containerColor = Color(0xFFE8E5FF))
                        ) {
                            Text(
                                text = observacoes[index],
                                fontSize = 14.sp,
                                color = Color(0xFF1A1A1A),
                                modifier = Modifier.padding(14.dp)
                            )
                        }
                    }
                }
            }

            Button(
                onClick = { },
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(20.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF5B3FF0)),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text("+", fontSize = 24.sp, color = Color.White)
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
}