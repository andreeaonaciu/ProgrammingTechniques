package presentation.controller;

import java.sql.SQLException;

import presentation.controller.MenuController;
import presentation.view.*;

public class mainConnection {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
      MainMenuFrame menu=new MainMenuFrame();
      MenuController contr=new MenuController(menu);
		
	}

}
