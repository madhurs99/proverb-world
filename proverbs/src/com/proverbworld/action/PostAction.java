package com.proverbworld.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.proverbworld.dao.ProverbDAO;
import com.proverbworld.form.ProverbForm;

public class PostAction extends Action {
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		ProverbForm lf = (ProverbForm)form;
		ProverbDAO.saveProverb(lf.getProverbBean());
		request.setAttribute("posted", "true");
		lf.clearForm();
		return mapping.findForward("success_post");
		
	}
}
