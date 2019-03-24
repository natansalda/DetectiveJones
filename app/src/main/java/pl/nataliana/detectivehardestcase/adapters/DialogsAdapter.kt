package pl.nataliana.detectivehardestcase.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import pl.nataliana.detectivehardestcase.R
import pl.nataliana.detectivehardestcase.model.Dialog

class DialogsAdapter(private val dialogs: MutableList<Dialog>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.dialog_list_item, parent, false)
        return DialogRowHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as DialogRowHolder).setDialog(dialogs[position])
    }

    fun addDialog(dialog: Dialog) {
        dialogs.add(dialog)
        notifyItemInserted(dialogs.size - 1)
    }

    override fun getItemCount(): Int {
        return dialogs.size
    }

    inner class DialogRowHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        @BindView(R.id.face_iv)
        internal var faceImageView: ImageView? = null

        @BindView(R.id.name_tv)
        internal var nameLabel: TextView? = null

        @BindView(R.id.dialog_tv)
        internal var dialogLabel: TextView? = null

        init {
            ButterKnife.bind(this, itemView)
        }

        fun setDialog(dialog: Dialog) {
            faceImageView!!.setImageResource(dialog.getmImageDrawable())
            nameLabel!!.text = dialog.getmName()
            dialogLabel!!.text = dialog.getmText()
        }
    }
}
