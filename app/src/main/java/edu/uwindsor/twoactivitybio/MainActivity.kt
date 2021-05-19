package edu.uwindsor.twoactivitybio

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.MaterialAutoCompleteTextView
import com.google.android.material.textfield.TextInputEditText
import edu.uwindsor.twoactivitybio.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var generateButton: Button
    private lateinit var firstNameField: TextInputEditText
    private lateinit var lastNameField: TextInputEditText
    private lateinit var graduationField: TextInputEditText
    private lateinit var schoolField: TextInputEditText
    private var degree: String = "BS"
    private lateinit var major: MaterialAutoCompleteTextView
    private lateinit var activities: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        generateButton = findViewById(R.id.button)
        firstNameField = findViewById(R.id.firstname)
        lastNameField = findViewById(R.id.lastname)
        graduationField = findViewById(R.id.gradyear)
        schoolField = findViewById(R.id.school)
        major = findViewById(R.id.combobox)
        activities = findViewById(R.id.favactivities)

        generateButton.setOnClickListener {
            val intent = Intent(this, BioActivity::class.java)
            val extras = Bundle()
            extras.putString("first_name", firstNameField?.text.toString())
            extras.putString("last_name", lastNameField?.text.toString())
            extras.putString("grad_year", graduationField?.text.toString())
            extras.putString("school", schoolField?.text.toString())
            extras.putString("degree", degree)
            extras.putString("major", major?.text.toString())
            extras.putString("activities", activities?.text.toString())
            intent.putExtras(extras)
            startActivity(intent)
        }

    }

    override fun onResume() {
        super.onResume()
        val language = resources.getStringArray(R.array.majors)
        val arrayAdapter = ArrayAdapter(applicationContext, R.layout.dropdown_item, language)
        binding.combobox.setAdapter(arrayAdapter)
    }

    fun onRadioButtonClicked(view: View) {

        val radioGroup1 = findViewById<RadioGroup>(R.id.first_group)
        val radioGroup2 = findViewById<RadioGroup>(R.id.second_group)
        val radioGroup3 = findViewById<RadioGroup>(R.id.third_group)
        val radioGroup4 = findViewById<RadioGroup>(R.id.fourth_group)

        val parent = view.parent as View
        when (parent.id) {
            R.id.first_group -> {
                radioGroup2.clearCheck()
                radioGroup3.clearCheck()
                radioGroup4.clearCheck()
            }
            R.id.second_group -> {
                radioGroup1.clearCheck()
                radioGroup3.clearCheck()
                radioGroup4.clearCheck()
            }
            R.id.third_group -> {
                radioGroup2.clearCheck()
                radioGroup1.clearCheck()
                radioGroup4.clearCheck()
            }
            R.id.fourth_group -> {
                radioGroup2.clearCheck()
                radioGroup3.clearCheck()
                radioGroup1.clearCheck()
            }
        }

        val radio: RadioButton = findViewById(view.id)
        degree = radio.text as String
    }
}
