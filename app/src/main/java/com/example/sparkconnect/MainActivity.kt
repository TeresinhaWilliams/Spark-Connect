package com.example.sparkconnect

// Import required Android libraries
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.animation.AlphaAnimation
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

// MainActivity is the entry point of the app
class MainActivity : AppCompatActivity() {

    // onCreate is called when the app starts
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Connect this Kotlin file to the XML layout (activity_main.xml)
        setContentView(R.layout.activity_main)

        // Link UI components from XML to Kotlin variables using their IDs
        val timeInput = findViewById<EditText>(R.id.timeInput)   // Input field
        val resultText = findViewById<TextView>(R.id.resultText) // Output text
        val suggestButton = findViewById<Button>(R.id.suggestButton) // Suggest button
        val resetButton = findViewById<Button>(R.id.resetButton) // Reset button

        // Set click listener for the "Get Spark" button
        suggestButton.setOnClickListener {

            // Get the user's input from the EditText
            // trim() removes extra spaces and lowercase() standardises input
            val time = timeInput.text.toString().trim().lowercase()

            /*
             The when statement checks the user's input
             and returns a matching social suggestion.
             It works like an if-else structure but is cleaner.
            */
            val suggestion = when (time) {

                // Morning suggestion
                "morning" -> "☀️ Send a cheerful 'Good morning' text!"

                // Mid-morning suggestion
                "mid-morning" -> "💼 Say thank you to a colleague."

                // Afternoon suggestion
                "afternoon" -> "😂 Share a funny meme with a friend."

                // Snack time suggestion
                "afternoon snack time" -> "💛 Send a 'Thinking of you' message."

                // Dinner suggestion
                "dinner" -> "📞 Call someone for a quick catch-up."

                // Night / after dinner suggestion
                "night", "after dinner" -> "💬 Leave a kind comment online."

                // Default case if input does not match any option
                else -> "⚠️ Please enter: Morning, Afternoon, Dinner or Night"
            }

            // Display the selected suggestion in the TextView
            resultText.text = suggestion

            /*
             Add a fade-in animation to improve user experience.
             The text fades in smoothly when updated.
            */
            val fadeIn = AlphaAnimation(0f, 1f)
            fadeIn.duration = 500 // Animation lasts 0.5 seconds
            resultText.startAnimation(fadeIn)

            /*
             Add a small button animation to make the app feel interactive.
             The button shrinks slightly and returns to normal size.
            */
            suggestButton.animate().scaleX(0.9f).scaleY(0.9f).setDuration(100).withEndAction {
                suggestButton.animate().scaleX(1f).scaleY(1f).duration = 100
            }
        }

        // Set click listener for the "Reset" button
        resetButton.setOnClickListener {

            // Clear the text input field
            timeInput.text.clear()

            // Reset the result text to default message
            resultText.text = "Your spark will appear here 😊"
        }
    }
}