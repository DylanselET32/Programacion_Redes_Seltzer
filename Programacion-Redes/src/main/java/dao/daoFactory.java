package dao;


public class daoFactory {

	private static daoFactory fabrica = null;
	private static stockDAO stock = null;
	

	private daoFactory() {

	}

	public static daoFactory getInstance() {
		if (fabrica == null)
			fabrica = new daoFactory();

		return fabrica;
	}

	public GeneralDAO getDAO(String type) {
		switch (type) {
		case "stock":
			if (stock == null)stock = new stockDAO();
			return stock;
		}

		return null;
	}

}
