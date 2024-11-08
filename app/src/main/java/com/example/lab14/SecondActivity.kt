package com.example.lab14

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TransferScreen()
        }
    }

    @Composable
    fun TransferScreen() {
        val amount = remember { mutableStateOf("") }
        val recipient = remember { mutableStateOf("") }
        val message = remember { mutableStateOf("") }

        Column(
            modifier = androidx.compose.ui.Modifier.fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(text = "Transferencias", style = MaterialTheme.typography.titleLarge)

            Spacer(modifier = androidx.compose.ui.Modifier.height(16.dp))

            TextField(
                value = amount.value,
                onValueChange = { amount.value = it },
                label = { Text("Monto a Transferir") }
            )

            Spacer(modifier = androidx.compose.ui.Modifier.height(8.dp))

            TextField(
                value = recipient.value,
                onValueChange = { recipient.value = it },
                label = { Text("Destinatario (Número de Cuenta)") }
            )

            Spacer(modifier = androidx.compose.ui.Modifier.height(16.dp))

            Button(onClick = {
                if (amount.value.isNotEmpty() && recipient.value.isNotEmpty()) {
                    message.value = "Transferencia de \$${amount.value} a ${recipient.value} realizada con éxito."
                } else {
                    message.value = "Por favor, completa todos los campos."
                }
            }) {
                Text("Confirmar Transferencia")
            }

            Spacer(modifier = androidx.compose.ui.Modifier.height(16.dp))

            Text(text = message.value, style = MaterialTheme.typography.bodyMedium)

            Spacer(modifier = androidx.compose.ui.Modifier.height(24.dp))

            Button(onClick = { finish() }) {
                Text("Volver a la Página Principal")
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewTransferScreen() {
        TransferScreen()
    }
}
