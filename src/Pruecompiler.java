/**
 * Created with IntelliJ IDEA.
 * User: misaelviveroscastro
 * Date: 27/10/13
 * Time: 0:17
 * To change this template use File | Settings | File Templates.
 */
import java.util.Random;

public class Pruecompiler {

    public static void main(String[] args) {

//        rnd.nextInt(HASTA-DESDE+1)+DESDE

//        Por ejemplo, para generar 5 números aleatorios entre 10 y 20:

        Random rnd = new Random();

        for(int i = 1; i<=5; i++)
            System.out.println(rnd.nextInt(20-10+1)+10);
    }
}
