package pl.nataliana.detectivehardestcase.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

import java.util.ArrayList

import pl.nataliana.detectivehardestcase.Dialog
import pl.nataliana.detectivehardestcase.R

class ProofAdapter(context: Context, proofsData: ArrayList<Dialog>) : ArrayAdapter<Dialog>(context, 0, proofsData) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var listItem = convertView
        if (listItem == null)
            listItem = LayoutInflater.from(context).inflate(R.layout.dialog_list_item, parent, false)

        val currentDialog = getItem(position)

        val image = listItem!!.findViewById<View>(R.id.face_iv) as ImageView
        image.setImageResource(currentDialog!!.getmImageDrawable())

        val name = listItem.findViewById<View>(R.id.name_tv) as TextView
        name.text = currentDialog.getmName()

        val dialog = listItem.findViewById<View>(R.id.dialog_tv) as TextView
        dialog.text = currentDialog.getmText()

        return listItem
    }
}