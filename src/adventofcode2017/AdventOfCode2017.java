/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventofcode2017;

import adventofcode2017.dia7.Nodo;
import dia8.Instruccion;
import dia8.Registro;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author thepu
 */
public class AdventOfCode2017 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        //Dia1
        //System.out.println(captchaD1());
        //Dia1-2
        //System.out.println(captchaD1_2());
        //Dia2
        //System.out.println(checksum());
        //Dia2_2
        //System.out.println(checksum_2());
        //Dia3
        //System.out.println(spiralMemory());
        //Dia3_2
        //System.out.println(spiralMemory_2());
        //Dia4
        //System.out.println(passPhrases());
        //System.out.println("Resultado :"+passPhrases_2());
        //Dia5
        //System.out.println(trampolines());
        //Dia5_2
        //System.out.println(trampolines_2());
        //Dia6
        //System.out.println("Iteraciones: " + memoryReallocation_2());
        //Dia7
        //System.out.println("Recursive Circus: "+recursiveCircus());
        //Dia8
        instrucciones();
    }

    //Dia1 Captcha
    public static int captchaD1() {
        String code = "31813174349235972159811869755166343882958376474278437681632495222499211488649543755655138842553867246131245462881756862736922925752647341673342756514856663979496747158241792857625471323535183222497949751644488277317173496124473893452425118133645984488759128897146498831373795721661696492622276282881218371273973538163779782435211491196616375135472517935481964439956844536136823757764494967297251545389464472794474447941564778733926532741752757865243946976266426548341889873514383464142659425122786667399143335772174973128383869893325977319651839516694295534146668728822393452626321892357192574444856264721585365164945647254645264693957898373214897848424966266582991272496771159583715456714645585576641458358326521858518319315233857473695712238323787254556597566461188452279853766184333696344395818615215846348586541164194624371353556812548945447432787795489443312941687221314432694115847863129826532628228386894683392352799514942665396273726821936346663485499159141368443782475714679953213388375939519711591262489869326145476958378464652451441434846382474578535468433514121336844727988128998543975147649823215332929623574231738442281161294838499441799996857746549441142859199799125595761724782225452394593514388571187279266291364278184761833324476838939898258225748562345853633364314923186685534864178665214135631494876474186833392929124337161222959459117554238429216916532175247326391321525832362274683763488347654497889261543959591212539851835354335598844669618391876623638137926893582131945361264841733341247646125278489995838369127582438419889922365596554237153412394494932582424222479798382932335239274297663365164912953364777876187522324991837775492621675953397843833247525599771974555545348388871578347332456586949283657613841414576976542343934911424716613479249893113961925713317644349946444271959375981158445151659431844142242547191181944395897963146947935463718145169266129118413523541222444997678726644615185324461293228124456118853885552279849917342474792984425629248492847827653133583215539325866881662159421987315186914769478947389188382383546881622246793781846254253759714573354544997853153798862436887889318646643359555663135476261863";
        List list = new ArrayList();
        int result = 0;
        for (int i = 0; i < code.length(); i++) {
            list.add(Integer.parseInt(code.charAt(i) + ""));
        }

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) == list.get(i - 1)) {
                result += (Integer) list.get(i);
            }
        }
        if (list.get(0) == list.get(list.size() - 1)) {
            result += (Integer) list.get(0);
        }
        return result;
    }

    //Dia1 - 2 Captcha
    public static int captchaD1_2() {
        String code = "31813174349235972159811869755166343882958376474278437681632495222499211488649543755655138842553867246131245462881756862736922925752647341673342756514856663979496747158241792857625471323535183222497949751644488277317173496124473893452425118133645984488759128897146498831373795721661696492622276282881218371273973538163779782435211491196616375135472517935481964439956844536136823757764494967297251545389464472794474447941564778733926532741752757865243946976266426548341889873514383464142659425122786667399143335772174973128383869893325977319651839516694295534146668728822393452626321892357192574444856264721585365164945647254645264693957898373214897848424966266582991272496771159583715456714645585576641458358326521858518319315233857473695712238323787254556597566461188452279853766184333696344395818615215846348586541164194624371353556812548945447432787795489443312941687221314432694115847863129826532628228386894683392352799514942665396273726821936346663485499159141368443782475714679953213388375939519711591262489869326145476958378464652451441434846382474578535468433514121336844727988128998543975147649823215332929623574231738442281161294838499441799996857746549441142859199799125595761724782225452394593514388571187279266291364278184761833324476838939898258225748562345853633364314923186685534864178665214135631494876474186833392929124337161222959459117554238429216916532175247326391321525832362274683763488347654497889261543959591212539851835354335598844669618391876623638137926893582131945361264841733341247646125278489995838369127582438419889922365596554237153412394494932582424222479798382932335239274297663365164912953364777876187522324991837775492621675953397843833247525599771974555545348388871578347332456586949283657613841414576976542343934911424716613479249893113961925713317644349946444271959375981158445151659431844142242547191181944395897963146947935463718145169266129118413523541222444997678726644615185324461293228124456118853885552279849917342474792984425629248492847827653133583215539325866881662159421987315186914769478947389188382383546881622246793781846254253759714573354544997853153798862436887889318646643359555663135476261863";
        //String code = "123123";
        List list = new ArrayList();
        int incremento = code.length() / 2;
        int result = 0;
        for (int i = 0; i < code.length(); i++) {
            list.add(Integer.parseInt(code.charAt(i) + ""));
        }
        int nuevo_indice = 0;
        for (int i = 0; i < list.size(); i++) {
            if (i + incremento < list.size()) {
                nuevo_indice = i + incremento;
            } else {
                nuevo_indice = i - list.size() + incremento;
            }

            if (list.get(i) == list.get(nuevo_indice)) {
                result += (Integer) list.get(i);
            }
        }
//        if (list.get(0) == list.get(list.size() - 1)) {
//            result += (Integer) list.get(0);
//        }
        return result;
    }

    //Dia2
    public static int checksum() {
        File archivo = new File("H:\\Documentos\\NetBeansProjects\\AdventOfCode2017\\src\\adventofcode2017\\dia2.txt");
        int resultado = 0;
        try {
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            List lista = new ArrayList();
            String aux;
            while ((aux = br.readLine()) != null) {
                lista.add(aux);
            }
            List<int[]> listaint = new ArrayList<>();
            for (int i = 0; i < lista.size(); i++) {
                StringTokenizer st = new StringTokenizer("" + lista.get(i));
                int array[] = new int[st.countTokens()];
                int contador = 0;
                while (st.hasMoreTokens()) {
                    array[contador] = Integer.parseInt(st.nextToken());
                    contador++;
                }
                listaint.add(array);
            }
            //Lista de datos completada
            //Buscar maximo y minimo por fila
            int max, min;
            for (int i = 0; i < listaint.size(); i++) {
                int arrayaux[] = listaint.get(i);
                max = arrayaux[0];
                min = arrayaux[0];
                for (int j = 1; j < arrayaux.length; j++) {
                    //maximo
                    if (arrayaux[j] > max) {
                        max = arrayaux[j];
                    }
                    //minimo
                    if (arrayaux[j] < min) {
                        min = arrayaux[j];
                    }
                }
                System.out.println("Iteracion " + i + ": Max " + max + " Min " + min);
                resultado += max - min;
            }

        } catch (Exception e) {
            System.out.println("Error de fichero " + e.getLocalizedMessage());
        }

        return resultado;
    }

    //Dia2 - 2
    //checksum divisible
    public static int checksum_2() {
        File archivo = new File("H:\\Documentos\\NetBeansProjects\\AdventOfCode2017\\src\\adventofcode2017\\dia2.txt");
        int resultado = 0;
        try {
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            List lista = new ArrayList();
            String aux;
            while ((aux = br.readLine()) != null) {
                lista.add(aux);
            }
            List<int[]> listaint = new ArrayList<>();
            for (int i = 0; i < lista.size(); i++) {
                StringTokenizer st = new StringTokenizer("" + lista.get(i));
                int array[] = new int[st.countTokens()];
                int contador = 0;
                while (st.hasMoreTokens()) {
                    array[contador] = Integer.parseInt(st.nextToken());
                    contador++;
                }
                listaint.add(array);
            }
            //Lista de datos completada
            //Buscar maximo y minimo por fila

            for (int[] array : listaint) {
                for (int i = 0; i < array.length; i++) {
                    for (int j = 0; j < array.length; j++) {
                        if (array[i] % array[j] == 0 && i != j) {
                            resultado += array[i] / array[j];
                            System.out.println(array[i] + " es divisible entre " + array[j] + " El modulo es " + array[i] % array[j] + " y la division es " + array[i] / array[j]);
                        }
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("Error de fichero " + e.getLocalizedMessage());
        }

        return resultado;
    }

    //Dia 3
    //Spiral Memory
    public static int spiralMemory() {
        int tamanyo = 611;
        int maxvalue = tamanyo * tamanyo;
        int memory[][] = new int[tamanyo][tamanyo];
        int centroX = ((tamanyo - 1) / 2) + 1;
        int centroY = centroX;
        int posXFind = 0, posYFind = 0;
        int contador = 1;
        int encontrar = 368078;
        System.out.println("Tamaño " + tamanyo + " MaxValue " + maxvalue + " CentroXY " + centroX);
        int posX = centroX, posY = centroY;
        //Poblar
        //Posicion inicial
        if (contador == encontrar) {
            posXFind = posX;
            posYFind = posY;
        }
        memory[centroX][centroY] = contador++;

        // for(int i = 3; i<((tamanyo-1)/2)+1;i+=2){
        for (int i = 3; i < tamanyo; i += 2) {
            //Mueve 1 Izquierda
            posX++;
            //System.out.println("PosicionX: "+posX+" PosicionY: "+posY+" Contador:"+contador );
            if (contador == encontrar) {
                posXFind = posX;
                posYFind = posY;
            }
            memory[posX][posY] = contador++;
            //Sube desde la derecha
            for (int j = 1; j < i - 1; j++) {
                posY--;
                //System.out.println("PosicionX: "+posX+" PosicionY: "+posY+" Contador:"+contador );
                if (contador == encontrar) {
                    posXFind = posX;
                    posYFind = posY;
                }
                memory[posX][posY] = contador++;
            }
            //Desde arriba a la derecha a izq
            for (int j = 1; j < i; j++) {
                posX--;
                //System.out.println("PosicionX: "+posX+" PosicionY: "+posY+" Contador:"+contador );
                if (contador == encontrar) {
                    posXFind = posX;
                    posYFind = posY;
                }
                memory[posX][posY] = contador++;
            }
            //Desde arriba a la izq a abajo
            for (int j = 1; j < i; j++) {
                posY++;
                // System.out.println("PosicionX: "+posX+" PosicionY: "+posY+" Contador:"+contador );
                if (contador == encontrar) {
                    posXFind = posX;
                    posYFind = posY;
                }
                memory[posX][posY] = contador++;
            }
            //Desde abaja a la izq a la derecha
            for (int j = 1; j < i; j++) {
                posX++;
                //System.out.println("PosicionX: "+posX+" PosicionY: "+posY+" Contador:"+contador );
                if (contador == encontrar) {
                    posXFind = posX;
                    posYFind = posY;
                }
                memory[posX][posY] = contador++;
            }
            //
            // System.out.println("PosicionX: "+posX+" PosicionY: "+posY+" Contador:"+contador );

        }
        System.out.println("Numero a encontrar: " + encontrar + " - PosicionX: " + posXFind + " PosicionY: " + posYFind + " Contador:" + memory[posXFind][posYFind]);
        System.out.println("Centro X " + centroX + " - Centro Y " + centroY);
        int resultado = Math.max(centroX, posXFind) - Math.min(centroX, posXFind);
        resultado += Math.max(centroY, posYFind) - Math.min(centroY, posYFind);
        return resultado;
    }

    //Dia 3_1
    //Spiral sum squares
    public static int spiralMemory_2() {
        int tamanyo = 611;
        int maxvalue = tamanyo * tamanyo;
        int memory[][] = new int[tamanyo][tamanyo];
        int centroX = ((tamanyo - 1) / 2) + 1;
        int centroY = centroX;
        int posXFind = 0, posYFind = 0;
        int contador = 1;
        int encontrar = 368078;
        int siguienteencontrar = 0;
        System.out.println("Tamaño " + tamanyo + " MaxValue " + maxvalue + " CentroXY " + centroX);
        int posX = centroX, posY = centroY;
        //Poblar
        //Posicion inicial
        if (contador == encontrar) {
            posXFind = posX;
            posYFind = posY;
        }
        memory[centroX][centroY] = 1;

        // for(int i = 3; i<((tamanyo-1)/2)+1;i+=2){
        for (int i = 3; i < tamanyo; i += 2) {
            //Mueve 1 Izquierda
            posX++;
            //System.out.println("PosicionX: "+posX+" PosicionY: "+posY+" Contador:"+contador );
            if (contador == encontrar) {
                posXFind = posX;
                posYFind = posY;
            }
            siguienteencontrar = variablesSquare(memory, posX, posY);
            if (siguienteencontrar > encontrar) {
                return siguienteencontrar;
            }
            memory[posX][posY] = siguienteencontrar;
            //Sube desde la derecha
            for (int j = 1; j < i - 1; j++) {
                posY--;
                //System.out.println("PosicionX: "+posX+" PosicionY: "+posY+" Contador:"+contador );
                if (contador == encontrar) {
                    posXFind = posX;
                    posYFind = posY;
                }
                siguienteencontrar = variablesSquare(memory, posX, posY);
                if (siguienteencontrar > encontrar) {
                    return siguienteencontrar;
                }
                memory[posX][posY] = siguienteencontrar;
            }
            //Desde arriba a la derecha a izq
            for (int j = 1; j < i; j++) {
                posX--;
                //System.out.println("PosicionX: "+posX+" PosicionY: "+posY+" Contador:"+contador );
                if (contador == encontrar) {
                    posXFind = posX;
                    posYFind = posY;
                }
                siguienteencontrar = variablesSquare(memory, posX, posY);
                if (siguienteencontrar > encontrar) {
                    return siguienteencontrar;
                }
                memory[posX][posY] = siguienteencontrar;
            }
            //Desde arriba a la izq a abajo
            for (int j = 1; j < i; j++) {
                posY++;
                // System.out.println("PosicionX: "+posX+" PosicionY: "+posY+" Contador:"+contador );
                if (contador == encontrar) {
                    posXFind = posX;
                    posYFind = posY;
                }
                siguienteencontrar = variablesSquare(memory, posX, posY);
                if (siguienteencontrar > encontrar) {
                    return siguienteencontrar;
                }
                memory[posX][posY] = siguienteencontrar;
            }
            //Desde abaja a la izq a la derecha
            for (int j = 1; j < i; j++) {
                posX++;
                //System.out.println("PosicionX: "+posX+" PosicionY: "+posY+" Contador:"+contador );
                if (contador == encontrar) {
                    posXFind = posX;
                    posYFind = posY;
                }
                siguienteencontrar = variablesSquare(memory, posX, posY);
                if (siguienteencontrar > encontrar) {
                    return siguienteencontrar;
                }
                memory[posX][posY] = siguienteencontrar;
            }
            //
            // System.out.println("PosicionX: "+posX+" PosicionY: "+posY+" Contador:"+contador );

        }
        System.out.println("Numero a encontrar: " + encontrar + " - PosicionX: " + posXFind + " PosicionY: " + posYFind + " Contador:" + memory[posXFind][posYFind]);
        System.out.println("Centro X " + centroX + " - Centro Y " + centroY);
        int resultado = Math.max(centroX, posXFind) - Math.min(centroX, posXFind);
        resultado += Math.max(centroY, posYFind) - Math.min(centroY, posYFind);
        return resultado;
    }

    public static int variablesSquare(int[][] memory, int posX, int posY) {
        int value = 0;
        value += memory[posX + 1][posY];
        value += memory[posX + 1][posY - 1];
        value += memory[posX][posY - 1];
        value += memory[posX - 1][posY - 1];
        value += memory[posX - 1][posY];
        value += memory[posX - 1][posY + 1];
        value += memory[posX][posY + 1];
        value += memory[posX + 1][posY + 1];
        System.out.println("Valor siguiente:" + value);
        return value;
    }

    //Dia 4 
    //passPhrases
    public static int passPhrases() {
        File archivo = new File("H:\\Documentos\\NetBeansProjects\\AdventOfCode2017\\src\\adventofcode2017\\dia4.txt");
        int resultado = 0;
        try {
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            List<String> lista = new ArrayList<>();
            String aux = "";
            while ((aux = br.readLine()) != null) {
                lista.add(aux);
            }

            //Convertir cada String en una lista de Strings
            int iterador = 0;
            for (String cadena : lista) {
                iterador++;
                //   System.out.println("Procesando linea "+iterador+ " resultado "+resultado);
                List<String> sublista = new ArrayList<>();
                StringTokenizer st = new StringTokenizer(cadena);
                while (st.hasMoreTokens()) {
                    sublista.add(st.nextToken());
                }
                //Recorrer cada elemento para ver si esta repetido
                boolean norepetido = true;
                for (int i = 0; i < sublista.size() && norepetido;) {
                    String token = sublista.remove(0);
                    for (int j = 0; j < sublista.size() && norepetido; j++) {
                        //          System.out.println("Comparando "+token+" con "+sublista.get(j));
                        if (token.equalsIgnoreCase(sublista.get(j))) {
                            norepetido = false;
                            resultado++;
                            //        System.out.println("La linea "+ iterador +" tiene el caracter repetido "+token);
                        }
                    }
                }
            }
            System.out.println("Las cadenas validas son: " + ((lista.size() - resultado) - 1));
            System.out.println("Hay " + lista.size() + " lineas");
        } catch (Exception e) {
            System.out.println("Error de lectura: " + e.getLocalizedMessage());
        }

        return resultado;
    }

    //Dia 4_2
    //passPhrasesRearranged
    public static int passPhrases_2() {
        File archivo = new File("H:\\Documentos\\NetBeansProjects\\AdventOfCode2017\\src\\adventofcode2017\\dia4.txt");
        int resultado = 0;
        try {
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            List<String> lista = new ArrayList<>();
            String aux = "";
            while ((aux = br.readLine()) != null) {
                lista.add(aux);
            }

            //Convertir cada String en una lista de Strings
            int iterador = 0;
            for (String cadena : lista) {
                iterador++;
                //   System.out.println("Procesando linea "+iterador+ " resultado "+resultado);
                List<String> sublista = new ArrayList<>();
                StringTokenizer st = new StringTokenizer(cadena);
                while (st.hasMoreTokens()) {
                    sublista.add(st.nextToken());
                }
                //Recorrer cada elemento para ver si esta repetido
                boolean norepetido = true;
                for (int i = 0; i < sublista.size() && norepetido;) {
                    String token = sublista.remove(0);
                    for (int j = 0; j < sublista.size() && norepetido; j++) {
                        //          System.out.println("Comparando "+token+" con "+sublista.get(j));
                        if (rearranged(token, sublista.get(j))) {
                            norepetido = false;
                            resultado++;

                            //        System.out.println("La linea "+ iterador +" tiene el caracter repetido "+token);
                        }
                    }
                }
            }
            System.out.println("Las cadenas validas son: " + ((lista.size() - resultado)));
            System.out.println("Hay " + lista.size() + " lineas");
        } catch (Exception e) {
            System.out.println("Error de lectura: " + e.getLocalizedMessage());
        }
        //261 es muy alto
        return resultado;
    }

    //Si son iguales devuelve true
    public static boolean rearranged(String value1, String value2) {
        System.out.println("Comparando cadenas " + value1 + " - " + value2);
        if (value1.length() != value2.length()) {
            return false;
        }
        boolean resultado = true;
        char[] ac1 = value1.toCharArray();
        char[] ac2 = value2.toCharArray();
        for (int i = 0; i < ac1.length; i++) {
            for (int j = 0; j < ac2.length; j++) {
                if (ac1[i] == ac2[j]) {
                    ac2[j] = '_';
                }
            }
        }
        value1 = "";
        value2 = "";
        for (int i = 0; i < ac1.length; i++) {
            value1 += ac1[i];
            value2 += ac2[i];
        }
        System.out.println("Resultado cadenas " + value1 + " - " + value2);
        for (int i = 0; i < ac2.length; i++) {
            if (ac2[i] != '_') {
                return false;
            }
        }
        return resultado;
    }

    //Dia 5
    //Trampolines
    public static int trampolines() {
        File archivo = new File("H:\\Documentos\\NetBeansProjects\\AdventOfCode2017\\src\\adventofcode2017\\dia5.txt");
        //File archivo = new File("H:\\Documentos\\NetBeansProjects\\AdventOfCode2017\\src\\adventofcode2017\\testdia5.txt");
        int resultado = 0;
        try {
            int array[];
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String aux = "";
            List<String> lista = new ArrayList<>();
            while ((aux = br.readLine()) != null) {
                lista.add(aux);
            }
            array = new int[lista.size()];
            int contador = 0;
            for (String cadena : lista) {
                array[contador] = Integer.parseInt(cadena);
                contador++;
            }
            //Ya tengo todos los caracteres en un array;
            int indice = 0;
            int indiceold;
            while (true) {
                System.out.println("Salto " + resultado + " 1/2 Estoy en la posición " + indice + " el valor es " + array[indice]);
                indiceold = indice;
                indice += array[indice];
                array[indiceold]++;
                System.out.println("Salto " + resultado + " 2/2 Ahora la posicion " + indiceold + " vale " + array[indiceold]);
                System.out.println("Tengo que saltar a la posicion " + indice);
                resultado++;//Saltos
            }

        } catch (FileNotFoundException fnfe) {
            System.out.println("No se ha encontrado el fichero " + fnfe.getLocalizedMessage());
        } catch (Exception e) {
            System.out.println("Casi seguro que hemos terminado: Contador = " + resultado + "\n" + e.getLocalizedMessage());
        }
        return resultado;
    }

    //Dia5_2
    //Trampolines
    public static int trampolines_2() {
        File archivo = new File("H:\\Documentos\\NetBeansProjects\\AdventOfCode2017\\src\\adventofcode2017\\dia5.txt");
        //File archivo = new File("H:\\Documentos\\NetBeansProjects\\AdventOfCode2017\\src\\adventofcode2017\\testdia5.txt");
        int resultado = 0;
        try {
            int array[];
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String aux = "";
            List<String> lista = new ArrayList<>();
            while ((aux = br.readLine()) != null) {
                lista.add(aux);
            }
            array = new int[lista.size()];
            int contador = 0;
            for (String cadena : lista) {
                array[contador] = Integer.parseInt(cadena);
                contador++;
            }
            //Ya tengo todos los caracteres en un array;
            int indice = 0;
            int indiceold;
            while (true) {
                // System.out.println("Salto " + resultado + " 1/2 Estoy en la posición " + indice + " el valor es " + array[indice]);
                indiceold = indice;
                indice += array[indice];
                if (array[indiceold] >= 3) {
                    array[indiceold]--;
                } else {
                    array[indiceold]++;
                }
                // System.out.println("Salto " + resultado + " 2/2 Ahora la posicion " + indiceold + " vale " + array[indiceold]);
                // System.out.println("Tengo que saltar a la posicion " + indice);
                resultado++;//Saltos
            }

        } catch (FileNotFoundException fnfe) {
            System.out.println("No se ha encontrado el fichero " + fnfe.getLocalizedMessage());
        } catch (Exception e) {
            System.out.println("Casi seguro que hemos terminado: Contador = " + resultado + "\n" + e.getLocalizedMessage());
        }
        return resultado;
    }

    //Dia 6
    //memoryRealllocation
    public static int memoryReallocation() {
        int array[] = {2, 8, 8, 5, 4, 2, 3, 1, 5, 5, 1, 2, 15, 13, 5, 14};
        //int array[] = {0,2,7,0};
        List<int[]> larrays = new ArrayList<>();
        larrays.add(array.clone());
        boolean repetido = false;
        int iteracion = 0;
        while (!repetido) {
//            System.out.print("Iteracion: " + iteracion + " Contenido:");
//            for (int i = 0; i < array.length; i++) {
//                System.out.print(array[i] + " ");
//            }
//            System.out.println("");

            int index = indexMax(array);
            int value = array[indexMax(array)];
            array[index] = 0;
            if (index == array.length - 1) {
                index = 0;
            } else {
                index++;
            }
            while (value > 0) {
                array[index]++;
                if (index == array.length - 1) {
                    index = 0;
                } else {
                    index++;
                }
                value--;
            }
            iteracion++;

            //Comprobar si esta repetido
            if (arrayRepetido(array, larrays)) {
                return iteracion;
            }
            larrays.add(array.clone());

        }
        return iteracion;
    }

    //Dia 6_2
    //memoryRealllocationloop
    public static int memoryReallocation_2() {
        int array[] = {2, 8, 8, 5, 4, 2, 3, 1, 5, 5, 1, 2, 15, 13, 5, 14};
        //int array[]={0,2,7,0};
        int arrayprimerarep[]={};
        //int array[] = {0,2,7,0};
        List<int[]> larrays = new ArrayList<>();
        larrays.add(array.clone());
        boolean repetido = false;
        int iteracion = 0;
        while (!repetido) {
            System.out.print("Iteracion: " + iteracion + " Contenido:");
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println("");

            int index = indexMax(array);
            int value = array[indexMax(array)];
            array[index] = 0;
            if (index == array.length - 1) {
                index = 0;
            } else {
                index++;
            }
            while (value > 0) {
                array[index]++;
                if (index == array.length - 1) {
                    index = 0;
                } else {
                    index++;
                }
                value--;
            }
            iteracion++;

            //Comprobar si esta repetido
            if (arrayRepetido(array, larrays)) {
                arrayprimerarep = array.clone();
                
                repetido = true;
            }
            larrays.add(array.clone());

        }
        repetido = false;
        iteracion=0;
        larrays.clear();
        while (!repetido) {
            int index = indexMax(array);
            int value = array[indexMax(array)];
            array[index] = 0;
            if (index == array.length - 1) {
                index = 0;
            } else {
                index++;
            }
            while (value > 0) {
                array[index]++;
                if (index == array.length - 1) {
                    index = 0;
                } else {
                    index++;
                }
                value--;
            }
            iteracion++;
            larrays.add(array.clone());
            //Comprobar si esta repetido
            if (arrayRepetido(arrayprimerarep, larrays)) {
                return iteracion;
            }
            
        }
        return iteracion;
    }

    public static int indexMax(int array[]) {
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[index] < array[i]) {
                index = i;
            }
        }
        return index;
    }

    public static boolean arrayRepetido(int array[], List<int[]> larray) {
        boolean resultado = true;
        boolean duplicado = false;
        if(larray.size()==0)return false;
        for (int elarray[] : larray) {
            resultado = true;
            if (duplicado) {
                return true;
            }
//            System.out.print("Comprobando ");
//            for (int i = 0; i < array.length; i++) {
//                System.out.print(array[i] + " ");
//            }
//            System.out.println("");
            for (int i = 0; i < elarray.length && resultado; i++) {
                if (array[i] == elarray[i]) {
                    resultado = true;
                } else {
                    resultado = false;
                }
            }
            if (resultado) {
                return true;
            }

        }

        return resultado;
    }
    
    //Dia 7
    //recursiveCircus
    public static String recursiveCircus(){
        File archivo = new File("H:\\Documentos\\NetBeansProjects\\AdventOfCode2017\\src\\adventofcode2017\\dia7.txt");
        //File archivo = new File("H:\\Documentos\\NetBeansProjects\\AdventOfCode2017\\src\\adventofcode2017\\testdia7.txt");
        List<Nodo> listanodos = new ArrayList<Nodo>();
        StringTokenizer st;
        String aux;
        Nodo nodoaux;
        int numaux;
        try {
            int array[];
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            
            while((aux = br.readLine())!=null){
                nodoaux = new Nodo();
                aux = aux.replace(',',' ');
                aux = aux.replace('-',' ');
                aux = aux.replace('>',' ');
                st = new StringTokenizer(aux);
                while(st.hasMoreTokens()){
                    if(nodoaux.getNombre()==null)
                        
                        nodoaux.setNombre(st.nextToken());
                    else if(nodoaux.getNumero()==-1){
                        aux = st.nextToken();
                        aux = aux.replace('(', ' ');
                        aux = aux.replace(')',' ');
                        aux = aux.trim();
                        nodoaux.setNumero(Integer.parseInt(aux));
                    }else
                        nodoaux.addHijo(new Nodo(st.nextToken().trim()));
                    
                }
                listanodos.add(nodoaux);
                
            }
            //Ya tienes todos los nodos en una lista, falta asignarles los hijos.
        }catch(IOException ioe){System.out.println("Error leyendo el fichero: "+ioe.getLocalizedMessage() );}
        //Ya tienes todos los nodos
        //return nodoPadre(listanodos).getNombre();
        nodoaux= creaArbol(listanodos);
        
        for(int i = 0; i<nodoaux.getHijos().size();i++){
            System.out.println("Hijos: "+nodoaux.getHijos().get(i).getNombre()+" - "+nodoaux.getHijos().get(i).sumValores());
        }
        return nodoaux.getNombre();
    }
    
    public static Nodo nodoPadre(List<Nodo> listanodos){
        Nodo aux = null;
       boolean eshijo = false;
        for(Nodo elnodo : listanodos){
            eshijo = false;
            if(elnodo.esPadre()){
                for(int i = 0; i<listanodos.size()&&!eshijo;i++){
                    if(listanodos.get(i).esPadre())
                        if(listanodos.get(i).esHijoDirecto(elnodo))
                            eshijo = true;//No vale
                }
                  if(!eshijo)aux = elnodo;
            }
        }
        //no hay solucion
        return aux;
    }
    public static Nodo creaArbol(List<Nodo> listanodos){
       Nodo padre = nodoPadre(listanodos);
       for(int i = 0; i<listanodos.size();i++){
           if(padre.getNombre().equals(listanodos.get(i).getNombre()))
               listanodos.remove(i);
           
       }
       while(listanodos.size()!=0){
           padre = anyadirHijosR(padre,listanodos);
       }
           
       return padre;
   }
    
    public static Nodo anyadirHijos(Nodo nodo, List<Nodo> listanodos){
        for(int i = 0; i<nodo.getHijos().size();i++){
            if(nodo.getHijos().get(i).getNumero()==-1){
                for(int j = 0; j<listanodos.size();j++){
                    if(nodo.getHijos().get(i).getNombre().equals( listanodos.get(j).getNombre())){
                        nodo.getHijos().set(i, listanodos.get(j));
                        listanodos.remove(j);
                    }
                }
            }
        }
        
        return nodo;
        
    }
    
    public static Nodo anyadirHijosR(Nodo nodo,List<Nodo> listanodos){
        if(nodo.esPadre()){
            for(int i = 0; i<nodo.getHijos().size();i++){
                Nodo hijo = nodo.getHijos().get(i);
                if(hijo.getNumero()==-1)
                    for(int j = 0; j<listanodos.size();j++){
                        if(hijo.getNombre().equals(listanodos.get(j).getNombre())){
                            nodo.getHijos().set(i,listanodos.get(j));
                            listanodos.remove(j);
                        }
                    }
                else nodo.getHijos().set(i,anyadirHijosR(hijo, listanodos));
            }
        }else{
            //Busca el nodo en la lista y eliminalo
            for(int i = 0; i<listanodos.size();i++){
                if(nodo.getNombre().equals(listanodos.get(i).getNombre()))
                    listanodos.remove(i);
            }
        }
        return nodo;
    }
    
    //Dia8
    //Instrucctions
    
    public static void instrucciones(){
        int maxvalue = 0;
        List<Registro> lregistros = new ArrayList<>();
        List<Instruccion> linstrucciones = new ArrayList<>();
        String aux = "";
         File archivo = new File("H:\\Documentos\\NetBeansProjects\\AdventOfCode2017\\src\\adventofcode2017\\dia8.txt");
         try {
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            while((aux = br.readLine())!=null){
            StringTokenizer st = new StringTokenizer(aux);
            String nombre1 = st.nextToken();
            Registro raux= new Registro(0,nombre1);
            if(!existeRegistro(raux, lregistros))
                lregistros.add(raux);
            String op = st.nextToken();
            int valoradd = Integer.parseInt(st.nextToken());
            st.nextToken();
            String regacomparar = st.nextToken();
            String comparar = st.nextToken();
            int valoracomparar = Integer.parseInt(st.nextToken());
            Instruccion intruccionaux = new Instruccion(nombre1, op, valoradd, regacomparar, comparar, valoracomparar);
            linstrucciones.add(intruccionaux);
            }
            
         }catch(IOException e){System.out.println("Error de lectura "+ e.getLocalizedMessage());}
         System.out.println("Nº de registros: "+lregistros.size());
         System.out.println("Nº de instrucciones: "+linstrucciones.size());
         
         for(int i = 0; i<linstrucciones.size();i++){
             Instruccion ins = linstrucciones.get(i);
             //Encontrar registro1
             Registro r1 = null;
             for(int ii = 0; ii<lregistros.size();ii++){
                 if(ins.getNombreReg1().equals(lregistros.get(ii).getNombre()))
                     r1 = lregistros.get(ii);
             }
              Registro r2 = null;
             for(int ii = 0; ii<lregistros.size();ii++){
                 if(ins.getNombreReg2().equals(lregistros.get(ii).getNombre()))
                     r2 = lregistros.get(ii);
             }
             
             Instruccion iaux = linstrucciones.get(i);
             System.out.print("Instruccion "+i+" ");
              r1 =  iaux.ejecuta(r1, r2);
              
              if(maxvalue<r1.getValue())maxvalue = r1.getValue();
              for(int ii = 0; ii<lregistros.size();ii++){
                  if(r1.getNombre().equals(lregistros.get(ii).getNombre()))
                      lregistros.set(ii, r1);
              }
         }
         System.out.println("### Valor de registros ###");
         for(int j = 0; j< lregistros.size();j++){
             System.out.println("Nombre:"+lregistros.get(j).getNombre()+" - Valor: "+lregistros.get(j).getValue());
         }
          System.out.println("### Maximo ###");
          Registro regmax = lregistros.get(0);
         for(int j = 1; j< lregistros.size();j++){
            if(regmax.getValue()<lregistros.get(j).getValue())
                regmax = lregistros.get(j);
         }
          System.out.println("Nombre:"+regmax.getNombre()+" - Valor Maximo: "+regmax.getValue());
          System.out.println("El valor maximo ha sido "+maxvalue);
    }
    
    public static boolean existeRegistro(Registro r,List<Registro> lreg){
        boolean existe = false;
        for(int i = 0;i < lreg.size();i++){
            if(r.getNombre().equals(lreg.get(i).getNombre()))existe = true;
        }
        return existe;
    }
}
