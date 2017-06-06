import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;


public class Snake {
	Box head = null;
	Box end = null;		
	int snakelong = 1;
	List<Box> boxes = new ArrayList<Box>();
	//Box next = null;
	//Box front = null;
	//D direction = null;
	//private int x,y;
	//private int ZONE = Window.RACT;
	
	public Rectangle headRact(){
		return new Rectangle(head.x*head.ZONE,head.y*head.ZONE,head.ZONE,head.ZONE);
	}
	
	public void eatBean(Bean bean){
		if(this.headRact().intersects(bean.positize())){
			this.addEnd();
			bean.newBean();
			snakelong ++;
			
		}
			
	}
	
	public Box newSnakeHead(){
		return new Box(20,20,World.RACT,D.LEFT);
	}
	
	public void move(){		
		this.addHead();
		this.removeEnd();		
	}
	
	public boolean eatItself(){
		boolean jud = false;
		Box box = null;
		int i = 0;
		for(int j=0;j<boxes.size();j++){
			box = boxes.get(j);
			if(head.positionEqual(box)){
				i++;
			}
		}
		if(i == 2){
			i = 0;
			return true;
		}else return false;
	}
	
	public void draw(Graphics g) {
		if (boxes == null) return;
		for(int i=0;i<boxes.size();i++){
			Box b = boxes.get(i);
			b.draw(g);
		}
	}
	
	public Snake() {
		Box b = new Box (20,20,World.RACT,D.LEFT);
		this.head = b;		
		this.end = b;
		boxes.add(b);
		
	}
	
	public void keyDirection(KeyEvent e){
		int key = e.getKeyCode();
		switch(key){
		case KeyEvent.VK_LEFT :
			if(this.head.direction != D.RIGHT)
				this.head.direction = D.LEFT;
			break;
		case KeyEvent.VK_DOWN :
			if(this.head.direction != D.UP)
				this.head.direction = D.DOWN;
			break;
		case KeyEvent.VK_RIGHT :
			if(this.head.direction != D.LEFT)
				this.head.direction = D.RIGHT;
			break;
		case KeyEvent.VK_UP :
			if(this.head.direction != D.DOWN)
				this.head.direction = D.UP;
			break;			
		default : return;
		}
	}
	
	public void addEnd(){
		Box b = null;							
		switch(end.direction){		
			case LEFT :
				b = new Box(end.x+1,end.y,end.ZONE,end.direction);
				break;
			case RIGHT :
				b = new Box(end.x-1,end.y,end.ZONE,end.direction);
				break;
			case UP :
				b = new Box(end.x,end.y+1,end.ZONE,end.direction);
				break;			
			case DOWN :
				b = new Box(end.x,end.y-1,end.ZONE,end.direction);
				break;		
		}
		boxes.add(b);	
		end.next = b;
		b.front = end;
		end = b;		
	}

	public void addHead (){
		Box b = null;
		switch(head.direction){		
		case LEFT :
			b = new Box(head.x-1,head.y,head.ZONE,head.direction);
			break;
		case RIGHT :
			b = new Box(head.x+1,head.y,head.ZONE,head.direction);
			break;
		case UP :
			b = new Box(head.x,head.y-1,head.ZONE,head.direction);
			break;			
		case DOWN :
			b = new Box(head.x,head.y+1,head.ZONE,head.direction);
			break;	
		}
		boxes.add(b);
		head.front = b;
		b.next = head;
		head = b;
		
	}
	
	public void removeEnd(){
		Box b = null;
		if(end.front == null){
			return;
		}else {
			end.front.next = null;
			b = end;
			end = end.front;
			boxes.remove(b);
		}
		
	}
	
	private class Box {
		private int x,y;
		private int ZONE = World.RACT;	
		Box next = null;
		Box front = null;
		D direction = null;
		
		public Box(int x, int y, int ZONE, D direction) {		
			this.x = x;
			this.y = y;
			this.ZONE = ZONE;
			this.direction = direction;
		}
		
		public boolean positionEqual(Box box){
			if(this.x == box.x && this.y == box.y) {
			return true;
			}
			return false;
		}
		
		void draw(Graphics g){
			Color c = g.getColor();
			g.setColor(Color.black);
			g.fillRect(x*ZONE, y*ZONE, ZONE, ZONE);
		}
		
	}	

}
