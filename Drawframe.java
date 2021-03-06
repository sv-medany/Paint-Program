/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programming.pkgfinal.paint;

import functionStates.CopyState;
import functionStates.DeleteState;
import functionStates.DrawState;
import functionStates.MoveState;
import functionStates.ResizeState;
import functionStates.SelectState;
import java.awt.Color;
import java.awt.Cursor;

/**
 *
 * @author DR- Mohamed
 */
public class Drawframe extends javax.swing.JFrame {

    /**
     * Creates new form Drawframe
     */
    private Drawframe() {
        initComponents();
        ColorChooser.setColor(Color.BLACK);  //sets the default color to black
    }
    public static Drawframe p = null;

    public static Drawframe getInstance() {   //apply the singleton design pattern
        if (p == null) {
            p = new Drawframe();
        }
        return p;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        drFrame = new programming.pkgfinal.paint.NewBoard();
        lineButton = new javax.swing.JButton();
        rectangleButton = new javax.swing.JButton();
        circleButton = new javax.swing.JButton();
        squareButton = new javax.swing.JButton();
        triangleButton = new javax.swing.JButton();
        undoButton = new javax.swing.JButton();
        ColorChooser = new javax.swing.JColorChooser();
        redoButton = new javax.swing.JButton();
        ResizeButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        SelectButton = new javax.swing.JButton();
        MoveButton = new javax.swing.JButton();
        CopyButton = new javax.swing.JButton();
        FillCheckBox = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        drFrame.setBackground(new java.awt.Color(255, 255, 255));
        drFrame.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                drFrameMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout drFrameLayout = new javax.swing.GroupLayout(drFrame);
        drFrame.setLayout(drFrameLayout);
        drFrameLayout.setHorizontalGroup(
            drFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 648, Short.MAX_VALUE)
        );
        drFrameLayout.setVerticalGroup(
            drFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 432, Short.MAX_VALUE)
        );

        lineButton.setText("Line");
        lineButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lineButtonMouseEntered(evt);
            }
        });
        lineButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lineButtonActionPerformed(evt);
            }
        });

        rectangleButton.setText("Rectangle");
        rectangleButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                rectangleButtonMouseEntered(evt);
            }
        });
        rectangleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rectangleButtonActionPerformed(evt);
            }
        });

        circleButton.setText("Circle");
        circleButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                circleButtonMouseEntered(evt);
            }
        });
        circleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                circleButtonActionPerformed(evt);
            }
        });

        squareButton.setText("Square");
        squareButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                squareButtonMouseEntered(evt);
            }
        });
        squareButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                squareButtonActionPerformed(evt);
            }
        });

        triangleButton.setText("Triangle");
        triangleButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                triangleButtonMouseEntered(evt);
            }
        });
        triangleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                triangleButtonActionPerformed(evt);
            }
        });

        undoButton.setText("Undo");
        undoButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                undoButtonMouseEntered(evt);
            }
        });
        undoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undoButtonActionPerformed(evt);
            }
        });

        redoButton.setText("Redo");
        redoButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                redoButtonMouseEntered(evt);
            }
        });
        redoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redoButtonActionPerformed(evt);
            }
        });

        ResizeButton.setText("Resize");
        ResizeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ResizeButtonMouseEntered(evt);
            }
        });
        ResizeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResizeButtonActionPerformed(evt);
            }
        });

        DeleteButton.setText("Delete");
        DeleteButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DeleteButtonMouseEntered(evt);
            }
        });
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        SelectButton.setText("Select");
        SelectButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SelectButtonMouseEntered(evt);
            }
        });
        SelectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectButtonActionPerformed(evt);
            }
        });

        MoveButton.setText("Move");
        MoveButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MoveButtonMouseEntered(evt);
            }
        });
        MoveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MoveButtonActionPerformed(evt);
            }
        });

        CopyButton.setText("Copy");
        CopyButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CopyButtonMouseEntered(evt);
            }
        });
        CopyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CopyButtonActionPerformed(evt);
            }
        });

        FillCheckBox.setText("filled");
        FillCheckBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                FillCheckBoxMouseEntered(evt);
            }
        });
        FillCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FillCheckBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(drFrame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ColorChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CopyButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rectangleButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lineButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(circleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(squareButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(triangleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(undoButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(redoButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ResizeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DeleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SelectButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MoveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(FillCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(drFrame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(ColorChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(lineButton)
                        .addGap(18, 18, 18)
                        .addComponent(rectangleButton)
                        .addGap(18, 18, 18)
                        .addComponent(circleButton)
                        .addGap(18, 18, 18)
                        .addComponent(squareButton)
                        .addGap(18, 18, 18)
                        .addComponent(triangleButton)
                        .addGap(18, 18, 18)
                        .addComponent(undoButton)
                        .addGap(18, 18, 18)
                        .addComponent(redoButton)
                        .addGap(18, 18, 18)
                        .addComponent(ResizeButton)
                        .addGap(18, 18, 18)
                        .addComponent(DeleteButton)
                        .addGap(18, 18, 18)
                        .addComponent(SelectButton)
                        .addGap(18, 18, 18)
                        .addComponent(MoveButton)
                        .addGap(18, 18, 18)
                        .addComponent(CopyButton)
                        .addGap(18, 18, 18)
                        .addComponent(FillCheckBox)))
                .addContainerGap(78, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lineButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lineButtonActionPerformed
        drFrame.currentColor = ColorChooser.getColor();  
        DrawState s = new DrawState();
        s.doFunction(drFrame);
        drFrame.flush();
        drFrame.returnColor();
        drFrame.clearRecentlyDeleted();
        drFrame.canUndo = true;   
        drFrame.canRedo = false;
        drFrame.clearshapepres();
        drFrame.noOfRedo = 0;
        drFrame.noOfUndo = 0;
        if (FillCheckBox.isSelected()) {
            drFrame.setFill = false;
        } else {
            drFrame.setFill = false;
        }
        drFrame.clearSelected();                       
        drFrame.myshapes = NewBoard.shape.line;    //sets the mode of shapes as line 
    }//GEN-LAST:event_lineButtonActionPerformed

    private void rectangleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rectangleButtonActionPerformed
        DrawState s = new DrawState();
        s.doFunction(drFrame);
        drFrame.currentColor = ColorChooser.getColor();
        drFrame.returnColor();
        drFrame.noOfRedo = 0;
        drFrame.noOfUndo = 0;
        drFrame.clearshapepres();
        drFrame.canUndo = true;
        drFrame.canRedo = false;
        drFrame.clearRecentlyDeleted();
        drFrame.clearSelected();
        drFrame.clearCopyRedoList();
        drFrame.flush();
        drFrame.setFill = FillCheckBox.isSelected();    //check whether the shape must be filled or not
        drFrame.myshapes = NewBoard.shape.rectangle;   //sets the mode of shapes as rectangle
    }//GEN-LAST:event_rectangleButtonActionPerformed

    private void circleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_circleButtonActionPerformed
        drFrame.currentColor = ColorChooser.getColor();
        DrawState s = new DrawState();
        s.doFunction(drFrame);
        drFrame.clearRecentlyDeleted();
        drFrame.noOfRedo = 0;
        drFrame.noOfUndo = 0;
        drFrame.clearshapepres();
        drFrame.canUndo = true;
        drFrame.canRedo = false;
        drFrame.clearCopyRedoList();
        drFrame.returnColor();
        drFrame.clearSelected();
        drFrame.flush();
        drFrame.setFill = FillCheckBox.isSelected();    //check whether the shape must be filled or not
        drFrame.myshapes = NewBoard.shape.circle;    //sets the mode of shapes as circle
    }//GEN-LAST:event_circleButtonActionPerformed

    private void squareButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_squareButtonActionPerformed
        drFrame.currentColor = ColorChooser.getColor();
        DrawState s = new DrawState();
        s.doFunction(drFrame);
        drFrame.clearRecentlyDeleted();
        drFrame.noOfRedo = 0;
        drFrame.noOfUndo = 0;
        drFrame.clearshapepres();
        drFrame.canUndo = true;
        drFrame.canRedo = false;
        drFrame.clearCopyRedoList();
        drFrame.returnColor();
        drFrame.flush();
        drFrame.clearSelected();
        drFrame.setFill = FillCheckBox.isSelected();   //check whether the shape must be filled or not
        drFrame.myshapes = NewBoard.shape.square;    //sets the mode of shapes as square
    }//GEN-LAST:event_squareButtonActionPerformed

    private void triangleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_triangleButtonActionPerformed
        drFrame.currentColor = ColorChooser.getColor();
        DrawState s = new DrawState();
        s.doFunction(drFrame);
        drFrame.flush();
        drFrame.returnColor();
        drFrame.noOfRedo = 0;
        drFrame.clearshapepres();
        drFrame.canUndo = true;
        drFrame.canRedo = false;
        drFrame.noOfUndo = 0;
        drFrame.clearCopyRedoList();
        drFrame.clearRecentlyDeleted();
        drFrame.clearSelected();
        drFrame.setFill = FillCheckBox.isSelected();   //check whether the shape must be filled or not
        drFrame.myshapes = NewBoard.shape.triangle;    //sets the mode of shapes as triangle
    }//GEN-LAST:event_triangleButtonActionPerformed

    private void undoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undoButtonActionPerformed
        drFrame.undo();
    }//GEN-LAST:event_undoButtonActionPerformed

    private void redoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redoButtonActionPerformed
        drFrame.redo();
    }//GEN-LAST:event_redoButtonActionPerformed

    private void ResizeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResizeButtonActionPerformed
        drFrame.clearRecentlyDeleted();
        drFrame.clearSelected();
        drFrame.returnColor();
        drFrame.flush();
        drFrame.noOfRedo = 0;
        drFrame.noOfUndo = 0;
        drFrame.clearshapepres();
        drFrame.canUndo = true;
        drFrame.canRedo = false;
        drFrame.clearCopyRedoList();
        drFrame.returnColor();
        ResizeState s1 = new ResizeState();
        s1.doFunction(drFrame);
        drFrame.myshapes = NewBoard.shape.fady;    
    }//GEN-LAST:event_ResizeButtonActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        DeleteState s2 = new DeleteState();
        s2.doFunction(drFrame);
        drFrame.delete();
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void SelectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectButtonActionPerformed
        drFrame.clearRecentlyDeleted();
        drFrame.returnColor();
        drFrame.noOfRedo = 0;
        drFrame.noOfUndo = 0;
        drFrame.clearshapepres();
        drFrame.canUndo = true;
        drFrame.canRedo = false;
        drFrame.clearCopyRedoList();
        drFrame.clearSelected();
        SelectState s3 = new SelectState();
        s3.doFunction(drFrame);
    }//GEN-LAST:event_SelectButtonActionPerformed

    private void MoveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MoveButtonActionPerformed
        drFrame.clearRecentlyDeleted();
        drFrame.returnColor();
        drFrame.noOfRedo = 0;
        drFrame.clearshapepres();
        drFrame.canUndo = true;
        drFrame.canRedo = false;
        drFrame.noOfUndo = 0;
        drFrame.clearCopyRedoList();
        drFrame.clearSelected();
        MoveState s4 = new MoveState();
        s4.doFunction(drFrame);
    }//GEN-LAST:event_MoveButtonActionPerformed

    private void CopyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CopyButtonActionPerformed
        drFrame.clearRecentlyDeleted();
        drFrame.returnColor();
        drFrame.noOfRedo = 0;
        drFrame.clearshapepres();
        drFrame.clearCopyRedoList();
        drFrame.canUndo = true;
        drFrame.canRedo = false;
        drFrame.noOfUndo = 0;
        drFrame.clearSelected();
        CopyState s5 = new CopyState();
        s5.doFunction(drFrame);
    }//GEN-LAST:event_CopyButtonActionPerformed

    private void FillCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FillCheckBoxActionPerformed
            drFrame.setFill = FillCheckBox.isSelected();
    }//GEN-LAST:event_FillCheckBoxActionPerformed

    private void ResizeButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResizeButtonMouseEntered

        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
        ResizeButton.setCursor(cursor);
        ResizeButton.setVisible(true);
    }//GEN-LAST:event_ResizeButtonMouseEntered

    private void DeleteButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteButtonMouseEntered
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
        DeleteButton.setCursor(cursor);
        DeleteButton.setVisible(true);
    }//GEN-LAST:event_DeleteButtonMouseEntered

    private void SelectButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SelectButtonMouseEntered
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
        SelectButton.setCursor(cursor);
        SelectButton.setVisible(true);
    }//GEN-LAST:event_SelectButtonMouseEntered

    private void MoveButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MoveButtonMouseEntered
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
        MoveButton.setCursor(cursor);
        MoveButton.setVisible(true);
    }//GEN-LAST:event_MoveButtonMouseEntered

    private void redoButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_redoButtonMouseEntered
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
        redoButton.setCursor(cursor);
        redoButton.setVisible(true);
    }//GEN-LAST:event_redoButtonMouseEntered

    private void undoButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_undoButtonMouseEntered
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
        undoButton.setCursor(cursor);
        undoButton.setVisible(true);
    }//GEN-LAST:event_undoButtonMouseEntered

    private void triangleButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_triangleButtonMouseEntered
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
        triangleButton.setCursor(cursor);
        triangleButton.setVisible(true);    }//GEN-LAST:event_triangleButtonMouseEntered

    private void squareButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_squareButtonMouseEntered
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
        squareButton.setCursor(cursor);
        squareButton.setVisible(true);    }//GEN-LAST:event_squareButtonMouseEntered

    private void circleButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_circleButtonMouseEntered
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
        circleButton.setCursor(cursor);
        circleButton.setVisible(true);    }//GEN-LAST:event_circleButtonMouseEntered

    private void rectangleButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rectangleButtonMouseEntered
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
        rectangleButton.setCursor(cursor);
        //rectangleButton.setVisible(true);
    }//GEN-LAST:event_rectangleButtonMouseEntered

    private void lineButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lineButtonMouseEntered
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
        lineButton.setCursor(cursor);
        lineButton.setVisible(true);    }//GEN-LAST:event_lineButtonMouseEntered

    private void CopyButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CopyButtonMouseEntered
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
        CopyButton.setCursor(cursor);
        CopyButton.setVisible(true);    }//GEN-LAST:event_CopyButtonMouseEntered

    private void FillCheckBoxMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FillCheckBoxMouseEntered
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
        FillCheckBox.setCursor(cursor);
        FillCheckBox.setVisible(true);    }//GEN-LAST:event_FillCheckBoxMouseEntered

    private void drFrameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_drFrameMouseEntered
        Cursor cursor = new Cursor(Cursor.CROSSHAIR_CURSOR);
        drFrame.setCursor(cursor);
        drFrame.setVisible(true);
    }//GEN-LAST:event_drFrameMouseEntered

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Drawframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Drawframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Drawframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Drawframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Drawframe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JColorChooser ColorChooser;
    private javax.swing.JButton CopyButton;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JCheckBox FillCheckBox;
    private javax.swing.JButton MoveButton;
    private javax.swing.JButton ResizeButton;
    private javax.swing.JButton SelectButton;
    private javax.swing.JButton circleButton;
    private programming.pkgfinal.paint.NewBoard drFrame;
    private javax.swing.JButton lineButton;
    private javax.swing.JButton rectangleButton;
    private javax.swing.JButton redoButton;
    private javax.swing.JButton squareButton;
    private javax.swing.JButton triangleButton;
    private javax.swing.JButton undoButton;
    // End of variables declaration//GEN-END:variables
}
