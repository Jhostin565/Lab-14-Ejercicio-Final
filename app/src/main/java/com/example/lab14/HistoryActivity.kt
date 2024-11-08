package com.example.lab14

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.LazyColumn

data class Transaction(val date: String, val amount: Double, val description: String)

class HistoryActivity : ComponentActivity() {
    private val transactions = listOf(
        Transaction("01/11/2024", 150.0, "Pago de Servicios"),
        Transaction("02/11/2024", 200.0, "Transferencia a Juan"),
        Transaction("03/11/2024", 75.0, "Compra en Supermercado"),
        Transaction("04/11/2024", 50.0, "Retiro de Cajero")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HistoryScreen()
        }
    }

    @Composable
    fun HistoryScreen() {
        Column(
            modifier = androidx.compose.ui.Modifier.fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(text = "Historial de Transacciones", style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = androidx.compose.ui.Modifier.height(16.dp))
            LazyColumn {
                items(transactions.size) { index ->
                    val transaction = transactions[index]
                    TransactionItem(transaction)
                }
            }
        }
    }

    @Composable
    fun TransactionItem(transaction: Transaction) {
        Column(modifier = androidx.compose.ui.Modifier.padding(8.dp)) {
            Text(text = "Fecha: ${transaction.date}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Monto: \$${transaction.amount}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Descripción: ${transaction.description}", style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = androidx.compose.ui.Modifier.height(8.dp))
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewHistoryScreen() {
        HistoryScreen()
    }
}
