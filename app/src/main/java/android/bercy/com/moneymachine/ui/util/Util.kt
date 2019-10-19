package android.bercy.com.moneymachine.ui.util

class Util {
    private val loginCallBack : LoginCallBack? = null

    companion object {
        fun isUserNameValid(email:String):Boolean {
            return email == "abc"
        }

        fun isPasswordValid(password:String):Boolean {
            return password=="123"
        }


    }

    fun loginValidation(valid: Boolean) {
        if(valid) {
            loginCallBack?.success()
        }else{
            loginCallBack?.failed()
        }
    }

}

interface LoginCallBack {
    fun success()

    fun failed()
}