package android.bercy.com.moneymachine.ui.ui

import android.bercy.com.moneymachine.R
import android.bercy.com.moneymachine.ui.Injection
import android.bercy.com.moneymachine.ui.model.Deposit
import android.bercy.com.moneymachine.ui.model.Withdraw
import android.bercy.com.moneymachine.ui.ui.viewmodel.HomeScreenViewModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {

    private var userName : String? = null
    private lateinit var spinner: Spinner
    private var formatted: String? = null
    private lateinit var viewModel : HomeScreenViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userName = intent.getStringExtra("UserName")

        // get the view model
        viewModel = ViewModelProviders.of(this, Injection.provideViewModelFacotry(this))
            .get(HomeScreenViewModel::class.java)

        setupSpinner()

        initBalance()

    }
    //observe the deposit and withdraw
    private fun initBalance() {
        viewModel.getTotalDeposit().observe(this, Observer {
            displayTotalDeposit(it,0)
            Log.d("boxi","deposit amount has changed to $it")
        })
        viewModel.getTotalWithdraw().observe(this, Observer {
            displayTotalDeposit(it,1)
        })
    }

    //calculate the balance
    private fun displayTotalDeposit(amount:Long,i : Int) {
        when(i) {
            0 ->tv_total_deposit.text=getString(R.string.total_deposit,amount.toString())
            1 ->tv_total_withdraw.text=getString(R.string.total_withdraw,amount.toString())
        }

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
        val current = LocalDateTime.now()
        //just show date not show exact time
        val formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy")
        formatted = current.format(formatter)
        Log.d("boxi","current date is $formatted")

        tv_date.text = formatted
        ct_deposit_and_withdraw_layout.visibility = View.VISIBLE
        tv_user_name_deposit_withdraw.text=getString(R.string.user,userName)

        if(view.id==depositButton.id) {
            enter_amount_button.text = getString(R.string.deposit)
            spinner.visibility = View.INVISIBLE


        }else if (view.id == withdrawButton.id) {
            enter_amount_button.text = getString(R.string.withdraw)
            spinner.visibility = View.VISIBLE
        }
    }

    /**
     * pressd enter button
     */
    fun onEnterPressed(view: View) {

        val userName = userName

        var amount = et_amount.text.toString()
        if(amount == "") amount = "0"

        val description  = et_description.text.toString()


         // for deposit
        if(enter_amount_button.text==getString(R.string.deposit)) {

            //create obj
            val deposit = Deposit()
            deposit.userName = userName
            deposit.amount = amount.toLong()
            deposit.description = description
            deposit.date = formatted

            //insert
            viewModel.insertDepositMoney(deposit)
            Toast.makeText(this, "You deposit $$amount", Toast.LENGTH_LONG).show()

            //for withdraw
        }else if(enter_amount_button.text==getString(R.string.withdraw)) {
            val tag:String = spinner.selectedItem.toString()

            //create obj
            val withdraw = Withdraw()
            withdraw.userName=userName
            withdraw.amount=amount.toLong()
            withdraw.description=description
            withdraw.date = formatted
            withdraw.tag = tag

            viewModel.insertWithdrawMoney(withdraw)
            Toast.makeText(this, "You withdraw $$amount", Toast.LENGTH_LONG).show()

        }
        //for clear the text in edittext and make visible gone
        ct_deposit_and_withdraw_layout.visibility = View.INVISIBLE
        et_amount.text.clear()
        et_description.text.clear()


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
