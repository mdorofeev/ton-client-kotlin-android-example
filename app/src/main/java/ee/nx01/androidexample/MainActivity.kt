package ee.nx01.androidexample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import ee.nx01.tonclient.NetworkConfig
import ee.nx01.tonclient.TonClient
import ee.nx01.tonclient.TonClientConfig
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        runBlocking {
            val client = TonClient(TonClientConfig(NetworkConfig(serverAddress="main.ton.dev")))

            Log.i("log", client.version())
            val account = client.net.accounts.getAccount("-1:3333333333333333333333333333333333333333333333333333333333333333")
            Log.i("log", account.toString())

            client.destroy()
        }

    }
}