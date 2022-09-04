package com.yongjunand.gondol.Fragments

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Context.CLIPBOARD_SERVICE
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.content.getSystemService
import androidx.core.widget.addTextChangedListener
import com.yongjunand.gondol.Braille
import com.yongjunand.gondol.R


class BrailleFragment : Fragment() {

    private lateinit var editText: EditText
    private lateinit var textView: TextView
    private lateinit var copyButton: Button
    private var braille = Braille()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view = inflater.inflate(R.layout.fragment_braille, container, false)
        this.editText = view.findViewById(R.id.brailleEditText)
        this.textView = view.findViewById(R.id.brailleTextView)
        this.copyButton = view.findViewById(R.id.brailleCopy)
        bind()

        return view
    }

    private fun bind() {
        this.editText.addTextChangedListener {
            var brailleText = ""

            for (text in it.toString()) {
                brailleText += this.braille.braille[text.toString()]
            }
            this.textView.text = brailleText
        }

        this.copyButton.setOnClickListener {
            var textToCopy = this.textView.text
            val clipboard = context?.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clipData = ClipData.newPlainText("braille", textToCopy)
            clipboard.setPrimaryClip(clipData)
        }
    }
}