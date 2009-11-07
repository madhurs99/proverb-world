package com.proverbworld.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.proverbworld.beans.Proverb;
import com.proverbworld.dao.ProverbDAO;
import com.proverbworld.form.ProverbForm;


public class AdminAction extends DispatchAction {
	
	public  ActionForward edit(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ProverbForm lf = (ProverbForm)form;
		ProverbDAO pdao = new ProverbDAO();
		Proverb eProverb = pdao.getProverb(Integer.parseInt(request.getParameter("id")));
		lf.setProverbBean(eProverb);
		return mapping.findForward("success_edit");
	}
	
	public  ActionForward delete(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("proverbID:"+request.getParameter("id"));
		
		boolean deleted = false;
		ProverbDAO pdao = new ProverbDAO();
		deleted = pdao.deleteProverb(Integer.parseInt(request.getParameter("id")));
		List proverbs = pdao.getProverbs(((String)request.getSession().getAttribute("showApproved")).equals("true"));
		request.getSession().setAttribute("plist", proverbs);
		return mapping.findForward("success_admin");		
		
	}
	
	public  ActionForward approve(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		boolean approved = false;
		ProverbDAO pdao = new ProverbDAO();
		approved = pdao.approveProverb(Integer.parseInt(request.getParameter("id")));
		System.out.println("proverb approved:"+ approved);
			
		List proverbs = pdao.getProverbs(((String)request.getSession().getAttribute("showApproved")).equals("true"));
		request.getSession().setAttribute("plist", proverbs);
		return mapping.findForward("success_admin");		
		
	}	
	
	public  ActionForward showProverbs(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String showApproved = (String)request.getSession().getAttribute("showApproved");
		if(showApproved.equals("false")){
			request.getSession().setAttribute("showApproved", "true");
		}else{
			request.getSession().setAttribute("showApproved", "false");
		}
		ProverbDAO pdao = new ProverbDAO();
		List proverbs = pdao.getProverbs(!Boolean.parseBoolean(showApproved));
		request.setAttribute("plist", proverbs);
		return mapping.findForward("success_admin");
	}
	
	public  ActionForward logout(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.getSession().setAttribute("who", "user");
		List proverbs = null;
		ProverbDAO pdao = new ProverbDAO();
		proverbs = pdao.getProverbs(true);
		request.setAttribute("plist", proverbs);
		request.getSession().setAttribute("who", "user");		
		return mapping.findForward("success_home");
	}
	
}
