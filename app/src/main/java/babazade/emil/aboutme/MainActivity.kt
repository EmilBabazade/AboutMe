package babazade.emil.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import babazade.emil.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val myName = MyName("Emil Babazade")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName

        binding.doneButton.setOnClickListener(::addNickname)
    }

    private fun addNickname(view: View) {
        binding.apply {
            myName?.nickname = nicknameEditText.text.toString() ?: ""
            invalidateAll()
            nicknameTextView.text = nicknameEditText.text
            nicknameTextView.visibility = View.VISIBLE
            nicknameEditText.visibility = View.GONE
            doneButton.visibility = View.GONE
        }

        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}