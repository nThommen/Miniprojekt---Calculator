public class Controller {

	private final Model model;
	private View view;


	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
		
	}

	public void setView(View view) {
		this.view = view;
	}
	
	
}
