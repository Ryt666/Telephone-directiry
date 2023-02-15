
	package com.company;

import javax.swing.*;

        public class Main {

            private JFrame window;

            public Main()
            {
                window = new JFrame("Test");
                window.setSize(500,300);
                Panel panel = new Panel();
                window.add(panel);
                window.setLocationRelativeTo(null);
                window.setResizable(false);
                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                window.setVisible(true);
            }






            public static void main(String[] args) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new Main();
                    }
                });


            }
        }


