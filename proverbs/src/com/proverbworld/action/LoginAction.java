package com.proverbworld.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.proverbworld.dao.ProverbDAO;
import com.proverbworld.form.LoginForm;

public class LoginAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		LoginForm lf = (LoginForm)form;
		ProverbDAO pdao = new ProverbDAO();

		if(pdao.login(lf.getUsername(), lf.getPassword())){
			lf.setPassword("");
			lf.setUsername("");
			try{
				
				System.out.println("LoginAction:execute()");
				
				//ProverbDAO pdao = new ProverbDAO();
				List proverbs = pdao.getProverbs(false);
				request.setAttribute("plist", proverbs);
				request.getSession().setAttribute("who", "admin");
				request.getSession().setAttribute("showApproved", "false");
				return mapping.findForward("success_admin");
				}catch(Exception e){
					System.out.println("******************************1");
					return null;
				}			
			
		}else{
			return mapping.findForward("unauthorised");
		}
	}
		
	
}
