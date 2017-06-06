import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class World extends Frame{	
	public static final int HORIZONTAL = 30;
	public  static final int VERTICAL = 30;
	public  static final int RACT = 15;
	private boolean judge = true;
	Snake s = new Snake();
	Bean bean = new Bean();
	Button button = new Button("pay again");
	Image image = null;	
	
	public static void main(String[] args) {				
		new World().launch();
		
	}
	
	public void launch(){		
		setLocation(100,20);		
		setSize(HORIZONTAL*RACT,VERTICAL*RACT);	
		//this.setResizable(false);
		button.setSize(60, 30);	
		button.setVisible(false);
		this.add(button);	
		this.setLayout(new FlowLayout(FlowLayout.RIGHT));			
		setVisible(true);		
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});		
		
	    this.addFocusListener(new FocusAdapter() {			
			public void focusLost(FocusEvent e) {
				requestFocus();
			}	    	
	    });
	    
		this.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e) {
			
				s.keyDirection(e);
			}
			
		});			
		
		button.addMouseListener(new MouseAdapter(){			
			public void mouseClicked(MouseEvent e) {			
				button.setVisible(false);				
				s.snakelong = 1;
				s.boxes.clear();				
				s.head = s.newSnakeHead();
				s.end = s.head;
				s.boxes.add(s.head);				
				judge = true;				
				
			}			
		});				
		new Thread(new repaintThread()).start();
		
		
	}
	
	public void gameStop(){
		boolean b = s.eatItself();
		if(b || s.headRact().intersects(new Rectangle(0,0,RACT,RACT*this.VERTICAL)) || s.headRact().intersects(new Rectangle(0,0,RACT*this.HORIZONTAL,3*RACT)) || s.headRact().intersects(new Rectangle(0,RACT*this.VERTICAL-RACT,RACT*this.HORIZONTAL,RACT)) || s.headRact().intersects(new Rectangle(this.VERTICAL*RACT-RACT,0,RACT,RACT*this.HORIZONTAL))){
			judge = false;			
			button.setVisible(true);
			this.setVisible(true);			
			
		}
		
	}

	public void paint(Graphics g) {	
		Color c = g.getColor();
		g.setColor(Color.lightGray);
		g.fillRect(0, 0, HORIZONTAL*RACT, VERTICAL*RACT);		
		g.setColor(Color.gray);	
		for(int i=1;i<HORIZONTAL;i++){
			g.drawLine(0, i*RACT, VERTICAL*RACT, i*RACT);
		}
		for(int i=1;i<VERTICAL;i++){
			g.drawLine(i*RACT, 0, i*RACT, RACT*HORIZONTAL);
		}
		
		s.draw(g);		
		s.eatBean(bean);		
		bean.draw(g);
		g.setColor(Color.YELLOW);
		Font font = g.getFont();
		g.setFont(new Font("ËÎÌå",Font.BOLD,20));
		g.drawString("score:"+(s.snakelong-1)*5, 20, 60);
		if(judge == false){
			g.setColor(Color.YELLOW);
			g.setFont(new Font("Á¥Êé",Font.ITALIC,60));
			g.drawString("Game Over", 100,270);
			
		}
		g.setColor(c);
		g.setFont(font);
		
	}
		
	
	public void update(Graphics g) {
		if (image == null){
			image = this.createImage(RACT*VERTICAL, RACT*HORIZONTAL);
		}
		Graphics gra = image.getGraphics();
		paint(gra);
		g.drawImage(image, 0, 0, null);		
		
	}	

	private class repaintThread implements Runnable{			
		public void run() {
			while(true){
				while(judge){				
					try {					
						Thread.sleep(150);
						s.move();					
						gameStop();
						repaint();
					} catch (InterruptedException e) {					
						e.printStackTrace();
					}			  
				}
			}
			
		}  
		
	}	

}