package Ej02.UD22_2;

import Ej02.UD22_2.Connection.ControllerConnect;
import Ej02.UD22_2.Connection.ViewConnect;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ViewConnect vc = new ViewConnect();
    	ControllerConnect cc = new ControllerConnect(vc);
    }
}
