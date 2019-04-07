
package Scientific_Calculate;

    import java.awt.Color;  
    import java.awt.Graphics;  
    import java.awt.Point;  
    import java.awt.Rectangle;  
    import javax.swing.JFrame;
    import javax.swing.JButton;
    import java.awt.FlowLayout;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener; 
    import javax.swing.Timer;

public class Hilbert extends JFrame{  
        static final int DOWN=1;  
        static final int LEFT=2;  
        static final int RIGHT=3;  
        static final int UP=4;  
        static int step;
        
 
        Hilbert(int n){  
            step=n;
            JButton jb=new JButton("OK");
            this.setBounds(200, 200, 800, 800);    
            this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);    
            this.setVisible(true);  
            this.setLayout(new FlowLayout());
            this.add(jb);
            this.setLocation(300,50);
            
            jb.addActionListener(new ActionListener(){
            
                public void actionPerformed(ActionEvent e){
                    dispose();
                }
            });
        }  
        public void paint(Graphics g) {   
            super.paint(g);  
            g.setColor(Color.red);  
            Rectangle rect=new Rectangle(100,100,600,600);  
            drawHilbert(rect,DOWN,step,g);  
        }  
        
        public Point[] drawHilbert(Rectangle rect, int direction,int n,Graphics g){  
            Point[] temp=new Point[2];  
            int width=rect.width/2;  
            int height=rect.height/2;  
            if(n==0){  
                Point p=new Point(rect.x+width,rect.y+height);  
                temp[0]=p;  
                temp[1]=p;  
            }  
            else{  
                Rectangle rect1=new Rectangle(rect.x,rect.y,width,height);  
                Rectangle rect2=new Rectangle(rect.x+width,rect.y,width,height);  
                Rectangle rect3=new Rectangle(rect.x,rect.y+height,width,height);  
                Rectangle rect4=new Rectangle(rect.x+width,rect.y+width,width,height);  
                switch (direction){  
                    case DOWN:{  
                        Point[] point1=drawHilbert(rect1,DOWN,n-1,g);  
                        Point[] point2=drawHilbert(rect2,DOWN,n-1,g);  
                        Point[] point3=drawHilbert(rect3,LEFT,n-1,g);  
                        Point[] point4=drawHilbert(rect4,RIGHT,n-1,g);  
                        g.drawLine(point1[1].x, point1[1].y, point2[0].x,point2[0].y);  
                        g.drawLine(point1[0].x, point1[0].y, point3[0].x,point3[0].y);  
                        g.drawLine(point2[1].x, point2[1].y, point4[0].x,point4[0].y);  
                        try { Thread.sleep ( 1 ) ;
                        } catch (InterruptedException ie){}
                        temp[0]=point3[1];  
                        temp[1]=point4[1];  
                        break;  
                    }  
                    case LEFT:{  
                        Point[] point1=drawHilbert(rect1,UP,n-1,g);  
                        Point[] point2=drawHilbert(rect2,LEFT,n-1,g);  
                        Point[] point3=drawHilbert(rect3,DOWN,n-1,g);  
                        Point[] point4=drawHilbert(rect4,LEFT,n-1,g);  
                        g.drawLine(point1[1].x, point1[1].y, point2[0].x,point2[0].y);  
                        g.drawLine(point3[1].x, point3[1].y, point4[1].x,point4[1].y);  
                        g.drawLine(point2[1].x, point2[1].y, point4[0].x,point4[0].y);  
                        try { Thread.sleep ( 1 ) ;
                        } catch (InterruptedException ie){}
                        temp[0]=point1[0];  
                        temp[1]=point3[0];  
                        break;  
                    }  
                    case RIGHT:{  
                        Point[] point1=drawHilbert(rect1,RIGHT,n-1,g);  
                        Point[] point2=drawHilbert(rect2,UP,n-1,g);  
                        Point[] point3=drawHilbert(rect3,RIGHT,n-1,g);  
                        Point[] point4=drawHilbert(rect4,DOWN,n-1,g);  
                        g.drawLine(point1[0].x, point1[0].y, point2[0].x,point2[0].y);  
                        g.drawLine(point1[1].x, point1[1].y, point3[0].x,point3[0].y);  
                        g.drawLine(point3[1].x, point3[1].y, point4[0].x,point4[0].y);
                        try { Thread.sleep ( 1 ) ;
                        } catch (InterruptedException ie){}
                        temp[0]=point2[1];  
                        temp[1]=point4[1];  
                        break;  
                    }  
                    case UP:{  
                        Point[] point1=drawHilbert(rect1,LEFT,n-1,g);  
                        Point[] point2=drawHilbert(rect2,RIGHT,n-1,g);  
                        Point[] point3=drawHilbert(rect3,UP,n-1,g);  
                        Point[] point4=drawHilbert(rect4,UP,n-1,g);  
                        g.drawLine(point1[1].x, point1[1].y, point3[0].x,point3[0].y);  
                        g.drawLine(point2[1].x, point2[1].y, point4[1].x,point4[1].y);  
                        g.drawLine(point3[1].x, point3[1].y, point4[0].x,point4[0].y);
                        try { Thread.sleep ( 1 ) ;
                        } catch (InterruptedException ie){}
                        temp[0]=point1[0];  
                        temp[1]=point2[0];  
                        break;  
                    }  
                }  
            }  
            return temp;  
        }  
    }
