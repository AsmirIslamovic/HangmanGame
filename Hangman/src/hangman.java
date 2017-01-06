import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class hangman {
	static JLabel wall = new JLabel();
	static int choice;
	static String curline = "a";
	static int linecount = 0;
	static int charcount;
	static String[] infoarray ;
	static JTextField[] box;
	static int lives = 6;
	static int visibleone ;
	static int right =0;
	static int wins = 0;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

			final Font font1 = new Font("Arial" , Font.PLAIN,40);
			Font font2 = new Font("Arial" , Font.PLAIN,14);		
			Font font3 = new Font("Arial" , Font.PLAIN ,20);
		
			final JFrame gameframe = new JFrame("HangMan");
			gameframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			gameframe.setSize(800,700);
			
			final JPanel panel1 = new JPanel();
			final JPanel panel2 = new JPanel();
			
			panel1.setLayout(null);
			panel2.setLayout(null);
			
			panel1.setBackground(Color.black);
			panel2.setBackground(Color.WHITE);
			
			panel1.setVisible(true);
			panel2.setVisible(false);
			
			panel1.setBounds(0,0,800,700);
			panel2.setBounds(0,0,800,700);
			
			JButton start = new JButton("start");
			start.setBounds(200,350,100,50);
			
			JButton back = new JButton("Back");
			back.setBounds(10,10,100,20);
			back.setVisible(true);
			
			final DefaultListModel<String> listModel = new DefaultListModel<String>();
			listModel.addElement("TV Shows");
			listModel.addElement("Movies");
			listModel.addElement("Actors");
			listModel.addElement("VideoGames");
			listModel.addElement("Animals");
			listModel.addElement("Countries");
			
			
			final JList<String> list = new JList<String>(listModel);
			list.setBounds(200,200,100,110);
			list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			list.setLayoutOrientation(JList.VERTICAL);
			JScrollPane listScroller = new JScrollPane(list);
			panel1.add(list);
			
			final JLabel chosen = new JLabel("You Chose");
			chosen.setBounds(120,0,500,30);
			chosen.setVisible(true);
			chosen.setFont(font1);
			wall.add(chosen);
			
			final JTextField wincount = new JTextField();
			wincount.setText(" " + wins);
			wincount.setBounds(420,250,150,50);
			wincount.setVisible(true);
			panel1.add(wincount);
			
			final JLabel wincounter = new JLabel("Your Wins");
			wincounter.setBounds(420,190,150,50);
			wincounter.setVisible(true);
			wincounter.setFont(font3);
			panel1.add(wincounter);
			
			
			
			final JLabel[] hanger = new JLabel[7];
			for (int abc = 0; abc <7 ; abc++)
			{
				hanger[abc] = new JLabel();
				hanger[abc].setIcon(new ImageIcon("C:\\Users\\Asmir\\Pictures\\Java Pics\\Hangman\\hang" + (abc +1) +".png"));
				hanger[abc].setBounds(30,30,300,350);
				hanger[abc].setVisible(false);
				wall.add(hanger[abc]);
			}
			hanger[0].setVisible(true);
			visibleone = 0;
			
			
			list.addListSelectionListener(new ListSelectionListener(){

				@Override
				public void valueChanged(ListSelectionEvent e) {
					// TODO Auto-generated method stub
					int selected = list.getSelectedIndex();
					
					if (selected == 0){
						System.out.println("you chose TV Shows");
						choice = 0;
						chosen.setText("TV Shows");
					}
					if (selected == 1){
						System.out.println("you chose Movies");
						choice = 1;
						chosen.setText("Movies");
					}
					if (selected == 2){
						System.out.println("you chose Actors");
						choice = 2;
						chosen.setText("Actors");
					}
					if (selected == 3){
						System.out.println("you chose VideoGames");
						choice =3;
						chosen.setText("Video Games");
					}
					if (selected == 4){
						System.out.println("you chose Animals");
						choice = 4;
						chosen.setText("animals");
					}
					if (selected == 5){
						System.out.println("you chose Countries");
						choice = 5;
						chosen.setText("Country");
					}
				}
					
			});
			
			
			JLabel title = new JLabel("The HangMan Game");
			title.setFont(font1);
			title.setBounds(50,100,480,50);
			
			
		
			ImageIcon wallpic = new ImageIcon("C:\\Users\\Asmir\\Pictures\\wall.jpg");
			wall.setIcon(wallpic);
			wall.setBounds(0,0,1000,1000);
			
			final JButton a = new JButton("a");
			a.setBounds(0,400,60,40);
			final JButton b = new JButton("b");
			b.setBounds(60,400,60,40);
			final JButton c = new JButton("c");
			c.setBounds(120,400,60,40);
			final JButton d = new JButton("d");
			d.setBounds(180,400,60,40);
			final JButton e = new JButton("e");
			e.setBounds(240,400,60,40);
			final JButton f = new JButton("f");
			f.setBounds(300,400,60,40);
			final JButton g = new JButton("g");
			g.setBounds(360,400,60,40);
			final JButton h = new JButton("h");
			h.setBounds(420,400,60,40);
			final JButton i = new JButton("i");
			i.setBounds(480,400,60,40);
			final JButton j = new JButton("j");
			j.setBounds(0,440,60,40);
			final JButton k = new JButton("k");
			k.setBounds(60,440,60,40);
			final JButton l = new JButton("l");
			l.setBounds(120,440,60,40);
			final JButton m = new JButton("m");
			m.setBounds(180,440,60,40);
			final JButton n = new JButton("n");
			n.setBounds(240,440,60,40);
			final JButton o = new JButton("o");
			o.setBounds(300,440,60,40);
			final JButton p = new JButton("p");
			p.setBounds(360,440,60,40);
			final JButton q = new JButton("q");
			q.setBounds(420,440,60,40);
			final JButton r = new JButton("r");
			r.setBounds(480,440,60,40);
			final JButton s = new JButton("s");
			s.setBounds(0,480,60,40);
			final JButton t = new JButton("t");
			t.setBounds(60,480,60,40);
			final JButton u = new JButton("u");
			u.setBounds(120,480,60,40);
			final JButton v = new JButton("v");
			v.setBounds(180,480,60,40);
			final JButton w = new JButton("w");
			w.setBounds(240,480,60,40);
			final JButton x = new JButton("x");
			x.setBounds(300,480,60,40);
			final JButton y = new JButton("y");
			y.setBounds(360,480,60,40);
			final JButton z = new JButton("z");
			z.setBounds(420,480,60,40);
			
			
			final JButton[] buttons = {a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z};
			for (int abc = 0; abc < 26;abc ++)
			{
				buttons[abc].setFont(font2);
				buttons[abc].setHorizontalTextPosition(SwingConstants.CENTER);
				wall.add(buttons[abc]);
				
			}
			
			final JLabel end = new JLabel();
			end.setIcon(new ImageIcon("C:\\Users\\Asmir\\Pictures\\Java Pics\\Hangman\\End.png"));
			end.setBounds(220,150,360,200);
			end.setVisible(false);
			wall.setComponentZOrder(end, 0);
			
			final JLabel winner = new JLabel("You Win");
			winner.setBounds(100,20,200,30);
			winner.setFont(font1);
			winner.setVisible(false);
			end.add(winner);
			
			final JLabel lost = new JLabel("You Lost");
			lost.setBounds(100,20,200,30);
			lost.setFont(font1);
			lost.setVisible(false);
			end.add(lost);
			
			JButton again = new JButton("Play Again?");
			again.setBounds(90,100,170,60);
			again.setFont(font3);
			again.setVisible(true);
			end.add(again);
			
			start.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					
					panel1.setVisible(false);
					panel2.setVisible(true);
					BufferedReader input;
					try {
						input = new BufferedReader(new FileReader("C:\\Users\\Asmir\\Pictures\\Java Text Files\\Hangman\\Words" + choice +".txt"));
						try {
							while (curline != null)
							{
								curline = input.readLine();
								if (curline != null)
								{
										linecount++;
								}
								
							}
							System.out.println(linecount);
							
							
							int rnum= (int)(Math.random()*linecount)+1;
							BufferedReader input2;
							input2 = new BufferedReader(new FileReader("C:\\Users\\Asmir\\Pictures\\Java Text Files\\Hangman\\Words" + choice +".txt"));
							System.out.println(rnum);
							for (int abc = 0; abc< rnum; abc++)
							{
								curline = input2.readLine();
							}
							System.out.println(curline);
							
							curline.trim();
							
							infoarray = curline.split("");
                        	for (int i = 0; i < infoarray.length;i ++)
                            {
                            	 System.out.println(infoarray[i]);
                            	 System.out.print(i);
                            	 charcount = i;
                            }
                        	
                        	box = new JTextField[charcount+1];
                    		for ( int abc = 0; abc < charcount ; abc ++)
                    		{
                    			box[abc] = new JTextField();
                    			box[abc].setBounds(31*abc,350,30,50);
                    			box[abc].setVisible(true);
                    			box[abc].setFont(font1);
                    			box[abc].setEditable(false);
                    			box[abc].setBackground(Color.cyan);
                    			box[abc].setHorizontalAlignment(JTextField.CENTER);
                    			wall.add(box[abc]);
                    			if (infoarray[abc].equalsIgnoreCase(" "))
                    			{
                    				box[abc-1].setBackground(Color.BLACK);
                    				right++;
                    			}
                    			
                    		}
                    	
                    		for (int abc = 0; abc< charcount ; abc++)
                    		{
                    			
                    		}
                    		
                    		
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				
				}
				
			});
			back.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					panel2.setVisible(false);
					panel1.setVisible(true);
					linecount = 0;
					
					for (int abc=0; abc <charcount; abc++)
					{
						box[abc].setVisible(false);
					}
					for (int abc = 0 ; abc < 26 ; abc ++)
					{
						buttons[abc].setEnabled(true);
					}
					hanger[0].setVisible(true);
					for (int abc = 1 ; abc <7; abc ++ )
					{
						hanger[abc].setVisible(false);
						visibleone = 0;
					}
					right = 0;
					
				}
				
			});
			
			again.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					panel2.setVisible(false);
					panel1.setVisible(true);
					linecount = 0;
					
					for (int abc=0; abc <charcount; abc++)
					{
						box[abc].setVisible(false);
					}
					for (int abc = 0 ; abc < 26 ; abc ++)
					{
						buttons[abc].setEnabled(true);
					}
					hanger[0].setVisible(true);
					for (int abc = 1 ; abc <7; abc ++ )
					{
						hanger[abc].setVisible(false);
						visibleone = 0;
					}
					
					end.setVisible(false);
					winner.setVisible(false);
					lost.setVisible(false);
					right = 0;
					for(int zyx = 0; zyx<26 ; zyx++)
					{
						buttons[zyx].setEnabled(true);
					}
				}
				
			});
			
			a.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					for (int abc = 0; abc < curline.length() +1 ; abc ++)
					{
						if (infoarray[abc].equalsIgnoreCase("a"))
						{
							box[abc-1].setText("a");
							right ++;
							if (right == charcount)
							{
								for(int zyx = 0; zyx<25 ; zyx++)
								{
									buttons[zyx].setEnabled(false);
								}
								winner.setVisible(true);
								end.setVisible(true);
								wins++;  wincount.setText(" " + wins);
							}
						}
						a.setEnabled(false);
					}
					int wrong = 0;
					for (int abc = 0; abc < curline.length()   ; abc ++)
					{
						
						if (!(infoarray[abc]).equalsIgnoreCase("a"))
						{
							wrong ++;
						}
						if (wrong == curline.length()  )
						{
							hanger[visibleone].setVisible(false);
							hanger[visibleone +1].setVisible(true);
							visibleone ++;
							if( hanger[6].isVisible() == true)
							{
								for(int zyx = 0; zyx<25 ; zyx++)
								{
									buttons[zyx].setEnabled(false);
								}
								lost.setVisible(true);
								end.setVisible(true);
								for ( int xyz = 0; xyz < charcount ; xyz ++)
	                    		{
	                    			if (infoarray[xyz].equalsIgnoreCase(""))
	                    			{
	                    				box[xyz-1].setText(infoarray[xyz]);
	                    			}
	                    			
	                    		}
							}
						}
					}
					
				}
				
			});
			b.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					for (int abc = 0; abc < curline.length() +1  ; abc ++)
					{
						if (infoarray[abc].equalsIgnoreCase("b"))
						{
							box[abc-1].setText("b");
							right ++;
							if (right == charcount)
							{
								for(int zyx = 0; zyx<25 ; zyx++)
								{
									buttons[zyx].setEnabled(false);
								}
								winner.setVisible(true);
								end.setVisible(true);
								wins++;  wincount.setText(" " + wins);

							}
						}
						b.setEnabled(false);
					}
					int wrong = 0;
					for (int abc = 0; abc < curline.length()  ; abc ++)
					{
						
						if (!(infoarray[abc]).equalsIgnoreCase("b"))
						{
							wrong ++;
						}
						if (wrong == curline.length() )
						{
							hanger[visibleone].setVisible(false);
							hanger[visibleone +1].setVisible(true);
							visibleone ++;
							if( hanger[6].isVisible() == true)
							{
								for(int zyx = 0; zyx<25 ; zyx++)
								{
									buttons[zyx].setEnabled(false);
								}
								lost.setVisible(true);
								end.setVisible(true);
								for ( int xyz = 0; xyz < charcount ; xyz ++)
	                    		{
	                    			if (infoarray[xyz].equalsIgnoreCase(""))
	                    			{
	                    				box[xyz-1].setText(infoarray[xyz]);
	                    			}
	                    			
	                    		}
							}
						}
					}
				}
				
			});
			c.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					for (int abc = 0; abc < curline.length() +1 ; abc ++)
					{
						if (infoarray[abc].equalsIgnoreCase("c"))
						{
							box[abc-1].setText("c");
							right ++;
							if (right == charcount)
							{
								for(int zyx = 0; zyx<25 ; zyx++)
								{
									buttons[zyx].setEnabled(false);
								}
								winner.setVisible(true);
								end.setVisible(true);
								wins++;  wincount.setText(" " + wins);

							}
						}
						c.setEnabled(false);
					}
					int wrong = 0;
					for (int abc = 0; abc < curline.length()  ; abc ++)
					{
						
						if (!(infoarray[abc]).equalsIgnoreCase("c"))
						{
							wrong ++;
						}
						if (wrong == curline.length() )
						{
							hanger[visibleone].setVisible(false);
							hanger[visibleone +1].setVisible(true);
							visibleone ++;
							if( hanger[6].isVisible() == true)
							{
								for(int zyx = 0; zyx<25 ; zyx++)
								{
									buttons[zyx].setEnabled(false);
								}
								lost.setVisible(true);
								end.setVisible(true);
								for ( int xyz = 0; xyz < charcount ; xyz ++)
	                    		{
	                    			if (infoarray[xyz].equalsIgnoreCase(""))
	                    			{
	                    				box[xyz-1].setText(infoarray[xyz]);
	                    			}
	                    			
	                    		}
							}
						}
					}
				}
				
			});
			
			d.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					for (int abc = 0; abc < curline.length() +1 ; abc ++)
					{
						if (infoarray[abc].equalsIgnoreCase("d"))
						{
							box[abc-1].setText("d");
							right ++;
							if (right == charcount)
							{
								for(int zyx = 0; zyx<25 ; zyx++)
								{
									buttons[zyx].setEnabled(false);
								}
								winner.setVisible(true);
								end.setVisible(true);
								wins++;  wincount.setText(" " + wins);

							}
						}
						d.setEnabled(false);
					}
					int wrong = 0;
					for (int abc = 0; abc < curline.length()  ; abc ++)
					{
						
						if (!(infoarray[abc]).equalsIgnoreCase("d"))
						{
							wrong ++;
						}
						if (wrong == curline.length() )
						{
							hanger[visibleone].setVisible(false);
							hanger[visibleone +1].setVisible(true);
							visibleone ++;
							if( hanger[6].isVisible() == true)
							{
								for(int zyx = 0; zyx<25 ; zyx++)
								{
									buttons[zyx].setEnabled(false);
								}
								lost.setVisible(true);
								end.setVisible(true);
								for ( int xyz = 0; xyz < charcount ; xyz ++)
	                    		{
	                    			if (infoarray[xyz].equalsIgnoreCase(""))
	                    			{
	                    				box[xyz-1].setText(infoarray[xyz]);
	                    			}
	                    			
	                    		}
							}
						}
					}
				}
				
			});
			
			e.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					for (int abc = 0; abc < curline.length() +1 ; abc ++)
					{
						if (infoarray[abc].equalsIgnoreCase("e"))
						{
							box[abc-1].setText("e");
							right ++;
							if (right == charcount)
							{
								for(int zyx = 0; zyx<25 ; zyx++)
								{
									buttons[zyx].setEnabled(false);
								}
								winner.setVisible(true);
								end.setVisible(true);
								wins++;  wincount.setText(" " + wins);

							}
						}
						e.setEnabled(false);
					}
					int wrong = 0;
					for (int abc = 0; abc < curline.length() ; abc ++)
					{
						
						if (!(infoarray[abc]).equalsIgnoreCase("e"))
						{
							wrong ++;
						}
						if (wrong == curline.length() )
						{
							hanger[visibleone].setVisible(false);
							hanger[visibleone +1].setVisible(true);
							visibleone ++;
							if( hanger[6].isVisible() == true)
							{
								for(int zyx = 0; zyx<25 ; zyx++)
								{
									buttons[zyx].setEnabled(false);
								}
								lost.setVisible(true);
								end.setVisible(true);
								for ( int xyz = 0; xyz < charcount ; xyz ++)
	                    		{
	                    			if (infoarray[xyz].equalsIgnoreCase(""))
	                    			{
	                    				box[xyz-1].setText(infoarray[xyz]);
	                    			}
	                    			
	                    		}
							}
						}
					}
				}
				
			});
			
			f.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					for (int abc = 0; abc < curline.length() +1 ; abc ++)
					{
						if (infoarray[abc].equalsIgnoreCase("f"))
						{
							box[abc-1].setText("f");
							right ++;
							if (right == charcount)
							{
								for(int zyx = 0; zyx<25 ; zyx++)
								{
									buttons[zyx].setEnabled(false);
								}
								winner.setVisible(true);
								end.setVisible(true);
								wins++;  wincount.setText(" " + wins);

							}
						}
						f.setEnabled(false);
					}
					int wrong = 0;
					for (int abc = 0; abc < curline.length()  ; abc ++)
					{
						
						if (!(infoarray[abc]).equalsIgnoreCase("f"))
						{
							wrong ++;
						}
						if (wrong == curline.length() )
						{
							hanger[visibleone].setVisible(false);
							hanger[visibleone +1].setVisible(true);
							visibleone ++;
							if( hanger[6].isVisible() == true)
							{
								for(int zyx = 0; zyx<25 ; zyx++)
								{
									buttons[zyx].setEnabled(false);
								}
								lost.setVisible(true);
								end.setVisible(true);
								for ( int xyz = 0; xyz < charcount ; xyz ++)
	                    		{
	                    			if (infoarray[xyz].equalsIgnoreCase(""))
	                    			{
	                    				box[xyz-1].setText(infoarray[xyz]);
	                    			}
	                    			
	                    		}
							}
						}
					}
				}
				
			});
			
			g.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					for (int abc = 0; abc < curline.length() +1 ; abc ++)
					{
						if (infoarray[abc].equalsIgnoreCase("g"))
						{
							box[abc-1].setText("g");
							right ++;
							if (right == charcount)
							{
								for(int zyx = 0; zyx<25 ; zyx++)
								{
									buttons[zyx].setEnabled(false);
								}
								winner.setVisible(true);
								end.setVisible(true);
								wins++;  wincount.setText(" " + wins);

							}
						}
						g.setEnabled(false);
					}
					int wrong = 0;
					for (int abc = 0; abc < curline.length()  ; abc ++)
					{
						
						if (!(infoarray[abc]).equalsIgnoreCase("g"))
						{
							wrong ++;
						}
						if (wrong == curline.length() )
						{
							hanger[visibleone].setVisible(false);
							hanger[visibleone +1].setVisible(true);
							visibleone ++;
							if( hanger[6].isVisible() == true)
							{
								for(int zyx = 0; zyx<25 ; zyx++)
								{
									buttons[zyx].setEnabled(false);
								}
								lost.setVisible(true);
								end.setVisible(true);
								for ( int xyz = 0; xyz < charcount ; xyz ++)
	                    		{
	                    			if (infoarray[xyz].equalsIgnoreCase(""))
	                    			{
	                    				box[xyz-1].setText(infoarray[xyz]);
	                    			}
	                    			
	                    		}
							}
						}
					}
				}
				
			});
			
			h.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					for (int abc = 0; abc < curline.length() +1 ; abc ++)
					{
						if (infoarray[abc].equalsIgnoreCase("h"))
						{
							box[abc-1].setText("h");
							right ++;
							if (right == charcount)
							{
								for(int zyx = 0; zyx<25 ; zyx++)
								{
									buttons[zyx].setEnabled(false);
								}
								winner.setVisible(true);
								end.setVisible(true);
								wins++;  wincount.setText(" " + wins);

							}
						}
						h.setEnabled(false);
					}
					int wrong = 0;
					for (int abc = 0; abc < curline.length()  ; abc ++)
					{
						
						if (!(infoarray[abc]).equalsIgnoreCase("h"))
						{
							wrong ++;
						}
						if (wrong == curline.length() )
						{
							hanger[visibleone].setVisible(false);
							hanger[visibleone +1].setVisible(true);
							visibleone ++;
							if( hanger[6].isVisible() == true)
							{
								for(int zyx = 0; zyx<25 ; zyx++)
								{
									buttons[zyx].setEnabled(false);
								}
								lost.setVisible(true);
								end.setVisible(true);
								for ( int xyz = 0; xyz < charcount ; xyz ++)
	                    		{
	                    			if (infoarray[xyz].equalsIgnoreCase(""))
	                    			{
	                    				box[xyz-1].setText(infoarray[xyz]);
	                    			}
	                    			
	                    		}
							}
						}
					}
				}
				
			});
			
			i.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					for (int abc = 0; abc < curline.length() +1 ; abc ++)
					{
						if (infoarray[abc].equalsIgnoreCase("i"))
						{
							box[abc-1].setText("i");
							right ++;
							if (right == charcount)
							{
								for(int zyx = 0; zyx<25 ; zyx++)
								{
									buttons[zyx].setEnabled(false);
								}
								winner.setVisible(true);
								end.setVisible(true);
								wins++;  wincount.setText(" " + wins);

							}
						}
						i.setEnabled(false);
					}
					int wrong = 0;
					for (int abc = 0; abc < curline.length()  ; abc ++)
					{
						
						if (!(infoarray[abc]).equalsIgnoreCase("i"))
						{
							wrong ++;
						}
						if (wrong == curline.length() )
						{
							hanger[visibleone].setVisible(false);
							hanger[visibleone +1].setVisible(true);
							visibleone ++;
							if( hanger[6].isVisible() == true)
							{
								for(int zyx = 0; zyx<25 ; zyx++)
								{
									buttons[zyx].setEnabled(false);
								}
								lost.setVisible(true);
								end.setVisible(true);
								for ( int xyz = 0; xyz < charcount ; xyz ++)
	                    		{
	                    			if (infoarray[xyz].equalsIgnoreCase(""))
	                    			{
	                    				box[xyz-1].setText(infoarray[xyz]);
	                    			}
	                    			
	                    		}
							}
						}
					}
				}
				
			});
			
			j.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					for (int abc = 0; abc < curline.length() +1 ; abc ++)
					{
						if (infoarray[abc].equalsIgnoreCase("j"))
						{
							box[abc-1].setText("j");
							right ++;
							if (right == charcount)
							{
								for(int zyx = 0; zyx<25 ; zyx++)
								{
									buttons[zyx].setEnabled(false);
								}
								winner.setVisible(true);
								end.setVisible(true);
								wins++;  wincount.setText(" " + wins);

							}
						}
						j.setEnabled(false);
					}
					int wrong = 0;
					for (int abc = 0; abc < curline.length()  ; abc ++)
					{
						
						if (!(infoarray[abc]).equalsIgnoreCase("j"))
						{
							wrong ++;
						}
						if (wrong == curline.length() )
						{
							hanger[visibleone].setVisible(false);
							hanger[visibleone +1].setVisible(true);
							visibleone ++;
							if( hanger[6].isVisible() == true)
							{
								for(int zyx = 0; zyx<25 ; zyx++)
								{
									buttons[zyx].setEnabled(false);
								}
								lost.setVisible(true);
								end.setVisible(true);
								for ( int xyz = 0; xyz < charcount ; xyz ++)
	                    		{
	                    			if (infoarray[xyz].equalsIgnoreCase(""))
	                    			{
	                    				box[xyz-1].setText(infoarray[xyz]);
	                    			}
	                    			
	                    		}
							}
						}
					}
				}
				
			});
			
			k.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					for (int abc = 0; abc < curline.length() +1 ; abc ++)
					{
						if (infoarray[abc].equalsIgnoreCase("k"))
						{
							box[abc-1].setText("k");
							right ++;
							if (right == charcount)
							{
								for(int zyx = 0; zyx<25 ; zyx++)
								{
									buttons[zyx].setEnabled(false);
								}
								winner.setVisible(true);
								end.setVisible(true);
								wins++;  wincount.setText(" " + wins);

							}
						}
						k.setEnabled(false);
					}
					int wrong = 0;
					for (int abc = 0; abc < curline.length()  ; abc ++)
					{
						
						if (!(infoarray[abc]).equalsIgnoreCase("k"))
						{
							wrong ++;
						}
						if (wrong == curline.length() )
						{
							hanger[visibleone].setVisible(false);
							hanger[visibleone +1].setVisible(true);
							visibleone ++;
							if( hanger[6].isVisible() == true)
							{
								for(int zyx = 0; zyx<25 ; zyx++)
								{
									buttons[zyx].setEnabled(false);
								}
								lost.setVisible(true);
								end.setVisible(true);
								for ( int xyz = 0; xyz < charcount ; xyz ++)
	                    		{
	                    			if (infoarray[xyz].equalsIgnoreCase(""))
	                    			{
	                    				box[xyz-1].setText(infoarray[xyz]);
	                    			}
	                    			
	                    		}
							}
						}
					}
				}
				
			});
			
			l.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					for (int abc = 0; abc < curline.length() +1 ; abc ++)
					{
						if (infoarray[abc].equalsIgnoreCase("l"))
						{
							box[abc-1].setText("l");
							right ++;
							if (right == charcount)
							{
								for(int zyx = 0; zyx<25 ; zyx++)
								{
									buttons[zyx].setEnabled(false);
								}
								winner.setVisible(true);
								end.setVisible(true);
								wins++;  wincount.setText(" " + wins);

							}
						}
						l.setEnabled(false);
					}
					int wrong = 0;
					for (int abc = 0; abc < curline.length()  ; abc ++)
					{
						
						if (!(infoarray[abc]).equalsIgnoreCase("l"))
						{
							wrong ++;
						}
						if (wrong == curline.length() )
						{
							hanger[visibleone].setVisible(false);
							hanger[visibleone +1].setVisible(true);
							visibleone ++;
							if( hanger[6].isVisible() == true)
							{
								for(int zyx = 0; zyx<25 ; zyx++)
								{
									buttons[zyx].setEnabled(false);
								}
								lost.setVisible(true);
								end.setVisible(true);
								for ( int xyz = 0; xyz < charcount ; xyz ++)
	                    		{
	                    			if (infoarray[xyz].equalsIgnoreCase(""))
	                    			{
	                    				box[xyz-1].setText(infoarray[xyz]);
	                    			}
	                    			
	                    		}
							}
						}
					}
				}
				
			});

			m.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					for (int abc = 0; abc < curline.length() +1 ; abc ++)
					{
						if (infoarray[abc].equalsIgnoreCase("m"))
						{
							box[abc-1].setText("m");
							right ++;
							if (right == charcount)
							{
								for(int zyx = 0; zyx<25 ; zyx++)
								{
									buttons[zyx].setEnabled(false);
								}
								winner.setVisible(true);
								end.setVisible(true);
								wins++;  wincount.setText(" " + wins);

							}
						}
						m.setEnabled(false);
					}
					int wrong = 0;
					for (int abc = 0; abc < curline.length()  ; abc ++)
					{
						
						if (!(infoarray[abc]).equalsIgnoreCase("m"))
						{
							wrong ++;
						}
						if (wrong == curline.length() )
						{
							hanger[visibleone].setVisible(false);
							hanger[visibleone +1].setVisible(true);
							visibleone ++;
							if( hanger[6].isVisible() == true)
							{
								for(int zyx = 0; zyx<25 ; zyx++)
								{
									buttons[zyx].setEnabled(false);
								}
								lost.setVisible(true);
								end.setVisible(true);
								for ( int xyz = 0; xyz < charcount ; xyz ++)
	                    		{
	                    			if (infoarray[xyz].equalsIgnoreCase(""))
	                    			{
	                    				box[xyz-1].setText(infoarray[xyz]);
	                    			}
	                    			
	                    		}
							}
						}
					}
				}
				
			});
			
			n.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					for (int abc = 0; abc < curline.length() +1 ; abc ++)
					{
						if (infoarray[abc].equalsIgnoreCase("n"))
						{
							box[abc-1].setText("n");
							right ++;
							if (right == charcount)
							{
								for(int zyx = 0; zyx<25 ; zyx++)
								{
									buttons[zyx].setEnabled(false);
								}
								winner.setVisible(true);
								end.setVisible(true);
								wins++;  wincount.setText(" " + wins);

							}
						}
						n.setEnabled(false);
					}
					int wrong = 0;
					for (int abc = 0; abc < curline.length()  ; abc ++)
					{
						
						if (!(infoarray[abc]).equalsIgnoreCase("n"))
						{
							wrong ++;
						}
						if (wrong == curline.length() )
						{
							hanger[visibleone].setVisible(false);
							hanger[visibleone +1].setVisible(true);
							visibleone ++;
							if( hanger[6].isVisible() == true)
							{
								for(int zyx = 0; zyx<25 ; zyx++)
								{
									buttons[zyx].setEnabled(false);
								}
								lost.setVisible(true);
								end.setVisible(true);
								for ( int xyz = 0; xyz < charcount ; xyz ++)
	                    		{
	                    			if (infoarray[xyz].equalsIgnoreCase(""))
	                    			{
	                    				box[xyz-1].setText(infoarray[xyz]);
	                    			}
	                    			
	                    		}
							}
						}
					}
				}
				
			});
			
			o.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					for (int abc = 0; abc < curline.length() +1 ; abc ++)
					{
						if (infoarray[abc].equalsIgnoreCase("o"))
						{
							box[abc-1].setText("o");
							right ++;
							if (right == charcount)
							{
								for(int zyx = 0; zyx<25 ; zyx++)
								{
									buttons[zyx].setEnabled(false);
								}
								winner.setVisible(true);
								end.setVisible(true);
								wins++;  wincount.setText(" " + wins);

							}
						}
						o.setEnabled(false);
					}
					int wrong = 0;
					for (int abc = 0; abc < curline.length()  ; abc ++)
					{
						
						if (!(infoarray[abc]).equalsIgnoreCase("o"))
						{
							wrong ++;
						}
						if (wrong == curline.length() )
						{
							hanger[visibleone].setVisible(false);
							hanger[visibleone +1].setVisible(true);
							visibleone ++;
							if( hanger[6].isVisible() == true)
							{
								for(int zyx = 0; zyx<25 ; zyx++)
								{
									buttons[zyx].setEnabled(false);
								}
								lost.setVisible(true);
								end.setVisible(true);
								for ( int xyz = 0; xyz < charcount ; xyz ++)
	                    		{
	                    			if (infoarray[xyz].equalsIgnoreCase(""))
	                    			{
	                    				box[xyz-1].setText(infoarray[xyz]);
	                    			}
	                    			
	                    		}
							}
						}
					}
				}
				
			});
			
			p.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					for (int abc = 0; abc < curline.length() +1 ; abc ++)
					{
						if (infoarray[abc].equalsIgnoreCase("p"))
						{
							box[abc-1].setText("p");
							right ++;
							if (right == charcount)
							{
								for(int zyx = 0; zyx<25 ; zyx++)
								{
									buttons[zyx].setEnabled(false);
								}
								winner.setVisible(true);
								end.setVisible(true);
								wins++;  wincount.setText(" " + wins);

							}
						}
						p.setEnabled(false);
					}
					int wrong = 0;
					for (int abc = 0; abc < curline.length()  ; abc ++)
					{
						
						if (!(infoarray[abc]).equalsIgnoreCase("p"))
						{
							wrong ++;
						}
						if (wrong == curline.length() )
						{
							hanger[visibleone].setVisible(false);
							hanger[visibleone +1].setVisible(true);
							visibleone ++;
							if( hanger[6].isVisible() == true)
							{
								for(int zyx = 0; zyx<25 ; zyx++)
								{
									buttons[zyx].setEnabled(false);
								}
								lost.setVisible(true);
								end.setVisible(true);
								for ( int xyz = 0; xyz < charcount ; xyz ++)
	                    		{
	                    			if (infoarray[xyz].equalsIgnoreCase(""))
	                    			{
	                    				box[xyz-1].setText(infoarray[xyz]);
	                    			}
	                    			
	                    		}
							}
						}
					}
				}
				
			});
			
			q.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					for (int abc = 0; abc < curline.length() +1 ; abc ++)
					{
						if (infoarray[abc].equalsIgnoreCase("q"))
						{
							box[abc-1].setText("q");
							right ++;
							if (right == charcount)
							{
								for(int zyx = 0; zyx<25 ; zyx++)
								{
									buttons[zyx].setEnabled(false);
								}
								winner.setVisible(true);
								end.setVisible(true);
								wins++;  wincount.setText(" " + wins);

							}
						}
						q.setEnabled(false);
					}
					int wrong = 0;
					for (int abc = 0; abc < curline.length()  ; abc ++)
					{
						
						if (!(infoarray[abc]).equalsIgnoreCase("q"))
						{
							wrong ++;
						}
						if (wrong == curline.length() )
						{
							hanger[visibleone].setVisible(false);
							hanger[visibleone +1].setVisible(true);
							visibleone ++;
							if( hanger[6].isVisible() == true)
							{
								for(int zyx = 0; zyx<25 ; zyx++)
								{
									buttons[zyx].setEnabled(false);
								}
								lost.setVisible(true);
								end.setVisible(true);
								for ( int xyz = 0; xyz < charcount ; xyz ++)
	                    		{
	                    			if (infoarray[xyz].equalsIgnoreCase(""))
	                    			{
	                    				box[xyz-1].setText(infoarray[xyz]);
	                    			}
	                    			
	                    		}
							}
						}
					}
				}
				
			});
			
			r.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					for (int abc = 0; abc < curline.length() +1 ; abc ++)
					{
						if (infoarray[abc].equalsIgnoreCase("r"))
						{
							box[abc-1].setText("r");
							right ++;
							if (right == charcount)
							{
								for(int zyx = 0; zyx<25 ; zyx++)
								{
									buttons[zyx].setEnabled(false);
								}
								winner.setVisible(true);
								end.setVisible(true);
								wins++;  wincount.setText(" " + wins);

							}
						}
						r.setEnabled(false);
					}
					int wrong = 0;
					for (int abc = 0; abc < curline.length()  ; abc ++)
					{
						
						if (!(infoarray[abc]).equalsIgnoreCase("r"))
						{
							wrong ++;
						}
						if (wrong == curline.length() )
						{
							hanger[visibleone].setVisible(false);
							hanger[visibleone +1].setVisible(true);
							visibleone ++;
							if( hanger[6].isVisible() == true)
							{
								for(int zyx = 0; zyx<25 ; zyx++)
								{
									buttons[zyx].setEnabled(false);
								}
								lost.setVisible(true);
								end.setVisible(true);
								for ( int xyz = 0; xyz < charcount ; xyz ++)
	                    		{
	                    			if (infoarray[xyz].equalsIgnoreCase(""))
	                    			{
	                    				box[xyz-1].setText(infoarray[xyz]);
	                    			}
	                    			
	                    		}
							}
						}
					}
				}
				
			});
			
			s.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					for (int abc = 0; abc < curline.length() +1 ; abc ++)
					{
						if (infoarray[abc].equalsIgnoreCase("s"))
						{
							box[abc-1].setText("s");
							right ++;
							if (right == charcount)
							{
								for(int zyx = 0; zyx<25 ; zyx++)
								{
									buttons[zyx].setEnabled(false);
								}
								winner.setVisible(true);
								end.setVisible(true);
								wins++;  wincount.setText(" " + wins);

							}
						}
						s.setEnabled(false);
					}
					int wrong = 0;
					for (int abc = 0; abc < curline.length()  ; abc ++)
					{
						
						if (!(infoarray[abc]).equalsIgnoreCase("s"))
						{
							wrong ++;
						}
						if (wrong == curline.length() )
						{
							hanger[visibleone].setVisible(false);
							hanger[visibleone +1].setVisible(true);
							visibleone ++;
							if( hanger[6].isVisible() == true)
							{
								for(int zyx = 0; zyx<25 ; zyx++)
								{
									buttons[zyx].setEnabled(false);
								}
								lost.setVisible(true);
								end.setVisible(true);
								for ( int xyz = 0; xyz < charcount ; xyz ++)
	                    		{
	                    			if (infoarray[xyz].equalsIgnoreCase(""))
	                    			{
	                    				box[xyz-1].setText(infoarray[xyz]);
	                    			}
	                    			
	                    		}
							}
						}
					}
				}
				
			});
			
			t.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					for (int abc = 0; abc < curline.length() +1 ; abc ++)
					{
						if (infoarray[abc].equalsIgnoreCase("t"))
						{
							box[abc-1].setText("t");
							right ++;
							if (right == charcount)
							{
								for(int zyx = 0; zyx<25 ; zyx++)
								{
									buttons[zyx].setEnabled(false);
								}
								winner.setVisible(true);
								end.setVisible(true);
								wins++;  wincount.setText(" " + wins);

							}
						}
						t.setEnabled(false);
					}
					int wrong = 0;
					for (int abc = 0; abc < curline.length()  ; abc ++)
					{
						
						if (!(infoarray[abc]).equalsIgnoreCase("t"))
						{
							wrong ++;
						}
						if (wrong == curline.length() )
						{
							hanger[visibleone].setVisible(false);
							hanger[visibleone +1].setVisible(true);
							visibleone ++;
							if( hanger[6].isVisible() == true)
							{
								for(int zyx = 0; zyx<25 ; zyx++)
								{
									buttons[zyx].setEnabled(false);
								}
								lost.setVisible(true);
								end.setVisible(true);
								for ( int xyz = 0; xyz < charcount ; xyz ++)
	                    		{
	                    			if (infoarray[xyz].equalsIgnoreCase(""))
	                    			{
	                    				box[xyz-1].setText(infoarray[xyz]);
	                    			}
	                    			
	                    		}
							}
						}
					}
				}
				
				
			});
			
			u.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					for (int abc = 0; abc < curline.length() +1 ; abc ++)
					{
						if (infoarray[abc].equalsIgnoreCase("u"))
						{
							box[abc-1].setText("u");
							right ++;
							if (right == charcount)
							{
								for(int zyx = 0; zyx<25 ; zyx++)
								{
									buttons[zyx].setEnabled(false);
								}
								winner.setVisible(true);
								end.setVisible(true);
								wins++;  wincount.setText(" " + wins);

							}
						}
						u.setEnabled(false);
					}
					int wrong = 0;
					for (int abc = 0; abc < curline.length()  ; abc ++)
					{
						
						if (!(infoarray[abc]).equalsIgnoreCase("u"))
						{
							wrong ++;
						}
						if (wrong == curline.length() )
						{
							hanger[visibleone].setVisible(false);
							hanger[visibleone +1].setVisible(true);
							visibleone ++;
							if( hanger[6].isVisible() == true)
							{
								for(int zyx = 0; zyx<25 ; zyx++)
								{
									buttons[zyx].setEnabled(false);
								}
								lost.setVisible(true);
								end.setVisible(true);
								for ( int xyz = 0; xyz < charcount ; xyz ++)
	                    		{
	                    			if (infoarray[xyz].equalsIgnoreCase(""))
	                    			{
	                    				box[xyz-1].setText(infoarray[xyz]);
	                    			}
	                    			
	                    		}
							}
						}
					}
				}
				
			});
			
			v.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					for (int abc = 0; abc < curline.length() +1 ; abc ++)
					{
						if (infoarray[abc].equalsIgnoreCase("v"))
						{
							box[abc-1].setText("v");
							right ++;
							if (right == charcount)
							{
								for(int zyx = 0; zyx<25 ; zyx++)
								{
									buttons[zyx].setEnabled(false);
								}
								winner.setVisible(true);
								end.setVisible(true);
								wins++;  wincount.setText(" " + wins);

							}
						}
						v.setEnabled(false);
					}
					int wrong = 0;
					for (int abc = 0; abc < curline.length()  ; abc ++)
					{
						
						if (!(infoarray[abc]).equalsIgnoreCase("v"))
						{
							wrong ++;
						}
						if (wrong == curline.length() )
						{
							hanger[visibleone].setVisible(false);
							hanger[visibleone +1].setVisible(true);
							visibleone ++;
							if( hanger[6].isVisible() == true)
							{
								for(int zyx = 0; zyx<25 ; zyx++)
								{
									buttons[zyx].setEnabled(false);
								}
								lost.setVisible(true);
								end.setVisible(true);
								for ( int xyz = 0; xyz < charcount ; xyz ++)
	                    		{
	                    			if (infoarray[xyz].equalsIgnoreCase(""))
	                    			{
	                    				box[xyz-1].setText(infoarray[xyz]);
	                    			}
	                    			
	                    		}
							}
						}
					}
				}
				
			});
			
			w.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					for (int abc = 0; abc < curline.length() +1 ; abc ++)
					{
						if (infoarray[abc].equalsIgnoreCase("w"))
						{
							box[abc-1].setText("w");
							right ++;
							if (right == charcount)
							{
								for(int zyx = 0; zyx<25 ; zyx++)
								{
									buttons[zyx].setEnabled(false);
								}
								winner.setVisible(true);
								end.setVisible(true);
								wins++;  wincount.setText(" " + wins);

							}
						}
						w.setEnabled(false);
					}
					int wrong = 0;
					for (int abc = 0; abc < curline.length()  ; abc ++)
					{
						
						if (!(infoarray[abc]).equalsIgnoreCase("w"))
						{
							wrong ++;
						}
						if (wrong == curline.length() )
						{
							hanger[visibleone].setVisible(false);
							hanger[visibleone +1].setVisible(true);
							visibleone ++;
							if( hanger[6].isVisible() == true)
							{
								for(int zyx = 0; zyx<25 ; zyx++)
								{
									buttons[zyx].setEnabled(false);
								}
								lost.setVisible(true);
								end.setVisible(true);
								for ( int xyz = 0; xyz < charcount ; xyz ++)
	                    		{
	                    			if (infoarray[xyz].equalsIgnoreCase(""))
	                    			{
	                    				box[xyz-1].setText(infoarray[xyz]);
	                    			}
	                    			
	                    		}
							}
						}
					}
				}
				
			});
			
			x.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					for (int abc = 0; abc < curline.length() +1 ; abc ++)
					{
						if (infoarray[abc].equalsIgnoreCase("x"))
						{
							box[abc-1].setText("x");
							right ++;
							if (right == charcount)
							{
								for(int zyx = 0; zyx<25 ; zyx++)
								{
									buttons[zyx].setEnabled(false);
								}
								winner.setVisible(true);
								end.setVisible(true);
								wins++;  wincount.setText(" " + wins);

							}
						}
						x.setEnabled(false);
					}
					int wrong = 0;
					for (int abc = 0; abc < curline.length()  ; abc ++)
					{
						
						if (!(infoarray[abc]).equalsIgnoreCase("x"))
						{
							wrong ++;
						}
						if (wrong == curline.length() )
						{
							hanger[visibleone].setVisible(false);
							hanger[visibleone +1].setVisible(true);
							visibleone ++;
							if( hanger[6].isVisible() == true)
							{
								for(int zyx = 0; zyx<25 ; zyx++)
								{
									buttons[zyx].setEnabled(false);
								}
								lost.setVisible(true);
								end.setVisible(true);
								for ( int xyz = 0; xyz < charcount ; xyz ++)
	                    		{
	                    			if (infoarray[xyz].equalsIgnoreCase(""))
	                    			{
	                    				box[xyz-1].setText(infoarray[xyz]);
	                    			}
	                    			
	                    		}
							}
						}
					}
				}
				
			});
			
			y.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					for (int abc = 0; abc < curline.length() +1 ; abc ++)
					{
						if (infoarray[abc].equalsIgnoreCase("y"))
						{
							box[abc-1].setText("y");
							right ++;
							if (right == charcount)
							{
								for(int zyx = 0; zyx<25 ; zyx++)
								{
									buttons[zyx].setEnabled(false);
								}
								winner.setVisible(true);
								end.setVisible(true);
								wins++;  wincount.setText(" " + wins);

							}
						}
						y.setEnabled(false);
					}
					int wrong = 0;
					for (int abc = 0; abc < curline.length()  ; abc ++)
					{
						
						if (!(infoarray[abc]).equalsIgnoreCase("y"))
						{
							wrong ++;
						}
						if (wrong == curline.length() )
						{
							hanger[visibleone].setVisible(false);
							hanger[visibleone +1].setVisible(true);
							visibleone ++;
							if( hanger[6].isVisible() == true)
							{
								for(int zyx = 0; zyx<25 ; zyx++)
								{
									buttons[zyx].setEnabled(false);
								}
								lost.setVisible(true);
								end.setVisible(true);
								for ( int xyz = 0; xyz < charcount ; xyz ++)
	                    		{
	                    			if (infoarray[xyz].equalsIgnoreCase(""))
	                    			{
	                    				box[xyz-1].setText(infoarray[xyz]);
	                    			}
	                    			
	                    		}
							}
						}
					}
				}
				
			});
			
			z.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					for (int abc = 0; abc < curline.length() +1 ; abc ++)
					{
						if (infoarray[abc].equalsIgnoreCase("z"))
						{
							box[abc-1].setText("z");
							right ++;
							if (right == charcount)
							{
								for(int zyx = 0; zyx<25 ; zyx++)
								{
									buttons[zyx].setEnabled(false);
								}
								winner.setVisible(true);
								end.setVisible(true);
								wins++;  wincount.setText(" " + wins);

								
							}
						}
						z.setEnabled(false);
					}
					int wrong = 0;
					for (int abc = 0; abc < curline.length()  ; abc ++)
					{
						
						if (!(infoarray[abc]).equalsIgnoreCase("z"))
						{
							wrong ++;
						}
						if (wrong == curline.length() )
						{
							hanger[visibleone].setVisible(false);
							hanger[visibleone +1].setVisible(true);
							visibleone ++;
							if(hanger[6].isVisible() == true)
							{
								for(int zyx = 0; zyx<25 ; zyx++)
								{
									buttons[zyx].setEnabled(false);
								}
								lost.setVisible(true);
								end.setVisible(true);
								for ( int xyz = 0; xyz < charcount ; xyz ++)
	                    		{
	                    			if (infoarray[xyz].equalsIgnoreCase(""))
	                    			{
	                    				box[xyz-1].setText(infoarray[xyz]);
	                    			}
	                    			
	                    		}
							}
						}
					}
				}
				
			});
			
			
			gameframe.add(panel2);
			gameframe.add(panel1);
			panel1.add(start);
			panel1.add(title);
			panel2.add(wall);
			wall.add(back);
			
			
			
			gameframe.setVisible(true);
	}

}
