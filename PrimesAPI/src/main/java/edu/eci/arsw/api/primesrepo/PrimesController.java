package edu.eci.arsw.api.primesrepo;

import com.sun.org.glassfish.gmbal.ParameterNames;
import edu.eci.arsw.api.primesrepo.model.FoundPrime;
import edu.eci.arsw.api.primesrepo.service.PrimeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.jboss.logging.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.PathVariable;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author Santiago Carrillo
 * 2/22/18.
 */



@RestController
@RequestMapping( value = "/primes")
public class PrimesController
{
    
    @Autowired
    PrimeService primeService;


    @RequestMapping(method = GET )
    public List<FoundPrime> getPrimes()
    {
        return primeService.getFoundPrimes();
    }
    
    
    @RequestMapping(method = POST)
    public void postPrimes(@PathVariable FoundPrime fp){
        primeService.addFoundPrime(fp);
    }
    
    
    
    @RequestMapping(value = "/primes/{primenumber}",method = GET)
    public FoundPrime getPrime(@PathVariable String primenumber){
        return primeService.getPrime(primenumber);
    }


}
