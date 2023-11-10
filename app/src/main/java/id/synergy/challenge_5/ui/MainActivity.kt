package id.synergy.challenge_5.ui

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import id.synergy.challenge_5.databinding.ActivityMainBinding

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private lateinit var ordoAdapter: OrdoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        ordoAdapter = OrdoAdapter { selectedOrdo ->

        }

        binding.recycler.layoutManager = LinearLayoutManager(this)
        binding.recycler.adapter = ordoAdapter


        binding.recycler.adapter = ordoAdapter
        viewModel.getOrdo()
        viewModel.ordoResult.observe(this) { resource ->
            ordoAdapter.setOrdoList(resource)
        }
        viewModel.isLoading.observe(this) { isLoading ->
            binding.progress.visibility = if (isLoading) View.VISIBLE else View.GONE
        }

    }
}