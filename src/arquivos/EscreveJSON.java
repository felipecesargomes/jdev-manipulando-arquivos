package arquivos;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class EscreveJSON {

	public static void main(String[] args) throws IOException {
		Usuario usuario1 = new Usuario();
		usuario1.setCpf("5888800");
		usuario1.setLogin("João");
		usuario1.setSenha("288000");
		usuario1.setNome("Felipe César");

		Usuario usuario2 = new Usuario();
		usuario2.setCpf("88888888");
		usuario2.setLogin("a334reff");
		usuario2.setSenha("asf32f");
		usuario2.setNome("César");

		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios.add(usuario1);
		usuarios.add(usuario2);

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonUser = gson.toJson(usuarios);
		System.out.println(jsonUser);
		
		FileWriter fileWriter = new FileWriter("C:\\Users\\wwwfe\\eclipse-workspace\\arquivos\\filejson.json");
		fileWriter.write(jsonUser);
		fileWriter.flush();
		fileWriter.close();

	}

}
