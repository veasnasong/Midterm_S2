package Swing;

import javax.swing.*;

public class Main_Locker {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Locker_App frame = new Locker_App();
                frame.setVisible(true);
            }
        });
    }

}
