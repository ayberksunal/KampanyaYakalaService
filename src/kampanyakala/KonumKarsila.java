package kampanyakala;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface KonumKarsila{
	@WebMethod String getKonumFarki(@WebParam(name = "locationx") String x, @WebParam(name = "locationy") String y);
}