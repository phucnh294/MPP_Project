package Common;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class View extends Stage {

	protected Pane primaryPane;
	protected GridPane tilePane;
	
	public View(Pane primaryStage) {
		this.primaryPane = primaryStage;
		
	}
	
	public Pane getPrimaryPane() {
		return primaryPane;
	}

	public GridPane getTilePane() {
		return tilePane;
	}
}
