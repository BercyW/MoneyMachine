package android.bercy.com.moneymachine.ui.ui

import android.bercy.com.moneymachine.R
import android.bercy.com.moneymachine.databinding.ActivityLoginBinding
import android.bercy.com.moneymachine.ui.ui.viewmodel.LoginViewModel
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

class LoginActivity : AppCompatActivity() {

    private var binding : ActivityLoginBinding? =null
    private var viewmodel: LoginViewModel? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        viewmodel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        binding?.viewmodel = viewmodel
        initObservables()
    }

    private fun initObservables() {
        viewmodel?.userLogin?.observe(this, Observer {
            success()
        })
    }

    /**
     * The right implementation should be insert a user table before the app starting,
     * since this is not important for this test, I didn't optimize this part.
     */
    private fun success() {
        val homePage = Intent(this,MainActivity::class.java)
        startActivity(homePage)
        Toast.makeText(this, "welcome ${viewmodel?.username?.get()}", Toast.LENGTH_LONG).show()
    }
}
