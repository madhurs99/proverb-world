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
		Proverb eProverb = ProverbDAO.getProverb(Integer.parseInt(request.getParameter("id")));
		lf.setProverbBean(eProverb);
		return mapping.findForward("success_edit");
	}
	
	public  ActionForward delete(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("proverbID:"+request.getParameter("id"));
		
		boolean deleted = false;
		String proverbID = request.getParameter("id");
		String proverbIdList = request.getParameter("idList");
		if(proverbID != null){
			deleted = ProverbDAO.deleteProverb(proverbID);
		} else if(proverbIdList != null){
			deleted = ProverbDAO.deleteProverb(proverbIdList);
		}
		List proverbs = ProverbDAO.getProverbs(((String)request.getSession().getAttribute("showApproved")).equals("true"));
		request.getSession().setAttribute("plist", proverbs);
		return mapping.findForward("success_admin");		
		
	}
	
	public  ActionForward approve(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		boolean approved = false;
		String proverbID = request.getParameter("id");
		String proverbIdList = request.getParameter("idList");
		if(proverbID != null){
			approved = ProverbDAO.approveProverb(proverbID);
		} else if(proverbIdList != null){
			approved = ProverbDAO.approveProverb(proverbIdList);
		}
			
		List proverbs = ProverbDAO.getProverbs(((String)request.getSession().getAttribute("showApproved")).equals("true"));
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
		List proverbs = ProverbDAO.getProverbs(!Boolean.parseBoolean(showApproved));
		request.setAttribute("plist", proverbs);
		return mapping.findForward("success_admin");
	}
	
	public  ActionForward logout(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.getSession().setAttribute("who", "user");
		List proverbs = null;
		proverbs = ProverbDAO.getProverbs(true);
		request.setAttribute("plist", proverbs);
		request.getSession().setAttribute("who", "user");		
		return mapping.findForward("success_home");
	}
	
}
