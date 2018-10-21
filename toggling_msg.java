package assignments;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class toggling_msg extends Applet implements Runnable,ActionListener

{
		Thread t;
		Button b;
		TextField tf;
		String s;
		char part;
		int df;
		
		public void init()
			
		{
				t = new Thread(this);
				b = new Button("TOGGLE");
				tf = new TextField(20);
				s = "BURNING IN THE SKIES ";
				
				t.start();
				df=0; //left direction <--
				
				setLayout(new FlowLayout());
				add(tf);
				add(b);
				b.addActionListener(this);
		}
		
		public void paint(Graphics g)
		{
			tf.setText(s);
		}
		
		public void run()
			
		{
			while(true)
			{
				if(df==0)
				{
					part=s.charAt(0);
					s=s.substring(1, s.length())+part;
					repaint();
					try {
						t.sleep(80);
						
					} catch (Exception e)
					{
					
					}
				}
				
				else
				{
					
					part=s.charAt(s.length()-1);
					s=s.substring(0,s.length()-1);
					s=part+s;
					repaint();
					try {
						t.sleep(80);
						
					} catch (Exception e)
					{
					
					}
				}
			}
				
		}
		
		
		public void actionPerformed(ActionEvent ae)
		{
			if(df==0)
			{
				df=1; //right direction -->
			}
			else if(df==1)
			{
				df=0;
			}
		}
	

}

