package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class DsController {
	@FXML
    private Button showBtn;

	@FXML
    private void onShowCon() {
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("/Pane.fxml"));
    		Parent conRoot = loader.load();
			Stage conStage = new Stage();

			PaneController converController =  loader.getController();
			converController.init(this, conStage);



			conStage.setTitle("Con");
			conStage.setScene(new Scene(conRoot));
			conStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
    }
}
