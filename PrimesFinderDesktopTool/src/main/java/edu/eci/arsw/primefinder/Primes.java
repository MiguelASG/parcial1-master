/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.primefinder;

import java.math.BigInteger;

/**
 *
 * @author 2128408
 */
public class Primes extends Thread{
    PrimesResultSet prs;
    int ant;
    int sig;
    
    public Primes(int ant, int sig, PrimesResultSet prs){
        this.ant = ant;
        this.sig = sig;
        this.prs = prs;
    }
    
    public void prime(){
        PrimeFinder.findPrimes(new BigInteger(Integer.toString(ant)), new BigInteger(Integer.toString(sig)), prs);
    }
    
    
    
    @Override
    public void run(){
        prime();
    }
    
    
    
    
}
