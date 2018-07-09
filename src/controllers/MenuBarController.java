package controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import resources.IConstant;

import java.io.File;
import java.io.IOException;

public class MenuBarController implements IConstant{


    @FXML
    public void menuBarButton(ActionEvent event) {
        try {
            saveNewMoviesToSER(MOVIE_FILE);

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            System.exit(1);
        }
    }

    private void saveNewMoviesToSER(File file) throws IOException {

        //OLD PRODUCT CODE, ADAPT TO MOVIE
/*        FileOutputStream fileOut = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOut);
        ArrayList<Product> productArrayList = new ArrayList<>(products);
        objectOutputStream.writeObject(productArrayList);
        objectOutputStream.close();
        fileOut.close();*/
    }


}
