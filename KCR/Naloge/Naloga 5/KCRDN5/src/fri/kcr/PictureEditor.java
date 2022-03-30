package fri.kcr;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Adrian Jarc
 */

public class PictureEditor extends javax.swing.JFrame {
    
    BufferedImage tempImage = null;
    String opLog = "Operations:\n";

    /** Creates new form PictureEditor */
    public PictureEditor() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Usability = new javax.swing.JFrame();
        Ok = new javax.swing.JButton();
        UsageScroll = new javax.swing.JScrollPane();
        UsageText = new javax.swing.JTextArea();
        MainPanel = new javax.swing.JTabbedPane();
        EditedScroll = new javax.swing.JScrollPane();
        EditedImage = new fri.kcr.PicturePanel();
        OriginalScroll = new javax.swing.JScrollPane();
        OriginalImage = new fri.kcr.PicturePanel();
        Status = new javax.swing.JLabel();
        Menu = new javax.swing.JMenuBar();
        File = new javax.swing.JMenu();
        Open = new javax.swing.JMenuItem();
        Save = new javax.swing.JMenuItem();
        Separator1 = new javax.swing.JPopupMenu.Separator();
        Quit = new javax.swing.JMenuItem();
        Edit = new javax.swing.JMenu();
        Blur = new javax.swing.JMenuItem();
        Sharpen = new javax.swing.JMenuItem();
        Edges = new javax.swing.JMenuItem();
        Separator2 = new javax.swing.JPopupMenu.Separator();
        Original = new javax.swing.JMenuItem();
        Channels = new javax.swing.JMenu();
        Red = new javax.swing.JMenuItem();
        Green = new javax.swing.JMenuItem();
        Blue = new javax.swing.JMenuItem();
        Help = new javax.swing.JMenu();
        Usage = new javax.swing.JMenuItem();
        aboutAuthor = new javax.swing.JMenuItem();

        Usability.setTitle("Usage");
        Usability.setMinimumSize(new java.awt.Dimension(470, 370));
        Usability.setResizable(false);

