package android.bercy.com.moneymachine.ui.ui.viewmodel

import android.app.Application
import android.bercy.com.moneymachine.ui.util.Util
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import javax.security.auth.callback.Callback


/**
 *
 * the logic here is when password and user name passed, I added "success" string to livedata, when livedata has
 * chagned, it will allow to login.
 */

class LoginViewModel(application: Application) : AndroidViewModel(application),Callback{

    /**
     * this part just want  to use observable + databinding.
     * when get success response added some info to userlogin livedata.
     * when userlogin data has changed, it means user succeed logged in.
     */
    var btnSelected: ObservableBoolean? = null
    var username : ObservableField<String>? = null
    var password: ObservableField<String>? = null
    var userLogin : MutableLiveData<String>? =null

    init {
        btnSelected = ObservableBoolean(false)
        username = ObservableField("")
        password = ObservableField("")
        userLogin  = MutableLiveData()
    }

    //only password and password is right then login button is enable
    fun onUserNameChanged(s: CharSequence, start: Int, befor: Int, count: Int) {
        btnSelected?.set(Util.isUserNameValid(s.toString()))
    }
    //only password and password is right then login button is enable
    fun onPasswordChanged(s: CharSequence, start: Int, befor: Int, count: Int) {
        btnSelected?.set(Util.isPasswordValid(s.toString()))
    }

    /**
     *  sorry for not getting result from Db, spent too much time on the login UI layout. : (
     */
    fun login() {
        val util = Util()
        val username = username?.get()
        val password = password?.get()

        if((username == "abc") && (password == "123")) {
            userLogin?.value = "success"
        }else {
            util.loginValidation(false)
        }
    }
}