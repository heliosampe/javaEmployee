package com.example.demo.Service;

import com.example.demo.Bean.EmpleadoBean;
import com.example.demo.Bean.EmpleadoBeanEntrada;
import com.example.demo.Bean.EmpleadoHorasBeanEntrada;

public interface EmployeeService {

	EmpleadoBean guardarEmpleado(EmpleadoBeanEntrada empleadoBeanEntrada);
	EmpleadoBean agregarHoras(EmpleadoHorasBeanEntrada empleadoHorasBeanEntrada);

}
