import java.util.Random;

import javax.swing.JPanel;

class Ball implements Runnable
    {	
	Random random = new Random();
    	JPanel jpnl;
        Thread t=null;
        int x,y,r,incr_y,incr_x;
        Ball(int x,int y,JPanel pnl)
        {	
        	
            this.x = x;
            this.y = y;
            this.r = 25;
            this.jpnl = pnl;
            incr_y=getYinc();
            incr_x=getXinc();
            t=new Thread(this);
            t.start();
        }
        private int getXinc() {
			int rand = random.nextInt(2 + 1+1) -2;
			if (rand==0) {
				rand = rand + 2; 
			}
			return rand;
		}
		private int getYinc() {
			int rand = random.nextInt(2 + 1+1) -2;
			if (rand==0) {
				rand = rand + 2; 
			}
			return rand;
		}
		public void run()
        {
           while(true) 
           {
               y=y+incr_y;
               x=x+incr_x;
                             
                if((y==jpnl.getSize().height-r)||(y==0))
                    incr_y=(-1)*incr_y;
                if(x==jpnl.getSize().width-r||x==0)    
                    incr_x=(-1)*incr_x;
               
               try
               {
                   t.sleep(10);
               }
               catch(InterruptedException e)
               {
                   
               }
               jpnl.repaint();
           }
        }
    }
