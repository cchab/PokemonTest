public class App {
    public static void main(String[] args) throws Exception {
        Pokedex p = new Pokedex();
        p.leer("src/Files/Pokedex.txt");
        //p.verPokedexFull();
        p.buscarPokemonRandom();
        p.buscarPokemonRandom();
        p.buscarPokemonRandom();
        p.verPokedexFull();
        p.guardarPokedex();
        //p.consultarPokemon(25);
    }
}
