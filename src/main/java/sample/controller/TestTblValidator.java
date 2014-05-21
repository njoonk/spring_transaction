package sample.controller;

import sample.bean.para.InsertTblPara;
import sample.bean.para.SelectTblPara;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class TestTblValidator implements Validator {

	final Logger logger = LoggerFactory.getLogger(TestTblValidator.class);

	public boolean supports(Class<?> clazz) {
		if(InsertTblPara.class.equals(clazz)) {
			return true;
		} else if(SelectTblPara.class.equals(clazz)) {
			return true;
		}else {

			// Though It is not target, execute the controller.
			return true;
		}
	}

	public void validate(Object object, Errors errors) {

		if (object instanceof InsertTblPara) {
			InsertTblPara insertTblPara = (InsertTblPara) object;
	        if(insertTblPara != null) {
	        	// Check a user UuId.
    			if (insertTblPara.getTestNum().equals("100")) {
	    			logger.error("userUuId = " + insertTblPara.getTestNum());
	    			errors.rejectValue("userUuId", "fever.parameter.error.message");
	    		}
	        }

	    } else if (object instanceof SelectTblPara) {

	    	/*
	    	 *  Add to check a validation.
	    	 */

	    }

	}
	
}