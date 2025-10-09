
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;

public class View extends JFrame{

    private JButton[][] buttons;   
    private JLabel statusLabel; 
    private Controller controller; 
    private int boardSize; 

    public View(Controller controller, int boardSize) {
        this.controller = controller;
        this.boardSize = boardSize;

        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(false);

        statusLabel = new JLabel("Player X’s turn", SwingConstants.CENTER);
        statusLabel.setFont(new Font("Arial", Font.BOLD, 18));
        statusLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(statusLabel, BorderLayout.NORTH);

        JPanel boardPanel = new JPanel(new GridLayout(boardSize, boardSize));
        buttons = new JButton[boardSize][boardSize];
        add(boardPanel, BorderLayout.CENTER);

        for (int r = 0; r < boardSize; r++) {
            for (int c = 0; c < boardSize; c++) {
                final int row = r;
                final int col = c;

                JButton button = new JButton("");
                button.setFont(new Font("Arial", Font.BOLD, 36));
                button.setFocusPainted(false);
                button.setPreferredSize(new Dimension(100, 100));

                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        controller.handleMove(row, col);
                    }
                });

                buttons[r][c] = button;
                boardPanel.add(button);
            }
        }
        JButton resetButton = new JButton("Restart Game");
        resetButton.setFont(new Font("Arial", Font.PLAIN, 14));
        resetButton.addActionListener(e -> controller.resetGame());
        add(resetButton, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void updateBoard(Board board) {
        for (int r = 0; r < board.getSize(); r++) {
            for (int c = 0; c < board.getSize(); c++) {
                char symbol = board.getIndex(r, c);
                buttons[r][c].setText(symbol == '\0' ? "" : String.valueOf(symbol));
            }
        }
    }

    public void setStatus(String message) {
        statusLabel.setText(message);
    }

    public void disableBoard() {
        for (int r = 0; r < boardSize; r++) {
            for (int c = 0; c < boardSize; c++) {
                buttons[r][c].setEnabled(false);
            }
        }
    }

    public void enableBoard() {
        for (int r = 0; r < boardSize; r++) {
            for (int c = 0; c < boardSize; c++) {
                buttons[r][c].setEnabled(true);
                buttons[r][c].setText("");
            }
        }
    }
}     

