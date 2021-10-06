package com.gecko.memorizeword.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gecko.memorizeword.databinding.ActivityVocabularyBinding

class VocabularyActivity : BaseActivity() {

    val binding by lazy { ActivityVocabularyBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupEvents()
        setValues()

    }

    override fun setupEvents() {

    }

    override fun setValues() {

    }

}