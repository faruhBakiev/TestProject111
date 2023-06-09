import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.presentation.R
import com.example.presentation.ui.base.BaseFragment
import com.example.presentation.databinding.FragmentFilmsBinding
import com.example.presentation.ui.UIState
import com.example.presentation.ui.adapter.FilmsAdapter
import com.example.presentation.ui.fragments.FilmsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FilmsFragment
    : BaseFragment<FragmentFilmsBinding, FilmsViewModel>(R.layout.fragment_films) {

    override val binding by viewBinding(FragmentFilmsBinding::bind)
    override val viewModel: FilmsViewModel by viewModels()
    private val filmsAdapter = FilmsAdapter()

    override fun initialize() {
        setupRecycler()
    }

    private fun setupRecycler() = with(binding.recFilms) {
        layoutManager = LinearLayoutManager(requireContext())
        adapter = filmsAdapter
    }
    override fun setupSubscribes() {
        subscribeToFilms()
    }

    private fun subscribeToFilms() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.filmsState.collect {
                    when (it) {
                        is UIState.Error -> {
                            Toast.makeText(requireContext(), it.toString(), Toast.LENGTH_SHORT).show()
                        }
                        is UIState.Loading -> {
                            Toast.makeText(requireContext(), "Loading", Toast.LENGTH_SHORT).show()
                        }
                        is UIState.Success -> {
                            it.data.let { data ->
                                filmsAdapter.submitList(data)
                            }
                        }
                    }
                }
            }
        }
    }
}