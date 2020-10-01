package com.pmt.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pmt.dao.SystemControlSelectDao;
import com.pmt.dao.SystemControlUpdatetDao;
import com.pmt.util.Common;

@Controller
@RequestMapping("/ChangeInterval")
public class ChangeIntervalController {
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView init(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView();
		if(Common.isManager(request))
		{
			
			try {
				SystemControlSelectDao select = new SystemControlSelectDao("INTERVAL_CD");
				String interval_cd = select.excute();
				mv.addObject("interval_cd", interval_cd);
				 select = new SystemControlSelectDao("LOAD_CD");
				String load_cd = select.excute();
				mv.addObject("load_cd", load_cd);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			mv.setViewName("/views/ChangeInterval.jsp");
		}
		else
		{
			mv.setViewName("redirect:/login");
		}
		return mv;
	}
	
	
	@RequestMapping(params="save", method=RequestMethod.POST)
	public ModelAndView ChangePin(HttpServletRequest request , RedirectAttributes att)
	{
		ModelAndView mv = new ModelAndView();
		if(Common.isManager(request))
		{
			String interval_cd = request.getParameter("interval_cd");
			String load_cd = request.getParameter("load_cd");
			if(Common.isNotEmpty(interval_cd) || Common.isNotEmpty(load_cd))
			{
				SystemControlUpdatetDao up = new SystemControlUpdatetDao("INTERVAL_CD", interval_cd.trim());
				try {
					up.excute();
					up = new SystemControlUpdatetDao("LOAD_CD", load_cd.trim());
					up.excute();
					att.addFlashAttribute(Common.MESSAGE_NOTIFICATION, "THAY ĐỔI THỜI GIAN THÀNH CÔNG");

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
			else
			{
				att.addFlashAttribute(Common.MESSAGE_ERROR, "THỜI GIAN LÀ BẮT BUỘC");
			}
			mv.setViewName("redirect:/ChangeInterval");
		}
		else
		{
			mv.setViewName("redirect:/login");
		}
		return mv;
	}

}
