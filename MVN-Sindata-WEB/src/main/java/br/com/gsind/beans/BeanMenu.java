package br.com.gsind.beans;  
  
import javax.faces.application.FacesMessage;  
import javax.faces.context.FacesContext;  

import org.primefaces.model.menu.MenuItem;
import org.primefaces.model.menu.MenuModel;

  
public class BeanMenu {  
  
    private MenuModel model;  
  
//    public BeanMenu() {  
//        model = new DefaultMenuModel();  
//          
//        //First submenu  
//        Submenu submenu = new Submenu();  
//        submenu.setLabel("Dynamic Submenu 1");  
//          
//        //MenuItem item = new MenuItem();  
//        MenuItem.setValue("Dynamic Menuitem 1.1");  
//        MenuItem.setUrl("#");  
//        submenu.getChildren().add(item);  
//          
//        model.addSubmenu(submenu);  
//          
//        //Second submenu  
//        submenu = new Submenu();  
//        submenu.setLabel("Dynamic Submenu 2");  
//          
//        item = new MenuItem();  
//        item.setValue("Dynamic Menuitem 2.1");  
//        item.setUrl("#");  
//        submenu.getChildren().add(item);  
//          
//        item = new MenuItem();  
//        item.setValue("Dynamic Menuitem 2.2");  
//        item.setUrl("#");  
//        submenu.getChildren().add(item);  
//          
//        model.addSubmenu(submenu);  
//    }  
//  
//    public MenuModel getModel() {  
//        return model;  
//    }     
//      
//    public void save() {  
//        addMessage("Data saved");  
//    }  
//      
//    public void update() {  
//        addMessage("Data updated");  
//    }  
//      
//    public void delete() {  
//        addMessage("Data deleted");  
//    }  
//      
//    public void addMessage(String summary) {  
//        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);  
//        FacesContext.getCurrentInstance().addMessage(null, message);  
//    }  
}  