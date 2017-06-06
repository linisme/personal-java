import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public  class Bean {	
	LittleBean littlebean = new LittleBean();
	
	public Rectangle positize(){
		return new Rectangle(this.littlebean.x*littlebean.ZONE,this.littlebean.y*this.littlebean.ZONE,this.littlebean.ZONE,this.littlebean.ZONE);
	}
	
	public void newBean(){
		littlebean = new LittleBean();
	}
	
	void draw(Graphics g){
		this.littlebean.draw(g);
	}
	
	private class LittleBean{
		private int x,y;
		LittleBean anotherBean = null;
		Random random = new Random();
		private int ZONE = World.RACT;
		public LittleBean(){
			this.x = random.nextInt(World.HORIZONTAL-2)+1;
			this.y = random.nextInt(World.VERTICAL-4)+3;
		}
		
		
		void draw(Graphics g){
			Color c = g.getColor();			
			g.setColor(Color.YELLOW);
			g.fillOval(x*ZONE,y*ZONE, ZONE, ZONE);
		}
	}

}
