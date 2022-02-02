package metodos;

import java.io.IOException;

public class CleanScreen {
    public void LimpaTela(String[] args) throws InterruptedException, IOException { 
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            System.out.print("\033[H\033[2J");
        
        System.out.flush();
    }
}
