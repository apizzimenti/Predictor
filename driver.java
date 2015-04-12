import java.util.*;
import javax.swing.*;
import java.awt.*;

public class driver extends JApplet {
    
    Container contain = getContentPane();
    JTextArea area = new JTextArea(800, 1000);
    Font except = new Font("Serif", Font.BOLD, 12);
    double strength1, strength2;
    
    public void init() {
        
        strength1 = Double.parseDouble(JOptionPane.showInputDialog("Team1 strength: "));
        strength2 = Double.parseDouble(JOptionPane.showInputDialog("\nTeam2 strength: "));
        
        team x = new team(strength1, strength2);
        x.series();
        x.calc();
        
        contain.add(area);
        area.setFont(except);
        
        area.append(x.toString());
    }
}
