package com.gurukul.android.ui

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext
import com.gurukul.android.R
import com.gurukul.android.data.ShishyaRepository
import com.gurukul.core.math.BreakthroughMath
import com.gurukul.core.model.Gift
import com.gurukul.core.model.Path
import com.gurukul.core.model.Samskara
import com.gurukul.core.model.Shishya
import com.gurukul.core.state.BreakthroughResult
import com.gurukul.core.state.SadhanaState
import com.gurukul.core.state.SadhanaStateMachine
import com.gurukul.core.state.YantraState

@Composable
fun GurukulScreen() {
    val context = LocalContext.current
    val repository = remember(context) { ShishyaRepository(context) }

    var shishya by mutableStateOf(
        repository.load() ?: Shishya(
            id = "shishya-1",
            name = "Arjun",
            samskara = Samskara.SATTVA,
            gift = Gift.YOGA,
            path = Path.YOGA,
            chakraLevel = 1,
            sattva = 50,
            karma = 0,
            prana = 0,
            inMoksha = false
        )
    )
    var yantraState by mutableStateOf(YantraState())
    var sadhanaState by mutableStateOf(SadhanaState.RECRUIT)
    var streakDays by mutableStateOf(0)

    // Auto-save on shishya changes
    LaunchedEffect(shishya) {
        repository.save(shishya)
    }

    val pranaProgress = remember { shishya.prana.toFloat() / 100f }
    val sattvaProgress = remember { shishya.sattva.toFloat() / 100f }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = androidx.compose.foundation.layout.Arrangement.spacedBy(8.dp)
    ) {
        // Header
        Text(
            text = "Gurukul",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Text(
            text = "${shishya.name} · ${shishya.path}",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        // Status cards
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = androidx.compose.foundation.layout.Arrangement.spacedBy(8.dp)
        ) {
            StatCard("Prana", "${shishya.prana}%", shishya.prana.toFloat() / 100f)
            StatCard("Sattva", "${shishya.sattva}%", shishya.sattva.toFloat() / 100f)
            StatCard("Karma", "${shishya.karma}", 0f) // Karma is -100 to 100
            StatCard("Streak", "${streakDays}d", 0f)
        }

        // Main content area
        when (sadhanaState) {
            SadhanaState.RECRUIT -> {
                Text("Tap to recruit your shishya.")
                Button(onClick = {
                    shishya = SadhanaStateMachine.recruit(
                        id = "shishya-1",
                        name = "Arjun",
                        samskara = Samskara.SATTVA,
                        gift = Gift.YOGA,
                        path = Path.YOGA
                    )
                    sadhanaState = SadhanaState.TRAIN
                }) {
                    Text("Recruit Arjun")
                }
            }
            SadhanaState.TRAIN -> {
                YantraCanvas(
                    state = yantraState,
                    onComplete = { accuracy ->
                        val result = SadhanaStateMachine.attemptBreakthrough(shishya, accuracy)
                        shishya = shishya.copy(
                            chakraLevel = result.newChakraLevel,
                            sattva = result.newSattva,
                            prana = result.newPrana,
                            inMoksha = result.isMoksha
                        )
                        if (result.success) {
                            streakDays++
                            sadhanaState = SadhanaState.BREAKTHROUGH_READY
                        } else {
                            sadhanaState = SadhanaState.TRAIN
                        }
                        yantraState = yantraState.complete(accuracy)
                    }
                )
            }
            SadhanaState.BREAKTHROUGH_READY -> {
                Text("Breakthrough achieved! Choose your path:")
                Row(
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = androidx.compose.foundation.layout.Arrangement.spacedBy(8.dp)
                ) {
                    PathChoiceButton(
                        name = "Karma Path",
                        subtitle = "+15% Prana Speed",
                        color = MaterialTheme.colorScheme.primary,
                        onClick = {
                            shishya = shishya.copy(path = Path.YOGA)
                            sadhanaState = SadhanaState.TRAIN
                            yantraState = yantraState.reset()
                        }
                    )
                    PathChoiceButton(
                        name = "Dharma Path",
                        subtitle = "+10% Aura Radius",
                        color = MaterialTheme.colorScheme.secondary,
                        onClick = {
                            shishya = shishya.copy(path = Path.BHAKTI)
                            sadhanaState = SadhanaState.TRAIN
                            yantraState = yantraState.reset()
                        }
                    )
                }
            }
            SadhanaState.MOKSHA -> {
                Text("Moksha achieved! Your disciple has ascended.")
                Button(onClick = {
                    shishya = SadhanaStateMachine.recruit(
                        id = "shishya-1",
                        name = "Arjun",
                        samskara = Samskara.SATTVA,
                        gift = Gift.YOGA,
                        path = Path.YOGA
                    )
                    sadhanaState = SadhanaState.TRAIN
                    streakDays = 0
                }) {
                    Text("Recruit New Shishya")
                }
            }
            else -> {
                Text("Unknown state")
            }
        }
    }
}

@Composable
fun StatCard(label: String, value: String, progress: Float = 0f) {
    Card(
        modifier = Modifier.fillMaxSize().height(80.dp)
    ) {
        androidx.compose.foundation.layout.Column(
            modifier = Modifier.fillMaxSize().padding(8.dp),
            verticalArrangement = androidx.compose.foundation.layout.Arrangement.spacedBy(4.dp)
        ) {
            Text(text = label, style = MaterialTheme.typography.bodySmall)
            Text(text = value, style = MaterialTheme.typography.titleMedium)
            if (progress > 0f) {
                androidx.compose.foundation.layout.Row(
                    modifier = Modifier.fillMaxSize()
                ) {
                    androidx.compose.material3.LinearProgressIndicator(
                        modifier = Modifier.fillMaxSize(),
                        progress = progress
                    )
                }
            }
        }
    }
}

@Composable
fun PathChoiceButton(name: String, subtitle: String, color: androidx.compose.ui.graphics.Color, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
    ) {
        androidx.compose.foundation.layout.Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = name)
            Text(text = subtitle, style = MaterialTheme.typography.bodySmall)
        }
    }
}