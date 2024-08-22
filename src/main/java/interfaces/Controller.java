package interfaces;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@FunctionalInterface
public interface Controller{
	void execute(HttpServletRequest req, HttpServletResponse res);
}
