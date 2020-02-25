package game;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class gameGui {

    final ArrayList<JFrame> frames = new ArrayList<>();
    final ArrayList<JButton> buttons = new ArrayList<>();
    final ArrayList<JPanel> panels = new ArrayList<>();

    //set up canvas this is the home page
    public void setupFrames(int w, int h, int rows, int cols) {
        for (frame_name n : frame_name.values()) {
            JPanel panel = new JPanel(new GridLayout(rows, cols));
            JFrame frame = new JFrame(String.valueOf(n));
            frame.setName(String.valueOf(n));
            frame.setSize(w, h);
            frame.setVisible(false);
            panel.setName(String.valueOf(n));
            frame.add(panel);
            frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
            frames.add(frame);
            panels.add(panel);
        }
    }

    public void createBackButton(gameGui.frame_name name) {
        JButton backButton = createButton("Back");
        backButton.addActionListener(e -> updateFrame(frame_name.HOME));
        addButton(backButton);
        addButtonsToFrame(name);
    }
    //create a method to add back button to frames

    //change frames based on what button is clicked
    public void updateFrame(gameGui.frame_name name) {

        toggleFrameVisibility(name);

        if (name == frame_name.SHOP_ARMOR) {
            createBackButton(name);
        } else if (name == frame_name.SHOP_WEAPONS) {
            createBackButton(name);
        } else if (name == frame_name.SHOP_FOOD) {
            createBackButton(name);
        } else if (name == frame_name.SHOP_MINERALS) {
            createBackButton(name);
        } else if (name == frame_name.UPGRADE_ARMOR) {
            createBackButton(name);
        } else if (name == frame_name.UPGRADE_WEAPON) {
            createBackButton(name);
        } else if (name == frame_name.FORAGE) {
            createBackButton(name);
        } else if (name == frame_name.FIGHT) {
            createBackButton(name);
        }
    }

    public void addButton(JButton button) {
        this.buttons.add(button);
    }

    public void removeButtons(ArrayList<JButton> buttons) {
        this.buttons.removeAll(buttons);
    }

    public void addButtonsToFrame(frame_name name) {
        for (JFrame frame : frames) {
            if (frame.getName().equalsIgnoreCase(String.valueOf(name))) {
                for (JPanel jPanel : panels) {
                    if (jPanel.getName().equalsIgnoreCase(String.valueOf(name))) {
                        for (JButton jButton : buttons) {
                            jPanel.add(jButton);
                        }
                        removeButtons(buttons);
                        frame.add(jPanel);
                    }
                }
            }
        }
    }

    public JButton createButton(String title) {
        return new JButton(title);
    }

    public void toggleFrameVisibility(frame_name name) {
        for (JFrame jFrame : frames) {
            if (jFrame.getName().equalsIgnoreCase(String.valueOf(name).toLowerCase())) {
                jFrame.setVisible(true);
            } else {
                jFrame.setVisible(false);
            }
        }
    }

    enum frame_name {HOME, SHOP_ARMOR, SHOP_FOOD, SHOP_WEAPONS, SHOP_MINERALS, UPGRADE_ARMOR, UPGRADE_WEAPON, FORAGE, FIGHT}

}
