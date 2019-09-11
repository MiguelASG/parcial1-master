package edu.eci.arsw.primefinder;

import edu.eci.arsw.mouseutils.MouseMovementMonitor;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

public class PrimesFinderTool {

	public static void main(String[] args) throws InterruptedException {
		            
            int maxPrim=1000;
            
            PrimesResultSet prs=new PrimesResultSet("john");
            /*
            PrimeFinder.findPrimes(new BigInteger("1"), new BigInteger("10"), prs);
            */
            ArrayList<Primes> primos = new ArrayList<Primes>();
            int ant=1;
            
            int max=100;
            int sig=max/4;
            int temp = sig;
            for(int i=0; i<4; i++){
                primos.add(new Primes(ant,sig,prs));
                ant = sig+1;
                if(i==3){
                    sig = max;
                }
                else{
                    sig = sig+temp;
                }
                
            }
            
            for(int i=0; i<primos.size(); i++){
                primos.get(i).start();
            }
            boolean task_not_finished = true;
            while(task_not_finished){
                try {
                    //check every 10ms if the idle status (10 seconds without mouse
                    //activity) was reached. 
                    Thread.sleep(10);
                    if (MouseMovementMonitor.getInstance().getTimeSinceLastMouseMovement()>10000){
                        for(int i = 0; i<primos.size(); i++){
                            primos.get(i).resume();
                        }
                        System.out.println("Idle CPU "); 
                        int con = 0;
                        for(int i=0; i<primos.size(); i++){
                            if(!primos.get(i).isAlive()){
                                con++;
                            }
                        }
                        if(con == 4){
                            task_not_finished = false;
                        }
                    }
                    else{
                        synchronized (prs){
                            for(int i = 0; i<primos.size(); i++){
                                primos.get(i).suspend();
                            }
                        }
                        
                        System.out.println("User working again!");
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(PrimesFinderTool.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println("Prime numbers found:");
            
            System.out.println(prs.getPrimes());            
            
            
            
	}
	
}


