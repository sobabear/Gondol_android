package com.yongjunand.gondol.Fragments

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import com.yongjunand.gondol.Braille
import com.yongjunand.gondol.Morse
import com.yongjunand.gondol.R

class MorseFragment : Fragment() {
    private lateinit var editText: EditText
    private lateinit var textView: TextView
    private lateinit var copyButton: Button
    private var morse = Morse()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view =  inflater.inflate(R.layout.fragment_morse, container, false)
        this.editText = view.findViewById(R.id.morseEditText)
        this.textView = view.findViewById(R.id.morseTextView)
        this.copyButton = view.findViewById(R.id.morseCopy)
        bind()

        return view
    }

    private fun bind() {
        this.editText.addTextChangedListener {
            var morseText = ""

            for (text in it.toString()) {
                morseText += this.morse.morse[text.toString()]
            }
            this.textView.text = morseText
        }


        this.copyButton.setOnClickListener {
            var textToCopy = this.textView.text
            val clipboard = context?.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clipData = ClipData.newPlainText("morse", textToCopy)
            clipboard.setPrimaryClip(clipData)
        }
    }

}