        Ok.setText("Ok");
        Ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usageButtons(evt);
            }
        });

        UsageText.setColumns(20);
        UsageText.setEditable(false);
        UsageText.setRows(5);
        UsageText.setText("All avalaible operations are:\n\nBlur - this operation blurs image.\nIt can be found in Menu>Edit\nSharpen - this operation sharpens image.\nIt can be found in Menu>Edit\nEdges - this operation discoveres edges of image.\nIt can be found in Menu>Edit\nOriginal - this operation reverts all changes to image.\nIt can be found in Menu>Edit\nRed - this operation shows only red component of image.\nIt can be found in Menu>Channels\nGreen - this operation  shows only green component of  image.\nIt can be found in Menu>Channels\nBlue - this operation  shows only blue component of  image.\nIt can be found in Menu>Channels");
        UsageText.setEnabled(false);
        UsageScroll.setViewportView(UsageText);

        javax.swing.GroupLayout UsabilityLayout = new javax.swing.GroupLayout(Usability.getContentPane());
        Usability.getContentPane().setLayout(UsabilityLayout);
        UsabilityLayout.setHorizontalGroup(
            UsabilityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(UsageScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
            .addGroup(UsabilityLayout.createSequentialGroup()
                .addGap(193, 193, 193)
                .addComponent(Ok)
                .addContainerGap(215, Short.MAX_VALUE))
        );
        UsabilityLayout.setVerticalGroup(
            UsabilityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UsabilityLayout.createSequentialGroup()
                .addComponent(UsageScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addComponent(Ok))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Picture editor");
        setMinimumSize(new java.awt.Dimension(500, 500));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                close(evt);
            }
        });

        javax.swing.GroupLayout EditedImageLayout = new javax.swing.GroupLayout(EditedImage);
        EditedImage.setLayout(EditedImageLayout);
        EditedImageLayout.setHorizontalGroup(
            EditedImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );
        EditedImageLayout.setVerticalGroup(
            EditedImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 252, Short.MAX_VALUE)
        );

        EditedScroll.setViewportView(EditedImage);

        MainPanel.addTab("Edited image", EditedScroll);

        javax.swing.GroupLayout OriginalImageLayout = new javax.swing.GroupLayout(OriginalImage);
        OriginalImage.setLayout(OriginalImageLayout);
        OriginalImageLayout.setHorizontalGroup(
            OriginalImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );
        OriginalImageLayout.setVerticalGroup(
            OriginalImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 252, Short.MAX_VALUE)
        );

        OriginalScroll.setViewportView(OriginalImage);

        MainPanel.addTab("Original image", OriginalScroll);

        getContentPane().add(MainPanel, java.awt.BorderLayout.CENTER);

        Status.setText("Status: ");
        getContentPane().add(Status, java.awt.BorderLayout.PAGE_END);

        File.setMnemonic('F');
        File.setText("File");

        Open.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        Open.setMnemonic('O');
        Open.setText("Open");
        Open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuButtons(evt);
            }
        });
        File.add(Open);

        Save.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        Save.setMnemonic('S');
        Save.setText("Save");
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuButtons(evt);
            }
        });
        File.add(Save);
        File.add(Separator1);

        Quit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        Quit.setMnemonic('Q');
        Quit.setText("Quit");
        Quit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuButtons(evt);
            }
        });
        File.add(Quit);

        Menu.add(File);

        Edit.setMnemonic('E');
        Edit.setText("Edit");

        Blur.setMnemonic('B');
        Blur.setText("Blur");
        Blur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuButtons(evt);
            }
        });
        Edit.add(Blur);

        Sharpen.setMnemonic('S');
        Sharpen.setText("Sharpen");
        Sharpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuButtons(evt);
            }
        });
        Edit.add(Sharpen);

        Edges.setMnemonic('E');
        Edges.setText("Edges");
        Edges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuButtons(evt);
            }
        });
        Edit.add(Edges);
        Edit.add(Separator2);

        Original.setMnemonic('O');
        Original.setText("Original");
        Original.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuButtons(evt);
            }
        });
        Edit.add(Original);

        Menu.add(Edit);

        Channels.setMnemonic('C');
        Channels.setText("Channels");

        Red.setMnemonic('R');
        Red.setText("Red");
        Red.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuButtons(evt);
            }
        });
        Channels.add(Red);

        Green.setMnemonic('G');
        Green.setText("Green");
        Green.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuButtons(evt);
            }
        });
        Channels.add(Green);

        Blue.setMnemonic('B');
        Blue.setText("Blue");
        Blue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuButtons(evt);
            }
        });
        Channels.add(Blue);

        Menu.add(Channels);

        Help.setText("Help");

        Usage.setText("Usage");
        Usage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuButtons(evt);
            }
        });
        Help.add(Usage);

        aboutAuthor.setText("About author");
        aboutAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuButtons(evt);
            }
        });
        Help.add(aboutAuthor);

        Menu.add(Help);

        setJMenuBar(Menu);

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void menuButtons(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuButtons
    if (evt.getSource() == Open){
        openFile();
    } else if (evt.getSource() == Save){
        saveFile();
    } else if(evt.getSource() == Quit){
        System.out.println("Quiting program.");
        opLog += "-Quit program\n";
        saveOpLog();
        System.exit(0);
    } else if (evt.getSource() == Blur){
        if (EditedImage.returnImage() != null){
            Status.setText("Blurring image.");
            EditedImage.blur();
            tempImage = EditedImage.returnImage();
            opLog += "-Blur image\n";
        } else {
            Status.setText("There is no file open. Please select file first.");
        }
    } else if (evt.getSource() == Sharpen){
        if (EditedImage.returnImage() != null){
            Status.setText("Sharpening image.");
            EditedImage.sharpen();
            tempImage = EditedImage.returnImage();
            opLog += "-Sharpen image\n";
        } else {
            Status.setText("There is no file open. Please select file first.");
        }
    } else if (evt.getSource() == Edges){
        if (EditedImage.returnImage() != null){
            Status.setText("Discovering edges of image.");
            EditedImage.edges();
            tempImage = EditedImage.returnImage();
            opLog += "-Discover edges of image\n";
        } else {
            Status.setText("There is no file open. Please select file first.");
        }
    } else if (evt.getSource() == Original){
        if (!(OriginalImage.returnImage() == null)){
            Status.setText("Reseting all changes.");
            EditedImage.setOriginal(OriginalImage.returnImage());
            tempImage = EditedImage.returnImage();
            opLog += "-Revert all changes to image\n";
        } else {
            Status.setText("There is no file open. Please select file first.");
        }
    } else if (evt.getSource() == Red){
        if (tempImage != null){
            Status.setText("Showing only red component of image.");
            EditedImage.onlyRed(tempImage);
            opLog += "-Show only red component of image\n";
        } else {
            Status.setText("There is no file open. Please select file first.");
        }
    } else if (evt.getSource() == Green){
        if (tempImage != null){
            Status.setText("Showing only green component of image.");
            EditedImage.onlyGreen(tempImage);
            opLog += "-Show only green component of image\n";
        } else {
            Status.setText("There is no file open. Please select file first.");
        }
    } else if (evt.getSource() == Blue){
        if (tempImage != null){
            Status.setText("Showing only blue component of image.");
            EditedImage.onlyBlue(tempImage);
            opLog += "-Show only blue component of image\n";
        } else {
            Status.setText("There is no file open. Please select file first.");
        }
    } else if (evt.getSource() == Usage){
        Usability.setVisible(true);
    } else if (evt.getSource() == aboutAuthor){
        Status.setText("Author: Adrian Jarc");
    }
}//GEN-LAST:event_menuButtons

