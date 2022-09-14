package client;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import server.Methods;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class RPCClient {
    public static void main(String[] args) throws IOException, XmlRpcException {
        //ULISES DANIEL GARCÍA MÉNDEZ
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("http://localhost:1200"));
        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);
        Scanner sc = new Scanner(System.in);
        System.out.println("Elija un ejercicio:\n1.-Ejercicio 2\n2.-Ejercicio 3\n3.-Ejercicio 4\n4.-Ejercicio IMC");
        int op = sc.nextInt();
        switch(op) {
            case 1:
                System.out.println("Ingrese el primer numero:");
                double num1 = sc.nextDouble();
                System.out.println("Ingrese el segundo numero:");
                double num2 = sc.nextDouble();
                System.out.println("Ingrese el tercer numero:");
                double num3 = sc.nextDouble();
                System.out.println("Ingrese el cuarto numero:");
                double num4 = sc.nextDouble();
                Object[] ope = {num1,num2,num3,num4};
                Object[] response = (Object[]) client.execute("Methods.resultados",ope);
                System.out.println("Hola\nel producto es: "+response[0]+",\nla suma es: "+response[1]+
                        ",\ny el promedio es: "+response[2]);
                break;
            case 2:
                System.out.println("Ingresa el limite inferior ");
                int num1E3 = sc.nextInt();
                System.out.println("Ingrese el limite superior: ");
                int num2E3 = sc.nextInt();
                Object[] numbers = { num1E3,num2E3};
                int responseE3 = (int) client.execute("Methods.sum",numbers);
                System.out.println("RESULT -> "+responseE3);
                break;
            case 3:
                int x;
                Object[] num=new Object[5];
                for(x=0;x<5;x++){
                    System.out.println("Ingrese un numero:");
                    num[x]=sc.nextInt();
                }
                Object[] arreglo = (Object[]) client.execute("Methods.arreglo",new Object[]{num});
                for(x=0;x<5;x++){
                    System.out.print(arreglo[x]+" ");
                }
                break;
            case 4:
                System.out.println("Ingrese su nombre: ");
                String name = sc.nextLine();
                System.out.println("Ingrese su altura: ");
                double altura = sc.nextDouble();
                System.out.println("Ingrese su peso: ");
                double peso = sc.nextDouble();
                Object[] person = {name,altura,peso};
                Object[] response = (Object[]) client.execute("immss.imc",person);
                System.out.println("Hola "+response[0]+" tu IMC es "+response[1]);
                break;
        }
    }
}
