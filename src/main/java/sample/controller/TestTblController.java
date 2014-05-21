package sample.controller;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sample.bean.model.TestTblModel;
import sample.bean.para.InsertTblPara;
import sample.bean.para.SelectTblPara;
import sample.service.TestTblService;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.httpclient.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/***
 * The <code>TestTblController</code> class represents action controller.
 * 1. Explain for a method 
 * 
 * @author  Woong-joon Kim
 * @version 0.1, 12/05/15
 * @see     sample.controller.TestTblController#index()
 * @see     sample.controller.TestTblController#insertTestTbl()
 * @see     sample.controller.TestTblController#selectTestTbl()
 * @since   JDK1.7
 */
@Controller
@RequestMapping("/test")
public class TestTblController {

	final Logger logger = LoggerFactory.getLogger(TestTblController.class);

	@Autowired
	private MessageSource message;
	@Autowired
    private Configuration configuration;
	@Autowired
    private TestTblService testTblService;

	
    /**
     * Index for ......
     * 
     * @param  ModelMap 
     *         model
     *         
     * @throws  Exception
     *          If a error occur, ...
     *
     * @return String
     * 		   a file name of FTL.
     * 
     * @since  1.7
     */
    @RequestMapping(value = {"/", "", "index.sp"}, method=RequestMethod.GET)
	public String index(ModelMap model) throws Exception {
		return "index";
	}

    /**
     * Insert some data into the server.
     * 
     * @param  InsertTblPara 
     *         insertTblPara
     * @param  BindingResult 
     *         bindingResult
     * @param  ModelMap 
     *         model
     * @param  HttpServletResponse 
     *         response
     * @param  HttpServletRequest 
     *         request
     *         
     * @throws  Exception
     *          If a error occur, ...
     *
     * @return String
     * 		   a file name of FTL.
     * 
     * @since  1.6
     */
	@RequestMapping(value = {"insertTestTbl.sp"})
	public String insertTestTbl(@ModelAttribute("insertTblPara") InsertTblPara insertTblPara, 
			BindingResult bindingResult, ModelMap model, HttpServletResponse response, HttpServletRequest request) throws Exception {

		String userJoonId = (String) request.getAttribute("joonId");

		TestTblModel testTblModel = new TestTblModel();

		// Validate the parameters.
		TestTblValidator validator = new TestTblValidator();
		validator.validate(insertTblPara, bindingResult);
		// If it occurs a error, set the default value.
		if (bindingResult.hasErrors()) {
			logger.error("insertTestTbl.sp >>>> it is occured a parameter error.");
			response.setStatus(400);
			model.addAttribute("errorTitle", message.getMessage("test.error.400.title", null, Locale.JAPAN));
			model.addAttribute("errorMessage", message.getMessage("test.error.400.message", null, Locale.JAPAN));

			return "error/error";
		}

		// Execute the transaction
		testTblService.insertTestTbl(insertTblPara);

		testTblModel.setListTestTblBean(testTblService.selectTestTblList(insertTblPara.getTestNum()));
		testTblModel.setListJoonTblBean(testTblService.selectJoonTblList(insertTblPara.getTestNum()));

		model.addAttribute("model", testTblModel);
		model.addAttribute("errorMessage", "Success");

		return "test/selectTestTbl";
	}

    /**
     * Select some data from the server.
     * 
     * @param  SelectTblPara 
     *         selectTblPara
     * @param  BindingResult 
     *         bindingResult
     * @param  ModelMap 
     *         model
     * @param  HttpServletResponse 
     *         response
     * @param  HttpServletRequest 
     *         request
     *         
     * @throws  Exception
     *          If a error occur, ...
     *
     * @return String
     * 		   a file name of FTL.
     * 
     * @since  1.7
     */
	@RequestMapping(value = {"selectTestTbl.sp"})
	public String selectTestTbl(@ModelAttribute("selectTblPara") SelectTblPara selectTblPara, 
			BindingResult bindingResult, ModelMap model, HttpServletResponse response, HttpServletRequest request) throws Exception {

		String userJoonId = (String) request.getAttribute("joonId");

		TestTblModel testTblModel = new TestTblModel();

		testTblModel.setListTestTblBean(testTblService.selectTestTblList(selectTblPara.getTestNum()));
		testTblModel.setListJoonTblBean(testTblService.selectJoonTblList(selectTblPara.getTestNum()));

		model.addAttribute("model", testTblModel);

		return "test/selectTestTbl";
	}

	@ExceptionHandler(Exception.class)
	public void handleException(Exception e, HttpServletResponse response, HttpServletRequest request) throws IOException {
		
		
		
		response.setContentLength(0);
		response.setStatus(HttpStatus.SC_INTERNAL_SERVER_ERROR);
	}

}