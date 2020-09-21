package com.example.demo.ServiceImpl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Bean.EmpleadoBean;
import com.example.demo.Bean.EmpleadoBeanEntrada;
import com.example.demo.Bean.EmpleadoHorasBeanEntrada;
import com.example.demo.Model.EmployeeWorkedHours;
import com.example.demo.Model.Employees;
import com.example.demo.Model.Genders;
import com.example.demo.Model.Jobs;
import com.example.demo.Repo.EmployeWorkedHoursRepo;
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
	@Autowired
	private EmployeWorkedHoursRepo employeWorkedHoursRepo;

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
		employeesBean.setGenders(new Genders(empleadoBeanEntrada.getGenderId()));
		employeesBean.setJob(new Jobs(empleadoBeanEntrada.getJobId()));

		employeesBean = employeeRepo.save(employeesBean);

		empleadoBean.setId(employeesBean.getIdEmployes());
		empleadoBean.setSuccess(true);

		return empleadoBean;
	}

	@Override
	public EmpleadoBean agregarHoras(EmpleadoHorasBeanEntrada empleadoHorasBeanEntrada) {

		EmpleadoBean empleadoBean = new EmpleadoBean();
		Date fechaActual = new Date();
		
		if (!this.employeeRepo.existsById(empleadoHorasBeanEntrada.getEmployee_id())) {
			empleadoBean.setId(null);
			empleadoBean.setSuccess(false);
			return empleadoBean;
		}
		
		if (empleadoHorasBeanEntrada.getWorked_hours() > 20) {
			empleadoBean.setId(null);
			empleadoBean.setSuccess(false);
			return empleadoBean;
		}
		if (empleadoHorasBeanEntrada.getWorked_date().compareTo(fechaActual) > 0) {
			empleadoBean.setId(null);
			empleadoBean.setSuccess(false);
			return empleadoBean;
		}

		
		

		Optional<EmployeeWorkedHours> employeeWorkedHoursObject = employeWorkedHoursRepo
				.findById(empleadoHorasBeanEntrada.getEmployee_id());
		
			EmployeeWorkedHours employeeWorkedHoursBase = employeeWorkedHoursObject.get();
			
			if (employeeWorkedHoursBase.getWorkedDate().compareTo(empleadoHorasBeanEntrada.getWorked_date()) == 0) {
				empleadoBean.setId(null);
				empleadoBean.setSuccess(false);
				return empleadoBean;
			} 
		

		
	
	

			EmployeeWorkedHours employeeWorkedHours = new EmployeeWorkedHours();
			
			employeeWorkedHours.setEmployees(new Employees(empleadoHorasBeanEntrada.getEmployee_id()));
			employeeWorkedHours.setWorkedHours(empleadoHorasBeanEntrada.getWorked_hours());
			employeeWorkedHours.setWorkedDate(empleadoHorasBeanEntrada.getWorked_date());

			employeWorkedHoursRepo.save(employeeWorkedHours);

			empleadoBean.setId(empleadoHorasBeanEntrada.getEmployee_id());
			empleadoBean.setSuccess(true);

			return empleadoBean;

	}

	@Override
	public EmpleadoBean consultarPuestos(int idJob) {
		// TODO Auto-generated method stub
		return null;
	}

}
