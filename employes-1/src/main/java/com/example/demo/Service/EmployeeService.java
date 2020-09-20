package com.example.demo.Service;

import org.springframework.stereotype.Service;

import com.example.demo.Bean.EmpleadoBean;
import com.example.demo.Bean.EmpleadoBeanEntrada;

public interface EmployeeService {

	EmpleadoBean guardarEmpleado(EmpleadoBeanEntrada empleadoBeanEntrada);

}
