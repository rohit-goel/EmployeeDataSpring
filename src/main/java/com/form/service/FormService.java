package com.form.service;



import com.form.model.FormMV;
import com.form.model.FormVM;

/*
 * Service of the Employee
*/
public interface FormService {
	public FormMV getData() ;

	public FormMV saveData(FormVM formVM);
}
