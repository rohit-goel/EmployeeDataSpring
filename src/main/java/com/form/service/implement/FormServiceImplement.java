package com.form.service.implement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.form.model.FormMV;
import com.form.model.FormVM;
import com.form.model.repository.FormRepository;
import com.form.service.FormService;

@Service
public class FormServiceImplement implements FormService {
	
	@Autowired
	private FormRepository formRepository;
	
	private static final Logger log = LoggerFactory.getLogger(FormServiceImplement.class);

	@Override
	public FormMV getData()  {
		log.info("Entered in Service getData");
		return formRepository.getData();
	}

	@Override
	public FormMV saveData(FormVM formVM) {		
		return formRepository.saveData(formVM);
	}
}