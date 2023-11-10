package id.synergy.challenge_5.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import id.synergy.challenge_5.domain.Resource
import id.synergy.challenge_5.domain.model.ordo.OrdoModel
import id.synergy.challenge_5.domain.usecase.ordo.OrdoUseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCase: OrdoUseCase
) : ViewModel(){
    private val _ordoResult = MutableLiveData<List<OrdoModel>>()
    val ordoResult: LiveData<List<OrdoModel>> get() = _ordoResult
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading : LiveData<Boolean> get() = _isLoading

    fun getOrdo() {
        viewModelScope.launch {
            useCase.getOrdo().collect{ result ->
                Log.d("Result", result.toString())
                when(result){
                    is Resource.Success -> {
                        _isLoading.value = false
                        _ordoResult.value = result.data
                    }
                    is Resource.Error -> {

                    }
                    is Resource.Loading ->{
                        _isLoading.value = true
                    }
                }
            }
        }
    }
}