package othello.slothello.ui;

import java.awt.*;
import javax.swing.*;

public class Board implements Runnable {
    private JFrame frame;
    private JButton[][] boardSquares;
    
    
    @Override
    public void run() {
        frame = new JFrame("Slothello");
        frame.setPreferredSize(new Dimension(800, 800));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }
    
    private void createComponents(Container container) {
        GridLayout layout = new GridLayout(8, 8);
        container.setLayout(layout);
        
        boardSquares = new JButton[8][8];
        
        for (int y = 0; y < boardSquares.length; y++) {
            for (int x = 0; x < boardSquares.length; x++) {
                container.add(boardSquares[x][y]);
            }
        }
        
    }

}
