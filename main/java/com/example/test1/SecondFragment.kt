package com.example.test1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.test1.databinding.FragmentSecondBinding

import kotlin.math.pow

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Встановлення обробки для кнопки "Результат"
        binding.sumButton.setOnClickListener {

            // Зчитування даних з EditText'ів через binding
            val num1 = binding.number1.text.toString().toDoubleOrNull() ?: 0.0
            val num2 = binding.number2.text.toString().toDoubleOrNull() ?: 0.0
            val num3 = binding.number3.text.toString().toDoubleOrNull() ?: 0.0
            val num4 = binding.number4.text.toString().toDoubleOrNull() ?: 0.0
            val num5 = binding.number5.text.toString().toDoubleOrNull() ?: 0.0
            val num6 = binding.number6.text.toString().toDoubleOrNull() ?: 0.0
            val num7 = binding.number7.text.toString().toDoubleOrNull() ?: 0.0
            val num8 = binding.number8.text.toString().toDoubleOrNull() ?: 0.0
            val num9 = binding.number9.text.toString().toDoubleOrNull() ?: 0.0
            val num10 = binding.number10.text.toString().toDoubleOrNull() ?: 0.0

            // Обчислення результатів
            val result1 = (10.0.pow(6) / num9)  * 0.8  * (num6 / (100 - 1.5)) * (1 - 0.985)
            val result2 = 10.0.pow(-6) * result1 * num9 * num10


            // Відображення результатів
            binding.res1.text = getString(R.string.result_text1, result1)
            binding.res2.text = getString(R.string.result_text2, result2)
        }

        // Кнопка повернення до головного екрану
        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}