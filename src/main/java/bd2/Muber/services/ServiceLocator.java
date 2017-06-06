package bd2.Muber.services;

//el service locator mantiene una referencia atodos los servicios existentes
import bd2.Muber.services.impl.*;
class ServiceLocator
{   //para voohh puppito
	static PasajerosServiceImpl pasajerosService;
	
	public static PasajerosServiceImpl getPasajerosService()
	{
		return pasajerosService;
	}
}


