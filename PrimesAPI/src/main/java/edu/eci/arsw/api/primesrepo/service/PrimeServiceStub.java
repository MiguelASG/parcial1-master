package edu.eci.arsw.api.primesrepo.service;

import edu.eci.arsw.api.primesrepo.model.FoundPrime;
import java.util.ArrayList;

import java.util.List;
import org.springframework.stereotype.Service;

/**
 * @author Santiago Carrillo
 * 2/22/18.
 */

@Service
public class PrimeServiceStub implements PrimeService{
    
    List<FoundPrime> found = new ArrayList<FoundPrime>(); 
    
    public PrimeServiceStub(){
        FoundPrime n = new FoundPrime("john", "32416190071");
        found.add(n);
    }
    
    
    @Override
    public void addFoundPrime( FoundPrime foundPrime )
    {
        found.add(foundPrime);
    }

    @Override
    public List<FoundPrime> getFoundPrimes()
    {
        return found;
    }

    @Override
    public FoundPrime getPrime( String prime )
    {
        FoundPrime rta = null;
        for(int i=0; i<found.size(); i++){
            if(found.get(i).getPrime().equals(prime)){
                rta = found.get(i);
                break;
            }
        }
        return rta;
    }
}
