
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;
class myframe
{
	JFrame f;
	JLabel l1,l2,l3,l4;
	JTextField t1,t2,t3,t4;
	JButton b1,b2,b3,b4,b5,b6,b7;
	myframe()
	{	
		f=new JFrame("Computer Information System");
		f.getContentPane().setLayout(null);
		l1=new JLabel("Model No.");
		t1=new JTextField(15);
		l2=new JLabel("Comapny");
		t2=new JTextField(15);
		l3=new JLabel("Price");
		t3=new JTextField(25);
		l4=new JLabel("Discount");
		t4=new JTextField(15);
		b1=new JButton("|<");
		b2=new JButton("<");
		b3=new JButton(">");
		b4=new JButton(">|");
		b5=new JButton("Add");
		b6=new JButton("Delete");
		b7=new JButton("Search");
		b4.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				fileread a=new fileread();
				try
				{
					a.read();
				}
				catch(Exception e){}
				t1.setText(a.model_no.substring(0,8));
				t2.setText(a.company.substring(0,12));
				t3.setText(a.price.substring(0,12));
				t4.setText(a.discount.substring(0,13));
			}
        	
        	});
		b7.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				search a=new search();
				try
				{
					a.read(t1.getText(),t2.getText(),t3.getText(),t4.getText());
				}
				catch(Exception e){}
				String t11=t1.getText();
				String t22=t2.getText();
				String t33=t3.getText();
				String t44=t4.getText();
				String p=" ";
				for(int i=t11.length();i<8;i++)
				{
					t11=t11+p;
				}
				for(int j=t22.length();j<12;j++)
				{
					t22=t22+p;
				}
				for(int k=t33.length();k<12;k++)
				{
					t33=t33+p;
				}
				for(int l=t44.length();l<13;l++)
				{
					t44=t44+p;
				}
				if(t11.equals(a.model_no)||t22.equals(a.company)||t33.equals(a.price)||t44.equals(a.discount))
				 {
				 t1.setText(a.model_no.substring(0,7));
				 t2.setText(a.company.substring(0,11));
				 t3.setText(a.price.substring(0,11));
				 t4.setText(a.discount.substring(0,12));
				 }
				 else
				 {
					JOptionPane.showMessageDialog(f, "No Match Found");
				}
			}
        	
        	});
		
		b5.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				String model_no,company,price,discount;
				String model_no1=" ";
				String company1=" ";
				String price1=" ";
				String discount1=" ";
				model_no=t1.getText().toString();
				for(int i=model_no.length();i<7;i++)
				{
					model_no1=model_no1+" ";
				}
				company=t2.getText().toString();
				for(int j=company.length();j<11;j++)
				{
					company1=company1+" ";
				}
				price=t3.getText().toString();
				for(int k=price.length();k<11;k++)
				{
					price1=price1+" ";
				}
				discount=t4.getText().toString();
				for(int l=discount.length();l<12;l++)
				{
					discount1=discount1+" ";
				}
				try
				{
					FileWriter w1=new FileWriter("projectnotepad.txt",true);
					w1.write(System.getProperty("line.separator"));
					w1.write(model_no+model_no1+"| ");
					w1.write(company+company1+"| ");
					w1.write(price+price1+"| ");
					w1.write(discount+discount1+"| ");
					JOptionPane.showMessageDialog(f, "Data Added");
					w1.close();
				}
					catch(Exception e){
					JOptionPane.showMessageDialog(f, "Error");
					}		
			}
		});
		b1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				data d=new data();
				try
				{
					d.read(1);
				}
				catch(Exception e){}
				t1.setText(d.model_no);
				t2.setText(d.company);
				t3.setText(d.price);
				t4.setText(d.discount);
			}
        	});
		b2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				rownum r=new rownum();
				data d=new data();
				try
				{
					int i=r.read(t1.getText());
					d.read(i-1);
				}
				catch(Exception e){}
				t1.setText(d.model_no);
				t2.setText(d.company);
				t3.setText(d.price);
				t4.setText(d.discount);
			}
        	});
		b3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				rownum r=new rownum();
				data d=new data();
				try
				{
					int i=r.read(t1.getText());
					d.read(i+1);
				}
				catch(Exception e){}
				t1.setText(d.model_no);
				t2.setText(d.company);
				t3.setText(d.price);
				t4.setText(d.discount);
			}
        	});
		b6.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");				
			}
		});
		l1.setBounds(50,20,120,27);
		l2.setBounds(50,90,120,27);
		l3.setBounds(50,160,120,27);
		l4.setBounds(50,230,120,27);
		t1.setBounds(220,20,180,27);
		t2.setBounds(220,90,180,27);
		t3.setBounds(220,160,180,27);
		t4.setBounds(220,230,180,27);
		b1.setBounds(50,300,80,27);
		b2.setBounds(140,300,80,27);
		b3.setBounds(230,300,80,27);
		b4.setBounds(320,300,80,27);
		b5.setBounds(50,370,80,27);
		b6.setBounds(185,370,80,27);
		b7.setBounds(320,370,80,27);
		l1.setForeground(Color.blue);
		l2.setForeground(Color.blue);
		l3.setForeground(Color.blue);
		l4.setForeground(Color.blue);
		f.getContentPane().add(l1);
		f.getContentPane().add(l2);
		f.getContentPane().add(l3);
		f.getContentPane().add(l4);
		f.getContentPane().add(t1);
		f.getContentPane().add(t2);
		f.getContentPane().add(t3);
		f.getContentPane().add(t4);
		f.getContentPane().add(b1);
		f.getContentPane().add(b2);
		f.getContentPane().add(b3);
		f.getContentPane().add(b4);
		f.getContentPane().add(b5);
		f.getContentPane().add(b6);
		f.getContentPane().add(b7);
		f.setSize(500,500);
		f.setVisible(true);
	}
}
class rownum
{
	String line,model_no,company,price,discount;
	int i=0;
	int read(String t1)throws IOException
	{
		FileReader fr=new FileReader("projectnotepad.txt");
		BufferedReader br=new BufferedReader(fr);
		while((line=br.readLine())!=null)
		{
			i++;
			model_no=line.substring(0,8);
			company=line.substring(10,22);
			price=line.substring(24,36);
			discount=line.substring(38,line.length()-2);
			if(t1.equals(model_no))
			{
				break;
			}
		}
		br.close();
		return i;
	}
}
class data
{
	String line,model_no,company,price,discount;
	void read(int n)throws IOException
	{
		FileReader fr=new FileReader("projectnotepad.txt");
		BufferedReader br=new BufferedReader(fr);
		while(((line=br.readLine())!=null)&&(n>0))
		{
			model_no=line.substring(0,8);
			company=line.substring(10,22);
			price=line.substring(24,36);
			discount=line.substring(38,line.length()-2);
			n--;
		}
		br.close();
	}
}
class search
{
	String line,model_no,company,price,discount;
	void read(String t1,String t2,String t3,String t4)throws IOException
	{
		FileReader fr=new FileReader("projectnotepad.txt");
		BufferedReader br=new BufferedReader(fr);
		String p=" ";
		while((line=br.readLine())!=null)
		{
			 model_no=line.substring(0,8);
			 company=line.substring(10,22);
			 price=line.substring(24,36);
			 discount=line.substring(38,line.length()-2);
			 for(int i=t1.length();i<8;i++)
			 {
				t1=t1+p;
			 }
			 for(int j=t2.length();j<12;j++)
			 {
				t2=t2+p;
			 }
			 for(int k=t3.length();k<12;k++)
			 {
				t3=t3+p;
			 }
			 for(int l=t4.length();l<13;l++)
			 {
				t4=t4+p;
			 }
			 if(t1.equals(model_no)||t2.equals(company)||t3.equals(price)||t4.equals(discount))
		 	 {
				break;
		  	 }
		}
		br.close();
	}
}
class fileread
{
	String line,model_no,company,price,discount;
	void read()throws IOException
	{
		FileReader fr=new FileReader("projectnotepad.txt");
		BufferedReader br=new BufferedReader(fr);
		while((line=br.readLine())!=null)
		{
			model_no=line.substring(0,9);
			company=line.substring(10,23);
			price=line.substring(24,37);
			discount=line.substring(38,line.length()-1);
			System.out.print(model_no);
			System.out.print(company);
			System.out.print(price);
			System.out.println(discount);
		}
		br.close();
	}
}
class computer_system
{
	public static void main(String [] args) throws IOException
	{
		fileread f=new fileread();
		f.read();
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				new myframe();
			}
		});
	}
}