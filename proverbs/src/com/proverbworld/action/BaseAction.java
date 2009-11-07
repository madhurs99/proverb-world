package com.proverbworld.action;

import java.util.List;

import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.actions.DispatchAction;

import com.proverbworld.dao.ProverbDAO;
import com.proverbworld.form.ProverbForm;

public class BaseAction extends DispatchAction {
	
	public  ActionForward home(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ProverbDAO pdao = new ProverbDAO();
		List proverbs = pdao.getProverbs(true);
		request.setAttribute("plist", proverbs);
		if(request.getSession().getAttribute("who") == null){
			request.getSession().setAttribute("who", "user");
		}
		return mapping.findForward("success_home");
	}
	
	public  ActionForward post(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ProverbForm pf = new ProverbForm();
		pf.clearForm();
		return mapping.findForward("success_post");
	}
	
	public  ActionForward contact(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return mapping.findForward("success_contact");
	}
	
	public  ActionForward adminlogin(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		if(request.getSession().getAttribute("who")!=null && ((String)request.getSession().getAttribute("who")).equals("admin")){
			ProverbDAO pdao = new ProverbDAO();
			List proverbs = pdao.getProverbs(false);
			request.setAttribute("plist", proverbs);
			return mapping.findForward("success_admin");
		}
		return mapping.findForward("success_adminlogin");
	}	
}
