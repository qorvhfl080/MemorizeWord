package com.gecko.memorizeword.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gecko.memorizeword.data.Word
import com.gecko.memorizeword.databinding.ActivityVocabularyBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase

class VocabularyActivity : BaseActivity() {

    val binding by lazy { ActivityVocabularyBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupEvents()
        setValues()

    }

    override fun setupEvents() {

        binding.submitBtn.setOnClickListener {

            val wordText = binding.wordEdt.text.toString()
            val meaningText = binding.meaningEdt.text.toString()

            val addRef = FirebaseDatabase.getInstance().getReference("Words").push()
            val word = Word(wordText, meaningText)
            addRef.setValue(word)
            finish()

        }

    }

    override fun setValues() {

        FirebaseDatabase.getInstance().getReference("Words")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    snapshot?.let {
                        val data = it.getValue()
                        binding.dbTxt.text = data.toString()
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    error.toException().printStackTrace()
                }
            })

    }

}