package com.gecko.memorizeword.activity

import android.content.Intent
import android.os.Bundle
import com.gecko.memorizeword.databinding.ActivityMainBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainActivity : BaseActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupEvents()
        setValues()

    }

    override fun setupEvents() {

        binding.vocabularyManageBtn.setOnClickListener {

            val intent = Intent(mContext, VocabularyActivity::class.java)
            startActivity(intent)

        }

    }

    override fun setValues() {
        FirebaseDatabase.getInstance().getReference("test")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    snapshot?.let {
                        val data = snapshot.getValue()
                        binding.descriptionTxt.text = data.toString()
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    error.toException().printStackTrace()
                }
            })
    }

}