private void close(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_close
    saveOpLog();
    System.exit(0);
}//GEN-LAST:event_close

private void usageButtons(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usageButtons
    if (evt.getSource() == Ok){
        Usability.setVisible(false);
    }
}//GEN-LAST:event_usageButtons

private void openFile(){
    JFileChooser jfc = new JFileChooser();
        jfc.setAcceptAllFileFilterUsed(false); 
        FileFilter all = new FileNameExtensionFilter("All images", "jpg", "jpeg", "png", "gif", "bmp");
        jfc.addChoosableFileFilter(all);
        if(jfc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
            try{
                Status.setText("Opening file: " + jfc.getSelectedFile().getName());
                OriginalImage.openFile(jfc.getSelectedFile());
                EditedImage.openFile(jfc.getSelectedFile());
                tempImage = EditedImage.returnImage();
                this.setSize(tempImage.getWidth(), tempImage.getHeight());
                opLog += "-Open image\n";
            } catch (Exception e){
                Status.setText("Error opening file.");
                System.err.println(e);
            }
        }
}

private void saveFile(){
    if (EditedImage.returnImage() == null){
            Status.setText("There is no open image. Not saving.");
        } else {
            JFileChooser jfc = new JFileChooser();
            jfc.setAcceptAllFileFilterUsed(false); 
            FileFilter jpg = new FileNameExtensionFilter("JPG", "jpg");
            FileFilter png = new FileNameExtensionFilter("PNG", "png");
            FileFilter gif = new FileNameExtensionFilter("GIF", "gif");
            jfc.addChoosableFileFilter(jpg);
            jfc.addChoosableFileFilter(png);
            jfc.addChoosableFileFilter(gif);
            if(jfc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION){
                File f = jfc.getSelectedFile();
                try {
                    tempImage = EditedImage.returnImage();
                    String ext = "";
                    if(jfc.getFileFilter() == jpg){
                        ext = "jpg";
                    } else if (jfc.getFileFilter() == png){
                        ext = "png";
                    } else if (jfc.getFileFilter() == gif){
                        ext = "gif";
                    }
                    if (!(f.getName().contains("."))){
                        f = new File(jfc.getSelectedFile() + "." + ext);
                    }
                    ImageIO.write(tempImage, ext, f);
                    Status.setText("Saved file: " + f.getName());
                    opLog += "-Save picture\n";
                } catch (Exception e){
                    Status.setText("Error while saving file!");
                    System.err.println(e);
                }
            }
        }
}



private void saveOpLog(){
    File f = new File("Operations log");
    try {
    PrintWriter out = new PrintWriter(new FileWriter(f));
    out.print(opLog);
    out.close();
    } catch (Exception e){
        System.err.println(e);
    }
}

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
            java.util.logging.Logger.getLogger(PictureEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PictureEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PictureEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PictureEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new PictureEditor().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Blue;
    private javax.swing.JMenuItem Blur;
    private javax.swing.JMenu Channels;
    private javax.swing.JMenuItem Edges;
    private javax.swing.JMenu Edit;
    private fri.kcr.PicturePanel EditedImage;
    private javax.swing.JScrollPane EditedScroll;
    private javax.swing.JMenu File;
    private javax.swing.JMenuItem Green;
    private javax.swing.JMenu Help;
    private javax.swing.JTabbedPane MainPanel;
    private javax.swing.JMenuBar Menu;
    private javax.swing.JButton Ok;
    private javax.swing.JMenuItem Open;
    private javax.swing.JMenuItem Original;
    private fri.kcr.PicturePanel OriginalImage;
    private javax.swing.JScrollPane OriginalScroll;
    private javax.swing.JMenuItem Quit;
    private javax.swing.JMenuItem Red;
    private javax.swing.JMenuItem Save;
    private javax.swing.JPopupMenu.Separator Separator1;
    private javax.swing.JPopupMenu.Separator Separator2;
    private javax.swing.JMenuItem Sharpen;
    private javax.swing.JLabel Status;
    private javax.swing.JFrame Usability;
    private javax.swing.JMenuItem Usage;
    private javax.swing.JScrollPane UsageScroll;
    private javax.swing.JTextArea UsageText;
    private javax.swing.JMenuItem aboutAuthor;
    // End of variables declaration//GEN-END:variables
}
