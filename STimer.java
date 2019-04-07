
package Scientific_Calculate;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
/**
 *
 * @author syz
 */
class STimer extends JFrame
implements ActionListener{

    private JTextField secsField,minsField;
    private JLabel secsLabel,minsLabel;
    private int ticks=0;
    private Timer timer;
    
    public void createGUI(){
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        Container window=getContentPane();
        window.setLayout(new FlowLayout());
        JButton jb=new JButton("GOT IT");
        
        
        minsLabel=new JLabel("minutes");
        window.add(minsLabel);
        
        minsField=new JTextField("0",5);
        window.add(minsField);
        
        secsLabel=new JLabel("seconds");
        window.add(secsLabel);
        
        secsField=new JTextField("0",5);
        window.add(secsField);
        
        window.add(jb);
        jb.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dispose();
            }
        });
        
        timer=new Timer(1000,this);
        timer.start();
        
        
    }
    public void actionPerformed(ActionEvent event){
        minsField.setText(Integer.toString(ticks/60));
        secsField.setText(Integer.toString(ticks%60));
        ticks++;
    }
    
}
