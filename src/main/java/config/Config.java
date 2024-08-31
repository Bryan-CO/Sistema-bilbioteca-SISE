package config;

import io.github.cdimascio.dotenv.Dotenv;

public class Config {
	private static Dotenv dotenv = Dotenv.configure()
            .directory("/config")  // Obtiene el directorio raíz del proyecto
            .load();
	public static String DB_URL = dotenv.get("DB_URL");
	public static String DB_USERNAME = dotenv.get("DB_USERNAME");
	public static String DB_PASSWORD = dotenv.get("DB_PASSWORD");
}
