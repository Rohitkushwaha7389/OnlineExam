import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;
class login extends JFrame implements ActionListener{

    JButton b1;
    JPanel newPanel;
    JLabel userJLabel,passJLabel;
    final JTextField textField1,textField2;
    login(){
        AbstractButton userLabel = new JLable();
        userLabel.setText("username");
        textField1=new JTextField(15);
        passLabel=new JLabel();
        passLabel.setText("Password");
        textField2=new JPasswordField(8);
      b1=new JButton("SUBMIT");
      newPanel=new JPanel(new GridLayout(3,1));
      newPanel.add(userLabel);
      newPanel.add(textField1);
      newPanel.add(passLabel);
      newPanel.add(textField1);
      newPanel.add(b1);
      add(newPanel,BorderLayout.CENTER);
      b1.addActionListener(this);
      setTitle("Login Form");
    }
    public void actionperformed(ActionEvent ae){
        String userValue=textField1.getText();
        String passValue=textField2.getText();
        if(!passValue.equals(" "))
                     new onlineTextBegin(userValue);
                     else{
                        textField2.setText("Enter Password");
                        actionperformed(ae);
                     }
    }
}
class OnlineTextBegin extends JFrame implements ActionListener{
    JLabel l;
    JLabel l1;
    JRadioButton jb[]=new JRadioButton[6];
    JButton b1,b2,log;
    ButtonGroup bg;
    int count=0,current=0,x=1,y=1,now=0;
    int m[]=new int[10];
    Timer timer=new Timer();
    onlineTextBegin(String s){
        super(s);
        l=new JLabel();
        add(l);
        add(l1);
        bg=new ButtonGroup();
        for(int i=0;i<5;i++){
            jb[i]=new  JRadioButton();
            add(jb[i]);
            bg.add(jb[i]);
        }
        b1=new JButton("Save and next");
        b2=new JButton("Save for later");
        b1.addActionListener(this);
        b1.addActionListener(this);
        add(b1);add(b2);
        set();
        l.setBounds(30,40,450,20);
        l1.setBounds(20,20,450,20);
        jb[0].setBounds(50,80,100,20);
        jb[1].setBounds(50,110,100,20);
        jb[2].setBounds(50,140,100,20);
        jb[3].setBounds(50,170,100,20);
        b1.setBounds(95,240,140,20);
        b2.setBounds(270,240,150,30);
        SetDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250,100);
        setVisible(true);
        setSize(600,350);
        timer.scheduleAtfixedRate(new TimerTask(){
            int i=600;
            public void run(){
                l1.setText("Time left"+i);
                i--;
                if(i<0){
                    timer.cancel();
                    l1.setText("Time out");
                }
            }
        },0,1000);
    }
    public void actionperformed(ActionEvent e){
        if(e.getSource()==b1){
            if(check())
            count=count+1;
            current++;
            set();
            if(current==9){
                b1.setEnabled(false);
                b2.setText("Result");
            }
        }
        if(e.getActionCommand().equals("Save for Later"))
        {
            JButton bk=new JButton("review"+x);
            bk.setBounds(480,20+30*x,100,30);
            add(bk);
            bk.addActionListener(this);
            m[x]=current;
            x++;
            current++;
            set();
            if(current==9)
            b2.setBounds("Result");
            setVisible(false);
            setVisible(true);
        }
        for(int i=0,y=1;i<x;i++,y++){
         if(e.getActionCommand().equals("Review"+y))
         {
            if(check())
             count=count+1;
             now=current;
             current=m[y];
             set();
             ((JButton)e.getSource()).setEnabled(false);
             current now;

            
         }
        }
        if(e.getActionCommand().equals("Result"))
        {
            if(check())
            count=count+1;
            current++;
            JOptionPane.ShowMessageDialog(this,"Score="+count);
            System.exit(0);
        }
    }
    void set(){
        jb[4].setSelected(true);
        if(current==0){
            l.setText("Q.1: who is known as a father of java programming language");
            jb[0].setText("Charls Babbage");jb[1].setText("Games Gosling");
            jb[2].setText("M.P java");jb[3].setText("pascal");
        }
        if(current==1){
            l.setText("Q2: Number of primitve data type in java ?");
            jb[0].setText("6");jb[1].setText("7");
            jb[2].setText("8");jb[3].setText("9");
        }
        if(current==2){
            l.setText("Q3: when is system class identify");
            jb[0].setText("java.lang.package");jb[1].setText("java.util.Package");
            jb[2].setText("java.io.pacakage");jb[3].setText("none");
        }
        if(current==3){
            l.setText("Q4:expected created by by try blockis caught in which block ?");
            jb[0].setText("Catch");jb[1].setText("throw");
            jb[2].setText("final");jb[3].setText("thrownl");
        }
        if(current==4){
            l.setText("Q5:which of the following is not an oops concept in java");
            jb[0].setText("polymorphism");jb[1].setText("inheritance");
            jb[2].setText("compilation");jb[3].setText("Encapsulation");
        }
        if(current==5){
            l.setText("Q6:identify the infinite loop");
            jb[0].setText("for(; ;)");jb[1].setText("for()i=0;j<1;i++");
            jb[2].setText("for(int i=0;i++)");jb[3].setText("All of the");
        }
        if(current==6){
            l.setText("Q7: when is the finalized method called");
            jb[0].setText("Before garbage collection");jb[1].setText("Before an object goes out of scope");
            jb[2].setText("Before a ");jb[3].setText("None");
        }
        if(current==7){
            l1.setText("Q8:what is implicit types of constractor");
            jb[0].setText("No return type");jb[1].setText("A class object in which it is a defined");
            jb[2].setText("void");jb[3].setText("None");
        }
        if(current==8){
            l.setText("Q9: The class at the top of exception class is .....?");
            jb[0].setText("Arithemetic Exception");jb[1].setText("Throwable");
            jb[2].setText("Object");jb[3].setText("consol");
        }
        if(current==9){
            l.setText("Q10: which provide return type environment for java byte code to be executed ?");
            jb[0].setText("jdk");jb[1].setText("jvm");
            jb[2].setText("PJRE");jb[3].setText("javac");
        }
        l.setBounds(50,80+i,200,20);
    }
    boolean check(){
        if(current==0)
            return(jb[1].isSelected());
         if(current==1)
            return(jb[1].isSelected());
         if(current==2)
            return(jb[2].isSelected());
         if(current==3)
            return(jb[0].isSelected());
         if(current==4)
            return(jb[2].isSelected());
         if(current==5)
            return(jb[3].isSelected());
         if(current==6)
            return(jb[1].isSelected());
         if(current==7)
            return(jb[3].isSelected());
         if(current==8)
            return(jb[2].isSelected());
         if(current==9)
            return(jb[2].isSelected());
            return false;
    }
}
public class OnlineExam {
    public static void main(String[] args) {

        try{
            Login form=new Login();
            form.size(400,150);
            form.setVisible(true);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        
    }
}
