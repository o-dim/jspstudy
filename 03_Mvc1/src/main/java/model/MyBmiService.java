package model;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;

public class MyBmiService implements MyService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		Optional<String> opt1 = Optional.ofNullable(request.getParameter("height"));
		int height = Integer.parseInt(opt1.orElse("0"));
		Optional<String> opt2 = Optional.ofNullable(request.getParameter("weight"));
		double weight = Double.parseDouble(opt2.orElse(""));
		
		double bmi = weight / (height * height * 0.0001);
		String health = "";
		if(bmi < 20) {
			health = "저체중";
		} else if (bmi < 25) {
			health = "정상";
		} else {
			health = "비만";
		}
		
		request.setAttribute("bmi", bmi);
		request.setAttribute("health", health);
		
		ActionForward actionForward = new ActionForward();
		actionForward.setPath("view/output.jsp");
		actionForward.setRedirect(false);
		
		return actionForward;
	}

}
