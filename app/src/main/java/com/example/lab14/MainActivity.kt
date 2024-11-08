package com.example.lab14

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }

    @Composable
    fun MainScreen() {
        Column(
            modifier = androidx.compose.ui.Modifier.fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(text = "Bienvenido a Banco Interamericano de Finanzas (BanBif)", style = MaterialTheme.typography.titleLarge)

            Spacer(modifier = androidx.compose.ui.Modifier.height(16.dp))

            Text(
                text = "Tu banco de confianza para todas tus necesidades financieras. " +
                        "Ofrecemos transferencias rápidas, seguridad y atención al cliente excepcional.",
                style = MaterialTheme.typography.bodyMedium,
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )

            Spacer(modifier = androidx.compose.ui.Modifier.height(32.dp))

            Text(text = "Saldo Actual: \$5,000.00", style = MaterialTheme.typography.titleMedium)
            Text(text = "Número de Cuenta: 123456789", style = MaterialTheme.typography.bodyMedium)

            Spacer(modifier = androidx.compose.ui.Modifier.height(24.dp))

            Text(text = "Accesos Rápidos", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = androidx.compose.ui.Modifier.height(8.dp))

            Button(onClick = { startActivity(Intent(this@MainActivity, SecondActivity::class.java)) }) {
                Text("Transferencias")
            }
            Spacer(modifier = androidx.compose.ui.Modifier.height(8.dp))
            Button(onClick = { startActivity(Intent(this@MainActivity, HistoryActivity::class.java)) }) {
                Text("Historial de Transacciones")
            }
            Spacer(modifier = androidx.compose.ui.Modifier.height(8.dp))
            Button(onClick = { /* Accion para Pagar Facturas */ }) {
                Text("Pagar Facturas")
            }
            Spacer(modifier = androidx.compose.ui.Modifier.height(8.dp))
            Button(onClick = { /* Accion para Depositar Dinero */ }) {
                Text("Depositar Dinero")
            }

            Spacer(modifier = androidx.compose.ui.Modifier.height(24.dp))

            Text(text = "Notificaciones", style = MaterialTheme.typography.titleMedium)
            Text(text = "Recuerda realizar tu pago de tarjeta este mes.", style = MaterialTheme.typography.bodySmall)

            Spacer(modifier = androidx.compose.ui.Modifier.height(24.dp))

            Button(onClick = { /* Accion para cerrar sesión */ }) {
                Text("Cerrar Sesión")
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewMainScreen() {
        MainScreen()
    }
}
