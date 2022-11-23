import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;

public class Pokedex {
    long longitudLineas;
    String[][] pokemon;

    public void leer(String archivo){
        Scanner s = null;
         
		try{
            File f = new File(archivo);
            Path path = Paths.get(archivo);
            longitudLineas = Files.lines(path).count();
            pokemon= new String[(int)longitudLineas][2];
			
			s = new Scanner(f);
            int i =0;
			while(s.hasNextLine()){
				String line = s.nextLine();
                pokemon[i][0] = line;
                i++;
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		finally{
			s.close();
		}
    }

    public void buscarPokemonRandom(){
        Random r = new Random(); 
        int i = r.nextInt(pokemon.length);
        System.out.println((i+1)+"-"+pokemon[i][0]);
        pokemon[i][1] ="Visto";
    }

    public void verPokedexFull(){
        for(int i =0; i<pokemon.length;i++){
            System.out.println((i+1)+"-"+pokemon[i][0]+"=>"+pokemon[i][1]);
        }
    }

    public void consultarPokemon(int i){
        System.out.println((i)+"-"+pokemon[i-1][0]);
    }

    public void guardarPokedex() {
        File file = new File("src/Files/Pokedex_saved.txt");
        FileWriter fr = null;
        BufferedWriter br = null;
		
        try{
            fr = new FileWriter(file);
            br = new BufferedWriter(fr);
            for(int i = 0; i<pokemon.length; i++){
				if(pokemon[i][1]!=null)
                	br.write(""+(i+1)+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                br.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
