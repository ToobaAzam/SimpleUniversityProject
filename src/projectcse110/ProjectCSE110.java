
package projectcse110;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ProjectCSE110 {

    public static boolean IsHerebySelected = false;
    public static void main(String[] args) {
      JFrame f1,f2, f3,f4,f5,f31,f32,f33,f41,f51;
      JLabel L1,L2,F2l1,F2l2,F2l3,F2l4,F3l1,F4l1,F5l1;
      JButton F1b1, F2b1,F2b2, F2b3, F3b1,F4b1,F5b1,bk1,bk2,bk3;
      JButton bk31,bk32,bk33,bk41,bk51;
      JButton f1ex1;
      JTextField t1;
     
      f1= new JFrame("XYZ University");
      f1.setSize(500, 500);
      
      L1 = new JLabel("Enter Your Email Address: ");
      L1.setBounds(50,20,200,80);
      
      t1 = new JTextField();
      t1.setBounds(50, 80, 300, 30);
      
      L2 = new JLabel("Enter Password: ");
      L2.setBounds(50, 140, 200, 80);
      
      JPasswordField pw = new JPasswordField();
      pw.setBounds(50, 200, 300, 30);
       
      JRadioButton r1=new JRadioButton("I,hereby agree the terms and conditions."); 
      r1.setBounds(50, 250, 300, 50);
      
      F1b1 = new JButton("Login");
      F1b1.setBounds(100,300,100,30);
      
      f1ex1 = new JButton("Close");
      f1ex1.setBounds(100,350,100,30);
      
       f1.add(L1); f1.add(pw);f1.add(L2);
       f1.add(F1b1);
       f1.add(t1);
       f1.add(r1);
       f1.setLayout(null);
       f1.setVisible(true);
       f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  

       f2=new JFrame("XYZ University");
       f2.setSize(650,650);
      
       F2l1 = new JLabel();
       F2l1.setBounds(100,1,500,100);
    
       JMenu menu1,menu2, menu3,menu;   
       JMenuItem m1i1, m1i2,m2i1,m2i2,m3i1,m3i2;  
       JMenuBar mb1;
       mb1 = new JMenuBar();
       menu = new JMenu("Departments"); 
       
       F2l2 = new JLabel(); 
       F2l2.setBounds(50,40,200,200);
       
       F2b1 = new JButton(new ImageIcon("OIP2.jpg"));
       F2b1.setBounds(250, 150, 140, 95);
       
       F2l3 = new JLabel(); 
       F2l3.setBounds(50,180,200,200);
       
       F2b2 = new JButton(new ImageIcon("OIPstd2.jpg"));
       F2b2.setBounds(250, 300, 140,95);
       
       F2l4 = new JLabel(); 
       F2l4.setBounds(50,320,200,200);
       
       F2b3 = new JButton(new ImageIcon("OIPcrs2.jpg"));
       F2b3.setBounds(250, 450, 140,95);
       
       menu1 = new JMenu("Science and Engineering");
       m1i1 = new JMenuItem("Computer Science & Engineering");
       m1i2 = new JMenuItem("Civil Engineering");
       menu1.add(m1i1);menu1.add(m1i2);
     
       menu2 = new JMenu("Liberal Arts and Social Science");
       m2i1 = new JMenuItem("English");
       m2i2 = new JMenuItem("Law");
       menu2.add(m2i1);menu2.add(m2i2);
       
       menu3 = new JMenu("Bussines and Economics");
       m3i1 = new JMenuItem("Bussiness Administration");
       m3i2 = new JMenuItem("Economics");
       menu3.add(m3i1);menu3.add(m3i2);
       menu.add(menu1); menu.add(menu2); menu.add(menu3);
       
       mb1.add(menu); 
       
       JFrame Mf1,Mf2,Mf3,Mf4,Mf5,Mf6;
       JButton Mbk1,Mbk2,Mbk3,Mbk4,Mbk5,Mbk6;
       JLabel Ml1,Ml2,Ml3,Ml4,Ml5,Ml6;
       
       Mf1=new JFrame("XYZ University");
       Mf1.setSize(700,600);
       
       Ml1 = new JLabel("CSE Course List");
       Ml1.setBounds(200, 2, 300, 100);
       
       Mbk1 = new JButton("Back");
       Mbk1.setBounds(1, 1, 80, 30);
       
      Mf1.add(Ml1); 
      Mf1.add(Mbk1);
      Mf1.setLayout(null);
      Mf1.setVisible(false);
      Mf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
      
      m1i1.addActionListener(new ActionListener() {  
                 public void actionPerformed(ActionEvent e) { 
                  
                         f2.setVisible(false);
                         Mf1.setVisible(true);
                         
                        Mbk1.addActionListener(new ActionListener() {
                             public void actionPerformed(ActionEvent e) {
                                Mf1.setVisible(false);
                                 f2.setVisible(true);
                                 
                             }
                         });
                         try {
                         File fl = new File("CSE Course.txt");
                         int totalLine = (int)Files.lines(Paths.get("CSE Course.txt")).count();
                         Scanner in = new Scanner(fl);
                         String[] col = in.nextLine().trim().split(";");
                         String row[][] = new String[totalLine-1][3];
                         while(in.hasNextLine()) {
                            for (int i=0; i<row.length; i++) {
                                String[] line = in.nextLine().trim().split(";");
                                for (int j=0; j<line.length; j++) {
                                    row[i][j] = line[j];
                                }
                            }
                             JTable Mtb1 = new JTable(row,col);
                             Mtb1.setBounds(10,60,680,300);   
                            JScrollPane sp=new JScrollPane(Mtb1);
                            Mf1.add(sp);
                           Mf1.add(Mtb1);                   
                         }
                     
                     } catch (Exception ex) {
                         Logger.getLogger(ProjectCSE110.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 
                            
                              }
                });    ;
                
       Mf2=new JFrame("XYZ University");
       Mf2.setSize(700,600);
       
       Ml2 = new JLabel("CE Course List");
       Ml2.setBounds(200, 2, 300, 100);
       
       Mbk2 = new JButton("Back");
       Mbk2.setBounds(1, 1, 80, 30);
       
      Mf2.add(Ml2); 
      Mf2.add(Mbk2);
      Mf2.setLayout(null);
      Mf2.setVisible(false);
      Mf2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
      
      m1i2.addActionListener(new ActionListener() {  
                 public void actionPerformed(ActionEvent e) { 
                  
                         f2.setVisible(false);
                         Mf2.setVisible(true);
                         
                        Mbk2.addActionListener(new ActionListener() {
                             public void actionPerformed(ActionEvent e) {
                                Mf2.setVisible(false);
                                 f2.setVisible(true);
                                 
                             }
                         });
                         try {
                         File fl = new File("CE Course.txt");
                         int totalLine = (int)Files.lines(Paths.get("CE Course.txt")).count();
                         Scanner in = new Scanner(fl);
                         String[] col = in.nextLine().trim().split(";");
                         String row[][] = new String[totalLine-1][3];
                         while(in.hasNextLine()) {
                            for (int i=0; i<row.length; i++) {
                                String[] line = in.nextLine().trim().split(";");
                                for (int j=0; j<line.length; j++) {
                                    row[i][j] = line[j];
                                }
                            }
                             JTable Mtb2 = new JTable(row,col);
                             Mtb2.setBounds(10,60,680,300);   
                            JScrollPane sp=new JScrollPane(Mtb2);
                            Mf2.add(sp);
                           Mf2.add(Mtb2);                   
                         }
                     
                     } catch (Exception ex) {
                         Logger.getLogger(ProjectCSE110.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 
                            
                              }
                });    ;
       
       Mf3=new JFrame("XYZ University");
       Mf3.setSize(700,600);
       
       Ml3 = new JLabel("English Course List");
       Ml3.setBounds(200, 2, 300, 100);
       
       Mbk3 = new JButton("Back");
       Mbk3.setBounds(1, 1, 80, 30);
       
      Mf3.add(Ml3); 
      Mf3.add(Mbk3);
      Mf3.setLayout(null);
      Mf3.setVisible(false);
      Mf3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
      
      m2i1.addActionListener(new ActionListener() {  
                 public void actionPerformed(ActionEvent e) { 
                  
                         f2.setVisible(false);
                         Mf3.setVisible(true);
                         
                        Mbk3.addActionListener(new ActionListener() {
                             public void actionPerformed(ActionEvent e) {
                                Mf3.setVisible(false);
                                 f2.setVisible(true);
                                 
                             }
                         });
                         try {
                         File fl = new File("English.txt");
                         int totalLine = (int)Files.lines(Paths.get("English.txt")).count();
                         Scanner in = new Scanner(fl);
                         String[] col = in.nextLine().trim().split(";");
                         String row[][] = new String[totalLine-1][3];
                         while(in.hasNextLine()) {
                            for (int i=0; i<row.length; i++) {
                                String[] line = in.nextLine().trim().split(";");
                                for (int j=0; j<line.length; j++) {
                                    row[i][j] = line[j];
                                }
                            }
                             JTable Mtb3 = new JTable(row,col);
                             Mtb3.setBounds(10,60,680,300);   
                            JScrollPane sp=new JScrollPane(Mtb3);
                            Mf3.add(sp);
                           Mf3.add(Mtb3);                   
                         }
                     
                     } catch (Exception ex) {
                         Logger.getLogger(ProjectCSE110.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 
                            
                              }
                });    ;
       
       Mf4=new JFrame("XYZ University");
       Mf4.setSize(700,600);
       
       Ml4 = new JLabel("Law Course List");
       Ml4.setBounds(200, 2, 300, 100);
       
       Mbk4 = new JButton("Back");
       Mbk4.setBounds(1, 1, 80, 30);
       
      Mf4.add(Ml4); 
      Mf4.add(Mbk4);
      Mf4.setLayout(null);
      Mf4.setVisible(false);
      Mf4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
      
      m2i2.addActionListener(new ActionListener() {  
                 public void actionPerformed(ActionEvent e) { 
                  
                         f2.setVisible(false);
                         Mf4.setVisible(true);
                         
                        Mbk4.addActionListener(new ActionListener() {
                             public void actionPerformed(ActionEvent e) {
                                Mf4.setVisible(false);
                                 f2.setVisible(true);
                                 
                             }
                         });
                         try {
                         File fl = new File("Law.txt");
                         int totalLine = (int)Files.lines(Paths.get("Law.txt")).count();
                         Scanner in = new Scanner(fl);
                         String[] col = in.nextLine().trim().split(";");
                         String row[][] = new String[totalLine-1][3];
                         while(in.hasNextLine()) {
                            for (int i=0; i<row.length; i++) {
                                String[] line = in.nextLine().trim().split(";");
                                for (int j=0; j<line.length; j++) {
                                    row[i][j] = line[j];
                                }
                            }
                             JTable Mtb4 = new JTable(row,col);
                             Mtb4.setBounds(10,60,680,300);   
                            JScrollPane sp=new JScrollPane(Mtb4);
                            Mf4.add(sp);
                           Mf4.add(Mtb4);                   
                         }
                     
                     } catch (Exception ex) {
                         Logger.getLogger(ProjectCSE110.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 
                            
                              }
                });    ;
  
       Mf5=new JFrame("XYZ University");
       Mf5.setSize(700,600);
       
       Ml5 = new JLabel("BBA Course List");
       Ml5.setBounds(200, 2, 300, 100);
       
       Mbk5 = new JButton("Back");
       Mbk5.setBounds(1, 1, 80, 30);
       
      Mf5.add(Ml5); 
      Mf5.add(Mbk5);
      Mf5.setLayout(null);
      Mf5.setVisible(false);
      Mf5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
      
      m3i1.addActionListener(new ActionListener() {  
                 public void actionPerformed(ActionEvent e) { 
                  
                         f2.setVisible(false);
                         Mf5.setVisible(true);
                         
                        Mbk5.addActionListener(new ActionListener() {
                             public void actionPerformed(ActionEvent e) {
                                Mf5.setVisible(false);
                                 f2.setVisible(true);
                                 
                             }
                         });
                         try {
                         File fl = new File("BBA.txt");
                         int totalLine = (int)Files.lines(Paths.get("BBA.txt")).count();
                         Scanner in = new Scanner(fl);
                         String[] col = in.nextLine().trim().split(";");
                         String row[][] = new String[totalLine-1][3];
                         while(in.hasNextLine()) {
                            for (int i=0; i<row.length; i++) {
                                String[] line = in.nextLine().trim().split(";");
                                for (int j=0; j<line.length; j++) {
                                    row[i][j] = line[j];
                                }
                            }
                             JTable Mtb5 = new JTable(row,col);
                             Mtb5.setBounds(10,60,680,300);   
                            JScrollPane sp=new JScrollPane(Mtb5);
                            Mf5.add(sp);
                           Mf5.add(Mtb5);                   
                         }
                     
                     } catch (Exception ex) {
                         Logger.getLogger(ProjectCSE110.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 
                            
                              }
                });    ;
                
       Mf6=new JFrame("XYZ University");
       Mf6.setSize(700,600);
       
       Ml6 = new JLabel("Economics Course List");
       Ml6.setBounds(200, 2, 300, 100);
       
       Mbk6 = new JButton("Back");
       Mbk6.setBounds(1, 1, 80, 30);
       
      Mf6.add(Ml6); 
      Mf6.add(Mbk6);
      Mf6.setLayout(null);
      Mf6.setVisible(false);
      Mf6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
      
      m3i2.addActionListener(new ActionListener() {  
                 public void actionPerformed(ActionEvent e) { 
                  
                         f2.setVisible(false);
                         Mf6.setVisible(true);
                         
                        Mbk6.addActionListener(new ActionListener() {
                             public void actionPerformed(ActionEvent e) {
                                Mf6.setVisible(false);
                                 f2.setVisible(true);
                                 
                             }
                         });
                         try {
                         File fl = new File("Economics.txt");
                         int totalLine = (int)Files.lines(Paths.get("Economics.txt")).count();
                         Scanner in = new Scanner(fl);
                         String[] col = in.nextLine().trim().split(";");
                         String row[][] = new String[totalLine-1][3];
                         while(in.hasNextLine()) {
                            for (int i=0; i<row.length; i++) {
                                String[] line = in.nextLine().trim().split(";");
                                for (int j=0; j<line.length; j++) {
                                    row[i][j] = line[j];
                                }
                            }
                             JTable Mtb6 = new JTable(row,col);
                             Mtb6.setBounds(10,60,680,300);   
                            JScrollPane sp=new JScrollPane(Mtb6);
                            Mf6.add(sp);
                           Mf6.add(Mtb6);                   
                         }
                     
                     } catch (Exception ex) {
                         Logger.getLogger(ProjectCSE110.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 
                            
                              }
                });    ;
                
       f2.setJMenuBar(mb1);
       f2.add(F2l1); f2.add(F2l2);
       f2.add(F2l3); f2.add(F2l4);
       f2.add(F2b1);f2.add(F2b2);f2.add(F2b3);
       f2.setLayout(null);
       f2.setVisible(false);
       f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       f3=new JFrame("XYZ University");
       f3.setSize(400,400);
       
       bk1 = new JButton("Back");
       bk1.setBounds(1, 1, 80, 30);
       
       F3l1 = new JLabel();
       F3l1.setBounds(120, 5, 200, 100);
     
       F3b1 = new JButton("Faculty list");
       F3b1.setBounds(80,80,200,50);

      f3.add(bk1);  
      f3.add(F3l1);
      f3.add(F3b1);

      f3.setLayout(null);
      f3.setVisible(false);
      f3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
      
       f4=new JFrame("XYZ University");
       f4.setSize(400,400);
      
       bk2 = new JButton("Back");
       bk2.setBounds(1, 1, 80, 30);
       
       F4l1 = new JLabel();
       F4l1.setBounds(120, 5, 200, 100);
       
       F4b1 = new JButton("Student list");
       F4b1.setBounds(80,80,200,50);
           
       f4.add(bk2);
       f4.add(F4l1);
       f4.add(F4b1);

      f4.setLayout(null);
      f4.setVisible(false);
      f4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
      
       f5=new JFrame("XYZ University");
       f5.setSize(400,400);
       
       bk3 = new JButton("Back");
       bk3.setBounds(1, 1, 80, 30);
       
       F5l1 = new JLabel();
       F5l1.setBounds(120, 5, 200, 100);
       
       F5b1 = new JButton("Course list");
       F5b1.setBounds(80,80,200,50);

        
      f5.add(bk3);
      f5.add(F5l1);
      f5.add(F5b1);

      f5.setLayout(null);
      f5.setVisible(false);
      f5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
      
      f31=new JFrame("XYZ University");
      f31.setSize(700,600);
      
       bk31 = new JButton("Back");
       bk31.setBounds(1, 1, 80, 30);
      
      f31.add(bk31);
      f31.setLayout(null);
      f31.setVisible(false);
      f31.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
      
       f32=new JFrame("XYZ University");
       f32.setSize(400,400);
      
       bk32 = new JButton("Back");
       bk32.setBounds(1, 1, 80, 30);
     
      f41=new JFrame("XYZ University");
      f41.setSize(700,600);
      
       bk41 = new JButton("Back");
       bk41.setBounds(1, 1, 80, 30);
      
      f41.add(bk41);
      f41.setLayout(null);
      f41.setVisible(false);
      f41.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
      
      f51=new JFrame("XYZ University");
      f51.setSize(700,600);
      
       bk51 = new JButton("Back");
       bk51.setBounds(1, 1, 80, 30);
      
      f51.add(bk51);
      f51.setLayout(null);
      f51.setVisible(false);
      f51.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
      
r1.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent ae) {
            IsHerebySelected = r1.isSelected() ? true: false; 
          }
      });
      
      F1b1.addActionListener(new ActionListener() {  
                public void actionPerformed(ActionEvent e) { 
                    if(IsHerebySelected)
                    {
                        try 
                    {
                        File file1 = new File("xyz university.txt");
                        Scanner in = new Scanner(file1);
                        String str1 = in.nextLine();
                        String str2 = in.nextLine();
                        if(str1.equals(t1.getText()) && str2.equals(new String(pw.getPassword()))){
                            f2.setVisible(true);
                            f1.setVisible(false);
                            F2l1.setText("Welcome To XYZ University");
                            F2l1.setFont(new Font("Verdana", Font.HANGING_BASELINE, 30));
                            F2l2.setText("Faculties :");
                            F2l2.setFont(new Font("Verdana", Font.BOLD, 20));
                            F2l3.setText("Students :");
                            F2l3.setFont(new Font("Verdana", Font.BOLD, 20));
                            F2l4.setText("Courses :");
                            F2l4.setFont(new Font("Verdana", Font.BOLD, 20));
       
         F2b1.addActionListener(new ActionListener() {  
                public void actionPerformed(ActionEvent e) { 
                            f2.setVisible(false);
                            f3.setVisible(true);
                            F3l1.setText("Faculties :");
                            F3l1.setFont(new Font("Verdana", Font.CENTER_BASELINE, 20));
                            
                bk1.addActionListener(new ActionListener() {  
                 public void actionPerformed(ActionEvent e) { 
                            f3.setVisible(false);
                            f2.setVisible(true);
                    
                              }
                });    
                
                F3b1.addActionListener(new ActionListener() {  
                 public void actionPerformed(ActionEvent e) { 
                  
                         f3.setVisible(false);
                         f31.setVisible(true);
                         
                         bk31.addActionListener(new ActionListener() {
                             public void actionPerformed(ActionEvent e) {
                                 f31.setVisible(false);
                                 f3.setVisible(true);
                                 
                             }
                         });
                         try {
                         File fl = new File("Faculty.txt");
                         int totalLine = (int)Files.lines(Paths.get("Faculty.txt")).count();
                         Scanner in = new Scanner(fl);
                         String[] col = in.nextLine().trim().split(";");
                         String row[][] = new String[totalLine-1][3];
                         while(in.hasNextLine()) {
                            for (int i=0; i<row.length; i++) {
                                String[] line = in.nextLine().trim().split(";");
                                for (int j=0; j<line.length; j++) {
                                    row[i][j] = line[j];
                                }
                            }
                             JTable tb1 = new JTable(row,col);
                             tb1.setBounds(10,60,680,300);   
                            JScrollPane sp=new JScrollPane(tb1);
                            f31.add(sp);
                            f31.add(tb1);                   
                         }
                     
                     } catch (Exception ex) {
                         Logger.getLogger(ProjectCSE110.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 
                            
                              }
                });    

                         }
                });    
            
                F2b2.addActionListener(new ActionListener() {  
                public void actionPerformed(ActionEvent e) { 
                            f2.setVisible(false);
                            f4.setVisible(true);
                            F4l1.setText("Students :");
                            F4l1.setFont(new Font("Verdana", Font.CENTER_BASELINE, 20));
                           
                  bk2.addActionListener(new ActionListener() {  
                       public void actionPerformed(ActionEvent e) { 
                            f4.setVisible(false);
                            f2.setVisible(true);
                    
                              }
                }); 
                   F4b1.addActionListener(new ActionListener() {  
                 public void actionPerformed(ActionEvent e) { 
                  
                         f4.setVisible(false);
                         f41.setVisible(true);
                         
                         bk41.addActionListener(new ActionListener() {
                             public void actionPerformed(ActionEvent e) {
                                 f41.setVisible(false);
                                 f4.setVisible(true);
                                 
                             }
                         });
                         try {
                         File fl = new File("Student.txt");
                         int totalLine = (int)Files.lines(Paths.get("Student.txt")).count();
                         Scanner in = new Scanner(fl);
                         String[] col = in.nextLine().trim().split(";");
                         String row[][] = new String[totalLine-1][3];
                         while(in.hasNextLine()) {
                            for (int i=0; i<row.length; i++) {
                                String[] line = in.nextLine().trim().split(";");
                                for (int j=0; j<line.length; j++) {
                                    row[i][j] = line[j];
                                }
                            }
                             JTable tb1 = new JTable(row,col);
                             tb1.setBounds(10,60,680,300);   
                            JScrollPane sp=new JScrollPane(tb1);
                            f41.add(sp);
                            f41.add(tb1);                   
                         }
                     
                     } catch (Exception ex) {
                         Logger.getLogger(ProjectCSE110.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 
                            
                              }
                });    

                  
                         }
                 });  
                
                F2b3.addActionListener(new ActionListener() {  
                public void actionPerformed(ActionEvent e) { 
                            f2.setVisible(false);
                            f5.setVisible(true);
                            F5l1.setText("Courses :");
                            F5l1.setFont(new Font("Verdana", Font.CENTER_BASELINE, 20));
                           
                         bk3.addActionListener(new ActionListener() {  
                          public void actionPerformed(ActionEvent e) { 
                            f5.setVisible(false);
                            f2.setVisible(true);
                    
                              }
                });    
                         
                         F5b1.addActionListener(new ActionListener() {  
                 public void actionPerformed(ActionEvent e) { 
                  
                         f5.setVisible(false);
                         f51.setVisible(true);
                         
                         bk51.addActionListener(new ActionListener() {
                             public void actionPerformed(ActionEvent e) {
                                 f51.setVisible(false);
                                 f5.setVisible(true);
                                 
                             }
                         });
                         try {
                         File fl = new File("Courses.txt");
                         int totalLine = (int)Files.lines(Paths.get("Courses.txt")).count();
                         Scanner in = new Scanner(fl);
                         String[] col = in.nextLine().trim().split(";");
                         String row[][] = new String[totalLine-1][3];
                         while(in.hasNextLine()) {
                            for (int i=0; i<row.length; i++) {
                                String[] line = in.nextLine().trim().split(";");
                                for (int j=0; j<line.length; j++) {
                                    row[i][j] = line[j];
                                }
                            }
                             JTable tb3 = new JTable(row,col);
                             tb3.setBounds(10,60,680,300);   
                            JScrollPane sp=new JScrollPane(tb3);
                            f51.add(sp);
                            f51.add(tb3);                   
                         }
                     
                     } catch (Exception ex) {
                         Logger.getLogger(ProjectCSE110.class.getName()).log(Level.SEVERE, null, ex);
                     }
                       
                              }
                });     
                        
                         }
                });    
                         
                        }
                        
                        else if(!str1.equals(t1.getText())){
                            JOptionPane.showMessageDialog(f1,"Wrong Email Address ","Alert",JOptionPane.WARNING_MESSAGE); 
                        }
                        else {
                             JOptionPane.showMessageDialog(f1,"Wrong Password","Alert",JOptionPane.WARNING_MESSAGE);     
                        }
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(ProjectCSE110.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    }
                    else{
                         JOptionPane.showMessageDialog(f1,"To login you must agree the terms and conditions.","Alert",JOptionPane.WARNING_MESSAGE); 
                    }
                    
                }
                
                });
    }
    }   




