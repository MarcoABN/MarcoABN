
package resources;

import javax.swing.ImageIcon;

 class CellObject {
    
     String text;
     ImageIcon icon;

    public CellObject(String text) {
        this.text = text;
    }

    public CellObject(ImageIcon icon) {
        this.icon = icon;
    }

    public CellObject(String text, ImageIcon icon) {
        this.text = text;
        this.icon = icon;
    }   
}
