package com.santirivera.frogtekbeertest.fragment.list

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.santirivera.domain.model.BeerItem
import dagger.hilt.android.AndroidEntryPoint
import com.santirivera.domain.usecase.Callback
import com.santirivera.frogtekbeertest.databinding.FragmentItemListBinding
import com.santirivera.frogtekbeertest.fragment.list.adapter.FrogtekBeerListAdapter
import com.santirivera.frogtekbeertest.fragment.list.adapter.viewholder.FrogtekBeerViewHolder
import com.santirivera.frogtekbeertest.fragment.base.FrogtekBeerBaseFragment
import java.lang.Exception
import java.util.*

@AndroidEntryPoint
class FrogtekBeerListFragment : FrogtekBeerBaseFragment(),
    FrogtekBeerViewHolder.OnBeerClickedCallback, Callback<List<BeerItem>> {

    private var _binding: FragmentItemListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: FrogtekBeerListViewModel by viewModels()

    private val adapter = FrogtekBeerListAdapter(ArrayList(), this)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentItemListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView: RecyclerView = binding.itemList
        setupRecyclerView(recyclerView)
        startLoad()
        viewModel.loadBeers(this)
    }


    private fun setupRecyclerView(recyclerView: RecyclerView) {
        recyclerView.adapter = adapter
        binding.itemList.layoutManager = LinearLayoutManager(context)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onBeerClicked(item: BeerItem) {
        val beerDialog = FrogtekBeerDialog(requireContext(), item)
        beerDialog.show()
    }


    @SuppressLint("NotifyDataSetChanged")
    override fun onSuccess(response: List<BeerItem>) {
        adapter.setNewValues(response)
        adapter.notifyDataSetChanged()
        endLoad()
    }

    override fun onError(error: Exception) {
        noInternet()
    }
}