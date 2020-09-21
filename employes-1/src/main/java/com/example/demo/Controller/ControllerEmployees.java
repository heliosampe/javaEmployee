package com.example.demo.Controller;

import javax.websocket.server.PathParam;

import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Bean.EmpleadoBean;
import com.example.demo.Bean.EmpleadoBeanEntrada;
import com.example.demo.Bean.EmpleadoHorasBeanEntrada;
import com.example.demo.Service.EmployeeService;




@RequestMapping("/registroEmpleados")
@RestController
public class ControllerEmployees {
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping({"/agregarEmpleado"})
	public EmpleadoBean agregarEmpleado(@RequestBody EmpleadoBeanEntrada empleadoBeanEntrada ) {
		EmpleadoBean response = new EmpleadoBean(); 
		response=employeeService.guardarEmpleado(empleadoBeanEntrada);
		return response ;
	}

	@PostMapping({"/agregarHoras"})
	public EmpleadoBean agregarHoras(@RequestBody EmpleadoHorasBeanEntrada empleadoHorasBeanEntrada) {
		EmpleadoBean response = new EmpleadoBean(); 
		response = employeeService.agregarHoras(empleadoHorasBeanEntrada); 
		return response;
	}
	
	
	@GetMapping({"consultarPuestos"})
	public EmpleadoBean consultarPuestos(@RequestBody int idJob) {
		EmpleadoBean response = new EmpleadoBean();
		response = employeeService.consultarPuestos(idJob);
		return response;
	}

}
