package android.bercy.com.moneymachine.ui.ui

import android.bercy.com.moneymachine.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var userName : String? = null
    private lateinit var spinner: Spinner
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userName = intent.getStringExtra("UserName")

        setupSpinner()
    }

    private fun setupSpinner() {
        spinner= this.findViewById(R.id.spinner)

        ArrayAdapter.createFromResource(
            this,
            R.array.tag_transaction,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }
    }

    /**
     * organize onclick event
     */
    fun onClick(view: View) {

        when(view.id) {
            R.id.deposit_button -> depositAndWithDrawUISetup(view)
            R.id.withdraw_button-> depositAndWithDrawUISetup(view)
            R.id.search_button -> searchLogic()
            R.id.summary_button -> summaryLogic()
        }
    }

    /**
     * only different is deposit has no TAG need to input
     * and button text is different
     */
    private fun depositAndWithDrawUISetup(view: View) {
        val depositButton : Button = findViewById(R.id.deposit_button)
        val withdrawButton : Button = findViewById(R.id.withdraw_button)
        ct_deposit_and_withdraw_layout.visibility = View.VISIBLE
        ct_summary_layout.visibility = View.GONE
        if(view.id==depositButton.id) {
            deposit_enter.text = getString(R.string.deposit)
            spinner.visibility = View.INVISIBLE

        }else if (view.id == withdrawButton.id) {
            deposit_enter.text = getString(R.string.withdraw)
            spinner.visibility = View.VISIBLE
        }
    }









    /**
     * for search
     */
    private fun searchLogic() {

    }

    /**
     * for summary
     */
    private fun summaryLogic() {

    }

}
