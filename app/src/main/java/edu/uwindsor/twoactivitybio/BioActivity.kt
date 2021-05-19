package edu.uwindsor.twoactivitybio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

private lateinit var returnButton: Button
private lateinit var messageTextBox: TextView

class BioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bio)

        val firstName = intent.extras?.getString("first_name")
        val lastName = intent.extras?.getString("last_name")
        val gradYear = intent.extras?.getString("grad_year")
        val schoolName = intent.extras?.getString("school")
        val deg = intent.extras?.getString("degree")
        val maj = intent.extras?.getString("major")
        val activities = intent.extras?.getString("activities")

        messageTextBox = findViewById(R.id.textView3)
        messageTextBox.text = "$firstName $lastName graduated in $gradYear from $schoolName with a $deg in $maj. Their favourite activities are $activities."

        returnButton = findViewById(R.id.button2)
        returnButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}