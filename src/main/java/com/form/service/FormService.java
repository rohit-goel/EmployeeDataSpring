package com.form.service;

import java.util.ArrayList;

import com.form.model.FormMV;
import com.form.model.FormVM;

/*
 * Service of the Employee
*/
public interface FormService {
	public ArrayList<FormMV> getData() ;

	public FormMV saveData(FormVM formVM);
}
