package com.example.demo.ServiceImpl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Bean.EmpleadoBean;
import com.example.demo.Bean.EmpleadoBeanEntrada;
import com.example.demo.Model.Employees;
import com.example.demo.Repo.EmployeeRepo;
import com.example.demo.Repo.GenderRepository;
import com.example.demo.Repo.JobsRepository;
import com.example.demo.Service.EmployeeService;

@Service
public class EmployeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;
	@Autowired
	private GenderRepository genderRepository;
	@Autowired
	private JobsRepository jobsRepository;


	@Override
	public EmpleadoBean guardarEmpleado(EmpleadoBeanEntrada empleadoBeanEntrada) {

		List<Employees> employees = employeeRepo.findAll();
		EmpleadoBean empleadoBean = new EmpleadoBean();

		if (!this.genderRepository.existsById(empleadoBeanEntrada.getGenderId())) {

			empleadoBean.setId(null);
			empleadoBean.setSuccess(false);
			return empleadoBean;
		}
		if (!this.jobsRepository.existsById(empleadoBeanEntrada.getJobId())) {
			empleadoBean.setId(null);
			empleadoBean.setSuccess(false);
			return empleadoBean;
		}

		Date fechaActual = new Date();
		Calendar Actual = Calendar.getInstance();
		Calendar Nacimiento = Calendar.getInstance();
		Actual.setTime(fechaActual);
		Nacimiento.setTime(empleadoBeanEntrada.getBirthname());

		int edad = Actual.get(Calendar.YEAR) - Nacimiento.get(Calendar.YEAR);

		for (Employees employees2 : employees) {
			if (employees2.getName().equals(empleadoBeanEntrada.getName())
					&& employees2.getLastName().equals(empleadoBeanEntrada.getLastName()) && edad > 18) {
				empleadoBean.setId(null);
				empleadoBean.setSuccess(false);
				return empleadoBean;
			}
		}

		Employees employeesBean = new Employees();

		employeesBean.setName(empleadoBeanEntrada.getName());
		employeesBean.setLastName(empleadoBeanEntrada.getLastName());
		employeesBean.setBirthname(empleadoBeanEntrada.getBirthname());
		employeesBean.setGenderId(empleadoBeanEntrada.getGenderId());
		employeesBean.setJobId(empleadoBeanEntrada.getJobId());

		employeesBean = employeeRepo.save(employeesBean);

		empleadoBean.setId(employeesBean.getIdEmployes());
		empleadoBean.setSuccess(true);

		return empleadoBean;
	}

}
