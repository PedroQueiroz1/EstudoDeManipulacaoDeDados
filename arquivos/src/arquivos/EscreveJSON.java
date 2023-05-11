package arquivos;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class EscreveJSON {

	@SuppressWarnings({ "resource", "unused" })
	public static void main(String[] args) throws IOException {
		
		Usuario usuario1 = new Usuario();
		
		usuario1.setCpf("41414141");
		usuario1.setLogin("Joao4141");
		usuario1.setNome("João quatroum");
		usuario1.setSenha("14141414");
		
		
		Usuario usuario2 = new Usuario();
		
		usuario2.setCpf("12121212");
		usuario2.setLogin("Marcos12");
		usuario2.setNome("Marcos doze");
		usuario2.setSenha("21212121");
		
		List<Usuario> usuarios = new ArrayList<>();
		
		usuarios.add(usuario1);
		usuarios.add(usuario2);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		String jsonUser = gson.toJson(usuarios);
		
		System.out.println(jsonUser);
		
		OutputStreamWriter fileWriterUTF8 = new OutputStreamWriter(new FileOutputStream(
				"C:\\Users\\pedro\\Desktop\\projetosJava\\ManipulacaoDeDados\\EstudoDeManipulacaoDeDados\\arquivos\\src\\arquivos\\arquivo3.json"), "UTF-8");
		
		FileWriter fileWriter = new FileWriter("C:\\Users\\pedro\\Desktop\\projetosJava\\ManipulacaoDeDados\\EstudoDeManipulacaoDeDados\\arquivos\\src\\arquivos\\arquivo3.json");
	
		fileWriterUTF8.write(jsonUser);
		fileWriterUTF8.flush();
		fileWriterUTF8.close();
		
		/*
		 * ---------------------- LENDO O ARQUIVO JSON ---------------------------
		 */
		
		FileReader fileReader = new FileReader("C:\\Users\\pedro\\Desktop\\projetosJava\\ManipulacaoDeDados\\EstudoDeManipulacaoDeDados\\arquivos\\src\\arquivos\\arquivo3.json");
		
		JsonArray jsonArray =  (JsonArray) JsonParser.parseReader(fileReader);
		
		List<Usuario> listUsuarios = new ArrayList<>();
		
		
		for(JsonElement jsonElement : jsonArray) {
			
			Usuario usuarioJsonElement = new Gson().fromJson(jsonElement, Usuario.class);
			listUsuarios.add(usuarioJsonElement);
		}
		
		System.out.println("Leitura do arquivo JSON: " + listUsuarios);
		
	}
}
