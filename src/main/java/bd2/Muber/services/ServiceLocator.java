//el service locator mantiene una referencia atodos los servicios existentes

class ServiceLocator
{
	PasajerosServiceImpl pasajerosService;
	
	public static PasajerosServiceImpl getPasajerosService()
	{
		return pasajerosService;
	}
}


