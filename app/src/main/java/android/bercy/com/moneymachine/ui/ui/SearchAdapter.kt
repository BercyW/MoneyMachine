package android.bercy.com.moneymachine.ui.ui

import android.bercy.com.moneymachine.R
import android.bercy.com.moneymachine.ui.model.Deposit
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.ry_search_item.view.*

class SearchAdapter : RecyclerView.Adapter<SearchAdapter.MyViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        /**
         *    // create a new view
        val textView = LayoutInflater.from(parent.context)
        .inflate(R.layout.my_text_view, parent, false) as TextView
        // set the view's size, margins, paddings and layout parameters
        ...
        return MyViewHolder(textView)
         */


        val view = LayoutInflater.from(parent.context).inflate(R.layout.ry_search_item,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemCount
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = getItemId(position)
        (holder as MyViewHolder).bind(item)

    }

    class MyViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {


        //check if it is deposit
        inline fun<reified T> bind(item : T ) {
            if(item==null) {
                itemView.rc_search.visibility = View.GONE
            }

            if(T::class=== Deposit::class) {
                if(item !=null) {
                    itemView.item_tv_name.text = (item as Deposit).userName
                    itemView.item_tv_date.text = (item as Deposit).date
                    itemView.item_tv_total.text = (item as Deposit).amount.toString()
                    itemView.item_tv_desc.text = (item as Deposit).description
                }
            }
        }
    }
}