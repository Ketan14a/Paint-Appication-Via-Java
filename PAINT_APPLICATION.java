package assignments;
import java.applet.*;
import java.awt.event.*;
import java.awt.*;

public class PAINT_APPLICATION extends Applet implements ActionListener,MouseMotionListener,MouseListener

{
		Button Pencil,Eraser,PB,rectangle,oval,reset;
		Choice size,clr;
		Label lsize,lclr;
		Color mycolor = Color.red;
		int Pf,Ef,PBf,Sqf,of;
		String getColor;
		int sqX1,sqY1,sqX2,sqY2;
		
		public void init()
			
		{
				Pencil = new Button("Pencil");
				Eraser = new Button("Eraser");
				PB = new Button("PaintBrush");
				rectangle = new Button("Rectangle");
				oval = new Button("Oval");
				reset = new Button("Reset all");
				size = new Choice();
				clr = new Choice();
				lsize = new Label("Select size");
				lclr = new Label("Choose color");
				Pf=PBf=Ef=Sqf=of=0;
				
				size.addItem("20");
				size.addItem("30");
				size.addItem("40");
				size.addItem("50");
				size.addItem("60");
				
				clr.addItem("Red");
				clr.addItem("Green");
				clr.addItem("Blue");
				clr.addItem("Black");
				
				setLayout(new FlowLayout());
				Pencil.addActionListener(this);
				Eraser.addActionListener(this);
				PB.addActionListener(this);
				rectangle.addActionListener(this);
				oval.addActionListener(this);
				reset.addActionListener(this);
				addMouseMotionListener(this);
				addMouseListener(this);
				add(Pencil);
				add(Eraser);
				add(PB);
				add(rectangle);
				add(oval);
				add(lsize);
				add(size);
				add(lclr);
				add(clr);
				add(reset);
				
				
			
				
		}
		
		public void paint(Graphics g)
		{
		
		}
		
		
		public void actionPerformed(ActionEvent ae)
		{
			getColor = clr.getSelectedItem();
			if(getColor == "Red")
				mycolor = Color.red;
			else if(getColor == "Green")
				mycolor = Color.green;
			else if(getColor == "Blue")
				mycolor = Color.blue;
			else if(getColor == "Black")
				mycolor = Color.black;
				
			if(ae.getSource()==Pencil)
			{

				Pf=1;
				Ef=PBf=Sqf=of=0;
			}
			else if(ae.getSource()==Eraser)
			{
				Ef=1;
				Pf=PBf=Sqf=of=0;
			}
			else if(ae.getSource()==PB)
			{
				 
				 Pf=Ef=Sqf=of=0;
				 PBf=1;
			}
			else if(ae.getSource()==reset)
			{
				mycolor = Color.red;
				repaint();
			}
			
			else if(ae.getSource()==rectangle)
			{
				Sqf=1;
				Pf=Ef=PBf=of=0;
			}
			else if(ae.getSource()==oval)
			{
				of=1;
				Pf=Ef=PBf=Sqf=0;
			}
		}
		
		public void mouseMoved(MouseEvent me)
		{
			
		}
		
		public void mouseDragged(MouseEvent me)
		{
			int SIZE;
			SIZE = Integer.parseInt(size.getSelectedItem());
			getColor = clr.getSelectedItem();
			if(getColor == "Red")
				mycolor = Color.red;
			else if(getColor == "Green")
				mycolor = Color.green;
			else if(getColor == "Blue")
				mycolor = Color.blue;
			else if(getColor == "Black")
				mycolor = Color.black;
			if(Pf==1 && Ef==0 && PBf==0)
			{
				Graphics g = getGraphics();
				g.setColor(mycolor);
				g.drawOval(me.getX(), me.getY(),1, 1);
				g.fillOval(me.getX(), me.getY(),1, 1);
				

				
			}
			else if(Ef==1 && Pf==0 && PBf==0)
			{
				
					Graphics g = getGraphics();
					g.setColor(Color.white);
					g.drawOval(me.getX(), me.getY(), SIZE, SIZE);
					g.fillOval(me.getX(), me.getY(), SIZE, SIZE);
					

			}
			
			else if(PBf==1 && Ef==0 && Pf==0)
			{
				Graphics g = getGraphics();
				g.setColor(mycolor);
				g.drawOval(me.getX(), me.getY(), SIZE, SIZE);
				g.fillOval(me.getX()+1, me.getY()+1, SIZE, SIZE);
				

			}
			
		} 
		
		
		public void mouseClicked(MouseEvent me)
		{
			
		}
		public void mouseEntered(MouseEvent me)
		{
			
		}
		public void mouseExited(MouseEvent me)
		{
			
		}
		public void mousePressed(MouseEvent me)
		{	
			if(Sqf==1 || of==1)
			sqX1 = me.getX();
			sqY1 = me.getY();
		}
		public void mouseReleased(MouseEvent me)
		{
			Graphics g = getGraphics();
			if(Sqf==1)
			{
				sqY2 = me.getY();
				sqX2 = me.getX();
				g.drawRect(sqX1, sqY1,sqX2,sqY2);
				
			}
			else if(of==1)
			{
				sqY2 = me.getY();
				sqX2 = me.getX();
				g.drawOval(sqX1, sqY1,sqX2,sqY2);
			}
		}
}























