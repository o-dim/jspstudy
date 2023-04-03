package common;

public class ActionForward {
	
	public String path; // 이동할 jsp 경로
	public boolean isRedirect; // 이동방식 (true 이면 redirect)
	public ActionForward() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ActionForward(String path, boolean isRedirect) {
		super();
		this.path = path;
		this.isRedirect = isRedirect;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	
	
}
